package org.fao.fenix.commons.msd.dto.full;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.fao.fenix.commons.annotations.*;
import org.fao.fenix.commons.msd.dto.JSONEntity;

import javax.persistence.Embedded;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.*;

public class MeIdentification <T extends DSD> extends JSONEntity implements Serializable {

    /* Properties */

    @JsonProperty
    @Label(en="Resource identification code")
    @Description(en="Resource identifier. It is a code that creates the match between the resource and the metadata it is associated to.")
    @Order(-1)
    @Format(Format.FORMAT.string)
    private String uid;

    @JsonProperty
    @Label(en="Version")
    @Description(en="This is the version of the metadata.")
    @Order(-1)
    @Format(Format.FORMAT.string)
    private String version;

    @JsonProperty
    @Label(en="Parent(s) metadata ID")
    @Description(en= "Identifier of the metadata record to which this metadata record is a subset of (i.e. parent metadata of hierarchical metadata records). The specification of the parentIdentifier allows to inherit a set of metadata information from the parent metadata record. The choice of which metadata elements must to be kept from the parent record and the one that has to be manually modified, it is subject to ad hoc controls.")
    @Order(-1)
    @Format(Format.FORMAT.string)
    private Collection<String> parentIdentifiers;

    @JsonProperty
    @Label(en="Language(s)")
    @Description(en= "Language used by the resource for textual information.")
    @Order(-1)
    @Format(Format.FORMAT.string)
    private OjCodeList language;

    @JsonProperty
    @Label(en="Language details")
    @Description(en= "Comments and additional details about the language used for the textual information of the resource. This field is addressed to highlight some particular inconsistencies in the language (or languages) used in the resource, if any. For example to alert that the resource is not completely homogeneous in the language used for textual information. Otherwise it can be leaved empty.")
    @Order(-1)
    @Format(Format.FORMAT.string)
    private Map<String, String> languageDetails;

    @JsonProperty
    @Label(en="Title")
    @Description(en= "Textual label used as title of the resource.")
    @Order(-1)
    @Format(Format.FORMAT.string)
    private Map<String, String> title;

    @JsonProperty
    @Label(en="Creation date")
    @Description(en= "Creation date of the resource.")
    @Order(-1)
    @Format(Format.FORMAT.string)
    private Date creationDate;

    @JsonProperty
    @Label(en="Character-set")
    @Description(en= "Full name of the character coding standard used by the resource.")
    @Order(-1)
    @Format(Format.FORMAT.string)
    private OjCodeList characterSet;

    @JsonProperty
    @Label(en="Character-set")
    @Description(en= "Full name of the character coding standard used by the resource.")
    @Order(-1)
    @Format(Format.FORMAT.string)
    private String metadataStandardName;

    @JsonProperty
    @Label(en="Used metadata standard")
    @Description(en= "Name of the metadata standard specifications used. In FENIX framework this field would be pre-compiled by 'FENIX'.")
    @Order(-1)
    @Format(Format.FORMAT.string)
    private String metadataStandardVersion;

    @JsonProperty
    @Label(en="Version of metadata standard")
    @Description(en= "Version of the metadata standard specifications used.")
    @Order(-1)
    @Format(Format.FORMAT.string)
    private OjCodeList metadataLanguage;

    @JsonProperty
    @Label(en="Contact(s)")
    @Description(en= "Responsible party that could be identify as the data source. FENIX metadata contains more than one field of the type 'ResponsibleParty' addressed to report all the information necessary to contact party(ies) playing different roles in respect to the resource. In particular this field (belonging to the Identification entity) should report the party who owns authority on the resource.")
    @Order(-1)
    @Format(Format.FORMAT.string)
    private Collection<OjResponsibleParty> contacts;

    @JsonProperty
    @Label(en="Value assigned to No-data")
    @Description(en= "Value assigned to the cells to represent the absence of data. Missing values are usually highlight through apposite ags, however the data matrix does not report empty cells but a predened combination of characters (such as 'NA', '000' . . . ) indicating the absence of data.")
    @Order(-1)
    @Format(Format.FORMAT.string)
    private String noDataValue;

    /* Connected entities */

    @JsonProperty
    @Label(en="DOCUMENTS")
    @Description(en= "This section allows linking publications, news, or other relevant material to the considered resource.")
    @Order(-1)
    @Format(Format.FORMAT.string)
    private Collection<MeDocuments> meDocuments;

    @JsonProperty
    @Label(en="INSTITUTIONAL MANDATE")
    @Description(en= "This section includes the formal set of instructions assigning responsibility as well as the authority to an organization for the collection, processing, and dissemination of statistics.")
    @Order(-1)
    @Format(Format.FORMAT.string)
    private MeInstitutionalMandate meInstitutionalMandate;

    @JsonProperty
    @Label(en="ACCESSIBILITY")
    @Description(en= "This section reports details about data distribution and sharing mechanisms. It includes information on conditions and formal agreements under which statistical information can be obtained. In addition it provides details on available options to obtain a resource, such as user accessibility to data and dissemination periodicity.")
    @Order(-1)
    @Format(Format.FORMAT.string)
    private MeAccessibility meAccessibility;

    @JsonProperty
    @Label(en="CONTENT")
    @Description(en= "This section includes a summary of the content of the resource and the description of the geographical, time and sector coverage.")
    @Order(-1)
    @Format(Format.FORMAT.string)
    private MeContent meContent;

    @JsonProperty
    @Label(en="DATA QUALITY")
    @Description(en= "This section provides a description and evaluation of the data quality. It allows to describe the data quality assurance process, inclusive of data validation, completeness and accuracy standards. In addition an assessment of the comparability and intern coherence of the resource is considered a quality dimension.")
    @Order(-1)
    @Format(Format.FORMAT.string)
    private MeDataQuality meDataQuality;

    @JsonProperty
    @Label(en="MAINTENANCE")
    @Description(en= "This section provides information about the frequency of resource upgrade and metadata maintenance.")
    @Order(-1)
    @Format(Format.FORMAT.string)
    private MeMaintenance meMaintenance;

    @JsonProperty
    @Label(en="REFERENCE SYSTEM")
    @Description(en= "This section includes temporal and coordinate identifiers. It contains all the required information to uniquely identify a point on the earth surface. It also defines the transformations and conversions parameters to convert from one coordinate reference system (CRS) to another. This metadata entity includes the parameters specifying the geospatial references that relate information represented in the data (features) to their geographic space. The considered reference system is only based on coordinates and not on geographic identifiers.")
    @Order(-1)
    @Format(Format.FORMAT.string)
    private MeReferenceSystem meReferenceSystem;

    @JsonProperty
    @Label(en="")
    @Description(en= "This section lists values and metadata of the dimensions of the resource. In a data table, dimensions may refer to geographical areas, time, commodities, gender, etc. . . It includes iterative elements representing 'n' dimensions and 'm' elements of each dimension. In addition ResourceRecord allows to report information at single-value level.")
    @Order(-1)
    @Format(Format.FORMAT.string)
    private MeResourceStructure meResourceStructure;

    @JsonProperty
    @Label(en="SPATIAL REPRESENTATION")
    @Description(en= "This section includes information about the mechanism to represent spatial information both in raster and vector formats. It includes concepts for describing and manipulating the spatial characteristics of geographic features. This metadata entity is only valid for geospatial resources like vector and raster layers or TINs. Depending on the value assumed by its resourceRepresentationType element, it extends to GridSpatialRepresentation entity (for resourceRepresentationType = 'raster') or VectorSpatialRepresentation (for resourceRepresentationType = 'vector' or 'tin').")
    @Order(-1)
    @Format(Format.FORMAT.string)
    private MeSpatialRepresentation meSpatialRepresentation;

    @JsonProperty
    @Label(en="STATISTICAL PROCESSING")
    @Description(en= "This section describes the statistical operations and transformations applied to data. It includes the process used to collect data, the description of raw data and a detailed review of the process used to compute processed resource.")
    @Order(-1)
    @Format(Format.FORMAT.string)
    private MeStatisticalProcessing meStatisticalProcessing;

    /* DSD */
    @JsonProperty private T dsd;



    //GET - SET
    public T getDsd() {
        return dsd;
    }
    public void setDsd(T dsd) {
        this.dsd = dsd;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public OjCodeList getLanguage() {
        return language;
    }
    @Embedded
    public void setLanguage(OjCodeList language) {
        this.language = language;
    }

    public Map<String, String> getLanguageDetails() {
        return languageDetails;
    }

    public void setLanguageDetails(Map<String, String> languageDetails) {
        this.languageDetails = languageDetails;
    }

    public Map<String, String> getTitle() {
        return title;
    }

    public void setTitle(Map<String, String> title) {
        this.title = title;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public OjCodeList getCharacterSet() {
        return characterSet;
    }
    @Embedded
    public void setCharacterSet(OjCodeList characterSet) {
        this.characterSet = characterSet;
    }

    public Collection<String> getParentIdentifiers() {
        return parentIdentifiers;
    }

    public void setParentIdentifiers(Collection<String> parentIdentifiers) {
        this.parentIdentifiers = parentIdentifiers;
    }

    public String getMetadataStandardName() {
        return metadataStandardName;
    }

    public void setMetadataStandardName(String metadataStandardName) {
        this.metadataStandardName = metadataStandardName;
    }

    public String getMetadataStandardVersion() {
        return metadataStandardVersion;
    }

    public void setMetadataStandardVersion(String metadataStandardVersion) {
        this.metadataStandardVersion = metadataStandardVersion;
    }

    public OjCodeList getMetadataLanguage() {
        return metadataLanguage;
    }
    @Embedded
    public void setMetadataLanguage(OjCodeList metadataLanguage) {
        this.metadataLanguage = metadataLanguage;
    }

    public Collection<OjResponsibleParty> getContacts() {
        return contacts;
    }
    @Embedded
    public void setContacts(Collection<OjResponsibleParty> contacts) {
        this.contacts = contacts;
    }

    public String getNoDataValue() {
        return noDataValue;
    }

    public void setNoDataValue(String noDataValue) {
        this.noDataValue = noDataValue;
    }



    //Connected entities
    public MeContent getMeContent() {
        return meContent;
    }
    @Embedded
    public void setMeContent(MeContent meContent) {
        this.meContent = meContent;
    }

    public Collection<MeDocuments> getMeDocuments() {
        return meDocuments;
    }
    @Embedded
    public void setMeDocuments(Collection<MeDocuments> meDocuments) {
        this.meDocuments = meDocuments;
    }

    public MeInstitutionalMandate getMeInstitutionalMandate() {
        return meInstitutionalMandate;
    }
    @Embedded
    public void setMeInstitutionalMandate(MeInstitutionalMandate meInstitutionalMandate) {
        this.meInstitutionalMandate = meInstitutionalMandate;
    }

    public MeAccessibility getMeAccessibility() {
        return meAccessibility;
    }
    @Embedded
    public void setMeAccessibility(MeAccessibility meAccessibility) {
        this.meAccessibility = meAccessibility;
    }

    public MeDataQuality getMeDataQuality() {
        return meDataQuality;
    }
    @Embedded
    public void setMeDataQuality(MeDataQuality meDataQuality) {
        this.meDataQuality = meDataQuality;
    }

    public MeMaintenance getMeMaintenance() {
        return meMaintenance;
    }
    @Embedded
    public void setMeMaintenance(MeMaintenance meMaintenance) {
        this.meMaintenance = meMaintenance;
    }

    public MeReferenceSystem getMeReferenceSystem() {
        return meReferenceSystem;
    }
    @Embedded
    public void setMeReferenceSystem(MeReferenceSystem meReferenceSystem) {
        this.meReferenceSystem = meReferenceSystem;
    }

    public MeResourceStructure getMeResourceStructure() {
        return meResourceStructure;
    }
    @Embedded
    public void setMeResourceStructure(MeResourceStructure meResourceStructure) {
        this.meResourceStructure = meResourceStructure;
    }

    public MeSpatialRepresentation getMeSpatialRepresentation() {
        return meSpatialRepresentation;
    }
    @Embedded
    public void setMeSpatialRepresentation(MeSpatialRepresentation meSpatialRepresentation) {
        this.meSpatialRepresentation = meSpatialRepresentation;
    }

    public MeStatisticalProcessing getMeStatisticalProcessing() {
        return meStatisticalProcessing;
    }
    @Embedded
    public void setMeStatisticalProcessing(MeStatisticalProcessing meStatisticalProcessing) {
        this.meStatisticalProcessing = meStatisticalProcessing;
    }



    //Utils
    public boolean isIdentificationOnly() throws IllegalAccessException {
        for (Field field : MeIdentification.class.getDeclaredFields()) {
            String fieldName = field.getName();
            Object fieldValue = field.get(this);
            if (!fieldName.equals("uid") && !fieldName.equals("version") && fieldValue!=null) {
                if (fieldValue instanceof Collection) {
                    if (((Collection)fieldValue).size()>0)
                        return false;
                } else if (fieldValue instanceof Map) {
                    if (((Map)fieldValue).size()>0)
                        return false;
                } else
                    return false;
            }
        }
        return true;
    }


}
