package org.fao.fenix.commons.msd.dto.templates.standard.combined.codelist;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.fao.fenix.commons.msd.dto.templates.identification.DSDCodelist;

public class Metadata extends org.fao.fenix.commons.msd.dto.templates.standard.combined.Metadata<DSDCodelist> {

    public Metadata() {}
    public Metadata(Object source) {
        super(source);
    }

    @Override
    @JsonProperty
    public DSDCodelist getDsd() {
        return null;
    }

}
