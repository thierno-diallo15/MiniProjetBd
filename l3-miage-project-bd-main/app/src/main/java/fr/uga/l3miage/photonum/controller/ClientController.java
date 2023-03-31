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

import fr.uga.l3miage.photonum.domain.DTO.ClientDTO;
import fr.uga.l3miage.photonum.domain.model.Client;
import fr.uga.l3miage.photonum.services.ClientService;

@RestController
@RequestMapping(value = "/photonum/client", produces = "application/json")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping()
    public List<ClientDTO> findAll(){
        return clientService.getAll();
    }

    @GetMapping(value = "/{id}")
    public ClientDTO findById(@PathVariable("id") Long id) throws ServerException{  
        ClientDTO clientDTO = clientService.getById(id);
        if (clientDTO == null){
            throw new ServerException("Client " +id + " n'existe pas!");
        }  
        return clientService.getById(id);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ClientDTO> create(@RequestBody Client newClient) throws ServerException{
        ClientDTO saved = clientService.save(newClient);
        if (saved == null){
            throw new ServerException("Echec de creation du compte!");
        }
        else{
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } 
    }

    @PutMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<ClientDTO> update(@PathVariable Long id ,@RequestBody Client client) throws ServerException{
        if (clientService.getById(id) == null){
            throw new ServerException("Client " +id + " n'existe pas!");
        }
        
        ClientDTO updated = clientService.update(client);
        if (updated == null){
            throw new ServerException("Echec de modification du compte!");
        }
        else{
            return new ResponseEntity<>(updated, HttpStatus.CREATED);
        } 
    }

}
