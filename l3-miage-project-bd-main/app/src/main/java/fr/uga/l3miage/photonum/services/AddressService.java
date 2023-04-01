package fr.uga.l3miage.photonum.services;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.l3miage.photonum.domain.DTO.AddressDTO;
import fr.uga.l3miage.photonum.domain.mapper.AddressMapper;
import fr.uga.l3miage.photonum.domain.model.Address;
import fr.uga.l3miage.photonum.domain.model.Client;
import fr.uga.l3miage.photonum.repository.AddressRepository;
import fr.uga.l3miage.photonum.repository.ClientRepository;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ClientRepository clientRepository;

    private AddressMapper addressMapper = Mappers.getMapper(AddressMapper.class);
    
    //to do: remplacer clientId par ClientDTO pour meilleure affichage
    public List<AddressDTO> getAll(){
        List<Address> addresses = addressRepository.findAll();
        //convertir les Address -> AddressDTO avant de renvoyer
        return new ArrayList<>(addressMapper.entityToDTO(addresses)) ;
    }

    public AddressDTO getById(Long id){
        Address address = addressRepository.get(id);
        return addressMapper.entityToDTO(address);
    }

    public AddressDTO save(AddressDTO addressDTO){
        //convertir l'objet DTO -> l'objet Adresse
        Address address = addressMapper.DTOToEntity(addressDTO);
        Client client = clientRepository.get(addressDTO.getClientId());
        //Mappeur non capable de convertir (Long) client_id -> l'objet Client
        //  -> on le fait manuellement 
        address.setClient(client);

        Address saved = addressRepository.save(address);
        return  addressMapper.entityToDTO(saved);
    }

    public AddressDTO update(AddressDTO addressDTO){
        //convertir AddressDTO -> Address 
        Address address = addressMapper.DTOToEntity(addressDTO);
        address.setClient(clientRepository.get(addressDTO.getClientId()));
        //to do: controle le cas ID n'existe pas

        Address updated = addressRepository.update(address);
        return addressMapper.entityToDTO(updated);
    }
}


