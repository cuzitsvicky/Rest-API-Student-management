package com.vicky.youtube.LearningRESTAPIs.controller;


import com.vicky.youtube.LearningRESTAPIs.dto.AddStudentRequestSto;
import com.vicky.youtube.LearningRESTAPIs.dto.StudentDto;
import com.vicky.youtube.LearningRESTAPIs.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

   private final StudentService studentService;




    @GetMapping
    public ResponseEntity<List<StudentDto>> getStudent(){
         return ResponseEntity.ok(studentService.getAllStudent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getstudentbyid(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getstudentbyid(id));
    }

    @PostMapping
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody @Valid AddStudentRequestSto addStudentRequestSto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestSto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAstudent(@PathVariable  Long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id,
                                                    @RequestBody  AddStudentRequestSto addStudentRequestDto) {
        return ResponseEntity.ok(studentService.updateStudent(id, addStudentRequestDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StudentDto> updatePartialStudent(@PathVariable Long id,
                                                           @RequestBody  Map<String, Object> updates) {
        return ResponseEntity.ok(studentService.updatePartialStudent(id, updates));
    }
}
