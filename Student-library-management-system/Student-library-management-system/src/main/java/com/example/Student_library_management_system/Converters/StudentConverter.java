package com.example.Student_library_management_system.Converters;

import com.example.Student_library_management_system.RequestDto.StudentRequestDto;
import com.example.Student_library_management_system.model_class.Student;

public class StudentConverter {
    //we use this converters to convert input requests into model classes
    //we need model classes for inputs
    public static Student convertStudentRequestDtoIntoStudent(StudentRequestDto studentRequestDto){
        Student student=new Student();
        student.setAdress(studentRequestDto.getAdress());
        student.setDept(studentRequestDto.getDept());
        student.setDob(studentRequestDto.getDob());
        student.setEmail(studentRequestDto.getEmail());
        student.setGender(studentRequestDto.getGender());
        student.setMob(studentRequestDto.getMob());
        student.setName(studentRequestDto.getName());
        student.setSem(studentRequestDto.getSem());

        return student;
    }
}
