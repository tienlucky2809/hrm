package com.project.hrm.entities;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Component
public class EmployeeValidator {
    @Autowired
    RegularExpression regularExpression;

    public boolean isValid(EmployeeEntity employeeEntity) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return employeeEntity != null &&
                !StringUtils.isAnyEmpty(employeeEntity.getFirstName(),
                                        employeeEntity.getLastName(),
                                        employeeEntity.getSex(),
                                        employeeEntity.getBirthday().toString(),
                                        employeeEntity.getAddress1(),
                                        employeeEntity.getIdentityNumber(),
                                        employeeEntity.getStartDate().toString(),
                                        employeeEntity.getJobStatus() + "") &&
                regularExpression.regexEmail(employeeEntity.getEmail()) &&
                regularExpression.regexIdentityNumber(employeeEntity.getIdentityNumber()) &&
                regularExpression.regexDate(dateFormat.format(employeeEntity.getBirthday())) &&
                regularExpression.regexDate(dateFormat.format(employeeEntity.getStartDate())) &&
                regularExpression.regexName(employeeEntity.getFirstName()) &&
                regularExpression.regexName(employeeEntity.getLastName()) &&
                (StringUtils.isEmpty(employeeEntity.getPhoneNumber()) || (!StringUtils.isEmpty(employeeEntity.getPhoneNumber()) && regularExpression.regexPhoneNumber(employeeEntity.getPhoneNumber())))
                ;
    }
}
