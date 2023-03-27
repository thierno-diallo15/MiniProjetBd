package fr.uga.l3miage.photonum.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.l3miage.photonum.data.domain.Print;
import fr.uga.l3miage.photonum.data.repo.PrintRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class PrintServiceImpl implements PrintService {
    /*
     * private final PrintRepository printRepository;
     * 
     * @Autowired
     * public PrintServiceImpl(PrintRepository printRepository) {
     * this.printRepository = printRepository;
     * }
     */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    @Override
    public Print get(Long id) throws EntityNotFoundException {
        // TODO Auto-generated method stub
        return PrintService.super.get(id);
    }

    @Override
    public Collection<Print> list() {
        // TODO Auto-generated method stub
        return PrintService.super.list();
    }

    @Override
    public Print update(Print object) throws EntityNotFoundException {
        // TODO Auto-generated method stub
        return PrintService.super.update(object);
    }

}
