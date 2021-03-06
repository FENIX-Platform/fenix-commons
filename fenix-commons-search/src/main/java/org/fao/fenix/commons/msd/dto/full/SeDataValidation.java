package org.fao.fenix.commons.msd.dto.full;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.fao.fenix.commons.mdsd.annotations.Description;
import org.fao.fenix.commons.mdsd.annotations.Format;
import org.fao.fenix.commons.mdsd.annotations.Label;
import org.fao.fenix.commons.mdsd.annotations.Order;
import org.fao.fenix.commons.msd.dto.JSONEntity;

import java.io.Serializable;
import java.util.Map;

public class SeDataValidation extends JSONEntity implements Serializable {

    @JsonProperty
    @Label(en="Data validation - intermediate", fr="Validation des données - intermédiaire", es="Validación de datos - intermedio")
    @Description(en= "Assessment of the quality and correctness of intermediate calculations leading to statistical outputs.")
    @Order(2)
    @Format(Format.FORMAT.textarea)
    private Map<String, String> dataValidationIntermediate;

    @JsonProperty
    @Label(en="Data validation - output", fr="Validation des données - output", es="Validación de datos - salida")
    @Description(en= "Assessment of discrepancies and/or inaccuracies observed in the statistical outputs.")
    @Order(3)
    @Format(Format.FORMAT.textarea)
    private Map<String, String> dataValidationOutput;

    @JsonProperty
    @Label(en="Data validation - source", fr="Validation des données - sources", es="Validación de datos - fuente")
    @Description(en= "Assessment of discrepancies and/or inaccuracies inherent to the data source.")
    @Order(1)
    @Format(Format.FORMAT.textarea)
    private Map<String, String> dataValidationSource;


    public Map<String, String> getDataValidationIntermediate() {
        return dataValidationIntermediate;
    }

    public void setDataValidationIntermediate(Map<String, String> dataValidationIntermediate) {
        this.dataValidationIntermediate = dataValidationIntermediate;
    }

    public Map<String, String> getDataValidationOutput() {
        return dataValidationOutput;
    }

    public void setDataValidationOutput(Map<String, String> dataValidationOutput) {
        this.dataValidationOutput = dataValidationOutput;
    }

    public Map<String, String> getDataValidationSource() {
        return dataValidationSource;
    }

    public void setDataValidationSource(Map<String, String> dataValidationSource) {
        this.dataValidationSource = dataValidationSource;
    }
}
