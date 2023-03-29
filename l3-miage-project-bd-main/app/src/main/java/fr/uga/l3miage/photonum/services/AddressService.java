package fr.uga.l3miage.photonum.services;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.l3miage.photonum.domain.DTO.AddressDTO;
import fr.uga.l3miage.photonum.domain.mapper.AddressMapper;
import fr.uga.l3miage.photonum.domain.model.Address;
import fr.uga.l3miage.photonum.repository.AddressRepository;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    private AddressMapper addressMapper = Mappers.getMapper(AddressMapper.class);
    
    //to do: remplacer clientId par ClientDTO pour meilleure affichage 
    public List<AddressDTO> getAll(){
        List<AddressDTO> addressesDTO = new ArrayList<>();
        List<Address> addresses = addressRepository.findAll();
        AddressDTO addressDTO = new AddressDTO();
        
        for (Address addr: addresses){
            addressDTO = addressMapper.entityToDTO(addr);
            addressDTO.setClientId(addr.getClient().getId());
            addressesDTO.add(addressDTO);
        }
        return addressesDTO;
    }

    public AddressDTO getById(Long id){
        Address address = addressRepository.get(id);
        AddressDTO addressDTO = addressMapper.entityToDTO(address);
        addressDTO.setClientId(address.getClient().getId());
        return (addressDTO);
    }
}
