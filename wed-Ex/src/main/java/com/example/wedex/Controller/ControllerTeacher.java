package com.example.wedex.Controller;

import com.example.wedex.Model.Student;
import com.example.wedex.Model.Teacher;
import com.example.wedex.Service.ServiceTeacher;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class ControllerTeacher {

    private final ServiceTeacher serviceTeacher;

    @GetMapping("/get")
    public ResponseEntity getTeacher(){
        ArrayList<Teacher>teachers=serviceTeacher.getTeacher();
        return ResponseEntity.status(200).body(teachers);
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher , Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        serviceTeacher.addTeacher(teacher);
        return ResponseEntity .status(200).body("teacher added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent (@PathVariable int id , @RequestBody @Valid Teacher teacher, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isupdated = serviceTeacher.updateTeacher(id,teacher);
        if(isupdated){
            return ResponseEntity.status(200).body("teachers updated");
        }
        return ResponseEntity.status(400).body("wrong id");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable int id ){
        boolean isdeleted = serviceTeacher.deleteTeacher(id);
        if(isdeleted){
            return ResponseEntity.status(200).body("teacher deleted");
        }
        return ResponseEntity.status(400).body("wrong id");
    }
   @GetMapping("/get/{id}")
    public ResponseEntity rteacher(@PathVariable int id) {

        ArrayList<Teacher>teachers=serviceTeacher.getTeacher();

       return ResponseEntity.status(200).body(teachers);
   }



}
