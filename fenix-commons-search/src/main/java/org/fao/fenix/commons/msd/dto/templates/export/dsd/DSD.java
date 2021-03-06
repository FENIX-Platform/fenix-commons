package org.fao.fenix.commons.msd.dto.templates.export.dsd;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.fao.fenix.commons.msd.dto.templates.ResponseHandler;

import java.util.Map;

public class DSD extends ResponseHandler {

    public DSD() {}
    public DSD(Object source) {
        super(source);
    }

    //Exclude RID informations
    @Override
    @JsonIgnore
    public String getRID() {
        return null;
    }


    @JsonProperty
    public String getContextSystem() {
        return null;
    }
    @JsonProperty
    public String[] getDatasources() {
        return null;
    }
    @JsonProperty
    public Map<String, Object> getContextExtension() {
        return null;
    }



}
