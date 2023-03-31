package fr.uga.l3miage.photonum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.l3miage.photonum.domain.DTO.ArticleDTO;
import fr.uga.l3miage.photonum.services.ArticleService;

@RestController
@RequestMapping(value = "/photonum/article", produces = "application/json")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping()
    public List<ArticleDTO> findAll(){
        return articleService.getAll();
    }

    // @GetMapping(value = "/{id}")
    // public AddressDTO findById(@PathVariable("id") Long id){    
    //     return addressService.getById(id);
    // }

    // @PostMapping
    // @Transactional
    // public ResponseEntity<AddressDTO> create(@RequestBody AddressDTO addressDTO) throws ServerException{
    //     AddressDTO saved = addressService.save(addressDTO);
    //     if (saved == null){
    //         throw new ServerException("Echec de creation de l'adresse!");
    //     }
    //     else{
    //         return new ResponseEntity<>(saved, HttpStatus.CREATED);
    //     } 
    // } 
}
