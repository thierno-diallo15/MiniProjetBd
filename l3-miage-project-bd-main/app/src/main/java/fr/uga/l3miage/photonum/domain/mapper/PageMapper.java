package fr.uga.l3miage.photonum.domain.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import fr.uga.l3miage.photonum.domain.DTO.PageDTO;
import fr.uga.l3miage.photonum.domain.model.Image;
import fr.uga.l3miage.photonum.domain.model.Page;

@Mapper
public interface PageMapper {

    @Mapping(source = "photos", target = "photoIds", qualifiedByName = "photosToPhotoIds")
    PageDTO entityToDTO(Page page);

    Collection<PageDTO> entityToDTO(Iterable<Page> pages);

    Page DTOToEntity(PageDTO pageDTO);
    Collection<Page> DTOToEntity(Iterable<PageDTO> pagesDTO);

    @Named("photosToPhotoIds")
    public static List<Long> commandeToCommandeId(List<Image> photos){
        List<Long> photoIds = new ArrayList<>();
       
        for (Image photo: photos){
            photoIds.add(photo.getId());
        }
        return photoIds;
    }

}
