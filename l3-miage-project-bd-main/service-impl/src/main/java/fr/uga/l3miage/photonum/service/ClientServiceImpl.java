package fr.uga.l3miage.photonum.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.l3miage.photonum.data.domain.Client;
import fr.uga.l3miage.photonum.data.repo.ClientRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    /*
     * @Autowired
     * private final ClientRepository clientRepository;
     * 
     * public ClientServiceImpl(ClientRepository clientRepository) {
     * this.clientRepository = clientRepository;
     * }
     */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    @Override
    public Client get(Long id) throws EntityNotFoundException {
        // TODO Auto-generated method stub
        return ClientService.super.get(id);
    }

    @Override
    public Collection<Client> list() {
        // TODO Auto-generated method stub
        return ClientService.super.list();
    }

    @Override
    public Client update(Client object) throws EntityNotFoundException {
        // TODO Auto-generated method stub
        return ClientService.super.update(object);
    }

}
