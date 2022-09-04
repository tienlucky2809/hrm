package com.project.hrm.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "employee_salaries")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSalaryEntity implements Serializable {
    private static final long serialVersionUID = -297553281792804396L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_salaries_generator")
//    @SequenceGenerator(name = "employee_salaries_generator", sequenceName = "employee_salaries_sequence", initialValue = 1, allocationSize = 1)
    @Column(name = "id")
    private int id;

    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "start_date")
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "Asia/Bangkok")
    Date startDate;

    @Column(name = "end_date")
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "Asia/Bangkok")
    Date endDate;

    @Column(name = "basic_rate")
    private double basicRate;

    @Column(name = "fringe_benefit")
    private double fringeBenefit;

    @Column(name = "active_status")
    private int activeStatus;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeSalaryEntity)) return false;
        EmployeeSalaryEntity that = (EmployeeSalaryEntity) o;
        return employeeId == that.employeeId &&
                Double.compare(that.basicRate, basicRate) == 0 &&
                Double.compare(that.fringeBenefit, fringeBenefit) == 0 &&
                startDate.equals(that.startDate) &&
                endDate.equals(that.endDate);
    }

    //active status phu thuoc vao thoi diem hien tai
    public void setActiveStatus(){
        if(endDate.compareTo(new Date()) >0 )
            activeStatus = 1;
        else
            activeStatus = 0;
    }
}
