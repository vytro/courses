package com.diplomado.courses.web.rest;

import com.diplomado.courses.domain.entities.Student;
import com.diplomado.courses.dto.StudentDTO;
import com.diplomado.courses.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> listStudents(@RequestParam(required = false, defaultValue = "false") boolean detailed){
        if(detailed){
            return ResponseEntity.ok().body(studentService.listStudentsDetailed());
        }else{
            return ResponseEntity.ok().body(studentService.listStudents());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable final Integer id) {
        return ResponseEntity
                .ok()
                .body(studentService
                        .getStudentById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id)));
    }

    @PostMapping
    public ResponseEntity<StudentDTO> create(@RequestBody final StudentDTO dto) throws URISyntaxException {
        if(dto.getId() != null){
            throw new IllegalArgumentException("A new student cannot already have an ID");
        }

        StudentDTO studentDB = studentService.save(dto);

        return ResponseEntity.created(new URI("/v1/students/" + studentDB.getId())).body(studentDB);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Integer id){
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
