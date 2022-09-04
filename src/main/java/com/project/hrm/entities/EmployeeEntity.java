package com.project.hrm.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
@Entity
public class EmployeeEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "sex")
    private String sex;
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "Asia/Bangkok")
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "address1")
    private String address1;
    @Column(name = "address2")
    private String address2;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "id_no")
    private String identityNumber;
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "Asia/Bangkok")
    @Column(name = "start_date")
    private Date startDate;
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "Asia/Bangkok")
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "job_status")
    private int jobStatus;
    @Column(name = "marial_status")
    @Enumerated(EnumType.STRING)
    private MarialStatus marialStatus;
}
