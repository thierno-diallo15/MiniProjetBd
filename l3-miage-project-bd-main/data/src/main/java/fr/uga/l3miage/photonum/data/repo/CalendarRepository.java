package fr.uga.l3miage.photonum.data.repo;

import java.util.List;

import fr.uga.l3miage.photonum.data.domain.Calendar;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class CalendarRepository implements CRUDRepository<Long, Calendar> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Calendar save(Calendar calendar) {
        entityManager.persist(calendar);
        return calendar;
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

}
