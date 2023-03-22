package fr.uga.l3miage.photonum.data.repo;

import jakarta.persistence.PersistenceContext;

import java.util.List;

import fr.uga.l3miage.photonum.data.domain.Client;
import jakarta.persistence.EntityManager;

public class ClientRepository implements CRUDRepository<Long, Client> {

    @PersistenceContext
    private EntityManager entityManager;

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
