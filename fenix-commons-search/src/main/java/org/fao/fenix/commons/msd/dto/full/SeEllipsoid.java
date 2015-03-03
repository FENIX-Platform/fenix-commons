package org.fao.fenix.commons.msd.dto.full;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.fao.fenix.commons.annotations.Description;
import org.fao.fenix.commons.annotations.Label;
import org.fao.fenix.commons.msd.dto.JSONEntity;

import javax.persistence.Embedded;
import java.io.Serializable;
import java.util.Map;

public class SeEllipsoid extends JSONEntity implements Serializable {

    @JsonProperty
    @Label(en="")
    @Description(en= "")
    private OjCodeList ellipsoid;

    @JsonProperty
    @Label(en="")
    @Description(en= "")
    private Map<String, String> ellipsoidName;

    @JsonProperty
    @Label(en="")
    @Description(en= "")
    private SeEllipsoidParameters seEllipsoidParameters;


    public OjCodeList getEllipsoid() {
        return ellipsoid;
    }
    @Embedded
    public void setEllipsoid(OjCodeList ellipsoid) {
        this.ellipsoid = ellipsoid;
    }

    public Map<String, String> getEllipsoidName() {
        return ellipsoidName;
    }

    public void setEllipsoidName(Map<String, String> ellipsoidName) {
        this.ellipsoidName = ellipsoidName;
    }

    public SeEllipsoidParameters getSeEllipsoidParameters() {
        return seEllipsoidParameters;
    }
    @Embedded
    public void setSeEllipsoidParameters(SeEllipsoidParameters seEllipsoidParameters) {
        this.seEllipsoidParameters = seEllipsoidParameters;
    }
}
