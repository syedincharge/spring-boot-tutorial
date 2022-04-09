package com.rizvi.spring.repositories;

import com.rizvi.spring.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

         List<Student> findByFirstName(String firstName);
         List<Student> findByFirstNameContaining(String name);
         List<Student> findByLastNameNotNull();
         List<Student> findByGuardianName(String guardianName);
         List<Student> findByFirstNameAndLastName(String firstName, String lastName);

         // JPQL

//         @Query(value = "SELECT s FROM student s where s.email_address = ?1", nativeQuery = false)
//         Student getStudentByEmailAddress(String emailId);

       // Native

         @Query(
                 value = "SELECT * FROM student s where s.email_address = ?1 ",
                 nativeQuery = true)
         Student getStudentByEmailAddressNative(String emailId);

        //Native Named  Param

         @Query(
                 value = "SELECT * FROM tbl_student s where s.email_address = :emailId ",
                 nativeQuery = true)
         Student getStudentByEmailAddressNativeParam(@Param("emailId") String emailId);

         @Modifying
         @Transactional
         @Query(
                 value = "update tbl_student set first_name = ?1 where email_address = ?2",
                 nativeQuery = true)
         int updateStudentNameByEmailId(String firstName, String emailId);



}
