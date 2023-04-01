package fr.uga.l3miage.photonum.domain.mapper;

import java.util.Collection;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import fr.uga.l3miage.photonum.domain.DTO.ImageDTO;
import fr.uga.l3miage.photonum.domain.model.Client;
import fr.uga.l3miage.photonum.domain.model.Image;

@Mapper
public interface ImageMapper {

    @Mapping(source = "owner", target = "ownerId", qualifiedByName = "ownerToOwnerId")
    ImageDTO entityToDTO(Image image);

    @Mapping(source = "owner", target = "ownerId", qualifiedByName = "ownerToOwnerId")
    Collection<ImageDTO> entityToDTO(Iterable<Image> images);

    Image DTOToEntity(ImageDTO imageDto);

    Collection<Image> DTOToEntity(Iterable<ImageDTO> imagesDTO);

    @Named("ownerToOwnerId")
    public static Long commandeToCommandeId(Client owner){
        return owner.getId();
    }
}
