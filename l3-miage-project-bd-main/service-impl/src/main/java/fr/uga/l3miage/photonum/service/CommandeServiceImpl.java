package fr.uga.l3miage.photonum.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.l3miage.photonum.data.domain.Commande;
import fr.uga.l3miage.photonum.data.repo.CommandeRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CommandeServiceImpl implements CommandeService {
    /*
     * private final CommandeRepository commandeRepository;
     * 
     * @Autowired
     * public CommandeServiceImpl(CommandeRepository commandeRepository) {
     * this.commandeRepository = commandeRepository;
     * }
     */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    @Override
    public Commande get(Long id) throws EntityNotFoundException {
        // TODO Auto-generated method stub
        return CommandeService.super.get(id);
    }

    @Override
    public Collection<Commande> list() {
        // TODO Auto-generated method stub
        return CommandeService.super.list();
    }

    @Override
    public Commande update(Commande object) throws EntityNotFoundException {
        // TODO Auto-generated method stub
        return CommandeService.super.update(object);
    }

}
