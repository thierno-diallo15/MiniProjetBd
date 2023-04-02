package fr.uga.l3miage.photonum.services;

import org.springframework.stereotype.Service;

import fr.uga.l3miage.photonum.domain.DTO.PrintDTO;
import fr.uga.l3miage.photonum.domain.mapper.PrintMapper;
import fr.uga.l3miage.photonum.domain.model.Image;
import fr.uga.l3miage.photonum.domain.model.Print;
import fr.uga.l3miage.photonum.repository.ArticleRepository;
import fr.uga.l3miage.photonum.repository.ClientRepository;
import fr.uga.l3miage.photonum.repository.ImageRepository;
import fr.uga.l3miage.photonum.repository.PrintRepository;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PrintService {
    
    @Autowired
    private PrintRepository printRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ImageRepository imageRepository;

    private PrintMapper printMapper = Mappers.getMapper(PrintMapper.class);

    public List<PrintDTO> getAll(){
        List<Print> frames = printRepository.findAll();
        return new ArrayList<>(printMapper.entityToDTO(frames)) ;
    }

    public PrintDTO getById(Long id){
        Print frame = printRepository.get(id);
        return printMapper.entityToDTO(frame);
    }

    public PrintDTO save(PrintDTO frameDTO){
        //convertir DTO -> l'objet Adresse
        Print frame = printMapper.DTOToEntity(frameDTO);
        remplirEntity(frameDTO, frame);
        Print saved = printRepository.save(frame);
        return  printMapper.entityToDTO(saved);
    }

    public PrintDTO update(PrintDTO frameDTO){
        //to do: controle le cas ID n'existe pas
        Print frame = printMapper.DTOToEntity(frameDTO);
        remplirEntity(frameDTO, frame);
        Print updated = printRepository.update(frame);
        return printMapper.entityToDTO(updated);
    }

    //remplir les champs qui ne sont pas remplis avec Mapper
    private void remplirEntity(PrintDTO frameDTO, Print frame){
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
