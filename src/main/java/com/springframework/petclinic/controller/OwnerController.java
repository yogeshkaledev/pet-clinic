package com.springframework.petclinic.controller;

import com.springframework.petclinic.dto.OwnerDto;
import com.springframework.petclinic.dto.PetDto;
import com.springframework.petclinic.model.Owner;
import com.springframework.petclinic.service.OwnerService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Yogesh Kale
 */
@RestController
@RequestMapping("/api/v1/owners")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<OwnerDto> createOwner(@RequestBody @Valid OwnerDto ownerDto) {
        final var owner = this.ownerService.createOwner(modelMapper.map(ownerDto, Owner.class));
        return new ResponseEntity<>(modelMapper.map(owner, OwnerDto.class), HttpStatus.CREATED);
    }

    @GetMapping("/{ownerId}")
    public ResponseEntity<OwnerDto> getOwner(@PathVariable Integer ownerId) {
        final var ownerOptional = ownerService.getOwner(ownerId);
        if (ownerOptional.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(this.modelMapper.map(ownerOptional.get(), OwnerDto.class));
    }

    @PutMapping
    public ResponseEntity<OwnerDto> modifyOwner(@RequestBody @Valid OwnerDto ownerDto) {
        final var objOwner = this.modelMapper.map(ownerDto, Owner.class);
        final var ownerOptional = ownerService.getOwner(ownerDto.getId());
        if (ownerOptional.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        objOwner.setPets(ownerOptional.get().getPets());
        return ResponseEntity.ok(this.modelMapper.map(this.ownerService.updateOwner(objOwner), OwnerDto.class));
    }

    @DeleteMapping("/{ownerId}")
    public ResponseEntity<Void> deleteOwner(@PathVariable Integer ownerId) {
        this.ownerService.deleteOwner(ownerId);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/pets/{ownerId}")
    public ResponseEntity<List<PetDto>> getAllPets(@PathVariable Integer ownerId) {
        final var ownerOptional = this.ownerService.getOwner(ownerId);
        if (ownerOptional.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        final var pets = ownerOptional.get().getPets();
        if (Objects.nonNull(pets)) {
            return ResponseEntity.ok(pets.stream().map(p -> this.modelMapper.map(p, PetDto.class)).collect(Collectors.toList()));
        }
        return ResponseEntity.noContent().build();
    }
}
