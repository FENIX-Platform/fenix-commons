package org.fao.fenix.commons.msd.dto.full;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.fao.fenix.commons.mdsd.annotations.Description;
import org.fao.fenix.commons.mdsd.annotations.Format;
import org.fao.fenix.commons.mdsd.annotations.Label;
import org.fao.fenix.commons.mdsd.annotations.Order;
import org.fao.fenix.commons.msd.dto.JSONEntity;

import java.io.Serializable;
import java.util.Map;

public class OjContact extends JSONEntity implements Serializable {
    
    @JsonProperty
    @Label(en="Telephone number",fr="Numéro de téléphone",es="Número de teléfono")
    @Description(en="Telephone numbers at which the organization or individual may be contacted.")
    @Order(1)
    @Format(Format.FORMAT.tel)
    private String phone;

    @JsonProperty
    @Label(en="Address",fr="Adresse",es="Dirección")
    @Description(en="Physical address at which the organization or individual may be contacted.")
    @Order(2)
    @Format(Format.FORMAT.string)
    private String address;

    @JsonProperty
    @Label(en="e-mail address",fr="Adresse Email",es="Dirección de correo electrónico")
    @Description(en="E-mail address at which the organization or individual may be contacted.")
    @Order(3)
    @Format(Format.FORMAT.email)
    private String emailAddress;

    @JsonProperty
    @Label(en="Hour of service",fr="Heures de service",es="Horarios de servicio")
    @Description(en="Time period (including time zone) when individuals can contact the organization or individual.")
    @Order(4)
    @Format(Format.FORMAT.string)
    private Map<String, String> hoursOfService;

    @JsonProperty
    @Label(en="Instruction",fr="Instruction",es="Instrucción")
    @Description(en="Supplemental instructions on how or when to contact the individual or organization.")
    @Order(5)
    @Format(Format.FORMAT.string)
    private Map<String, String> contactInstruction;


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Map<String, String> getHoursOfService() {
        return hoursOfService;
    }

    public void setHoursOfService(Map<String, String> hoursOfService) {
        this.hoursOfService = hoursOfService;
    }

    public Map<String, String> getContactInstruction() {
        return contactInstruction;
    }

    public void setContactInstruction(Map<String, String> contactInstruction) {
        this.contactInstruction = contactInstruction;
    }
}
