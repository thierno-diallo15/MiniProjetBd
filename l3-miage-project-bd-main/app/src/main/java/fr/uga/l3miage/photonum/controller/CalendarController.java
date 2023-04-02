package fr.uga.l3miage.photonum.controller;

import java.rmi.ServerException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.l3miage.photonum.domain.DTO.CalendarDTO;
import fr.uga.l3miage.photonum.services.CalendarService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping(value = "/photonum/calendar", produces = "application/json")
public class CalendarController {

    @Autowired
    private CalendarService calendarService;

    @GetMapping()
    public List<CalendarDTO> findAll(){
        return calendarService.getAll();
    }

    @GetMapping(value = "/{id}")
    public CalendarDTO findById(@PathVariable("id") Long id){    
        return calendarService.getById(id);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CalendarDTO> create(@RequestBody CalendarDTO calendarDTO) throws ServerException{
        CalendarDTO saved = calendarService.save(calendarDTO);
        if (saved == null){
            throw new ServerException("Echec de creation de Calendar!");
        }
        else{
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } 
    } 

    @PutMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<CalendarDTO> update(@PathVariable Long id ,@RequestBody CalendarDTO calendarDTO) throws ServerException{
        if (calendarService.getById(id) == null){
            throw new ServerException("Calendar " +id + " n'existe pas!");
        }
        
        CalendarDTO updated = calendarService.update(calendarDTO);
        if (updated == null){
            throw new ServerException("Echec de modification du Calendar!");
        }
        else{
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } 
    }

}
