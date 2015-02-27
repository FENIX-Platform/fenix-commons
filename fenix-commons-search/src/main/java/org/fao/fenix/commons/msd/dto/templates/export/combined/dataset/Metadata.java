package org.fao.fenix.commons.msd.dto.templates.export.combined.dataset;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.fao.fenix.commons.msd.dto.templates.identification.DSDDataset;

public class Metadata extends org.fao.fenix.commons.msd.dto.templates.export.combined.Metadata<DSDDataset> {

    public Metadata() {}
    public Metadata(Object source) {
        super(source);
    }

    @Override
    @JsonProperty
    public DSDDataset getDsd() {
        return null;
    }

}
