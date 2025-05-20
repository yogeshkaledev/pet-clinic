package com.springframework.petclinic.repository;

import com.springframework.petclinic.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Yogesh Kale
 */
@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer> {
}
