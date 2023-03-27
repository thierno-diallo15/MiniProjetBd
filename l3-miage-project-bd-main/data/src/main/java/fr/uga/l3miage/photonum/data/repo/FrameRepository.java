package fr.uga.l3miage.photonum.data.repo;

import java.util.List;

import fr.uga.l3miage.photonum.data.domain.Frame;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class FrameRepository implements CRUDRepository<Long, Frame> {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Frame  save(Frame frame) {
        entityManager.persist(frame);
        return frame;
    }
    @Override
    public Frame get(Long id) {
        return entityManager.find(Frame.class, id);
    }
    @Override
    public void delete(Frame frame) {
        entityManager.remove(frame);
    }
    @Override
    public List<Frame> all() {
        return null;
    }


    
}
