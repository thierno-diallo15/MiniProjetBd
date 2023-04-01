package fr.uga.l3miage.photonum.services;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.l3miage.photonum.domain.DTO.ArticleDTO;
import fr.uga.l3miage.photonum.domain.mapper.ArticleMapper;
import fr.uga.l3miage.photonum.domain.model.Article;
import fr.uga.l3miage.photonum.domain.model.Commande;
import fr.uga.l3miage.photonum.repository.ArticleRepository;
import fr.uga.l3miage.photonum.repository.CommandeRepository;

@Service
public class ArticleService {
    
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CommandeRepository commandeRepository;

    private ArticleMapper articleMapper = Mappers.getMapper(ArticleMapper.class);


    public List<ArticleDTO> getAll(){
        List<Article> articles = articleRepository.findAll();
        return new ArrayList<>(articleMapper.entityToDTO(articles)) ;
    }

    public ArticleDTO getById(Long id){
        Article article = articleRepository.get(id);
        return articleMapper.entityToDTO(article);
    }

    public ArticleDTO save(ArticleDTO ArticleDTO){
        //convertir l'objet DTO -> l'objet Adresse
        Article article = articleMapper.DTOToEntity(ArticleDTO);
        Commande commande = commandeRepository.get(ArticleDTO.getCommandeId());
        article.setCommande(commande);

        Article saved = articleRepository.save(article);
        return  articleMapper.entityToDTO(saved);
    }

    public ArticleDTO update(ArticleDTO articleDTO){
        //convertir ArticleDTO -> Article 
        Article article = articleMapper.DTOToEntity(articleDTO);
        article.setCommande(commandeRepository.get(articleDTO.getCommandeId()));
        //to do: controle le cas ID n'existe pas

        Article updated = articleRepository.update(article);
        return articleMapper.entityToDTO(updated);
    }
}
