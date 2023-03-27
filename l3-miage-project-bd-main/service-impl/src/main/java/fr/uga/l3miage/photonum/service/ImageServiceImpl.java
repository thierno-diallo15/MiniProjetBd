package fr.uga.l3miage.photonum.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.l3miage.photonum.data.domain.Image;
import fr.uga.l3miage.photonum.data.repo.ImageRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ImageServiceImpl implements ImageService {
    /*
     * private final ImageRepository imageRepository;
     * 
     * @Autowired
     * public ImageServiceImpl(ImageRepository imageRepository) {
     * this.imageRepository = imageRepository;
     * }
     */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    @Override
    public Image get(Long id) throws EntityNotFoundException {
        // TODO Auto-generated method stub
        return ImageService.super.get(id);
    }

    @Override
    public Collection<Image> list() {
        // TODO Auto-generated method stub
        return ImageService.super.list();
    }

    @Override
    public Image update(Image object) throws EntityNotFoundException {
        // TODO Auto-generated method stub
        return ImageService.super.update(object);
    }

}
