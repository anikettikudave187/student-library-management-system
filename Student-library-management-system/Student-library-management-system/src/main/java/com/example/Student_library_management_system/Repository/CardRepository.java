package com.example.Student_library_management_system.Repository;

import com.example.Student_library_management_system.model_class.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {
    public List<Card> findByDate(String inDate);
    public List<Card> findByStatus(String inDate);
    public long countByStatus(String inDate);
}
