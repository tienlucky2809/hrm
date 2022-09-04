package com.project.hrm.service.impl;

import com.project.hrm.entities.EmployeeEntity;
import com.project.hrm.entities.RegisterLeaveEntity;
import com.project.hrm.entities.RegisterLeaveStatus;
import com.project.hrm.entities.RegisterLeaveValidator;
import com.project.hrm.repository.RegisterLeaveRepository;
import com.project.hrm.service.EmployeeService;
import com.project.hrm.service.RegisterLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class RegisterLeaveServiceImpl implements RegisterLeaveService {
    @Autowired
    RegisterLeaveRepository registerLeaveRepository;
    @Autowired
    RegisterLeaveValidator registerLeaveValidator;
    @Autowired
    EmployeeService employeeService;

    @Override
    public RegisterLeaveEntity getRegisterLeaveById(Integer registerLeaveId) throws Exception {
        RegisterLeaveEntity registerLeaveEntity = registerLeaveRepository.findByRegisterLeaveId(registerLeaveId);
        if (registerLeaveEntity == null) {
            throw new Exception("register leave is not exist!!");
        } else return registerLeaveEntity;
    }

    @Override
    public RegisterLeaveEntity insertRegisterLeave(RegisterLeaveEntity registerLeaveEntity) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (!registerLeaveValidator.isValid(registerLeaveEntity)) {
            throw new Exception("Input data failed!!");
        }
        EmployeeEntity employeeEntity = employeeService.getEmployeeById(registerLeaveEntity.getEmployeeId());
        if (employeeEntity == null) {
            throw new Exception("EmployeeId " + employeeEntity.getEmployeeId() + " is not exist!!");
        } else if (employeeEntity.getJobStatus() == 0) {
            throw new Exception("EmployeeId " + employeeEntity.getEmployeeId() + " was off job!!");
        } else if (registerLeaveRepository.findByEmployeeIdFromStartDateToEndDate(registerLeaveEntity.getEmployeeId(),
                dateFormat.format(registerLeaveEntity.getStartDate()),
                dateFormat.format(registerLeaveEntity.getEndDate())).size() > 0) {
            throw new Exception("Register leave is conflict!!");
        } else return registerLeaveRepository.save(registerLeaveEntity);

    }

    @Override
    public RegisterLeaveEntity getRegisterLeaveEmployeeIdLatest(Integer employeeId) throws Exception {
        RegisterLeaveEntity registerLeaveEntity = registerLeaveRepository.findLatestByEmployeeId(employeeId);
        if (registerLeaveEntity == null) {
            throw new Exception("EmployeeId " + employeeId + " have not register leave");
        } else return registerLeaveEntity;
    }

    @Override
    public List<RegisterLeaveEntity> getListRegisterLeaveEmployeeId(Integer employeeId) throws Exception {
        List<RegisterLeaveEntity> listRegisterLeave = new ArrayList<RegisterLeaveEntity>();
        listRegisterLeave.addAll(registerLeaveRepository.findAllByEmployeeId(employeeId));
        if (listRegisterLeave.size() == 0) {
            throw new Exception("EmployeeId " + employeeId + " have not register leave");
        } else return listRegisterLeave;
    }

    @Override
    public List<RegisterLeaveEntity> getListRegisterLeaveEmployeeIdAYear(Integer employeeId) throws Exception {
        List<RegisterLeaveEntity> listRegisterLeave = new ArrayList<RegisterLeaveEntity>();
        listRegisterLeave.addAll(registerLeaveRepository.findAYearByEmployeeId(employeeId));
        if (listRegisterLeave.size() == 0) {
            throw new Exception("EmployeeId " + employeeId + " have not register leave for a year");
        } else return listRegisterLeave;
    }

    @Override
    public List<RegisterLeaveEntity> getListRegisterLeaveEmployeeIdFromStartDateToEndDate(Integer employeeId, String startDate, String endDate) throws Exception {
        List<RegisterLeaveEntity> listRegisterLeave = new ArrayList<RegisterLeaveEntity>();
        listRegisterLeave.addAll(registerLeaveRepository.findByEmployeeIdFromStartDateToEndDate(employeeId, startDate, endDate));
        if (listRegisterLeave.size() == 0) {
            throw new Exception("EmployeeId " + employeeId + " have not register leave");
        } else return listRegisterLeave;
    }


    @Override
    public void deleteRegisterLeaveEmployeeId(Integer registerLeaveId) {
        registerLeaveRepository.deleteById(registerLeaveId);
    }

    @Override
    public RegisterLeaveEntity updateRegisterLeaveStatus(Integer registerLeaveId, RegisterLeaveStatus registerLeaveStatus) throws Exception {
        RegisterLeaveEntity registerLeaveEntity = registerLeaveRepository.findByRegisterLeaveId(registerLeaveId);
        if (registerLeaveEntity == null) {
            throw new Exception("Register Leave is not exist!!");
        } else {
            registerLeaveEntity.setRegisterLeaveStatus(registerLeaveStatus);
            return registerLeaveRepository.save(registerLeaveEntity);
        }
    }


}
