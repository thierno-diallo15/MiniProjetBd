package fr.uga.l3miage.photonum.repository;

import jakarta.persistence.PersistenceContext;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.uga.l3miage.photonum.domain.model.Client;
import jakarta.persistence.EntityManager;

@Repository
public class ClientRepository implements CRUDRepository<Long, Client> {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Client> findAll(){
        return entityManager.createQuery("from Client").getResultList();
    }

    @Override
    public Client save(Client client) {
        entityManager.persist(client);
        return client;
    }

    @Override
    public Client get(Long id) {
        return entityManager.find(Client.class, id);
    }

    @Override
    public void delete(Client client) {
        entityManager.remove(client);
    }

    @Override
    public List<Client> all() {
        return null;
    }

}
