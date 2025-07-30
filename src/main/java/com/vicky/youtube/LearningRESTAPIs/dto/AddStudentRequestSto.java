package com.vicky.youtube.LearningRESTAPIs.dto;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class AddStudentRequestSto {

    @NotBlank(message = "Name is required")
    @Size(min=3,max = 30,message = "Name should be length 3 to 30 characters")
    private String name;

    @Email
    @NotBlank(message = "Can not be blank")
    private String mail;
}
