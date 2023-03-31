package fr.uga.l3miage.photonum.domain.mapper;

import java.util.Collection;

import org.mapstruct.Mapper;

import fr.uga.l3miage.photonum.domain.DTO.AlbumDTO;
import fr.uga.l3miage.photonum.domain.model.Album;

@Mapper
public interface AlbumMapper {
    AlbumDTO entityToDTO(Album album);

    Album DTOToEntity(AlbumDTO albumDto);

    Collection<AlbumDTO> entityToDTO(Iterable<Album> albums);

    Collection<Album> DTOToEntity(Iterable<AlbumDTO> albumsDTO);
}
