package com.example.Student_library_management_system.Converters;

import com.example.Student_library_management_system.RequestDto.BookRequestDto;
import com.example.Student_library_management_system.model_class.Book;

public class BookConverter {
    public static Book convertBookRequestDtoIntoBook(BookRequestDto bookRequestDto){
        Book book=new Book();

        book.setCategory(bookRequestDto.getCategory());
        book.setPages(bookRequestDto.getPages());
        book.setTitle(bookRequestDto.getTitle());
        book.setPublisherName(bookRequestDto.getPublisherName());
        book.setRackNo(bookRequestDto.getRackNo());
        book.setPublishedDate(bookRequestDto.getPublishedDate());
        book.setAvaibility(bookRequestDto.isAvaibility());

        return book;
    }
}
