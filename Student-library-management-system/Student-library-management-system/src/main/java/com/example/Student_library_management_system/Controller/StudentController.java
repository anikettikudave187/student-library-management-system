package com.example.Student_library_management_system.Controller;

import com.example.Student_library_management_system.RequestDto.StudentRequestDto;
import com.example.Student_library_management_system.Service.StudentService;
import com.example.Student_library_management_system.model_class.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/api")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public String saveStudent(@RequestBody StudentRequestDto studentRequestDto){
        String response =studentService.saveStudent(studentRequestDto);
        return response;
    }

    @GetMapping("/findById")
    public ResponseEntity<?> findById(@PathVariable int id){
        try {
            Student student =studentService.findStudentById(id);
            return ResponseEntity.ok(student);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("exception occurred: "+e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public String deleteById(@PathVariable int id){
        try{
            return studentService.deleteStudentById(id);
        } catch (Exception e) {
            throw new RuntimeException("exception occurred: "+e.getMessage());
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAllStudent(){
        try {
            List<Student> studentList =studentService.findAllStudent();
            return ResponseEntity.ok(studentList);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("exception occurred: "+e.getMessage());
        }
    }

    @GetMapping("/count")
    public ResponseEntity<?> countStudent(){
        try {
            String studentCount =studentService.countStudent();
            return ResponseEntity.ok(studentCount);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("exception occurred: "+e.getMessage());
        }
    }

    @PutMapping("/updateStudent")
    public String updateStudent(@PathVariable int id,@RequestBody StudentRequestDto studentRequestDto){
        String response=studentService.updateStudent(id,studentRequestDto);
        return response;
    }

    @GetMapping("/findBySemAndDept")
    public ResponseEntity<?> findBySemAndDept(String inSem,String inDept){
        try {
            List<Student> studentList =studentService.findStudentBySemAndDept(inSem,inDept);
            return ResponseEntity.ok(studentList);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("exception occurred: "+e.getMessage());
        }
    }
}
