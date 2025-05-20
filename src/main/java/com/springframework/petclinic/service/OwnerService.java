package com.springframework.petclinic.service;

import com.springframework.petclinic.dto.OwnerDto;
import com.springframework.petclinic.model.Owner;
import com.springframework.petclinic.model.Pet;

import java.util.Optional;

public interface OwnerService {
    Owner createOwner(Owner owner);
    Optional<Owner> getOwner(Integer ownerId);
    Owner updateOwner(Owner owner);
    void deleteOwner(Integer ownerId);
}
