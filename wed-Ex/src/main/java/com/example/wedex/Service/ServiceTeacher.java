package com.example.wedex.Service;

import com.example.wedex.Model.Student;
import com.example.wedex.Model.Teacher;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@Service
public class ServiceTeacher {

    ArrayList<Teacher> teachers = new ArrayList<>();

    public ArrayList getTeacher() {
        return teachers;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public boolean updateTeacher(int id, Teacher teacher) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getID() == id) {
                teachers.set(i, teacher);
                return true;
            }
        }
        return false;
    }

    public boolean deleteTeacher(int id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getID() == id) {
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }


    public ArrayList getrTeacher(int id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getID() == id) {
                teachers.get(i).toString();
                return teachers;
            }
        }
        return null;
    }



}
