package fr.uga.l3miage.photonum.domain.mapper;

import java.util.Collection;

import org.mapstruct.Mapper;

import fr.uga.l3miage.photonum.domain.DTO.FrameDTO;
import fr.uga.l3miage.photonum.domain.model.Frame;

@Mapper
public interface FrameMapper {

    FrameDTO entityToDTO(Frame frame);

    Frame DTOToEntity(FrameDTO frameDto);

    Collection<FrameDTO> entityToDTO(Iterable<Frame> frames);

    Collection<Frame> DTOToEntity(Iterable<FrameDTO> imagesDTO);
}
