package com.springframework.petclinic.service;

import com.springframework.petclinic.model.PetType;

import java.util.Optional;

/**
 * @author yogesh
 */
public interface PetTypeService {
    Optional<PetType> findByName(String name);
}
