package com.example.Student_library_management_system.Controller;

import com.example.Student_library_management_system.RequestDto.BookRequestDto;
import com.example.Student_library_management_system.Service.BookService;
import com.example.Student_library_management_system.model_class.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book/api")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/save")
    public String saveBook(@RequestBody BookRequestDto bookRequestDto){
            return bookService.saveBook(bookRequestDto);
    }

    @GetMapping("/findById")
    public ResponseEntity<?> findById(@PathVariable int id){
        try{
            return ResponseEntity.ok(bookService.findBookById(id));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Exception occurred"+e.getMessage());
        }
    }

    @GetMapping("/findByRackNoOr")
    public ResponseEntity<?> findBookByRackNoOrAuthorOrTittle(@PathVariable String inRack,String inAuthor,String inTittle){
        try{
            List<Book> bookList= bookService.findBookByRackNoOrAuthorOrTittle(inRack,inAuthor,inTittle);
            return ResponseEntity.ok(bookList);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Exception Occurred "+e.getMessage());
        }
    }

    @GetMapping("/count")
    public ResponseEntity<?> countBook(){
        try{
            long total=bookService.countTotalBooks();
            return ResponseEntity.ok(total);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("exception occurred "+e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public String deleteBook(@PathVariable int id){
        return bookService.deleteByIde(id);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateBook(@PathVariable int id, @RequestBody BookRequestDto bookRequestDto){
        try{
            return ResponseEntity.ok(bookService.updateBook(id,bookRequestDto));
        }catch(Exception e){
            return ResponseEntity.internalServerError().body("Exception occurred "+e.getMessage());
        }
    }


}
