package fr.uga.l3miage.photonum.domain.mapper;

import java.util.Collection;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import fr.uga.l3miage.photonum.domain.DTO.AddressDTO;
import fr.uga.l3miage.photonum.domain.model.Address;
import fr.uga.l3miage.photonum.domain.model.Client;

@Mapper
public interface AddressMapper {
    //AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Mapping(source = "client", target = "clientId", qualifiedByName = "clientToClientId")
    AddressDTO entityToDTO(Address address);
    
    @Mapping(source = "client", target = "clientId", qualifiedByName = "clientToClientId")
    Collection<AddressDTO> entityToDTO(Iterable<Address> addresses);

    //DTO -> Entity ne copie pas l'Id (DTO) -> l'Id (Entity) alors on doit le faire manuellement
    @Mapping(source = "id", target = "id", qualifiedByName = "DTOidToId")
    Address DTOToEntity(AddressDTO addressDto);

    @Mapping(source = "id", target = "id", qualifiedByName = "DTOidToId")
    Collection<Address> DTOToEntity(Iterable<AddressDTO> addressesDTO);

    @Named("clientToClientId")
    public static Long clientToClientId(Client client){
        return client.getId();
    }

    @Named("DTOidToId")
    public static Long dtoIdToId(Long dtoId){
        return dtoId;
    }
}
