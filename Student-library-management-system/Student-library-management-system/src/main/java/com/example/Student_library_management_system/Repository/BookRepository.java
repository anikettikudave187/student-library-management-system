package com.example.Student_library_management_system.Repository;

import com.example.Student_library_management_system.model_class.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    //public List<Book> findByTittle(String tittle);
    public List<Book> findByRackNoOrAuthorOrTittle(String rackNo,String author,String tittle);
}
