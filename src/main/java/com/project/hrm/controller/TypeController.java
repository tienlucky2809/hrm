package com.project.hrm.controller;

import com.project.hrm.models.Type;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class TypeController {

    @GetMapping("/get-type")
    public ResponseEntity demo(){
        Type type = new Type();
        type.setId(3);
        type.setDescription("Dưới 25 tuổi nhưng thất nghiệp");
        return ResponseEntity.ok(type);
    }

    @PostMapping("/add-type")
    public ResponseEntity demo(@RequestBody Type type){
        System.out.println(type);
        return ResponseEntity.ok(type);
    }
}
