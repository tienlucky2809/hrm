package com.project.hrm.service;

import com.project.hrm.entities.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    EmployeeEntity insertEmployee(EmployeeEntity employeeEntity) throws Exception;

    List<EmployeeEntity> insertListEmployee(List<EmployeeEntity> listEmployeeEntity) throws Exception;

    EmployeeEntity getEmployeeByIdentityNumber(String indentityNumber);

    List<EmployeeEntity> getListEmployee();

    EmployeeEntity getEmployeeById(Integer employeeId);

    EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) throws Exception;

    void deleteById(Integer employeeId);
}
