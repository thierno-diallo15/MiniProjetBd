package fr.uga.l3miage.photonum.repository;

import jakarta.persistence.PersistenceContext;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.uga.l3miage.photonum.domain.model.Address;
import jakarta.persistence.EntityManager;

@Repository
public class AddressRepository implements CRUDRepository<Long, Address> {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Address> findAll(){
        return entityManager.createQuery("from Address").getResultList();
    }

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

    public Address update(Address address){
        return entityManager.merge(address);
    }

}
