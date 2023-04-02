package fr.uga.l3miage.photonum.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.l3miage.photonum.domain.DTO.AlbumDTO;
import fr.uga.l3miage.photonum.domain.mapper.AlbumMapper;
import fr.uga.l3miage.photonum.domain.model.Album;
import fr.uga.l3miage.photonum.domain.model.Page;
import fr.uga.l3miage.photonum.repository.AlbumRepository;
import fr.uga.l3miage.photonum.repository.ArticleRepository;
import fr.uga.l3miage.photonum.repository.ClientRepository;
import fr.uga.l3miage.photonum.repository.ImageRepository;
import fr.uga.l3miage.photonum.repository.PageRepository;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private PageRepository pageRepository;
    @Autowired
    private ImageRepository imageRepository;

    private AlbumMapper albumMapper = Mappers.getMapper(AlbumMapper.class);

    public List<AlbumDTO> getAll(){
        List<Album> albums = albumRepository.findAll();
        return new ArrayList<>(albumMapper.entityToDTO(albums)) ;
    }

    public AlbumDTO getById(Long id){
        Album album = albumRepository.get(id);
        return albumMapper.entityToDTO(album);
    }

    public AlbumDTO save(AlbumDTO albumDTO){
        //convertir DTO -> l'objet Album
        Album album = albumMapper.DTOToEntity(albumDTO);
        remplirEntity(albumDTO, album);
        Album saved = albumRepository.save(album);
        return  albumMapper.entityToDTO(saved);
    }

    public AlbumDTO update(AlbumDTO albumDTO){
        //to do: controle le cas ID n'existe pas
        Album album = albumMapper.DTOToEntity(albumDTO);
        remplirEntity(albumDTO, album);
        Album updated = albumRepository.update(album);
        return albumMapper.entityToDTO(updated);
    }

    //remplir les champs qui ne sont pas remplis avec Mapper
    private void remplirEntity(AlbumDTO albumDTO, Album album){
        //ajouter Cover
        album.setCover(imageRepository.get(albumDTO.getCoverId()));

        //ajouter Client selon Id
        album.setClient(clientRepository.get(albumDTO.getClientId()));
        
        //ajouter Article selon Id
        if (albumDTO.getArticleId() == null){
            album.setArticle(null);
        }else{
            album.setArticle(articleRepository.get(albumDTO.getArticleId()));
        }
        
        //ajouter Pages selon Id
        Set<Page> pages = new HashSet<>();
        for (Long pageId: albumDTO.getPageIds()){
            pages.add(pageRepository.get(pageId));
        }
        album.setPages(pages);
    }
    
}
