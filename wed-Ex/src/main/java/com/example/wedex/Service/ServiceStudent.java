package com.example.wedex.Service;

import com.example.wedex.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServiceStudent {

    ArrayList<Student>students=new ArrayList<>();

    public ArrayList getStudents(){
        return students;
    }

    public void addStudents(Student student){
        students.add(student);
    }

    public boolean updateStudents(int id , Student student){
        for(int i=0; i<students.size();i++){
            if(students.get(i).getID()==id){
                students.set(i,student);
                return true;
            }
        }
        return false;
    }
    public boolean deleteStudent(int id){
        for(int i=0; i<students.size();i++){
            if(students.get(i).getID()==id){
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Student> getrStudent(String name) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(name)){
                students.get(i).toString();
                return students;
            }
        }
        return null;
    }

}
