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

import fr.uga.l3miage.photonum.domain.DTO.AlbumDTO;
import fr.uga.l3miage.photonum.services.AlbumService;
import fr.uga.l3miage.photonum.services.FrameService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping(value = "/photonum/album", produces = "application/json")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping()
    public List<AlbumDTO> findAll(){
        return albumService.getAll();
    }

    @GetMapping(value = "/{id}")
    public AlbumDTO findById(@PathVariable("id") Long id){    
        return albumService.getById(id);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<AlbumDTO> create(@RequestBody AlbumDTO albumDTO) throws ServerException{
        AlbumDTO saved = albumService.save(albumDTO);
        if (saved == null){
            throw new ServerException("Echec de creation de l'Album!");
        }
        else{
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } 
    } 

    @PutMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<AlbumDTO> update(@PathVariable Long id ,@RequestBody AlbumDTO albumDTO) throws ServerException{
        if (albumService.getById(id) == null){
            throw new ServerException("Album " +id + " n'existe pas!");
        }
        
        AlbumDTO updated = albumService.update(albumDTO);
        if (updated == null){
            throw new ServerException("Echec de modification du Album!");
        }
        else{
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } 
    }
}
