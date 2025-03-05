package com.example.Student_library_management_system.Service;

import com.example.Student_library_management_system.Converters.CardConverter;
import com.example.Student_library_management_system.Repository.CardRepository;
import com.example.Student_library_management_system.RequestDto.CardRequestDto;
import com.example.Student_library_management_system.model_class.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public String deleteById(int id){
        cardRepository.deleteById(id);
        return "deleted successfully";
    }
    public List<Card> findByStatus(String inStatus){
        return cardRepository.findByStatus(inStatus);
    }
    public long countCardByStatus(String inStatus){
        return cardRepository.countByStatus(inStatus);
    }


}
