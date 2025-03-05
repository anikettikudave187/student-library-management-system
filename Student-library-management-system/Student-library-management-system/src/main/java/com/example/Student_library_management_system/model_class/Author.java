package com.example.Student_library_management_system.model_class;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "Name",nullable = false)
    private String name;

    @Column(name = "Email",nullable = false)
    private String email;

    @Column(name = "Gender",nullable = false)
    private String gender;

    @Column(name = "Country",nullable = false)
    private String country;

    @Column(name = "Ratings",nullable = false)
    private double ratings;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private List<Book> booksByAuthor=new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getRatings() {
        return ratings;
    }

    public void setRatings(double ratings) {
        this.ratings = ratings;
    }

    public List<Book> getBooksByAuthor() {
        return booksByAuthor;
    }

    public void setBooksByAuthor(List<Book> booksByAuthor) {
        this.booksByAuthor = booksByAuthor;
    }
}
