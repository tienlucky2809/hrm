package com.project.hrm.entities;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Component
public class RegisterLeaveValidator {
    @Autowired
    RegularExpression regularExpression;

    public Boolean isValid(RegisterLeaveEntity registerLeaveEntity) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return registerLeaveEntity != null &&
                !StringUtils.isAnyEmpty(registerLeaveEntity.getEmployeeId() + "",
                                        dateFormat.format(registerLeaveEntity.getStartDate()),
                                        dateFormat.format(registerLeaveEntity.getEndDate()),
                                        dateFormat.format(registerLeaveEntity.getCreateDate()),
                                        registerLeaveEntity.getReasonLeave(),
                                        registerLeaveEntity.getRegisterLeaveStatus().name()) &&
                (registerLeaveEntity.getStartDate().compareTo(registerLeaveEntity.getEndDate()) <= 0) &&
                regularExpression.regexDate(dateFormat.format(registerLeaveEntity.getStartDate())) &&
                regularExpression.regexDate(dateFormat.format(registerLeaveEntity.getEndDate()));
    }


}
