package fr.uga.l3miage.photonum.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.l3miage.photonum.data.domain.Frame;
import fr.uga.l3miage.photonum.data.repo.FrameRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class FrameServiceImpl implements FrameService {
    /*
     * private final FrameRepository frameRepository;
     * 
     * @Autowired
     * public FrameServiceImpl(FrameRepository frameRepository) {
     * this.frameRepository = frameRepository;
     * }
     */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    @Override
    public Frame get(Long id) throws EntityNotFoundException {
        // TODO Auto-generated method stub
        return FrameService.super.get(id);
    }

    @Override
    public Collection<Frame> list() {
        // TODO Auto-generated method stub
        return FrameService.super.list();
    }

    @Override
    public Frame update(Frame object) throws EntityNotFoundException {
        // TODO Auto-generated method stub
        return FrameService.super.update(object);
    }

}
