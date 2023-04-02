package fr.uga.l3miage.photonum.domain.mapper;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import fr.uga.l3miage.photonum.domain.DTO.AlbumDTO;
import fr.uga.l3miage.photonum.domain.model.Album;
import fr.uga.l3miage.photonum.domain.model.Article;
import fr.uga.l3miage.photonum.domain.model.Client;
import fr.uga.l3miage.photonum.domain.model.Image;
import fr.uga.l3miage.photonum.domain.model.Page;

@Mapper
public interface AlbumMapper {

    @Mapping(source = "cover", target = "coverId", qualifiedByName = "coverToCoverId")
    @Mapping(source = "client", target = "clientId", qualifiedByName = "clientToClientId")
    @Mapping(source = "article", target = "articleId", qualifiedByName = "articleToArticleId")
    @Mapping(source = "pages", target = "pageIds", qualifiedByName = "pagesToPageIds")
    AlbumDTO entityToDTO(Album album);

    @Mapping(source = "cover", target = "coverId", qualifiedByName = "coverToCoverId")
    @Mapping(source = "client", target = "clientId", qualifiedByName = "clientToClientId")
    @Mapping(source = "article", target = "articleId", qualifiedByName = "articleToArticleId")
    @Mapping(source = "pages", target = "pageIds", qualifiedByName = "pagesToPageIds")
    Collection<AlbumDTO> entityToDTO(Iterable<Album> albums);
    

    Album DTOToEntity(AlbumDTO albumDto);
    Collection<Album> DTOToEntity(Iterable<AlbumDTO> albumsDTO);

    @Named("coverToCoverId")
    public static Long coverToCoverId(Image cover){
        return cover.getId();
    }
    
    @Named("clientToClientId")
    public static Long clientToClientId(Client client){
        return client.getId();
    }

    @Named("articleToArticleId")
    public static Long articleToArticleId(Article article){
        return article.getId();
    }

    @Named("pagesToPageIds")
    public static Set<Long> pagesToPageIds(Set<Page> pages){
        Set<Long> pageIds = new HashSet<>();
       
        for (Page page: pages){
            pageIds.add(page.getId());
        }
        return pageIds;
    }
}
