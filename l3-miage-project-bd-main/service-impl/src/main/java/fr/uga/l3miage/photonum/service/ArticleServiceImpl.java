package fr.uga.l3miage.photonum.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.l3miage.photonum.data.domain.Article;
import fr.uga.l3miage.photonum.data.repo.ArticleRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    /*
     * private final ArticleRepository articleRepository;
     * 
     * @Autowired
     * public ArticleServiceImpl(ArticleRepository articleRepository) {
     * this.articleRepository = articleRepository;
     * }
     */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    @Override
    public Article get(Long id) throws EntityNotFoundException {
        // TODO Auto-generated method stub
        return ArticleService.super.get(id);
    }

    @Override
    public Collection<Article> list() {
        // TODO Auto-generated method stub
        return ArticleService.super.list();
    }

    @Override
    public Article update(Article object) throws EntityNotFoundException {
        // TODO Auto-generated method stub
        return ArticleService.super.update(object);
    }

}
