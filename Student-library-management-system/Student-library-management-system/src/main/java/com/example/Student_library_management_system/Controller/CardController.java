package com.example.Student_library_management_system.Controller;

import com.example.Student_library_management_system.Service.CardService;
import com.example.Student_library_management_system.model_class.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card/api")
public class CardController {
    @Autowired
    private CardService cardService;

    @DeleteMapping("/deleteCard")
    public void deleteCardById(@PathVariable int id){
        cardService.deleteById(id);
    }

    @GetMapping("/countByStatus")
    public ResponseEntity<?> countByStatus(String inStatus){
       try{
           long totalCount= cardService.countCardByStatus(inStatus);
           return ResponseEntity.ok(totalCount);
       } catch (Exception e) {
           return ResponseEntity.internalServerError().body("exception occurred: "+e.getMessage());
       }
    }

    @GetMapping("/findByStatus")
    public ResponseEntity<?> findByStatus(String status){
        try{
            List<Card> cardList= cardService.findByStatus(status);
            return ResponseEntity.ok(cardList);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("exception occurred: "+e.getMessage());
        }
    }


}
