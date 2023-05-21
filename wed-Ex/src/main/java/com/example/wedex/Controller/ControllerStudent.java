package com.example.wedex.Controller;

import com.example.wedex.Model.Student;
import com.example.wedex.Model.Teacher;
import com.example.wedex.Service.ServiceStudent;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class ControllerStudent {

    private final ServiceStudent serviceStudent;
    @GetMapping("/get")
    public ResponseEntity getStudents(){
        ArrayList<Student>students=serviceStudent.getStudents();
        return ResponseEntity.status(200).body(students);
    }
@PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student , Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        serviceStudent.addStudents(student);
        return ResponseEntity .status(200).body("students added");
    }
  @PutMapping("/update/{id}")
    public ResponseEntity updateStudent (@PathVariable int id , @RequestBody @Valid Student student,Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
       boolean isupdated = serviceStudent.updateStudents(id,student);
        if(isupdated){
            return ResponseEntity.status(200).body("steudent updated");
        }
        return ResponseEntity.status(400).body("wrong id");
    }
  @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudents(@PathVariable int id ){
        boolean isdeleted = serviceStudent.deleteStudent(id);
        if(isdeleted){
            return ResponseEntity.status(200).body("steudent deleted");
        }
        return ResponseEntity.status(400).body("wrong id");
    }

    @GetMapping("/get/{name}")
    public ResponseEntity rtstudent(@PathVariable String name) {

        ArrayList<Student> students = serviceStudent.getrStudent(name);

        return ResponseEntity.status(200).body(students);


    }


}
