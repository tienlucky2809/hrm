package com.project.hrm;

import com.project.hrm.entities.EmployeeSalaryEntity;
import com.project.hrm.exception.ResponseMessage;
import com.project.hrm.service.EmployeeSalaryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@SpringBootTest
@ActiveProfiles("dev")
@Transactional
public class EmployeeSalaryServiceTests {

    @Autowired
    private EmployeeSalaryService employeeSalaryService;

    @Test
    void insertEmployeeSalaryEntity_wrongDate() throws ParseException {
        //StartDate > EndDate
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        EmployeeSalaryEntity employeeSalaryEntity = new EmployeeSalaryEntity();
        employeeSalaryEntity.setEmployeeId(1);
        employeeSalaryEntity.setStartDate(dateFormat.parse("01-08-2021"));
        employeeSalaryEntity.setEndDate(dateFormat.parse("01-02-2021"));
        employeeSalaryEntity.setBasicRate(8000000);
        employeeSalaryEntity.setFringeBenefit(800000);
        employeeSalaryEntity.setActiveStatus();
        ResponseMessage responseMessage = employeeSalaryService.insertEmployeeSalary(employeeSalaryEntity);
        Assertions.assertEquals("fail", responseMessage.getStatus());
        Assertions.assertEquals("wrong information", responseMessage.getMessage());
    }

    @Test
    void insertEmployeeSalaryEntity_notExists_employeeId() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        EmployeeSalaryEntity employeeSalaryEntity = new EmployeeSalaryEntity();
        employeeSalaryEntity.setEmployeeId(2);
        employeeSalaryEntity.setStartDate(dateFormat.parse("01-02-2021"));
        employeeSalaryEntity.setEndDate(dateFormat.parse("01-08-2021"));
        employeeSalaryEntity.setBasicRate(8000000);
        employeeSalaryEntity.setFringeBenefit(800000);
        employeeSalaryEntity.setActiveStatus();
        ResponseMessage responseMessage = employeeSalaryService.insertEmployeeSalary(employeeSalaryEntity);
        Assertions.assertEquals("fail", responseMessage.getStatus());
        Assertions.assertEquals("employee does not exist", responseMessage.getMessage());
    }

    @Test
    void insertEmployeeSalaryEntity_alreadyExisted() throws ParseException {
        //neu bang luong moi trung khop voi bang luong hien tai
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        EmployeeSalaryEntity employeeSalaryEntity = new EmployeeSalaryEntity();
        employeeSalaryEntity.setEmployeeId(1);
        employeeSalaryEntity.setStartDate(dateFormat.parse("01-06-2021"));
        employeeSalaryEntity.setEndDate(dateFormat.parse("01-09-2025"));
        employeeSalaryEntity.setBasicRate(8500000);
        employeeSalaryEntity.setFringeBenefit(850000);
        employeeSalaryEntity.setActiveStatus();
        //eemployeeSalaryEntity.activeStatus = 1
        ResponseMessage responseMessage = employeeSalaryService.insertEmployeeSalary(employeeSalaryEntity);
        Assertions.assertEquals("fail", responseMessage.getStatus());
        Assertions.assertEquals("salary existed", responseMessage.getMessage());
    }

    @Test
    @Rollback
    void insertEmployeeSalaryEntity_valid() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        EmployeeSalaryEntity employeeSalaryEntity = new EmployeeSalaryEntity();
        employeeSalaryEntity.setEmployeeId(3);
        employeeSalaryEntity.setStartDate(dateFormat.parse("12-06-2021"));
        employeeSalaryEntity.setEndDate(dateFormat.parse("12-06-2022"));
        employeeSalaryEntity.setBasicRate(8000000);
        employeeSalaryEntity.setFringeBenefit(800000);
        employeeSalaryEntity.setActiveStatus();
        ResponseMessage responseMessage = employeeSalaryService.insertEmployeeSalary(employeeSalaryEntity);
        Assertions.assertEquals("success", responseMessage.getStatus());
        Assertions.assertEquals("new salary has been added", responseMessage.getMessage());
    }

    @Test
    @Rollback
    void insertEmployeeSalaryEntity_newValidSalary() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        EmployeeSalaryEntity employeeSalaryEntity = new EmployeeSalaryEntity();
        employeeSalaryEntity.setEmployeeId(1);
        employeeSalaryEntity.setStartDate(dateFormat.parse("01-06-2021"));
        employeeSalaryEntity.setEndDate(dateFormat.parse("01-09-2026"));
        employeeSalaryEntity.setBasicRate(8800000);
        employeeSalaryEntity.setFringeBenefit(880000);
        employeeSalaryEntity.setActiveStatus();
        ResponseMessage responseMessage = employeeSalaryService.insertEmployeeSalary(employeeSalaryEntity);
        Assertions.assertEquals("success", responseMessage.getStatus());
        Assertions.assertEquals("old salary has been updated, " +
                "new salary has been added", responseMessage.getMessage());
    }
}
