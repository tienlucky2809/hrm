package com.project.hrm.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Relation {
    int id;
    String firstName;
    String lastName;
    char sex;

//    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "Asia/Bangkok")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss" , timezone = "Asia/Bangkok")
    Date birthDay;

    String relationship;
    int employeeId;
    int typeId;

//    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "Asia/Bangkok")
    @JsonFormat(timezone = "Asia/Bangkok")
    Date registeredDate;

    String identityNumber;
    String insuranceNumber;
}
