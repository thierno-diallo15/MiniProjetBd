package fr.uga.l3miage.photonum.domain.mapper;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import fr.uga.l3miage.photonum.domain.DTO.CalendarDTO;
import fr.uga.l3miage.photonum.domain.model.Calendar;
import fr.uga.l3miage.photonum.domain.model.Article;
import fr.uga.l3miage.photonum.domain.model.Client;
import fr.uga.l3miage.photonum.domain.model.Page;

@Mapper
public interface CalendarMapper {

    @Mapping(source = "client", target = "clientId", qualifiedByName = "clientToClientId")
    @Mapping(source = "article", target = "articleId", qualifiedByName = "articleToArticleId")
    @Mapping(source = "pages", target = "pageIds", qualifiedByName = "pagesToPageIds")
    CalendarDTO entityToDTO(Calendar calendar);

    @Mapping(source = "client", target = "clientId", qualifiedByName = "clientToClientId")
    @Mapping(source = "article", target = "articleId", qualifiedByName = "articleToArticleId")
    @Mapping(source = "pages", target = "pageIds", qualifiedByName = "pagesToPageIds")
    Collection<CalendarDTO> entityToDTO(Iterable<Calendar> calendars);

    Calendar DTOToEntity(CalendarDTO calendarDto);

    Collection<Calendar> DTOToEntity(Iterable<CalendarDTO> calendarsDTO);

    @Named("clientToClientId")
    public static Long clientToClientId(Client client){
        return client.getId();
    }

    @Named("articleToArticleId")
    public static Long articleToArticleId(Article article){
        return article.getId();
    }

    @Named("pagesToPageIds")
    public static Set<Long> pagesToPageIds(Set<Page> pages){
        Set<Long> pageIds = new HashSet<>();
       
        for (Page page: pages){
            pageIds.add(page.getId());
        }
        return pageIds;
    }
}
