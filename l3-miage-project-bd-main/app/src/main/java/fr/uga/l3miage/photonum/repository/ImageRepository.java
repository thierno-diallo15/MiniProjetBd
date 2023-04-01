package fr.uga.l3miage.photonum.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.uga.l3miage.photonum.domain.model.Image;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ImageRepository implements CRUDRepository<Long, Image> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Image save(Image image) {
        entityManager.persist(image);
        return image;
    }

    @Override
    public Image get(Long id) {
        return entityManager.find(Image.class, id);
    }

    @Override
    public void delete(Image image) {
        entityManager.remove(image);
    }

    @Override
    public List<Image> all() {
        return null;
    }

    public List<Image> findAll(){
        return entityManager.createQuery("from Image").getResultList();
    }

    public Image update(Image image){
        return entityManager.merge(image);
    }   
}
