package org.fao.fenix.commons.msd.dto.full;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.fao.fenix.commons.mdsd.annotations.Description;
import org.fao.fenix.commons.mdsd.annotations.Format;
import org.fao.fenix.commons.mdsd.annotations.Label;
import org.fao.fenix.commons.mdsd.annotations.Order;
import org.fao.fenix.commons.msd.dto.JSONEntity;

import javax.persistence.Embedded;
import java.io.Serializable;

public class SeDataDissemination extends JSONEntity implements Serializable {

    @JsonProperty
    @Label(en="Distribution",fr="Distribution",es="Distribución")
    @Description(en= "This section reports the mode of distribution of the resource with a focus on how to access the resource, the supported formats.")
    @Order(1)
    @Format(Format.FORMAT.string)
    private SeDistribution seDistribution;

    @JsonProperty
    @Label(en="Release Policy",fr="Politique de publication",es="Política de lanzamiento")
    @Description(en= "")
    @Order(2)
    @Format(Format.FORMAT.string)
    private SeReleasePolicy seReleasePolicy;


    public SeReleasePolicy getSeReleasePolicy() {
        return seReleasePolicy;
    }
    @Embedded
    public void setSeReleasePolicy(SeReleasePolicy seReleasePolicy) {
        this.seReleasePolicy = seReleasePolicy;
    }

    public SeDistribution getSeDistribution() {
        return seDistribution;
    }
    @Embedded
    public void setSeDistribution(SeDistribution seDistribution) {
        this.seDistribution = seDistribution;
    }
}
