package com.project.hrm.validator;

import com.project.hrm.entities.EmployeeEntity;
import com.project.hrm.entities.EmployeeSalaryEntity;
import com.project.hrm.repository.EmployeeRepository;
import com.project.hrm.repository.EmployeeSalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public class EmployeeSalaryValidator {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeSalaryRepository employeeSalaryRepository;

    public boolean isValid(EmployeeSalaryEntity employeeSalaryEntity){
        return Optional.ofNullable(employeeSalaryEntity)
                .filter(r -> r.getEmployeeId() > 0)
                .filter(r -> r.getStartDate() != null)
                .filter(r -> r.getStartDate().compareTo(new Date()) <= 0)
                .filter(r -> r.getEndDate() != null)
                .filter(r -> r.getEndDate().compareTo(r.getStartDate()) > 0)
                .filter(r -> r.getBasicRate() > 0)
                .filter(r -> r.getFringeBenefit() >= 0)
                .filter(r -> r.getActiveStatus() == 0 || r.getActiveStatus() == 1)
                .isPresent();
    }

    public boolean isEmployeeExist(EmployeeSalaryEntity employeeSalaryEntity) {
        EmployeeEntity e = employeeRepository.findByEmployeeId(employeeSalaryEntity.getEmployeeId());
        return ((e != null) && (e.getJobStatus() == 1));
    }

}
