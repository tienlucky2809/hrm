package com.project.hrm.service.impl;

import com.project.hrm.entities.EmployeeEntity;
import com.project.hrm.entities.EmployeeValidator;
import com.project.hrm.repository.EmployeeRepository;
import com.project.hrm.service.EmployeeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeValidator employeeValidator;

    @Override
    public EmployeeEntity insertEmployee(EmployeeEntity employeeEntity) throws Exception {
        if (!employeeValidator.isValid(employeeEntity)) {
            throw new Exception("input employee invalid");
        }
        EmployeeEntity employeeEntity1 = employeeRepository.findByIdentityNumber(employeeEntity.getIdentityNumber());
        if (employeeEntity1 == null) {
            // neu csdl chua ton tai employee co identity giong input dau vao
            // insert moi employee
            return employeeRepository.save(employeeEntity);
        } else {
            // neu csdl ton tai employee co identity giong input dau vao
            if (employeeEntity1.getJobStatus() == 0)
                // neu employee da nghi viec
                //insert moi employee
                return employeeRepository.save(employeeEntity);
            else {
                //neu nhan vien con lam viec
                // khong cho insert
                throw new Exception("employee is exist");
            }
        }
    }

    @Override
    public List<EmployeeEntity> insertListEmployee(List<EmployeeEntity> listEmployeeEntity) throws Exception {

        List<EmployeeEntity> listEmployeeEntity1 = new ArrayList<EmployeeEntity>();
        for (EmployeeEntity employeeEntity : listEmployeeEntity) {
            EmployeeEntity employeeEntity1 = this.insertEmployee(employeeEntity);
            if (employeeEntity1 != null) {
                System.out.println(employeeEntity1.toString());
                listEmployeeEntity1.add(employeeEntity1);
            }
        }
        if (listEmployeeEntity1 == null) {
            throw new Exception("input employee is invalid");
        } else return listEmployeeEntity1;
    }


    @Override
    public EmployeeEntity getEmployeeByIdentityNumber(String indentityNumber) {
        return employeeRepository.findByIdentityNumber(indentityNumber);
    }

    @Override
    public List<EmployeeEntity> getListEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeEntity getEmployeeById(Integer employeeId) {
        return employeeRepository.findByEmployeeId(employeeId);
    }

    @Override
    public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) throws Exception {
        if (!employeeValidator.isValid(employeeEntity) || StringUtils.isEmpty(employeeEntity.getEmployeeId() + "")) {
            throw new Exception("input employee is valid");
        } else return employeeRepository.save(employeeEntity);
    }

    @Override
    public void deleteById(Integer employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
