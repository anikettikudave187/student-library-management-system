package com.example.Student_library_management_system.Repository;

import com.example.Student_library_management_system.model_class.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
