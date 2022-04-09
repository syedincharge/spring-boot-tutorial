package com.rizvi.spring.repositories;

import com.rizvi.spring.entity.Course;
import com.rizvi.spring.entity.Teacher;


import lombok.var;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static com.rizvi.spring.entity.Teacher.*;


@SpringBootTest
class TeacherRepositoryTest {
    List<Course> courses;
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){

        Course courseDBA =  Course.builder()
                .title("DBA")
                .credits(5)
                .build();

        Course courseJava =  Course.builder()
                .title("Java")
                .credits(7)
                .build();


      Teacher teacher = builder()
                .firstName("Ramesh")
                .lastName("Khan")
           //     .courses(List.of(courses(courseDBA, courseJava))
                .build();


        teacherRepository.save(teacher);
    }
}