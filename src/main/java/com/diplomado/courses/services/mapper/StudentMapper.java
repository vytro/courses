package com.diplomado.courses.services.mapper;

import com.diplomado.courses.domain.entities.Student;
import com.diplomado.courses.dto.StudentDTO;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper implements CustomMapper<StudentDTO, Student>{

    @Override
    public Student toEntity(StudentDTO studentDTO) {
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setEmail(studentDTO.getEmail());
        student.setAge(studentDTO.getAge());
//        student.setCardNumber(studentDTO.getCardNumber());
        return student;
    }

    @Override
    public StudentDTO toDto(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setFirstName(student.getFirstName());
        dto.setLastName(student.getLastName());
        dto.setEmail(student.getEmail());
        dto.setAge(student.getAge());
        return dto;
    }

    @Override
    public StudentDTO toDtoDetailed(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setFirstName(student.getFirstName());
        dto.setLastName(student.getLastName());
        dto.setEmail(student.getEmail());
        dto.setAge(student.getAge());

        if(student.getStudentIdCard() != null){
            dto.setCardNumber(student.getStudentIdCard().getCardNumber());
        }else{
            dto.setCardNumber("Not assigned yet");
        }
//        dto.setCardNumber(student.getStudentIdCard().getCardNumber());
        return dto;
    }
}
