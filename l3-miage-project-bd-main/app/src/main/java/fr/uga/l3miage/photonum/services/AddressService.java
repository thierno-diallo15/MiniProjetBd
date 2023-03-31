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

    public AddressDTO save(AddressDTO addressDTO){
        //convertir l'objet DTO -> l'objet Adresse
        Address address = addressMapper.DTOToEntity(addressDTO);
        Client client = clientRepository.get(addressDTO.getClientId());
        //Mappeur non capable de convertir (Long) client_id -> l'objet Client
        //  -> on le fait manuellement 
        address.setClient(client);

        Address saved = addressRepository.save(address);
        AddressDTO savedDTO = addressMapper.entityToDTO(saved);
        //convertir manuellement l'objet Client -> (Long) client_id pour DTO
        savedDTO.setClientId(saved.getClient().getId());
        return  savedDTO;
    }
}


