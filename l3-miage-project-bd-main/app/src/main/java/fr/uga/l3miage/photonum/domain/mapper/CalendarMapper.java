package fr.uga.l3miage.photonum.domain.mapper;

import java.util.Collection;

import org.mapstruct.Mapper;

import fr.uga.l3miage.photonum.domain.DTO.CalendarDTO;
import fr.uga.l3miage.photonum.domain.model.Calendar;

@Mapper
public interface CalendarMapper {

    CalendarDTO entityToDTO(Calendar calendar);

    Calendar DTOToEntity(CalendarDTO calendarDto);

    Collection<CalendarDTO> entityToDTO(Iterable<Calendar> calendars);

    Collection<Calendar> DTOToEntity(Iterable<CalendarDTO> calendarsDTO);
}
