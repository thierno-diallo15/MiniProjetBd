package fr.uga.l3miage.photonum.domain.mapper;

import java.util.Collection;

import org.mapstruct.Mapper;

import fr.uga.l3miage.photonum.domain.DTO.ArticleDTO;
import fr.uga.l3miage.photonum.domain.model.Article;

@Mapper
public interface ArticleMapper {
    ArticleDTO entityToDTO(Article article);

    Article DTOToEntity(ArticleDTO articleDto);

    Collection<ArticleDTO> entityToDTO(Iterable<Article> articles);

    Collection<Article> DTOToEntity(Iterable<ArticleDTO> articlesDTO);
}
