package com.project.hrm.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "register_leave")
@Entity
public class RegisterLeaveEntity {
    @Id
    @Column(name = "register_leave_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer registerLeaveId;
    @Column(name = "employee_id")
    private Integer employeeId;
    @Column(name = "start_date")
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = " Asia/Bangkok")
    private Date startDate;
    @Column(name = "end_date")
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = " Asia/Bangkok")
    private Date endDate;
    @Column(name = "create_date")
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = " Asia/Bangkok")
    private Date createDate;
    @Column(name = "reason_leave")
    private String reasonLeave;
    @Column(name = "register_leave_status")
    @Enumerated(EnumType.STRING)
    private RegisterLeaveStatus registerLeaveStatus;
}
