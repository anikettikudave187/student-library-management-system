package com.example.Student_library_management_system.Service;

import com.example.Student_library_management_system.Converters.TransactionConverter;
import com.example.Student_library_management_system.Repository.BookRepository;
import com.example.Student_library_management_system.Repository.CardRepository;
import com.example.Student_library_management_system.Repository.TransactionRepository;
import com.example.Student_library_management_system.RequestDto.TransactionRequestDto;
import com.example.Student_library_management_system.model_class.Book;
import com.example.Student_library_management_system.model_class.Card;
import com.example.Student_library_management_system.model_class.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private BookRepository bookRepository;

    public String saveTransaction(TransactionRequestDto transactionRequestDto){
        Transaction transaction= TransactionConverter.convertTransactionRequestDtoIntoTransaction(transactionRequestDto);

        Card card=cardRepository.findById(transactionRequestDto.getCardId()).get();
        transaction.setCard(card);

        Book book=bookRepository.findById(transactionRequestDto.getBookId()).get();
        transaction.setBook(book);

        transactionRepository.save(transaction);
        return "Book saved successfully";
    }

    public String deleteTransaction(int id){
        transactionRepository.deleteById(id);
        return "deleted successfully";
    }

    public Transaction findTransactionById(int id,TransactionRequestDto transactionRequestDto){
        Optional<Transaction> transaction=transactionRepository.findById(id);
        if(transaction.isPresent()){
            return transaction.get();
        }else{
            throw new RuntimeException("transaction not found");
        }
    }

    public String updateTransaction(int id,TransactionRequestDto transactionRequestDto){
        Transaction transaction=findTransactionById(id,transactionRequestDto);
        if(transaction!=null){
            transaction.setTransactionType(transactionRequestDto.getTransactionType());
            transaction.setFine(transactionRequestDto.getFine());
            transaction.setDueDate(transactionRequestDto.getDueDate());

            transactionRepository.save(transaction);
            return "updated successfully";
        }else{
            return "transaction not found";
        }
    }
}
