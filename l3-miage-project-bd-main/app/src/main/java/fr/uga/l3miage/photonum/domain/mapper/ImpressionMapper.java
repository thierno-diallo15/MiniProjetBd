package fr.uga.l3miage.photonum.domain.mapper;

import org.mapstruct.Mapper;

import fr.uga.l3miage.photonum.domain.DTO.ImpressionDTO;
import fr.uga.l3miage.photonum.domain.model.Impression;

import java.util.Collection;

@Mapper
public interface ImpressionMapper {
    ImpressionDTO entityToDTO(Impression impression);

    Collection<ImpressionDTO> entityToDTO(Iterable<Impression> authors);
//A revoir ***
   // Impression dtoToEntity(ImpressionDTO author);

   // Collection<Impression> dtoToEntity(Iterable<ImpressionDTO> authors);
}