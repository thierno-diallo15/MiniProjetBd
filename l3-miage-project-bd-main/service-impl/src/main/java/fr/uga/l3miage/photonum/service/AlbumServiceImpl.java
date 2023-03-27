package fr.uga.l3miage.photonum.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.l3miage.photonum.data.domain.Album;
import fr.uga.l3miage.photonum.data.repo.AlbumRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
    /*
     * private final AlbumRepository albumRepository;
     * 
     * @Autowired
     * public AlbumServiceImpl(AlbumRepository albumRepository) {
     * this.albumRepository = albumRepository;
     * }
     */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    @Override
    public Album get(Long id) throws EntityNotFoundException {
        // TODO Auto-generated method stub
        return AlbumService.super.get(id);
    }

    @Override
    public Collection<Album> list() {
        // TODO Auto-generated method stub
        return AlbumService.super.list();
    }

    @Override
    public Album update(Album object) throws EntityNotFoundException {
        // TODO Auto-generated method stub
        return AlbumService.super.update(object);
    }

}
