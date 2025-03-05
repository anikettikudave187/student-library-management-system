package com.example.Student_library_management_system.Service;

import com.example.Student_library_management_system.Controller.StudentController;
import com.example.Student_library_management_system.Converters.StudentConverter;
import com.example.Student_library_management_system.EnumClasses.CardStatus;
import com.example.Student_library_management_system.Repository.StudentRepository;
import com.example.Student_library_management_system.RequestDto.StudentRequestDto;
import com.example.Student_library_management_system.model_class.Card;
import com.example.Student_library_management_system.model_class.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public String saveStudent(StudentRequestDto studentRequestDto){
        Student student= StudentConverter.convertStudentRequestDtoIntoStudent(studentRequestDto);

        Card card=new Card();
        card.setCardstatus(CardStatus.ACTIVE);
        card.setStudent(student);
        student.setCard(card);

        studentRepository.save(student);
        return "student and card saved successfully";
    }

    public Student findStudentById(int id){
        Optional<Student> studentOptional =studentRepository.findById(id);
        if(studentOptional.isPresent()){
            return studentOptional.get();
        }else{
            throw new RuntimeException("Student not found with id : "+id);
        }
    }

    public List<Student> findAllStudent(){
        List<Student> studentList =studentRepository.findAll();
        return studentList;
    }

    public String deleteStudentById(int id){
        studentRepository.deleteById(id);
        return "student deleted successfully";
    }

    public String updateStudent(int id,StudentRequestDto studentRequestDto){
        Student student=findStudentById(id);

        if(student!=null){
            student.setSem(studentRequestDto.getSem());
            student.setMob(studentRequestDto.getMob());
            student.setName(studentRequestDto.getName());
            student.setGender(studentRequestDto.getGender());
            student.setEmail(studentRequestDto.getEmail());
            student.setDob(studentRequestDto.getDob());
            student.setDept(studentRequestDto.getDept());
            student.setAdress(studentRequestDto.getAdress());

            studentRepository.save(student);
            return "student updated successfully";
        }else{
            return "student not found";
        }
    }

    public String countStudent(){
        long studentCount=studentRepository.count();
        return "total count of students is: "+studentCount;
    }

    public List<Student> findStudentBySemAndDept(String inSem,String inDept){
        List<Student> studentList=studentRepository.findBySemAndDept(inSem,inDept);
        return studentList;
    }
}
