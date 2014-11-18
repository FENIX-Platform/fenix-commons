package org.fao.fenix.commons.msd.dto.data.dataset;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

public class Resource extends org.fao.fenix.commons.msd.dto.data.Resource<Object[]> {

    @JsonProperty private MeIdentification metadata;

    public Resource() {
    }

    public Resource(MeIdentification metadata) {
        this.metadata = metadata;
    }

    public Resource(MeIdentification metadata, Collection<Object[]> data) {
        super(data);
        this.metadata = metadata;
    }




    @Override
    public MeIdentification getMetadata() {
        return metadata;
    }

    public void setMetadata(MeIdentification metadata) {
        this.metadata = metadata;
    }

}
