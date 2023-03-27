package fr.uga.l3miage.photonum.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.l3miage.photonum.data.domain.Calendar;
import fr.uga.l3miage.photonum.data.repo.CalendarRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CalendarServiceImpl implements CalendarService {
    /*
     * private final CalendarRepository calendarRepository;
     * 
     * @Autowired
     * public CalendarServiceImpl(CalendarRepository calendarRepository) {
     * this.calendarRepository = calendarRepository;
     * }
     */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    @Override
    public Calendar get(Long id) throws EntityNotFoundException {
        // TODO Auto-generated method stub
        return CalendarService.super.get(id);
    }

    @Override
    public Collection<Calendar> list() {
        // TODO Auto-generated method stub
        return CalendarService.super.list();
    }

    @Override
    public Calendar update(Calendar object) throws EntityNotFoundException {
        // TODO Auto-generated method stub
        return CalendarService.super.update(object);
    }

}
