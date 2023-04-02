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

import fr.uga.l3miage.photonum.domain.DTO.PageDTO;
import fr.uga.l3miage.photonum.services.PageService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping(value = "/photonum/page", produces = "application/json")
public class PageController {

    @Autowired
    private PageService pageService;

    @GetMapping()
    public List<PageDTO> findAll(){
        return pageService.getAll();
    }

    @GetMapping(value = "/{id}")
    public PageDTO findById(@PathVariable("id") Long id){    
        return pageService.getById(id);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PageDTO> create(@RequestBody PageDTO pageDTO) throws ServerException{
        PageDTO saved = pageService.save(pageDTO);
        if (saved == null){
            throw new ServerException("Echec de creation du Page!");
        }
        else{
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } 
    } 

    @PutMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<PageDTO> update(@PathVariable Long id ,@RequestBody PageDTO pageDTO) throws ServerException{
        if (pageService.getById(id) == null){
            throw new ServerException("Page " +id + " n'existe pas!");
        }
        
        PageDTO updated = pageService.update(pageDTO);
        if (updated == null){
            throw new ServerException("Echec de modification du Page!");
        }
        else{
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } 
    }

}
