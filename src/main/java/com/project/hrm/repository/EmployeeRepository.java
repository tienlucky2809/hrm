package com.project.hrm.repository;

import com.project.hrm.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
    @Query(value = "SELECT * FROM employees WHERE id_no = :identityNumber ORDER BY employee_id DESC LIMIT 1;", nativeQuery = true)
    EmployeeEntity findByIdentityNumber(@Param("identityNumber") String identityNumber);

    @Query(value = "select * from employees", nativeQuery = true)
    List<EmployeeEntity> findAll();

    EmployeeEntity findByEmployeeId(Integer employeeId);

}
