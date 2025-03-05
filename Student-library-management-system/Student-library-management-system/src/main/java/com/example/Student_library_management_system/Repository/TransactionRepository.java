package com.example.Student_library_management_system.Repository;

import com.example.Student_library_management_system.model_class.Card;
import com.example.Student_library_management_system.model_class.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
}
