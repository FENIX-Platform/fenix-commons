package org.fao.fenix.commons.msd.dto.templates.identification;

import org.codehaus.jackson.annotate.JsonProperty;
import org.fao.fenix.commons.msd.dto.templates.ResponseHandler;

public class MeIdentification extends ResponseHandler {

    public MeIdentification() {}
    public MeIdentification(Object source) {
        super(source);
    }


    @JsonProperty
    public String getUid() {
        return null;
    }
    @JsonProperty
    public String getVersion() {
        return null;
    }

}
