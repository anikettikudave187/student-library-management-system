package com.example.Student_library_management_system.model_class;

import com.example.Student_library_management_system.EnumClasses.CardStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Card")
public class Card {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "CardStatus",nullable = false)
    @Enumerated(value = EnumType.STRING)
    private CardStatus cardstatus;

    @Column(name = "CreatedDate",nullable = false)
    @CreationTimestamp
    private Date createdDate;

    @Column(name = "UpdatedDate",nullable = false)
    @UpdateTimestamp
    private Date updatedDate;

    @OneToOne
    @JoinColumn
    private Student student;

    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    private List<Book> bookList=new ArrayList<>();

    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    private List<Transaction> transactionList=new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CardStatus getCardstatus() {
        return cardstatus;
    }

    public void setCardstatus(CardStatus cardstatus) {
        this.cardstatus = cardstatus;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
}
