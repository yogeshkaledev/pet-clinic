package com.springframework.petclinic.service;

import com.springframework.petclinic.dto.OwnerDto;
import com.springframework.petclinic.model.Owner;
import com.springframework.petclinic.repository.OwnerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class OwnerServiceImpl implements OwnerService{

    @Autowired
    private OwnerRepository ownerRepository;
    @Override
    public Owner createOwner(Owner owner) {
        return this.ownerRepository.save(owner);
    }

    @Override
    public Optional<Owner> getOwner(Integer ownerId) {
        return this.ownerRepository.findById(ownerId);
    }

    @Override
    public Owner updateOwner(Owner owner) {
        return this.ownerRepository.save(owner);
    }

    @Override
    public void deleteOwner(Integer ownerId) {
        this.ownerRepository.deleteById(ownerId);

    }
}
