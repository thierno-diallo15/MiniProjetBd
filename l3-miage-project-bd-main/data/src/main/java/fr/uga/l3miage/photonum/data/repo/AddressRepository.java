package fr.uga.l3miage.photonum.data.repo;

import jakarta.persistence.PersistenceContext;

import java.util.List;

import fr.uga.l3miage.photonum.data.domain.Address;
import jakarta.persistence.EntityManager;

public class AddressRepository implements CRUDRepository<Long, Address> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Address save(Address address) {
        entityManager.persist(address);
        return address;
    }

    @Override
    public Address get(Long id) {
        return entityManager.find(Address.class, id);
    }

    @Override
    public void delete(Address address) {
        entityManager.remove(address);
    }

    @Override
    public List<Address> all() {
        return null;
    }

}
