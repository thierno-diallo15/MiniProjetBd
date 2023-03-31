package fr.uga.l3miage.photonum.domain.mapper;

import java.util.Collection;

import org.mapstruct.Mapper;

import fr.uga.l3miage.photonum.domain.DTO.PrintDTO;
import fr.uga.l3miage.photonum.domain.model.Print;

@Mapper
public interface PrintMapper {

    PrintDTO entityToDTO(Print print);

    Print DTOToEntity(PrintDTO printDto);

    Collection<PrintDTO> entityToDTO(Iterable<Print> prints);

    Collection<Print> DTOToEntity(Iterable<PrintDTO> printsDTO);
}
