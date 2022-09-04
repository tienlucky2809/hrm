package com.project.hrm.service;

import com.project.hrm.entities.EmployeeSalaryEntity;
import com.project.hrm.exception.ResponseMessage;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface EmployeeSalaryService {
    ResponseMessage insertEmployeeSalary(EmployeeSalaryEntity employeeSalaryEntity);
    List<EmployeeSalaryEntity> getListEmployeeSalary();
    EmployeeSalaryEntity getEmployeeSalaryById(int id);
    EmployeeSalaryEntity getEmployeeCurrentSalary(int id);
    List<EmployeeSalaryEntity> getListEmployeeSalaryByEmployeeId(int id);
    List<EmployeeSalaryEntity> getListEmployeeSalaryByEmployeeIdAndStartDateGreaterThanEqual(int id, Date date);
}
