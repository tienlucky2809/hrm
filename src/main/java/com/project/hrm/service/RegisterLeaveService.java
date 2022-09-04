package com.project.hrm.service;

import com.project.hrm.entities.RegisterLeaveEntity;
import com.project.hrm.entities.RegisterLeaveStatus;

import java.util.List;

public interface RegisterLeaveService {
    RegisterLeaveEntity getRegisterLeaveById(Integer registerLeaveId) throws Exception;

    RegisterLeaveEntity insertRegisterLeave(RegisterLeaveEntity registerLeaveEntity) throws Exception;

    RegisterLeaveEntity getRegisterLeaveEmployeeIdLatest(Integer employeeId) throws Exception;

    List<RegisterLeaveEntity> getListRegisterLeaveEmployeeId(Integer employeeId) throws Exception;

    List<RegisterLeaveEntity> getListRegisterLeaveEmployeeIdAYear(Integer employeeId) throws Exception;

    List<RegisterLeaveEntity> getListRegisterLeaveEmployeeIdFromStartDateToEndDate(Integer employeeId, String startDate, String endDate) throws Exception;

    void deleteRegisterLeaveEmployeeId(Integer registerLeaveId);

    RegisterLeaveEntity updateRegisterLeaveStatus(Integer registerLeaveId, RegisterLeaveStatus registerLeaveStatus) throws Exception;
}
