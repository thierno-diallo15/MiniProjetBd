package fr.uga.l3miage.photonum.repository;

import java.util.List;

import fr.uga.l3miage.photonum.domain.model.Image;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

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

}
