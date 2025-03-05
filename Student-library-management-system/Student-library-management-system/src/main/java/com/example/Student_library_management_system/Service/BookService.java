package com.example.Student_library_management_system.Service;

import com.example.Student_library_management_system.Converters.BookConverter;
import com.example.Student_library_management_system.Repository.AuthorRepository;
import com.example.Student_library_management_system.Repository.BookRepository;
import com.example.Student_library_management_system.Repository.CardRepository;
import com.example.Student_library_management_system.RequestDto.BookRequestDto;
import com.example.Student_library_management_system.model_class.Author;
import com.example.Student_library_management_system.model_class.Book;
import com.example.Student_library_management_system.model_class.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
   private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CardRepository cardRepository;

    public String saveBook(BookRequestDto bookRequestDto){
        Book book =BookConverter.convertBookRequestDtoIntoBook(bookRequestDto);

        Card card=cardRepository.findById(bookRequestDto.getCardId()).get();
        book.setCard(card);

        Author author=authorRepository.findById(bookRequestDto.getAuthorId()).get();
        book.setAuthor(author);

        bookRepository.save(book);
        return "Book saved successfully";
    }
    public Book findBookById(int id){
        Optional<Book> book=bookRepository.findById(id);
        if(book.isPresent()){
            return book.get();
        }else{
            throw new RuntimeException("book not found");
        }
    }

    public List<Book> findBookByRackNoOrAuthorOrTittle(String rackNo,String author,String tittle){
        List<Book> bookList=bookRepository.findByRackNoOrAuthorOrTittle(rackNo,author,tittle);
        return bookList;
    }

    public long countTotalBooks(){
        return bookRepository.count();
    }

   public String deleteByIde(int id){
        bookRepository.deleteById(id);
        return "book deleted successfully";
   }

   public String updateBook(int id, BookRequestDto bookRequestDto){
        Book book =findBookById(id);

        if(book!=null){
            book.setAvaibility(bookRequestDto.isAvaibility());
            book.setTitle(bookRequestDto.getTitle());
            book.setPages(bookRequestDto.getPages());
            book.setCategory(bookRequestDto.getCategory());
            book.setPublishedDate(bookRequestDto.getPublishedDate());
            book.setRackNo(bookRequestDto.getRackNo());
            book.setPublisherName(bookRequestDto.getPublisherName());

            bookRepository.save(book);
            return "book updated successfully";
        }else{
            return "no book available of this id";
        }
   }
}
