package fr.uga.l3miage.photonum.domain.mapper;

import java.util.Collection;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import fr.uga.l3miage.photonum.domain.DTO.ArticleDTO;
import fr.uga.l3miage.photonum.domain.model.Article;
import fr.uga.l3miage.photonum.domain.model.Commande;

@Mapper
public interface ArticleMapper {
    
    @Mapping(source = "commande", target = "commandeId", qualifiedByName = "commandeToCommandeId")
    ArticleDTO entityToDTO(Article article);

    @Mapping(source = "commande", target = "commandeId", qualifiedByName = "commandeToCommandeId")
    Collection<ArticleDTO> entityToDTO(Iterable<Article> articles);

    Article DTOToEntity(ArticleDTO articleDto);
    Collection<Article> DTOToEntity(Iterable<ArticleDTO> articlesDTO);

    @Named("commandeToCommandeId")
    public static Long commandeToCommandeId(Commande commande){
        return commande.getId();
    }
}
