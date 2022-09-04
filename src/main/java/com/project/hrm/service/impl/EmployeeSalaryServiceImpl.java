package com.project.hrm.service.impl;

import com.project.hrm.entities.EmployeeSalaryEntity;
import com.project.hrm.exception.ResponseMessage;
import com.project.hrm.repository.EmployeeSalaryRepository;
import com.project.hrm.service.EmployeeSalaryService;
import com.project.hrm.validator.EmployeeSalaryValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeSalaryServiceImpl implements EmployeeSalaryService {

    @Autowired
    private EmployeeSalaryRepository employeeSalaryRepository;

    @Autowired
    private EmployeeSalaryValidator employeeSalaryValidator;

    @Override
    public ResponseMessage insertEmployeeSalary(EmployeeSalaryEntity employeeSalaryEntity){
        if(!employeeSalaryValidator.isValid(employeeSalaryEntity)){
            // neu cac truong du lieu khong phu hop
            return new ResponseMessage("fail","wrong information");
        } else if(!employeeSalaryValidator.isEmployeeExist(employeeSalaryEntity)){
            // neu nhan vien khong co thong tin trong database hoac da nghi viec
            return new ResponseMessage("fail","employee does not exist");
        }
        else{
            EmployeeSalaryEntity currentSalary = employeeSalaryRepository.
                    findByEmployeeIdAndActiveStatus(employeeSalaryEntity.getEmployeeId(),1);

            if(currentSalary==null){
                //nhan vien da co thong tin trong db nhung chua co bang luong hien tai
                employeeSalaryEntity.setActiveStatus();
                employeeSalaryRepository.save(employeeSalaryEntity);
                return new ResponseMessage("success","new salary has been added");
            } else if(employeeSalaryEntity.equals(currentSalary)){
                //neu bang luong da nhap trung khop voi bang luong hien tai
                return new ResponseMessage("fail","salary existed");
            } else{
                //chinh sua bang luong cu
                currentSalary.setEndDate(new Date
                        (employeeSalaryEntity.getStartDate().getTime() - 24 * 3600000));
                if(currentSalary.getEndDate().compareTo(new Date()) >0 )
                    currentSalary.setEndDate((new Date(new Date().getTime() - 24 * 3600000)));

                currentSalary.setActiveStatus(0);
                employeeSalaryRepository.save(currentSalary);
                //tao bang luong moi
                employeeSalaryEntity.setActiveStatus();
                employeeSalaryRepository.save(employeeSalaryEntity);
                return new ResponseMessage("success","old salary has been updated, " +
                        "new salary has been added");
            }
        }
    }

    @Override
    public List<EmployeeSalaryEntity> getListEmployeeSalary(){
        return employeeSalaryRepository.findAll();
    }

    @Override
    public EmployeeSalaryEntity getEmployeeSalaryById(int id){
        return employeeSalaryRepository.findById(id);
    }

    @Override
    public EmployeeSalaryEntity getEmployeeCurrentSalary(int id){
        return employeeSalaryRepository.findByEmployeeIdAndActiveStatus(id, 1);
    }

    @Override
    public List<EmployeeSalaryEntity> getListEmployeeSalaryByEmployeeId(int id){
        return employeeSalaryRepository.findAllByEmployeeIdOrderByStartDate(id);
    }

    @Override
    public List<EmployeeSalaryEntity> getListEmployeeSalaryByEmployeeIdAndStartDateGreaterThanEqual(int id, Date date){
        return employeeSalaryRepository.findAllByEmployeeIdAndStartDateGreaterThanEqual(id, date);
    }
}
