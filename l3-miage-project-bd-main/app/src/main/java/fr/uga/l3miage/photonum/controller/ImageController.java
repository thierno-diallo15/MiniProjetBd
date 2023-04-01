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

import fr.uga.l3miage.photonum.domain.DTO.ImageDTO;
import fr.uga.l3miage.photonum.services.ImageService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping(value = "/photonum/image", produces = "application/json")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping()
    public List<ImageDTO> findAll(){
        return imageService.getAll();
    }

    @GetMapping(value = "/{id}")
    public ImageDTO findById(@PathVariable("id") Long id){    
        return imageService.getById(id);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ImageDTO> create(@RequestBody ImageDTO imageDTO) throws ServerException{
        ImageDTO saved = imageService.save(imageDTO);
        if (saved == null){
            throw new ServerException("Echec d'upload de l'image!");
        }
        else{
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } 
    } 

    @PutMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<ImageDTO> update(@PathVariable Long id ,@RequestBody ImageDTO imageDTO) throws ServerException{
        if (imageService.getById(id) == null){
            throw new ServerException("Image " +id + " n'existe pas!");
        }
        
        ImageDTO updated = imageService.update(imageDTO);
        if (updated == null){
            throw new ServerException("Echec de modification de l'image!");
        }
        else{
            return new ResponseEntity<>(updated, HttpStatus.CREATED);
        } 
    }

}
