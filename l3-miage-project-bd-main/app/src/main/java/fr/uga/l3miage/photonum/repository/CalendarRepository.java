package fr.uga.l3miage.photonum.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.uga.l3miage.photonum.domain.model.Calendar;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CalendarRepository implements CRUDRepository<Long, Calendar> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Calendar save(Calendar calendar) {
        entityManager.persist(calendar);
        return entityManager.find(Calendar.class, calendar.getId());
    }

    @Override
    public Calendar get(Long id) {
        return entityManager.find(Calendar.class, id);
    }

    @Override
    public void delete(Calendar calendar) {
        entityManager.remove(calendar);
    }

    @Override
    public List<Calendar> all() {
        return null;
    }

    public List<Calendar> findAll(){
        return entityManager.createQuery("from Calendar").getResultList();
    }

    public Calendar update(Calendar calendar){
        return entityManager.merge(calendar);
    } 
}
