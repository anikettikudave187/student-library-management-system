package com.example.Student_library_management_system.Controller;

import com.example.Student_library_management_system.RequestDto.AuthorRequestDto;
import com.example.Student_library_management_system.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author/api")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping("/save")
    public String saveAuthor(@RequestBody AuthorRequestDto authorRequestDto){
        String response =authorService.saveAuthor(authorRequestDto);
        return response;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteAuthor(@PathVariable int id){
        try{
            return ResponseEntity.ok(authorService.deleteById(id));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Exception Occurred"+e.getMessage());
        }
    }

    @PutMapping("/updateAuthor")
    public ResponseEntity<?> updateAuthor(@PathVariable int id,@RequestBody AuthorRequestDto authorRequestDto){
        try{
            return ResponseEntity.ok(authorService.updateAuthor(id,authorRequestDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Exception Occurred"+e.getMessage());
        }
    }

    @GetMapping("/findAuthor")
    public ResponseEntity<?> findauthor(@PathVariable int id){
        try{
            return ResponseEntity.ok(authorService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Exception Occurred"+e.getMessage());
        }
    }
}
