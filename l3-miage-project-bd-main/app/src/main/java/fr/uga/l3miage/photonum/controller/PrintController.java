package fr.uga.l3miage.photonum.controller;

import java.rmi.ServerException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.l3miage.photonum.domain.DTO.PrintDTO;
import fr.uga.l3miage.photonum.services.PrintService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping(value = "/photonum/print", produces = "application/json")
public class PrintController {

    @Autowired
    private PrintService printService;

    @GetMapping()
    public List<PrintDTO> findAll(){
        return printService.getAll();
    }

    @GetMapping(value = "/{id}")
    public PrintDTO findById(@PathVariable("id") Long id){    
        return printService.getById(id);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PrintDTO> create(@RequestBody PrintDTO printDTO) throws ServerException{
        PrintDTO saved = printService.save(printDTO);
        if (saved == null){
            throw new ServerException("Echec de creation du Print!");
        }
        else{
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } 
    } 

    @PutMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<PrintDTO> update(@PathVariable Long id ,@RequestBody PrintDTO printDTO) throws ServerException{
        if (printService.getById(id) == null){
            throw new ServerException("Print " +id + " n'existe pas!");
        }
        
        PrintDTO updated = printService.update(printDTO);
        if (updated == null){
            throw new ServerException("Echec de modification du Print!");
        }
        else{
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } 
    }
}
