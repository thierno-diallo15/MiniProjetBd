package fr.uga.l3miage.photonum.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.uga.l3miage.photonum.domain.model.Print;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
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

    public List<Print> findAll(){
        return entityManager.createQuery("from Print").getResultList();
    }

    public Print update(Print print){
        return entityManager.merge(print);
    } 
}
