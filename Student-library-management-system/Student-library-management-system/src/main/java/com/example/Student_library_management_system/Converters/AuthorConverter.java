package com.example.Student_library_management_system.Converters;

import com.example.Student_library_management_system.RequestDto.AuthorRequestDto;
import com.example.Student_library_management_system.model_class.Author;

public class AuthorConverter {
    public static Author convertAuthorRequestDtoIntoAuthor(AuthorRequestDto authorRequestDto){
        Author author=new Author();

        author.setCountry(authorRequestDto.getCountry());
        author.setEmail(authorRequestDto.getEmail());
        author.setGender(authorRequestDto.getGender());
        author.setName(authorRequestDto.getName());
        author.setRatings(authorRequestDto.getRatings());

        return author;
    }
}
