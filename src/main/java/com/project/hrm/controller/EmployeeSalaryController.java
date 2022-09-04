package com.project.hrm.controller;

import com.project.hrm.entities.EmployeeSalaryEntity;
import com.project.hrm.exception.ResponseMessage;
import com.project.hrm.service.EmployeeSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@CrossOrigin("*")
@RestController
public class EmployeeSalaryController {

    @Autowired
    private EmployeeSalaryService employeeSalaryService;

    @RequestMapping(value = "/api/add-employee-salary", method = RequestMethod.POST)
    public ResponseEntity<ResponseMessage> add(@RequestBody EmployeeSalaryEntity employeeSalaryEntity) {
        return new ResponseEntity<>(employeeSalaryService.insertEmployeeSalary(employeeSalaryEntity),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/api/get-employee-salaries", method = RequestMethod.GET)
    public ResponseEntity<List<EmployeeSalaryEntity>> findAll() {
        return new ResponseEntity<>(employeeSalaryService.getListEmployeeSalary(), HttpStatus.OK);
    }

    @RequestMapping(value = "/api/get-employee-salary-by-id", method = RequestMethod.GET)
    public ResponseEntity<EmployeeSalaryEntity> findAllById
            (@RequestParam(value = "id", required = false) int id) {
        return new ResponseEntity<>(employeeSalaryService.getEmployeeSalaryById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/api/get-employee-current-salary", method = RequestMethod.GET)
    public ResponseEntity<EmployeeSalaryEntity> findByEmployeeIdAndActiveStatus
            (@RequestParam(value = "id", required = false) int id) {
        return new ResponseEntity<>(employeeSalaryService.getEmployeeCurrentSalary(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/api/get-employee-salaries-by-employee-id", method = RequestMethod.GET)
    public ResponseEntity<List<EmployeeSalaryEntity>> findAllByEmployeeId
            (@RequestParam(value = "id", required = false) int id) {
        return new ResponseEntity<>(employeeSalaryService.getListEmployeeSalaryByEmployeeId(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/api/get-employee-salaries-by-employee-id-and-start-date", method = RequestMethod.GET)
    public ResponseEntity<List<EmployeeSalaryEntity>> findAllByEmployeeId
            (@RequestParam(value = "id", required = false) int id,
             @RequestParam(value = "date", required = false) String date) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return new ResponseEntity<>(employeeSalaryService.
                getListEmployeeSalaryByEmployeeIdAndStartDateGreaterThanEqual(id, dateFormat.parse(date)),
                HttpStatus.OK);
    }
}
