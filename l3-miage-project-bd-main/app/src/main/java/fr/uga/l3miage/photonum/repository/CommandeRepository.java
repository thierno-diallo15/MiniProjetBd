package fr.uga.l3miage.photonum.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.uga.l3miage.photonum.domain.model.Commande;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CommandeRepository implements CRUDRepository<Long, Commande> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Commande save(Commande commande) {
        entityManager.persist(commande);
        return commande;
    }

    public Commande update(Commande commande){
        return entityManager.merge(commande);
    }

    public List<Commande> findAll(){
        return entityManager.createQuery("from Commande").getResultList();
    }

    @Override
    public Commande get(Long id) {
        return entityManager.find(Commande.class, id);
    }

    @Override
    public void delete(Commande commande) {
        entityManager.remove(commande);
    }

    @Override
    public List<Commande> all() {
        return null;
    }

}
