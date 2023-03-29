package fr.uga.l3miage.photonum.repository;

import java.util.List;

import fr.uga.l3miage.photonum.domain.model.Print;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class PrintRepository implements CRUDRepository<Long, Print> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Print save(Print image) {
        entityManager.persist(image);
        return image;
    }

    @Override
    public Print get(Long id) {
        return entityManager.find(Print.class, id);
    }

    @Override
    public void delete(Print print) {
        entityManager.remove(print);
    }

    @Override
    public List<Print> all() {
        return null;
    }
}
