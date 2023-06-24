package com.example.remoteapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student get(  int admnNo)
    {
        return studentRepository.get(admnNo);
    }

    public String addStudent(Student student)
    {
        return studentRepository.addStudent(student);
    }

    public String delete(int admnNo) {
        return studentRepository.delete(admnNo);
    }

    public Student updatecourse(int admnNo, String course) {
        Student s = studentRepository.updatecourse(admnNo);
        s.setCourse(course);
        return s;


    }

    public int gettotalstudent() {

        return studentRepository.gettotalstudent();
    }
}
