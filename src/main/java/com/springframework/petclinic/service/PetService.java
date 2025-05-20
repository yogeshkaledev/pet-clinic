package com.springframework.petclinic.service;

import com.springframework.petclinic.model.Pet;

import java.util.Optional;

public interface PetService {
    Pet createPet(Pet pet);
    Optional<Pet> getPet(Integer petId);
    Pet updatePet(Pet pet);
    void deletePet(Integer petId);
}
