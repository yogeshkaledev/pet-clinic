package com.springframework.petclinic.repository;

import com.springframework.petclinic.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Yogesh Kale
 */
@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {
}
