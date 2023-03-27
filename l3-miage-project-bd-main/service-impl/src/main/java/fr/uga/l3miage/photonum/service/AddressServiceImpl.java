package fr.uga.l3miage.photonum.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.l3miage.photonum.data.domain.Address;
import fr.uga.l3miage.photonum.data.repo.AddressRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    /*
     * private final AddressRepository addressRepository;
     * 
     * @Autowired
     * public AddressServiceImpl(AddressRepository addressRepository) {
     * this.addressRepository = addressRepository;
     * }
     */
    @Override
    public Address get(Long id) throws EntityNotFoundException {
        // TODO Auto-generated method stub
        return AddressService.super.get(id);
    }

    @Override
    public Collection<Address> list() {
        // TODO Auto-generated method stub
        return AddressService.super.list();
    }

    @Override
    public Address update(Address object) throws EntityNotFoundException {
        // TODO Auto-generated method stub
        return AddressService.super.update(object);
    }

}
