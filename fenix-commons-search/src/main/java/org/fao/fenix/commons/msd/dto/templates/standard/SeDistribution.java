package org.fao.fenix.commons.msd.dto.templates.standard;

import org.codehaus.jackson.annotate.JsonProperty;
import org.fao.fenix.commons.msd.dto.templates.ResponseHandler;

import java.util.Collection;

public class SeDistribution extends ResponseHandler {

    public SeDistribution() {}
    public SeDistribution(Object source) {
        super(source);
    }


    @JsonProperty
    public String getOnlineResource() {
        return null;
    }
    @JsonProperty
    public Collection<String> getDisseminationFormat() {
        return null;
    }

}
