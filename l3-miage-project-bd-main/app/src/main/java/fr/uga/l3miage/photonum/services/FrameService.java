package fr.uga.l3miage.photonum.services;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.l3miage.photonum.domain.DTO.FrameDTO;
import fr.uga.l3miage.photonum.domain.mapper.FrameMapper;
import fr.uga.l3miage.photonum.domain.model.Frame;
import fr.uga.l3miage.photonum.domain.model.Image;
import fr.uga.l3miage.photonum.repository.ArticleRepository;
import fr.uga.l3miage.photonum.repository.ClientRepository;
import fr.uga.l3miage.photonum.repository.FrameRepository;
import fr.uga.l3miage.photonum.repository.ImageRepository;

@Service
public class FrameService {
    
    @Autowired
    private FrameRepository frameRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ImageRepository imageRepository;

    private FrameMapper frameMapper = Mappers.getMapper(FrameMapper.class);

    public List<FrameDTO> getAll(){
        List<Frame> frames = frameRepository.findAll();
        return new ArrayList<>(frameMapper.entityToDTO(frames)) ;
    }

    public FrameDTO getById(Long id){
        Frame frame = frameRepository.get(id);
        return frameMapper.entityToDTO(frame);
    }

    public FrameDTO save(FrameDTO frameDTO){
        //convertir DTO -> l'objet Adresse
        Frame frame = frameMapper.DTOToEntity(frameDTO);
        remplirEntity(frameDTO, frame);

        //debug
        System.out.println("DEBUG: frameDTO ID: " + frame.getId());
        System.out.println("DEBUG: frame ID: " + frame.getId());

        Frame saved = frameRepository.save(frame);
        return  frameMapper.entityToDTO(saved);
    }

    public FrameDTO update(FrameDTO frameDTO){
        //to do: controle le cas ID n'existe pas
        Frame frame = frameMapper.DTOToEntity(frameDTO);
        remplirEntity(frameDTO, frame);
        Frame updated = frameRepository.update(frame);
        return frameMapper.entityToDTO(updated);
    }

    //remplir les champs qui ne sont pas remplis avec Mapper
    private void remplirEntity(FrameDTO frameDTO, Frame frame){
        //ajouter Client selon Id
        frame.setClient(clientRepository.get(frameDTO.getClientId()));
        
        //ajouter Article selon Id
        if (frameDTO.getArticleId() == null){
            frame.setArticle(null);
        }else{
            frame.setArticle(articleRepository.get(frameDTO.getArticleId()));
        }
        
        //ajouter Images selon Id
        List<Image> photos = new ArrayList<>();
        for (Long photoId: frameDTO.getPhotoIds()){
            photos.add(imageRepository.get(photoId));
        }
        frame.setPhotos(photos);
    }
}
