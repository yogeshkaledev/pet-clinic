package com.springframework.petclinic.service;

import com.springframework.petclinic.model.PetType;
import com.springframework.petclinic.repository.PetTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author yogesh
 */
@Service
@Transactional
public class PetTypeServiceImpl implements PetTypeService {
    @Autowired
    private PetTypesRepository petTypesRepository;

    @Override
    public Optional<PetType> findByName(String name) {
        return this.petTypesRepository.findByName(name);
    }
}
