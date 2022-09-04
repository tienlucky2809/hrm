package com.project.hrm.controller;

import com.project.hrm.entities.RegisterLeaveEntity;
import com.project.hrm.entities.RegisterLeaveStatus;
import com.project.hrm.service.RegisterLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RegisterLeaveController {
    @Autowired
    RegisterLeaveService registerLeaveService;

    @GetMapping("/get-all-register-leave-employee/{employeeId}")
    public ResponseEntity getRegisterLeaveEmployee(@PathVariable(name = "employeeId") Integer employeeId) {
        try {
            List<RegisterLeaveEntity> listRegisterLeave = new ArrayList<RegisterLeaveEntity>();
            listRegisterLeave.addAll(registerLeaveService.getListRegisterLeaveEmployeeId(employeeId));
            return ResponseEntity.ok(listRegisterLeave);
        } catch (Exception exception) {
            exception.printStackTrace();
            return new ResponseEntity("get all register leave employeeId " + employeeId + " failed!!", HttpStatus.OK);
        }
    }

    @GetMapping("/get-register-leave-employee-latest/{employeeId}")
    public ResponseEntity getRegisterLeaveEmployeeLastest(@PathVariable(name = "employeeId") Integer employeeId) {
        try {
            RegisterLeaveEntity registerLeaveEntity = registerLeaveService.getRegisterLeaveEmployeeIdLatest(employeeId);
            return ResponseEntity.ok(registerLeaveEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return new ResponseEntity("get register leave employee latest failed !!!", HttpStatus.OK);
        }
    }

    @GetMapping("/get-register-leave-employee-by-time/{employeeId}/{startDate}/{endDate}")
    public ResponseEntity getRegisterLeaveEmployeeByTime(@PathVariable(name = "employeeId") Integer employeeId,
                                                         @PathVariable(name = "startDate") String startDate,
                                                         @PathVariable(name = "endDate") String endDate) {
        try {
            List<RegisterLeaveEntity> listRegisterLeave = new ArrayList<RegisterLeaveEntity>();
            listRegisterLeave.addAll(registerLeaveService.getListRegisterLeaveEmployeeIdFromStartDateToEndDate(employeeId, startDate, endDate));
            return ResponseEntity.ok(listRegisterLeave);
        } catch (Exception exception) {
            exception.printStackTrace();
            return new ResponseEntity("get register leave employee by time failed !!!", HttpStatus.OK);
        }
    }

    @GetMapping("/get-register-leave-employee-a-year/{employeeId}")
    public ResponseEntity getRegisterLeaveEmployeeAYear(@PathVariable(name = "employeeId") Integer employeeId) {
        try {
            List<RegisterLeaveEntity> listRegisterLeave = new ArrayList<RegisterLeaveEntity>();
            listRegisterLeave.addAll(registerLeaveService.getListRegisterLeaveEmployeeIdAYear(employeeId));
            return ResponseEntity.ok(listRegisterLeave);
        } catch (Exception exception) {
            exception.printStackTrace();
            return new ResponseEntity("get register leave employee a year failed !!!", HttpStatus.OK);
        }
    }

    @PostMapping("/add-register-leave")
    public ResponseEntity insertRegisterLeave(@RequestBody RegisterLeaveEntity registerLeaveEntity) {
        try {
            RegisterLeaveEntity registerLeaveEntity1 = registerLeaveService.insertRegisterLeave(registerLeaveEntity);
            return new ResponseEntity("add success!!!", HttpStatus.OK);
        } catch (Exception exception) {
            exception.printStackTrace();
            return new ResponseEntity("add failed!!!", HttpStatus.OK);
        }
    }

    @DeleteMapping("/detete-register-leave/{registerLeaveId}")
    public ResponseEntity deleteRegisterLeave(@PathVariable(name = "registerLeaveId") Integer registerLeaveId) {
        try {
            registerLeaveService.deleteRegisterLeaveEmployeeId(registerLeaveId);
            return new ResponseEntity("delete success!!!", HttpStatus.OK);
        } catch (Exception exception) {
            exception.printStackTrace();
            return new ResponseEntity("delete failed!!!", HttpStatus.OK);
        }
    }

    @PutMapping("/update-register-leave-status/{registerLeaveId}/{registerLeaveStatus}")
    public ResponseEntity updateRegisterLeaveStatus(@PathVariable(name = "registerLeaveId") Integer registerLeaveId,
                                                    @PathVariable(name = "registerLeaveStatus") RegisterLeaveStatus registerLeaveStatus) {
        System.out.println(registerLeaveId + " " + registerLeaveStatus);
        try {
            RegisterLeaveEntity registerLeaveEntity = registerLeaveService.updateRegisterLeaveStatus(registerLeaveId, registerLeaveStatus);
            return ResponseEntity.ok(registerLeaveEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return new ResponseEntity("update failed!!", HttpStatus.OK);
        }
    }

}
