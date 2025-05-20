package com.springframework.petclinic.service;

import com.springframework.petclinic.model.Pet;
import com.springframework.petclinic.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PetServiceImpl implements PetService {
    @Autowired
    private PetRepository petRepository;
    @Override
    public Pet createPet(Pet pet) {
        return this.petRepository.save(pet);
    }

    @Override
    public Optional<Pet> getPet(Integer petId) {
        return this.petRepository.findById(petId);
    }

    @Override
    public Pet updatePet(Pet pet) {
        return this.petRepository.save(pet);
    }

    @Override
    public void deletePet(Integer petId) {
        this.petRepository.deleteById(petId);
    }
}
