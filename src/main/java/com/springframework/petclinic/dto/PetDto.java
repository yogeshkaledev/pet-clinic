package com.springframework.petclinic.dto;

import com.springframework.petclinic.dto.common.NamedDto;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class PetDto extends NamedDto {
    private LocalDate birthDate;
    @NotBlank(message = "type is required")
    private String type;
    @NotBlank(message = "temperament is required")
    private String temperament;
    private Float petLength;
    private Float weight;

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public Float getPetLength() {
        return petLength;
    }

    public void setPetLength(Float petLength) {
        this.petLength = petLength;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }
}
