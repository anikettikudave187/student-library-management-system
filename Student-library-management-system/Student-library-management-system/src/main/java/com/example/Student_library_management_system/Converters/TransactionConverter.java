package com.example.Student_library_management_system.Converters;

import com.example.Student_library_management_system.RequestDto.TransactionRequestDto;
import com.example.Student_library_management_system.model_class.Transaction;

public class TransactionConverter {
    public static Transaction convertTransactionRequestDtoIntoTransaction(TransactionRequestDto transactionRequestDto){
        Transaction transaction =new Transaction();

        transaction.setTransactionType(transactionRequestDto.getTransactionType());
        transaction.setFine(transactionRequestDto.getFine());
        transaction.setDueDate(transactionRequestDto.getDueDate());;

        return transaction;
    }
}
