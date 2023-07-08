package com.company.library;


import com.company.library.model.Category;
import com.company.library.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner {
    private final CategoryRepository categoryRepository;

    public LibraryApplication(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Category category = categoryRepository.save(new Category.Builder().id("jcsjdsc").name("Macera").build());
        System.out.println(category);
    }
}