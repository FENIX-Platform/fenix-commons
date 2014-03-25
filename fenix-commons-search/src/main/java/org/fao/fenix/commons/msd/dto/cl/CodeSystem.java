package org.fao.fenix.commons.msd.dto.cl;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.fao.fenix.commons.msd.dto.cl.type.CSSharingPolicy;
import org.fao.fenix.commons.msd.dto.cl.type.CycleCodeReferenceException;
import org.fao.fenix.commons.msd.dto.cl.type.DuplicateCodeException;
import org.fao.fenix.commons.msd.dto.common.ContactIdentity;
import org.fao.fenix.commons.msd.utils.DataUtils;

import java.util.*;

public class CodeSystem implements Comparable<CodeSystem> {
	
	//Attributes
	private String system;
	private String version;
	private Map<String,String> title;
	private Map<String,String> description;
	private Date startDate;
	private Date endDate;
	private Date virtualDate;

	private Code region;
	private ContactIdentity source;
	private ContactIdentity provider;
	private Code category;

	private Set<String> keyWords;
	private CSSharingPolicy sharingPolicy;

	//Code list
	private Set<Code> rootCodes;
	private Integer levelsNumber;
	
	public CodeSystem() {}
	public CodeSystem(String system, String version) {
		this.system = system;
		this.version = version;
	}

	//GET-SET
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}
	public Set<String> getKeyWords() {
		return keyWords;
	}
	public void setKeyWords(Set<String> keyWords) {
		this.keyWords = keyWords;
	}
	public Code getCategory() {
		return category;
	}
	public void setCategory(Code category) {
		this.category = category;
	}
	public Map<String, String> getTitle() {
		return title;
	}
	public void setTitle(Map<String, String> title) {
		this.title = title;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public CSSharingPolicy getSharingPolicy() {
		return sharingPolicy;
	}
	public void setSharingPolicy(CSSharingPolicy sharingPolicy) {
		this.sharingPolicy = sharingPolicy;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = DataUtils.roundDate(startDate);
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = DataUtils.roundDate(endDate);
	}
	public Date getVirtualDate() {
		return virtualDate;
	}
	public void setVirtualDate(Date virtualDate) {
		this.virtualDate = DataUtils.roundDate(virtualDate);
	}
	public Map<String, String> getDescription() {
		return description;
	}
	public void setDescription(Map<String, String> description) {
		this.description = description;
	}
	public Code getRegion() {
		return region;
	}
	public void setRegion(Code region) {
		this.region = region;
	}
	public ContactIdentity getSource() {
		return source;
	}
	public void setSource(ContactIdentity source) {
		this.source = source;
	}
	public ContactIdentity getProvider() {
		return provider;
	}
	public void setProvider(ContactIdentity provider) {
		this.provider = provider;
	}
	@JsonManagedReference("system") public Collection<Code> getRootCodes() {
		return rootCodes;
	}
	@JsonManagedReference("system") public void setRootCodes(Collection<Code> rootCodes) throws DuplicateCodeException {
		if (rootCodes==null)
            this.rootCodes = null;
        else {
            this.rootCodes = new HashSet<>();
            for (Code code : rootCodes)
                addCode(code);
        }
	}
	public Integer getLevelsNumber() {
		return levelsNumber;
	}
	public void setLevelsNumber(Integer levelsNumber) {
		this.levelsNumber = levelsNumber;
	}
	
	//Utilities
	public void addKeyWord(String keyWord) {
        if (keyWords==null)
            keyWords = new HashSet<String>();
		keyWords.add(keyWord);
	}
	public void addTitle(String language, String title) {
        if (this.title==null)
            this.title = new HashMap<String, String>();
		this.title.put(language, title);
	}
	public void addDescription(String language, String description) {
        if (this.description==null)
            this.description = new HashMap<String, String>();
		this.description.put(language, description);
	}
	public void addCode(Code code) throws DuplicateCodeException {
        if (rootCodes==null)
            rootCodes = new HashSet<>();
		if (!rootCodes.add(code))
            throw new DuplicateCodeException(this,code);
	}
	public boolean hasCodeList() { return rootCodes!=null && rootCodes.size()>0; }
	
	public String encodedKeyWords() {
		StringBuilder buffer = new StringBuilder();
		for (String keyWord : keyWords)
			buffer.append('|').append(keyWord);
		return keyWords.size()>0 ? buffer.substring(1) : "";
	}
	public void decodedKeyWords(String keyWords) {
		this.keyWords.clear();
		for (String keyWord : keyWords.split("\\|"))
			this.keyWords.add(keyWord);
	}
	
	public Collection<Collection<Code>> findBranches() {
		Collection<Collection<Code>> buffer = new LinkedList<>();
		if (rootCodes!=null)
			for (Code code : rootCodes)
				buffer.addAll(code.findBranches());
		return buffer;
	}


    //CODE LIST NORMALIZATION
    public void normalize() throws CycleCodeReferenceException, DuplicateCodeException {
        resetSystemReference();
        resetLevelsNumber();
        compress();
    }

    private void resetSystemReference() {
        if (rootCodes!=null)
            for (Code code : rootCodes)
                code.resetSystem(this);
    }
    private void resetLevelsNumber() {
        levelsNumber = 0;
        if (rootCodes!=null)
            for (Code code : rootCodes)
                levelsNumber = Math.max(levelsNumber,code.resetLevel(0));
    }
    private void compress() throws CycleCodeReferenceException, DuplicateCodeException {
        if (rootCodes!=null) {
            Map<String,Code> processedCodes = new HashMap<>();
            Stack<String> branchCodes = new Stack<>();
            for (Code code : rootCodes)
                rootCodes.add(compress(null, code, processedCodes, branchCodes));
        }
    }

    private Code compress(Code parent, Code code, Map<String, Code> processedCodes, Stack<String> branch) throws CycleCodeReferenceException, DuplicateCodeException {
        if (branch.contains(code)) //Check for cycle references
            throw new CycleCodeReferenceException(this,code);

        branch.push(code.getCode());

        Code processed = processedCodes.get(code.getCode());
        if (processed!=null) {
            //Use processed code for next recursive iteration
            code = processed;
            //Add the parent
            if (parent!=null)
                code.addParentNoCheck(parent);
        } else
            processedCodes.put(code.getCode(), code);

        if (!code.isLeaf())
            for (Code child : code.getChilds())
                compress(code, child, processedCodes, branch);

        branch.pop();

        return code;
    }


    //Compare
	@Override public boolean equals(Object obj) { return obj!=null && obj instanceof CodeSystem && ((CodeSystem)obj).toString().equals(toString()); }
	@Override public String toString() { return system+'|'+version; }
    @Override public int compareTo(CodeSystem o) { return toString().compareTo(o.toString()); }
    @Override public int hashCode() { return toString().hashCode(); }
}
