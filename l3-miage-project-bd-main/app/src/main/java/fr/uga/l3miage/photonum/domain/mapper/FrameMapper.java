package fr.uga.l3miage.photonum.domain.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import fr.uga.l3miage.photonum.domain.DTO.FrameDTO;
import fr.uga.l3miage.photonum.domain.model.Article;
import fr.uga.l3miage.photonum.domain.model.Client;
import fr.uga.l3miage.photonum.domain.model.Frame;
import fr.uga.l3miage.photonum.domain.model.Image;

@Mapper
public interface FrameMapper {

    @Mapping(source = "client", target = "clientId", qualifiedByName = "clientToClientId")
    @Mapping(source = "article", target = "articleId", qualifiedByName = "articleToArticleId")
    @Mapping(source = "photos", target = "photoIds", qualifiedByName = "photosToPhotoIds")
    FrameDTO entityToDTO(Frame frame);

    @Mapping(source = "photos", target = "photoIds", qualifiedByName = "photosToPhotoIds")
    Collection<FrameDTO> entityToDTO(Iterable<Frame> frames);
    
    Frame DTOToEntity(FrameDTO frameDto);

    Collection<Frame> DTOToEntity(Iterable<FrameDTO> imagesDTO);

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
