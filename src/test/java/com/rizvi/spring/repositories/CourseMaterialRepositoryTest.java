package com.rizvi.spring.repositories;

import com.rizvi.spring.entity.Course;
import com.rizvi.spring.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;


    @Test
    public void saveCourseMaterial(){

        Course course = Course.builder()
                .title("DSA")
                .credits(6)
                .build();


        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.google.com")
                .course(course)
                .build();

        repository.save(courseMaterial);

    }

    @Test
    public void printAllCourseMaterials(){

        List<CourseMaterial> courseMaterials = repository.findAll();

        System.out.println(courseMaterials);

    }


}