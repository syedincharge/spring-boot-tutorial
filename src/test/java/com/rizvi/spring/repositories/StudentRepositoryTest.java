package com.rizvi.spring.repositories;

import com.rizvi.spring.entity.Guardian;
import com.rizvi.spring.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;



@SpringBootTest
//@EnableJpaRepositories
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

  //  @Test
    public void saveStudent(){

        Student student = Student.builder()
                .emailId("Shaz@gmail.com")
                .firstName("Shazan")
                .lastName("Rizvi")
               // .guardianName("Syed")
               // .guardianEmail("syed@gmail.com")
                //.guardianMobile("12125551212")
                .build();

        studentRepository.save(student);

    }


  //  @Test
    public  void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .email("syed@gmail.com")
                .name("Syed")
                .mobile("9999999995")
                .build();

        Student student = Student.builder()
                .firstName("Shazan")
                .lastName("Rizvi")
                .emailId("ahaz@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }


    @Test
    public void  printListAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("StudentList  =  "+studentList);
    }


    @Test
    public void printStudentByFirstName(){

        List<Student> students = studentRepository.findByFirstName("Mohammad");
        System.out.println("Student By First Name  "+students);
    }


    @Test
    public void printStudentByFirstNameContaining(){

        List<Student> students = studentRepository.findByFirstNameContaining("Mo");
        System.out.println("Student By First Name  "+students);

    }


    @Test
    public void printFindByGuardianName(){

        List<Student> studentGuardian = studentRepository.findByGuardianName("Syed");
        System.out.println("Guardian First Name  "+studentGuardian);

    }


    @Test
    public void printStudentByFirstNameAndLastName(){

        List<Student> students = studentRepository.findByFirstNameAndLastName("Mohammad", "Rizvi");
        System.out.println("Student By First Name And Last Name "+students);
    }

//    @Test
//    public void printgetStudentByEmailAddress(){
//
//        Student student = studentRepository.getStudentByEmailAddress("mohd@gmail.com");
//        System.out.println("Student By emailId   "+student);
//    }


    @Test
    public void printgetStudentByEmailAddressNative(){

        Student student = studentRepository.getStudentByEmailAddressNative("mohd@gmail.com");
        System.out.println("Student By emailId by Native Named  "+student);
    }

    @Test
    public void printgetStudentByEmailAddressNativeNamedParam() {

        Student student = studentRepository.getStudentByEmailAddressNative("mohd@gmail.com");
        System.out.println("Student By emailId by Native Named Param   "+student);
    }

    @Test
     public void updateStudentNamebyEmailIdTest(){

        studentRepository.updateStudentNameByEmailId(
                   "Imtiaz", "shabbir@gmail.com");
    }

}