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
import org.springframework.web.bind.annotation.ResponseStatus;
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
    public ClientDTO findById(@PathVariable("id") Long id){    
        return clientService.getById(id);
    }

    @PutMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<Client> updateClient(@PathVariable("id") Long id , @RequestBody Client client){
      client.setId(id);
      Client saved = clientService.save(client);
      return new ResponseEntity<Client>(saved,HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Client> create(@RequestBody Client newClient) throws ServerException{
        Client saved = clientService.save(newClient);
        if (saved == null){
            throw new ServerException("Echec de creation du compte!");
        }
        else{
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } 
    }

}
