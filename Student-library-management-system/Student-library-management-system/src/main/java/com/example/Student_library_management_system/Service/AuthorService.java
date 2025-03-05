package com.example.Student_library_management_system.Service;

import com.example.Student_library_management_system.Converters.AuthorConverter;
import com.example.Student_library_management_system.Repository.AuthorRepository;
import com.example.Student_library_management_system.RequestDto.AuthorRequestDto;
import com.example.Student_library_management_system.model_class.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public String saveAuthor(AuthorRequestDto authorRequestDto){
        Author author= AuthorConverter.convertAuthorRequestDtoIntoAuthor(authorRequestDto);
        authorRepository.save(author);

        return "Author saved successfully";
    }

    public Author findById(int id){
        Optional<Author> author=authorRepository.findById(id);
        if(author.isPresent()){
            return author.get();
        }else{
            throw new RuntimeException("author not found of this id: "+id);
        }
    }

    public String deleteById(int id){
        authorRepository.deleteById(id);
        return "deleted Successfully";
    }

    public String updateAuthor(int id,AuthorRequestDto authorRequestDto){
        Author author=findById(id);
        if(author!=null){
            author.setRatings(authorRequestDto.getRatings());
            author.setName(authorRequestDto.getName());
            author.setGender(authorRequestDto.getGender());
            author.setEmail(authorRequestDto.getEmail());
            author.setCountry(authorRequestDto.getCountry());

            authorRepository.save(author);
            return "updated student successfully";
        }else{
            return "student not found";
        }
    }
}
