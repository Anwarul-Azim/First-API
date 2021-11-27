package com.anwar.first;

import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api")

public class Controller {

    private final Map<Integer, Student> students = new ConcurrentHashMap<>();


    @PostMapping("/student")
    public Map<String, Integer> setStudent(@RequestBody Student student) {

        students.put(students.size() + 1, student);

        return Map.of("Id", students.size());
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id) {
        return students.get(id);
    }

    @GetMapping("/students")
    public Map<Integer, Student> getAll() {
        return students;
    }

    @DeleteMapping("/student/{id}")
    public String delStudent(@PathVariable int id){
        return students.remove(id) + "\nDeleted";
    }




}
