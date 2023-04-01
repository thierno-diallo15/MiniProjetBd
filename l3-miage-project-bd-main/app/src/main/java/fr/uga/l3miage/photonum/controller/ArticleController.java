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

import fr.uga.l3miage.photonum.domain.DTO.ArticleDTO;
import fr.uga.l3miage.photonum.services.ArticleService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping(value = "/photonum/article", produces = "application/json")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping()
    public List<ArticleDTO> findAll(){
        return articleService.getAll();
    }

    @GetMapping(value = "/{id}")
    public ArticleDTO findById(@PathVariable("id") Long id){    
        return articleService.getById(id);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ArticleDTO> create(@RequestBody ArticleDTO articleDTO) throws ServerException{
        ArticleDTO saved = articleService.save(articleDTO);
        if (saved == null){
            throw new ServerException("Echec de creation de l'article!");
        }
        else{
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } 
    } 

    @PutMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<ArticleDTO> update(@PathVariable Long id ,@RequestBody ArticleDTO articleDTO) throws ServerException{
        if (articleService.getById(id) == null){
            throw new ServerException("Article " +id + " n'existe pas!");
        }
        
        ArticleDTO updated = articleService.update(articleDTO);
        if (updated == null){
            throw new ServerException("Echec de modification de l'article!");
        }
        else{
            return new ResponseEntity<>(updated, HttpStatus.CREATED);
        } 
    }
}
