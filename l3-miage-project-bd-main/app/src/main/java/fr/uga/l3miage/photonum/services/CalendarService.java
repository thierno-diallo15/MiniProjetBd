package fr.uga.l3miage.photonum.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.l3miage.photonum.domain.DTO.CalendarDTO;
import fr.uga.l3miage.photonum.domain.mapper.CalendarMapper;
import fr.uga.l3miage.photonum.domain.model.Calendar;
import fr.uga.l3miage.photonum.domain.model.Page;
import fr.uga.l3miage.photonum.repository.CalendarRepository;
import fr.uga.l3miage.photonum.repository.ArticleRepository;
import fr.uga.l3miage.photonum.repository.ClientRepository;
import fr.uga.l3miage.photonum.repository.PageRepository;

@Service
public class CalendarService {
    
    @Autowired
    private CalendarRepository calendarRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private PageRepository pageRepository;

    private CalendarMapper calendarMapper = Mappers.getMapper(CalendarMapper.class);

    public List<CalendarDTO> getAll(){
        List<Calendar> calendars = calendarRepository.findAll();
        return new ArrayList<>(calendarMapper.entityToDTO(calendars)) ;
    }

    public CalendarDTO getById(Long id){
        Calendar calendar = calendarRepository.get(id);
        return calendarMapper.entityToDTO(calendar);
    }

    public CalendarDTO save(CalendarDTO calendarDTO){
        //convertir DTO -> l'objet Calendar
        Calendar calendar = calendarMapper.DTOToEntity(calendarDTO);
        remplirEntity(calendarDTO, calendar);
        Calendar saved = calendarRepository.save(calendar);
        return  calendarMapper.entityToDTO(saved);
    }

    public CalendarDTO update(CalendarDTO calendarDTO){
        //to do: controle le cas ID n'existe pas
        Calendar calendar = calendarMapper.DTOToEntity(calendarDTO);
        remplirEntity(calendarDTO, calendar);
        Calendar updated = calendarRepository.update(calendar);
        return calendarMapper.entityToDTO(updated);
    }

    //remplir les champs qui ne sont pas remplis avec Mapper
    private void remplirEntity(CalendarDTO calendarDTO, Calendar calendar){

        //ajouter Client selon Id
        calendar.setClient(clientRepository.get(calendarDTO.getClientId()));
        
        //ajouter Article selon Id
        if (calendarDTO.getArticleId() == null){
            calendar.setArticle(null);
        }else{
            calendar.setArticle(articleRepository.get(calendarDTO.getArticleId()));
        }
        
        //ajouter Pages selon Id
        Set<Page> pages = new HashSet<>();
        for (Long pageId: calendarDTO.getPageIds()){
            pages.add(pageRepository.get(pageId));
        }
        calendar.setPages(pages);
    }
}
