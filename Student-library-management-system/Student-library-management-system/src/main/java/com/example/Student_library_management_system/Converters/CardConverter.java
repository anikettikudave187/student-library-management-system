package com.example.Student_library_management_system.Converters;

import com.example.Student_library_management_system.RequestDto.CardRequestDto;
import com.example.Student_library_management_system.model_class.Card;

public class CardConverter {
    public static Card convertCardRequestDtoIntoCard(CardRequestDto cardRequestDto){
        Card card=new Card();

        card.setCardstatus(cardRequestDto.getCardstatus());
        return card;
    }
}
