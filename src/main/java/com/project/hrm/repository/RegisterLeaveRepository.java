package com.project.hrm.repository;

import com.project.hrm.entities.RegisterLeaveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegisterLeaveRepository extends JpaRepository<RegisterLeaveEntity, Integer> {
    List<RegisterLeaveEntity> findAll();

    List<RegisterLeaveEntity> findAllByEmployeeId(Integer employeeId);

    @Query(value = "SELECT * FROM register_leave WHERE employee_id = :employeeId ORDER BY register_leave_id DESC LIMIT 1", nativeQuery = true)
    RegisterLeaveEntity findLatestByEmployeeId(@Param("employeeId") Integer employeeId);

    @Query(value = "SELECT * FROM register_leave WHERE employee_id = :employeeId AND start_date >=(CURDATE() - INTERVAL 1 YEAR) AND end_date <= CURDATE() ORDER BY end_date desc", nativeQuery = true)
    List<RegisterLeaveEntity> findAYearByEmployeeId(@Param("employeeId") Integer employeeId);

    @Query(value = "SELECT * FROM register_leave WHERE employee_id = :employeeId AND end_date >= :startDate AND start_date <= :endDate", nativeQuery = true)
    List<RegisterLeaveEntity> findByEmployeeIdFromStartDateToEndDate(@Param("employeeId") Integer employeeId,
                                                                     @Param("startDate") String startDate,
                                                                     @Param("endDate") String endDate);

    @Query(value = "SELECT * FROM register_leave WHERE register_leave_id = :registerLeaveId", nativeQuery = true)
    RegisterLeaveEntity findByRegisterLeaveId(@Param("registerLeaveId") Integer registerLeaveId);

}
