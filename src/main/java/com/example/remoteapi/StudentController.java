package com.example.remoteapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student)
    {
        return studentService.addStudent(student);
    }

    @GetMapping("/get")
    public Student get( @RequestParam("id") int admnNo)
    {
        return studentService.get(admnNo);
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam("id") int admnNo)
    {
        return studentService.delete(admnNo);

    }

    // update the course
    @PutMapping("/update_course")
    public Student updatecourse(@RequestParam("id") int admnNo,@RequestParam("course") String course)
    {
        return studentService.updatecourse(admnNo,course);

    }
    // return the total number of student whose age greater than 15
    @GetMapping("/gettotalstudent")
    public int gettotalstudent()
    {
        return studentService.gettotalstudent();

    }
}
