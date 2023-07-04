package com.company.library.repository;

import com.company.library.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ImageRepository extends JpaRepository<Image, String>, JpaSpecificationExecutor<Image> {
}
