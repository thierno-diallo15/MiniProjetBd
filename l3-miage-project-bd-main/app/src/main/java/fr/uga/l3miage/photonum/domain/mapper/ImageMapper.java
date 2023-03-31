package fr.uga.l3miage.photonum.domain.mapper;

import java.util.Collection;

import org.mapstruct.Mapper;

import fr.uga.l3miage.photonum.domain.DTO.ImageDTO;
import fr.uga.l3miage.photonum.domain.model.Image;

@Mapper
public interface ImageMapper {
    ImageDTO entityToDTO(Image image);

    Image DTOToEntity(ImageDTO imageDto);

    Collection<ImageDTO> entityToDTO(Iterable<Image> images);

    Collection<Image> DTOToEntity(Iterable<ImageDTO> imagesDTO);
}
