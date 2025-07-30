package com.vicky.youtube.LearningRESTAPIs.service;

import com.vicky.youtube.LearningRESTAPIs.dto.AddStudentRequestSto;
import com.vicky.youtube.LearningRESTAPIs.dto.StudentDto;

import java.util.List;
import java.util.Map;

public interface StudentService {


    List<StudentDto> getAllStudent();

    StudentDto getstudentbyid(Long id);

    StudentDto createNewStudent(AddStudentRequestSto addStudentRequestSto);

    void deleteStudentById(Long id);

    StudentDto updateStudent(Long id, AddStudentRequestSto addStudentRequestDto);

    StudentDto updatePartialStudent(Long id, Map<String, Object> updates);
}
