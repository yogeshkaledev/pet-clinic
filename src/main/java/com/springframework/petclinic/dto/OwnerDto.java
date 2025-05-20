package com.springframework.petclinic.dto;

import com.springframework.petclinic.dto.common.Person;
import jakarta.validation.constraints.NotBlank;

public class OwnerDto extends Person {
    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "city is required")
    private String city;

    @NotBlank(message = "telephone is required")
    private String telephone;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
