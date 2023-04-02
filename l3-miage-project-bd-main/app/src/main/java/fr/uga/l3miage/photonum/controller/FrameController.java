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

import fr.uga.l3miage.photonum.domain.DTO.FrameDTO;
import fr.uga.l3miage.photonum.services.FrameService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping(value = "/photonum/frame", produces = "application/json")
public class FrameController {

    @Autowired
    private FrameService frameService;

    @GetMapping()
    public List<FrameDTO> findAll(){
        return frameService.getAll();
    }

    @GetMapping(value = "/{id}")
    public FrameDTO findById(@PathVariable("id") Long id){    
        return frameService.getById(id);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<FrameDTO> create(@RequestBody FrameDTO frameDTO) throws ServerException{
        FrameDTO saved = frameService.save(frameDTO);
        if (saved == null){
            throw new ServerException("Echec de creation du Frame!");
        }
        else{
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } 
    } 

    @PutMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<FrameDTO> update(@PathVariable Long id ,@RequestBody FrameDTO frameDTO) throws ServerException{
        if (frameService.getById(id) == null){
            throw new ServerException("Frame " +id + " n'existe pas!");
        }
        
        FrameDTO updated = frameService.update(frameDTO);
        if (updated == null){
            throw new ServerException("Echec de modification du Frame!");
        }
        else{
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } 
    }
}
