package fr.uga.l3miage.photonum.services;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.l3miage.photonum.domain.DTO.ImageDTO;
import fr.uga.l3miage.photonum.domain.mapper.ImageMapper;
import fr.uga.l3miage.photonum.domain.model.Client;
import fr.uga.l3miage.photonum.domain.model.Image;
import fr.uga.l3miage.photonum.repository.ClientRepository;
import fr.uga.l3miage.photonum.repository.ImageRepository;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ClientRepository clientRepository;

    private ImageMapper imageMapper = Mappers.getMapper(ImageMapper.class);


    public List<ImageDTO> getAll(){
        List<Image> images = imageRepository.findAll();
        return new ArrayList<>(imageMapper.entityToDTO(images)) ;
    }

    public ImageDTO getById(Long id){
        Image image = imageRepository.get(id);
        return imageMapper.entityToDTO(image);
    }
    
    public ImageDTO save(ImageDTO ImageDTO){
        //convertir l'objet DTO -> l'objet Adresse
        Image image = imageMapper.DTOToEntity(ImageDTO);
        Client owner = clientRepository.get(ImageDTO.getOwnerId());
        image.setOwner(owner);

        Image saved = imageRepository.save(image);
        return  imageMapper.entityToDTO(saved);
    }

    public ImageDTO update(ImageDTO imageDTO){
        //convertir ImageDTO -> Image 
        Image image = imageMapper.DTOToEntity(imageDTO);
        image.setOwner(clientRepository.get(imageDTO.getOwnerId()));
        //to do: controle le cas ID n'existe pas

        Image updated = imageRepository.update(image);
        return imageMapper.entityToDTO(updated);
    }
}

