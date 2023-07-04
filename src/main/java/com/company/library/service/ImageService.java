package com.company.library.service;

import com.company.library.model.Image;
import com.company.library.repository.ImageRepository;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    private final ImageRepository imageRepository;


    public ImageService(ImageRepository imageRepository, ImageRepository imageRepository1) {
        this.imageRepository = imageRepository1;
    }



}
