package com.example.remoteapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody Student student)
    {
          String  s = studentService.addStudent(student);
        return new ResponseEntity(s, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity get( @RequestParam("id") int admnNo)
    {
        Student s = studentService.get(admnNo);

        if(s==null)
        {
            return new ResponseEntity<>("Student not found",HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(s,HttpStatus.FOUND);

    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam("id") int admnNo)
    {
        String s = studentService.delete(admnNo);

        return new ResponseEntity<>(s,HttpStatus.OK);

    }

    // update the course
    @PutMapping("/update_course")
    public Student updatecourse(@RequestParam("id") int admnNo,@RequestParam("course") String course)
    {
        return studentService.updatecourse(admnNo,course);

    }
    // return the total number of student whose age greater than 15
    @GetMapping("/gettotalstudent")
    public ResponseEntity gettotalstudent()
    {
        int totalstudent = studentService.gettotalstudent();

        return new ResponseEntity(totalstudent,HttpStatus.OK);

    }
}
