package org.fao.fenix.commons.msd.dto.templates.standard;

import org.codehaus.jackson.annotate.JsonProperty;
import org.fao.fenix.commons.msd.dto.templates.ResponseHandler;

import java.util.Map;

public class SeProjection extends ResponseHandler {

    public SeProjection() {}
    public SeProjection(Object source) {
        super(source);
    }


    @JsonProperty
    public OjCodeList getProjection() {
        return null;
    }
    @JsonProperty
    public Map<String, String> getProjectionName() {
        return null;
    }
    @JsonProperty
    public SeProjectionParameters getSeProjectionParameters() {
        return null;
    }

}
