package fr.uga.l3miage.photonum.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.uga.l3miage.photonum.domain.model.Album;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class AlbumRepository implements CRUDRepository<Long, Album> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Album save(Album album) {
        entityManager.persist(album);
        return this.get(album.getId());
    }

    @Override
    public Album get(Long id) {
        return entityManager.find(Album.class, id);
    }

    @Override
    public void delete(Album album) {
        entityManager.remove(album);
    }

    @Override
    public List<Album> all() {
        return null;
    }

    public List<Album> findAll(){
        return entityManager.createQuery("from Album").getResultList();
    }

    public Album update(Album album){
        return entityManager.merge(album);
    } 
}
