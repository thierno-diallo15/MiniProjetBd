package fr.uga.l3miage.photonum.controller;

import java.rmi.ServerException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import fr.uga.l3miage.photonum.domain.DTO.CommandeDTO;
import fr.uga.l3miage.photonum.services.CommandeService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping(value = "/photonum/commande", produces = "application/json")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    @GetMapping()
    public List<CommandeDTO> findAll(){
        return commandeService.getAll();
    }
    @GetMapping(value = "/{id}")
    public CommandeDTO findById(@PathVariable("id") Long id){    
        return commandeService.getById(id);
    }
    
    @PostMapping
    @Transactional
    public ResponseEntity<CommandeDTO> create(@RequestBody CommandeDTO commandeDTO) throws ServerException{
        CommandeDTO saved = commandeService.save(commandeDTO);
        if (saved == null){
            throw new ServerException("Echec de creation du compte!");
        }
        else{
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } 
    }

}
