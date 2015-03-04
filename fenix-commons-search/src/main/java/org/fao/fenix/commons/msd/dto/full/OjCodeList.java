package org.fao.fenix.commons.msd.dto.full;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.fao.fenix.commons.annotations.Description;
import org.fao.fenix.commons.annotations.Label;
import org.fao.fenix.commons.msd.dto.JSONEntity;

import javax.persistence.Embedded;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

public class OjCodeList extends JSONEntity implements Serializable {
    private MeIdentification linkedCodeList;

    @JsonProperty
    @Label(en="")
    @Description(en="")
    private Collection<OjCode> codes;

    @JsonProperty
    @Label(en="")
    @Description(en="")
    private String idCodeList;

    @JsonProperty
    @Label(en="")
    @Description(en="")
    private String version;

    @JsonProperty
    @Label(en="")
    @Description(en="")
    private Map<String, String> extendedName;

    @JsonProperty
    @Label(en="")
    @Description(en="")
    private OjResponsibleParty contactInfo;

    @JsonProperty
    @Label(en="")
    @Description(en="")
    private Collection<OjCitation> codeListResources;

    @JsonProperty
    @Label(en="")
    @Description(en="")
    private String link;


    public String getIdCodeList() {
        return idCodeList;
    }

    public void setIdCodeList(String idCodeList) {
        this.idCodeList = idCodeList;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Collection<OjCode> getCodes() {
        return codes;
    }
    @Embedded
    public void setCodes(Collection<OjCode> codes) {
        this.codes = codes;
    }

    public Map<String, String> getExtendedName() {
        return extendedName;
    }

    public void setExtendedName(Map<String, String> extendedName) {
        this.extendedName = extendedName;
    }

    public OjResponsibleParty getContactInfo() {
        return contactInfo;
    }
    @Embedded
    public void setContactInfo(OjResponsibleParty contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public MeIdentification getLinkedCodeList() {
        return linkedCodeList;
    }

    public void setLinkedCodeList(MeIdentification linkedCodeList) {
        this.linkedCodeList = linkedCodeList;
    }

    public Collection<OjCitation> getCodeListResources() {
        return codeListResources;
    }
    @Embedded
    public void setCodeListResources(Collection<OjCitation> codeListResources) {
        this.codeListResources = codeListResources;
    }
}
