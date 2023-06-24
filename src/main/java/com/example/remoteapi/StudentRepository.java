package com.example.remoteapi;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository

public class StudentRepository {
    Map<Integer,Student> Studentdb = new HashMap<>();

    public Student get(int admnNo)
    {
        return Studentdb.get(admnNo);
    }
    public String addStudent(Student student)
    {
        if(Studentdb.containsKey(student.getAdmnNo()))
        {
            return "Student already present";
        }

        Studentdb.put(student.getAdmnNo(),student);
        return "Student successfully added";
    }

    public String delete(int admnNo) {

        Studentdb.remove(admnNo);
        return  "Student removed";
    }

    public Student updatecourse(int admnNo) {

        if(!Studentdb.containsKey(admnNo))
        {
            throw new RuntimeException("Student not present");
        }
        return Studentdb.get(admnNo);
//        student.setCourse(course);
//        return student;
    }

    public int gettotalstudent() {

        int count=0;
        for(int admno : Studentdb.keySet())
        {
            if(Studentdb.get(admno).getAge() > 15) count++;
        }
        return count;
    }
}
