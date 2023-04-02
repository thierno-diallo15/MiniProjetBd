package fr.uga.l3miage.photonum.services;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.l3miage.photonum.domain.DTO.PageDTO;
import fr.uga.l3miage.photonum.domain.mapper.PageMapper;
import fr.uga.l3miage.photonum.domain.model.Image;
import fr.uga.l3miage.photonum.domain.model.Page;
import fr.uga.l3miage.photonum.repository.ImageRepository;
import fr.uga.l3miage.photonum.repository.PageRepository;

@Service
public class PageService {

    @Autowired
    private PageRepository pageRepository;
    
    @Autowired
    private ImageRepository imageRepository;

    private PageMapper pageMapper = Mappers.getMapper(PageMapper.class);

    public List<PageDTO> getAll(){
        List<Page> pages = pageRepository.findAll();
        return new ArrayList<>(pageMapper.entityToDTO(pages)) ;
    }

    public PageDTO getById(Long id){
        Page page = pageRepository.get(id);
        return pageMapper.entityToDTO(page);
    }

    public PageDTO save(PageDTO pageDTO){
        //convertir DTO -> l'objet Adresse
        Page page = pageMapper.DTOToEntity(pageDTO);
        
        //ajouter Images selon Id
        List<Image> photos = new ArrayList<>();
        for (Long photoId: pageDTO.getPhotoIds()){
            photos.add(imageRepository.get(photoId));
        }
        page.setPhotos(photos);

        Page saved = pageRepository.save(page);
        return  pageMapper.entityToDTO(saved);
    }

    public PageDTO update(PageDTO pageDTO){
        //to do: controle le cas ID n'existe pas
        Page page = pageMapper.DTOToEntity(pageDTO);
        
        //ajouter Images selon Id
        List<Image> photos = new ArrayList<>();
        for (Long photoId : pageDTO.getPhotoIds()){
            photos.add(imageRepository.get(photoId));
        }
        page.setPhotos(photos);
        
        Page updated = pageRepository.update(page);
        return pageMapper.entityToDTO(updated);
    }
    
}
