package com.vicky.youtube.LearningRESTAPIs.service.impl;

import com.vicky.youtube.LearningRESTAPIs.dto.AddStudentRequestSto;
import com.vicky.youtube.LearningRESTAPIs.dto.StudentDto;
import com.vicky.youtube.LearningRESTAPIs.entity.Student;
import com.vicky.youtube.LearningRESTAPIs.repository.StudentRepository;
import com.vicky.youtube.LearningRESTAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudent() {

        List<Student> students=studentRepository.findAll();
        return  students.stream().map(student -> new StudentDto(student.getId(), student.getName(), student.getMail())).toList();

    }

    @Override
    public StudentDto getstudentbyid(Long id) {
        Student student= studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Student not found with id"+id));
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestSto addStudentRequestSto) {
        Student newstudent=modelMapper.map(addStudentRequestSto,Student.class);
        Student student=studentRepository.save(newstudent);
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Does not exist by id "+id);

        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(Long id, AddStudentRequestSto addStudentRequestDto) {
        Student student  = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with ID: "+id));
        modelMapper.map(addStudentRequestDto, student);

        student = studentRepository.save(student);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto updatePartialStudent(Long id, Map<String, Object> updates) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with ID: "+id));

        updates.forEach((field, value) -> {
            switch (field) {
                case "name":
                    student.setName((String) value);
                    break;
                case "email":
                    student.setMail((String) value);
                    break;
                default:
                    throw new IllegalArgumentException("Field is not supported");
            }
        });
        Student savedStudent = studentRepository.save(student);
        return modelMapper.map(savedStudent, StudentDto.class);
    }
}
