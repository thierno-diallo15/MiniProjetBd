package fr.uga.l3miage.photonum.domain.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import fr.uga.l3miage.photonum.domain.DTO.PrintDTO;
import fr.uga.l3miage.photonum.domain.model.Print;
import fr.uga.l3miage.photonum.domain.model.Article;
import fr.uga.l3miage.photonum.domain.model.Client;
import fr.uga.l3miage.photonum.domain.model.Frame;
import fr.uga.l3miage.photonum.domain.model.Image;

@Mapper
public interface PrintMapper {

    @Mapping(source = "client", target = "clientId", qualifiedByName = "clientToClientId")
    @Mapping(source = "article", target = "articleId", qualifiedByName = "articleToArticleId")
    @Mapping(source = "photos", target = "photoIds", qualifiedByName = "photosToPhotoIds")
    PrintDTO entityToDTO(Print print);

    @Mapping(source = "client", target = "clientId", qualifiedByName = "clientToClientId")
    @Mapping(source = "article", target = "articleId", qualifiedByName = "articleToArticleId")
    @Mapping(source = "photos", target = "photoIds", qualifiedByName = "photosToPhotoIds")
    Collection<PrintDTO> entityToDTO(Iterable<Print> prints);

    Print DTOToEntity(PrintDTO printDto);
    Collection<Print> DTOToEntity(Iterable<PrintDTO> printsDTO);

    @Named("clientToClientId")
    public static Long clientToClientId(Client client){
        return client.getId();
    }

    @Named("articleToArticleId")
    public static Long articleToArticleId(Article article){
        return article.getId();
    }

    @Named("photosToPhotoIds")
    public static List<Long> commandeToCommandeId(List<Image> photos){
        List<Long> photoIds = new ArrayList<>();
       
        for (Image photo: photos){
            photoIds.add(photo.getId());
        }
        return photoIds;
    }
}
