package fr.uga.l3miage.photonum.services;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.l3miage.photonum.domain.DTO.ArticleDTO;
import fr.uga.l3miage.photonum.domain.mapper.ArticleMapper;
import fr.uga.l3miage.photonum.domain.model.Article;
import fr.uga.l3miage.photonum.repository.ArticleRepository;
import fr.uga.l3miage.photonum.repository.CommandeRepository;

@Service
public class ArticleService {
    
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CommandeRepository commandeRepository;

    private ArticleMapper articleMapper = Mappers.getMapper(ArticleMapper.class);
    
    //to do: remplacer clientId par ClientDTO pour meilleure affichage
    public List<ArticleDTO> getAll(){
        List<Article> articles = articleRepository.findAll();
        return new ArrayList<>(articleMapper.entityToDTO(articles)) ;
    }

    public ArticleDTO getById(Long id){
        Article article = articleRepository.get(id);
        ArticleDTO articleDTO = articleMapper.entityToDTO(article);
        articleDTO.setCommandeId(article.getCommande().getId());
        return (articleDTO);
    }

    // public AddressDTO save(AddressDTO addressDTO){
    //     //convertir l'objet DTO -> l'objet Adresse
    //     Address address = addressMapper.DTOToEntity(addressDTO);
    //     Client client = clientRepository.get(addressDTO.getClientId());
    //     //Mappeur non capable de convertir (Long) client_id -> l'objet Client
    //     //  -> on le fait manuellement 
    //     address.setClient(client);

    //     Address saved = addressRepository.save(address);
    //     AddressDTO savedDTO = addressMapper.entityToDTO(saved);
    //     //convertir manuellement l'objet Client -> (Long) client_id pour DTO
    //     savedDTO.setClientId(saved.getClient().getId());
    //     return  savedDTO;
    // }
}
