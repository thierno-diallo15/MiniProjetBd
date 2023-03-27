package fr.uga.l3miage.photonum.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.l3miage.photonum.data.domain.Page;
import fr.uga.l3miage.photonum.data.repo.PageRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class PageServiceImpl implements PageService {
    /*
     * private final PageRepository pageRepository;
     * 
     * @Autowired
     * public PageServiceImpl(PageRepository pageRepository) {
     * this.pageRepository = pageRepository;
     * }
     */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    @Override
    public Page get(Long id) throws EntityNotFoundException {
        // TODO Auto-generated method stub
        return PageService.super.get(id);
    }

    @Override
    public Collection<Page> list() {
        // TODO Auto-generated method stub
        return PageService.super.list();
    }

    @Override
    public Page update(Page object) throws EntityNotFoundException {
        // TODO Auto-generated method stub
        return PageService.super.update(object);
    }

}
