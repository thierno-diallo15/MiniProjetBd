package fr.uga.l3miage.photonum.controller;

import java.rmi.ServerException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.l3miage.photonum.domain.DTO.AddressDTO;
import fr.uga.l3miage.photonum.domain.model.Address;
import fr.uga.l3miage.photonum.services.AddressService;

@RestController
@RequestMapping(value = "/photonum/address", produces = "application/json")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping()
    public List<AddressDTO> findAll(){
        return addressService.getAll();
    }

    @GetMapping(value = "/{id}")
    public AddressDTO findById(@PathVariable("id") Long id){    
        return addressService.getById(id);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<AddressDTO> create(@RequestBody AddressDTO addressDTO) throws ServerException{
        AddressDTO saved = addressService.save(addressDTO);
        if (saved == null){
            throw new ServerException("Echec de creation de l'adresse!");
        }
        else{
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } 
    } 

    @PutMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<AddressDTO> update(@PathVariable Long id ,@RequestBody AddressDTO addressDTO) throws ServerException{
        if (addressService.getById(id) == null){
            throw new ServerException("Address " +id + " n'existe pas!");
        }
        
        AddressDTO updated = addressService.update(addressDTO);
        if (updated == null){
            throw new ServerException("Echec de modification de l'adresse!");
        }
        else{
            return new ResponseEntity<>(updated, HttpStatus.CREATED);
        } 
    }
}
