package com.project.hrm.repository;

import com.project.hrm.entities.EmployeeSalaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeSalaryRepository extends JpaRepository<EmployeeSalaryEntity, Integer> {
    EmployeeSalaryEntity findById(int id);

    List<EmployeeSalaryEntity> findAllByEmployeeIdOrderByStartDate(int id);

    EmployeeSalaryEntity findByEmployeeIdAndActiveStatus(int id, int activeStatus);

    List<EmployeeSalaryEntity> findAllByEmployeeIdAndStartDateGreaterThanEqual(int id, Date date);
}
