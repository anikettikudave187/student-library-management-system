package com.example.Student_library_management_system.Repository;

import com.example.Student_library_management_system.model_class.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    public List<Student> findBySemAndDept(String inSem,String inDept);
}
