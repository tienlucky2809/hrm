package com.project.hrm.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "relations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RelationEntity implements Serializable {
    private static final long serialVersionUID = -297553281792804396L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "relations_generator")
//    @SequenceGenerator(name = "relations_generator", sequenceName = "relation_sequence", initialValue = 1, allocationSize = 1)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "sex")
    char sex;

    @Column(name = "birthday")
//    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", timezone = "Asia/Bangkok")
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "Asia/Bangkok")
    Date birthDay;

    @Column(name = "relationship")
    String relationship;

    @Column(name = "employee_id")
    int employeeId;

    @Column(name = "type_id")
    int typeId;

    @Column(name = "registered_date")
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "Asia/Bangkok")
    Date registeredDate;

    @Column(name = "identity_number")
    String identityNumber;

    @Column(name = "insurance_number")
    String insuranceNumber;
}
