package com.springframework.petclinic.repository;

import com.springframework.petclinic.model.PetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PetTypesRepository extends JpaRepository<PetType, Integer> {
//    @Query("SELECT p FROM PetType p WHERE LOWER(p.name) = LOWER(:name)")
    Optional<PetType> findByName(String name);
}
