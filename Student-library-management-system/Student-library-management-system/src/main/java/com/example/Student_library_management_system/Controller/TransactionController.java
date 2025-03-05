package com.example.Student_library_management_system.Controller;

import com.example.Student_library_management_system.RequestDto.TransactionRequestDto;
import com.example.Student_library_management_system.Service.TransactionService;
import com.example.Student_library_management_system.model_class.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction/api")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/save")
    public String saveTransaction(@RequestBody TransactionRequestDto transactionRequestDto){
        String response=transactionService.saveTransaction(transactionRequestDto);
        return response;
    }

    @DeleteMapping("/deleteTransaction")
    public ResponseEntity<?> deleteTransaction(@PathVariable int id){
        try{
            return ResponseEntity.ok(transactionService.deleteTransaction(id));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Exception Occurred "+e.getMessage());
        }
    }

    @PutMapping("/updateTransaction")
    public ResponseEntity<?> updateTransaction(@PathVariable int id,@RequestBody TransactionRequestDto transactionRequestDto){
        try{
            return ResponseEntity.ok(transactionService.updateTransaction(id,transactionRequestDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Exception Occurred "+e.getMessage());
        }
    }

    @GetMapping("/findById")
    public ResponseEntity<?> findTransaction(@PathVariable int id,@RequestBody TransactionRequestDto transactionRequestDto){
        try{
            Transaction transaction=transactionService.findTransactionById(id,transactionRequestDto);
            return ResponseEntity.ok(transaction);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Exception Occurred "+e.getMessage());
        }

    }
}
