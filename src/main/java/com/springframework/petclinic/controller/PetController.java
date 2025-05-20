package com.springframework.petclinic.controller;

import com.springframework.petclinic.dto.PetDto;
import com.springframework.petclinic.model.Pet;
import com.springframework.petclinic.service.OwnerService;
import com.springframework.petclinic.service.PetService;
import com.springframework.petclinic.service.PetTypeService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author yogesh
 */
@RestController
@RequestMapping("/api/v1/pets")
public class PetController {

    @Autowired
    private PetService petService;
    @Autowired
    private OwnerService ownerService;

    @Autowired
    private PetTypeService petTypeService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/{ownerId}")
    public ResponseEntity<PetDto> addPet(@PathVariable Integer ownerId, @RequestBody @Valid PetDto petDto) {
        final var petTypeOptional = this.petTypeService.findByName(petDto.getType());
        if (petTypeOptional.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        final var ownerOptional = this.ownerService.getOwner(ownerId);
        if (ownerOptional.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        final var objPet = this.modelMapper.map(petDto, Pet.class);
        objPet.setType(petTypeOptional.get());
        objPet.setOwner(ownerOptional.get());
        return new ResponseEntity(this.petService.createPet(this.modelMapper.map(objPet, Pet.class)), HttpStatus.CREATED);
    }

    @GetMapping("/{petId}")
    public ResponseEntity<PetDto> getPet(@PathVariable Integer petId) {
        final var petOptional = this.petService.getPet(petId);
        if (petOptional.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        final var objDto = this.modelMapper.map(petOptional.get(), PetDto.class);
        objDto.setType(petOptional.get().getType().getName());
        return ResponseEntity.ok(objDto);
    }

    @PutMapping("/{ownerId}")
    public ResponseEntity<PetDto> modifyPet(@PathVariable Integer ownerId, @RequestBody @Valid PetDto petDto) {
        final var objPet = this.modelMapper.map(petDto, Pet.class);
        final var petOptional = this.petService.getPet(petDto.getId());
        if (petOptional.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        final var petTypeOptional = this.petTypeService.findByName(petDto.getType());
        if (petTypeOptional.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        final var ownerOptional = this.ownerService.getOwner(ownerId);
        if (ownerOptional.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        objPet.setOwner(ownerOptional.get());
        objPet.setType(petTypeOptional.get());
        return ResponseEntity.ok(this.modelMapper.map(this.petService.updatePet(objPet), PetDto.class));
    }

    @DeleteMapping("/{petId}")
    public ResponseEntity<Void> deletePet(@PathVariable Integer petId) {
        this.petService.deletePet(petId);
        return ResponseEntity.ok(null);
    }

}
