package com.example.undergrad.Controller;

import com.example.undergrad.Service.StudentService;
import com.example.undergrad.model.Students;
import io.micrometer.common.util.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping( value = "/getStudent", produces = "application/json")
    public void getEmployee(@RequestParam("student_Id") String empId) throws ExecutionException, InterruptedException {
        Students students = studentService.getStudent("1");
        System.out.println(students);
    }
}
