package com.project.hrm.controller;

import com.project.hrm.entities.EmployeeEntity;
import com.project.hrm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/add-employee")
    public ResponseEntity addEmployee(@RequestBody EmployeeEntity employeeEntity) {
        try {
            EmployeeEntity employeeEntity1 = employeeService.insertEmployee(employeeEntity);
            return new ResponseEntity("add success", HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity("add failded", HttpStatus.OK);
        }
    }

    @PostMapping("/add-list-employee")
    public ResponseEntity addListEmployee(@RequestBody List<EmployeeEntity> listEmployeeEntity) {
        try {
            List<EmployeeEntity> listEmployeeEntity1 = employeeService.insertListEmployee(listEmployeeEntity);
            return new ResponseEntity("add " + listEmployeeEntity1.size() + " employee success", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity("add list employee failded", HttpStatus.OK);
        }
    }

    @GetMapping("/get-all-employee")
    public ResponseEntity getEmployee() {
        List listEmployee = new ArrayList<EmployeeEntity>();
        listEmployee = employeeService.getListEmployee();
        return ResponseEntity.ok(listEmployee);
    }

    @GetMapping("/get-employee-by-id/{employeeId}")
    public ResponseEntity getEmployeeById(@PathVariable(name = "employeeId") Integer employeeId) {
        EmployeeEntity employeeEntity = employeeService.getEmployeeById(employeeId);
        System.out.println("/get-employee-by-id/{employeeId}");
        System.out.println(employeeEntity.toString());
        if (employeeEntity == null) return new ResponseEntity("not found", HttpStatus.OK);
        else {
            return ResponseEntity.ok(employeeEntity);
        }
    }

    @GetMapping("/get-employee-by-identityNumber/{identityNumber}")
    public ResponseEntity getEmployeeByIdentityNumber(@PathVariable(name = "identityNumber") String identityNumber) {
        EmployeeEntity employeeEntity = employeeService.getEmployeeByIdentityNumber(identityNumber);
        System.out.println("/get-employee-by-identityNumber/{identityNumber}");
        System.out.println(employeeEntity.toString());
        if (employeeEntity == null) return new ResponseEntity("not found", HttpStatus.OK);
        else {
            return ResponseEntity.ok(employeeEntity);
        }
    }

    @PutMapping("/update-employee")
    public ResponseEntity updateEmployee(@RequestBody EmployeeEntity employeeEntity) {
        try {
            System.out.println("/update-employee");
            System.out.println(employeeEntity.toString());
            EmployeeEntity employeeEntity1 = employeeService.updateEmployee(employeeEntity);
            return new ResponseEntity("update success", HttpStatus.OK);
        } catch (Exception exception) {
            exception.printStackTrace();
            return new ResponseEntity("update failded", HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete-employee-by-id/{employeeId}")
    public ResponseEntity deleteEmployeeById(@PathVariable(name = "employeeId") Integer employeeId) {
        EmployeeEntity employeeEntity = employeeService.getEmployeeById(employeeId);
        System.out.println("/delete-employee-by-id/{employeeId}");
        System.out.println(employeeEntity.toString());
        employeeService.deleteById(employeeId);
        return new ResponseEntity("delete success", HttpStatus.OK);
    }

}
