package fr.uga.l3miage.photonum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.l3miage.photonum.domain.DTO.AddressDTO;
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

    /*@PostMapping
    public ResponseEntity<ClientDTO> create(@RequestBody Client newClient) throws ServerException{
        ClientDTO saved = clientService.save(newClient);
        if (saved == null){
            throw new ServerException("Echec de creation du compte!");
        }
        else{
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } 
    } */
}
