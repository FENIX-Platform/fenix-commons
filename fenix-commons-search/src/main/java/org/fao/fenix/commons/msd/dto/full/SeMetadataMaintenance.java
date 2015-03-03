package org.fao.fenix.commons.msd.dto.full;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.fao.fenix.commons.annotations.Description;
import org.fao.fenix.commons.annotations.Label;
import org.fao.fenix.commons.msd.dto.JSONEntity;

import java.io.Serializable;
import java.util.Date;

public class SeMetadataMaintenance extends JSONEntity implements Serializable {

    @JsonProperty
    @Label(en="")
    @Description(en= "")
    private Date metadataLastCertified;

    @JsonProperty
    @Label(en="")
    @Description(en= "")
    private Date metadataLastPosted;

    @JsonProperty
    @Label(en="")
    @Description(en= "")
    private Date metadataLastUpdate;


    public Date getMetadataLastCertified() {
        return metadataLastCertified;
    }

    public void setMetadataLastCertified(Date metadataLastCertified) {
        this.metadataLastCertified = metadataLastCertified;
    }

    public Date getMetadataLastPosted() {
        return metadataLastPosted;
    }

    public void setMetadataLastPosted(Date metadataLastPosted) {
        this.metadataLastPosted = metadataLastPosted;
    }

    public Date getMetadataLastUpdate() {
        return metadataLastUpdate;
    }

    public void setMetadataLastUpdate(Date metadataLastUpdate) {
        this.metadataLastUpdate = metadataLastUpdate;
    }
}
