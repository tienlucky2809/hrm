package com.project.hrm.validator;

import com.project.hrm.entities.EmployeeEntity;
import com.project.hrm.entities.RelationEntity;
import com.project.hrm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

import java.util.Optional;

@Component
public class RelationValidator {

    @Autowired
    private EmployeeService employeeService;

    public boolean isValid(RelationEntity relationEntity) {
        return Optional.ofNullable(relationEntity)
                .filter(r -> !StringUtils.isEmptyOrWhitespace(r.getFirstName()))
                .filter(r -> !StringUtils.isEmptyOrWhitespace(r.getLastName()))
                .filter(r -> r.getSex() == 'F' || r.getSex() == 'M')
                .filter(r -> r.getEmployeeId() > 0)
                .filter(r -> r.getTypeId() > 0)
                .filter(r -> r.getRegisteredDate() != null)
                .isPresent();
    }

    public boolean isEmployeeExist(RelationEntity relationEntity) {
        EmployeeEntity e = employeeService.getEmployeeById(relationEntity.getEmployeeId());
        return ((e != null) && (e.getJobStatus() == 1));
    }
}
