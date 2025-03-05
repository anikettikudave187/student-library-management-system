package com.example.Student_library_management_system.RequestDto;

import com.example.Student_library_management_system.EnumClasses.CardStatus;

public class CardRequestDto {
    private CardStatus cardstatus;
    private int studentId;

    public CardStatus getCardstatus() {
        return cardstatus;
    }

    public void setCardstatus(CardStatus cardstatus) {
        this.cardstatus = cardstatus;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
