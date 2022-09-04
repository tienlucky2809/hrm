package com.project.hrm;

import com.project.hrm.entities.RegisterLeaveEntity;
import com.project.hrm.entities.RegisterLeaveStatus;
import com.project.hrm.service.RegisterLeaveService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Transactional
@Rollback
@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
@SpringBootTest
public class RegisterLeaveTest {
    @Autowired
    RegisterLeaveService registerLeaveService;

    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    //test insert success
    @Test
    public void testInsertRegisterLeaveSuccess() {
        try {
            int size = registerLeaveService.getListRegisterLeaveEmployeeId(1).size();
            RegisterLeaveEntity registerLeaveEntity = new RegisterLeaveEntity();
            registerLeaveEntity.setEmployeeId(1);
            registerLeaveEntity.setStartDate(dateFormat.parse("20-11-2021"));
            registerLeaveEntity.setEndDate(dateFormat.parse("20-11-2021"));
            registerLeaveEntity.setCreateDate(dateFormat.parse("12-08-2021"));
            registerLeaveEntity.setReasonLeave("nghi om");
            registerLeaveEntity.setRegisterLeaveStatus(RegisterLeaveStatus.WAITING);
            registerLeaveService.insertRegisterLeave(registerLeaveEntity);

            int size1 = registerLeaveService.getListRegisterLeaveEmployeeId(1).size();
            Assert.assertEquals(size1, size + 1);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    // test insert failed
    // employeeId null
    @Test
    public void testInsertRegisterLeaveEmployeeIdNull() {
        try {
            int size = registerLeaveService.getListRegisterLeaveEmployeeId(1).size();
            RegisterLeaveEntity registerLeaveEntity = new RegisterLeaveEntity();
//           registerLeaveEntity.setEmployeeId(1);
            registerLeaveEntity.setStartDate(dateFormat.parse("20-11-2021"));
            registerLeaveEntity.setEndDate(dateFormat.parse("20-11-2021"));
            registerLeaveEntity.setCreateDate(dateFormat.parse("12-08-2021"));
            registerLeaveEntity.setReasonLeave("nghi om");
            registerLeaveEntity.setRegisterLeaveStatus(RegisterLeaveStatus.WAITING);
            registerLeaveService.insertRegisterLeave(registerLeaveEntity);

            int size1 = registerLeaveService.getListRegisterLeaveEmployeeId(1).size();
            Assert.assertEquals(size1, size);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    // test insert failed
    // start date null
    @Test
    public void testInsertRegisterLeaveStartDateNull() {
        try {
            int size = registerLeaveService.getListRegisterLeaveEmployeeId(1).size();
            RegisterLeaveEntity registerLeaveEntity = new RegisterLeaveEntity();
            registerLeaveEntity.setEmployeeId(1);
//            registerLeaveEntity.setStartDate(dateFormat.parse("20-11-2021"));
            registerLeaveEntity.setEndDate(dateFormat.parse("20-11-2021"));
            registerLeaveEntity.setCreateDate(dateFormat.parse("12-08-2021"));
            registerLeaveEntity.setReasonLeave("nghi om");
            registerLeaveEntity.setRegisterLeaveStatus(RegisterLeaveStatus.WAITING);
            registerLeaveService.insertRegisterLeave(registerLeaveEntity);

            int size1 = registerLeaveService.getListRegisterLeaveEmployeeId(1).size();
            Assert.assertEquals(size1, size);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    // test insert failed
    // end date  null
    @Test
    public void testInsertRegisterLeaveEndDateNull() {
        try {
            int size = registerLeaveService.getListRegisterLeaveEmployeeId(1).size();
            RegisterLeaveEntity registerLeaveEntity = new RegisterLeaveEntity();
            registerLeaveEntity.setEmployeeId(1);
            registerLeaveEntity.setStartDate(dateFormat.parse("20-11-2021"));
//            registerLeaveEntity.setEndDate(dateFormat.parse("20-11-2021"));
            registerLeaveEntity.setCreateDate(dateFormat.parse("12-08-2021"));
            registerLeaveEntity.setReasonLeave("nghi om");
            registerLeaveEntity.setRegisterLeaveStatus(RegisterLeaveStatus.WAITING);
            registerLeaveService.insertRegisterLeave(registerLeaveEntity);

            int size1 = registerLeaveService.getListRegisterLeaveEmployeeId(1).size();
            Assert.assertEquals(size1, size);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    // test insert failed
    // reason  null
    @Test
    public void testInsertRegisterLeaveReasonNull() throws Exception {
        try {
            int size = registerLeaveService.getListRegisterLeaveEmployeeId(1).size();
            RegisterLeaveEntity registerLeaveEntity = new RegisterLeaveEntity();
            registerLeaveEntity.setEmployeeId(1);
            registerLeaveEntity.setStartDate(dateFormat.parse("20-11-2021"));
            registerLeaveEntity.setEndDate(dateFormat.parse("20-11-2021"));
            registerLeaveEntity.setCreateDate(dateFormat.parse("12-08-2021"));
//            registerLeaveEntity.setReasonLeave("nghi om");
            registerLeaveEntity.setRegisterLeaveStatus(RegisterLeaveStatus.WAITING);
            registerLeaveService.insertRegisterLeave(registerLeaveEntity);

            int size1 = registerLeaveService.getListRegisterLeaveEmployeeId(1).size();
            Assert.assertEquals(size1, size);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    // test insert failed
    // status null
    @Test
    public void testInsertRegisterLeaveStatusNull() throws Exception {
        try {
            int size = registerLeaveService.getListRegisterLeaveEmployeeId(1).size();
            RegisterLeaveEntity registerLeaveEntity = new RegisterLeaveEntity();
            registerLeaveEntity.setEmployeeId(1);
            registerLeaveEntity.setStartDate(dateFormat.parse("20-11-2021"));
            registerLeaveEntity.setEndDate(dateFormat.parse("20-11-2021"));
            registerLeaveEntity.setCreateDate(dateFormat.parse("12-08-2021"));
            registerLeaveEntity.setReasonLeave("nghi om");
//            registerLeaveEntity.setRegisterLeaveStatus(RegisterLeaveStatus.WAITING);
            registerLeaveService.insertRegisterLeave(registerLeaveEntity);

            int size1 = registerLeaveService.getListRegisterLeaveEmployeeId(1).size();
            Assert.assertEquals(size1, size);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    // test insert failed
    // end_date < start_date
    @Test
    public void testInsertRegisterLeaveEndDateLessStartDate() throws Exception {
        try {
            int size = registerLeaveService.getListRegisterLeaveEmployeeId(1).size();
            RegisterLeaveEntity registerLeaveEntity = new RegisterLeaveEntity();
            registerLeaveEntity.setEmployeeId(1);
            registerLeaveEntity.setStartDate(dateFormat.parse("20-11-2021"));
            registerLeaveEntity.setEndDate(dateFormat.parse("19-11-2021"));
            registerLeaveEntity.setCreateDate(dateFormat.parse("12-08-2021"));
            registerLeaveEntity.setReasonLeave("nghi om");
            registerLeaveEntity.setRegisterLeaveStatus(RegisterLeaveStatus.WAITING);
            RegisterLeaveEntity registerLeaveEntity1 = registerLeaveService.insertRegisterLeave(registerLeaveEntity);

            int size1 = registerLeaveService.getListRegisterLeaveEmployeeId(1).size();
            Assert.assertEquals(size1, size);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    // test insert failed
    // employee was off job
    @Test
    public void testInsertRegisterLeaveEmployeeOffJob() throws Exception {
        try {
            int size = registerLeaveService.getListRegisterLeaveEmployeeId(2).size();
            RegisterLeaveEntity registerLeaveEntity = new RegisterLeaveEntity();
            registerLeaveEntity.setEmployeeId(1);
            registerLeaveEntity.setStartDate(dateFormat.parse("20-11-2021"));
            registerLeaveEntity.setEndDate(dateFormat.parse("20-11-2021"));
            registerLeaveEntity.setCreateDate(dateFormat.parse("12-08-2021"));
            registerLeaveEntity.setReasonLeave("nghi om");
            registerLeaveEntity.setRegisterLeaveStatus(RegisterLeaveStatus.WAITING);
            registerLeaveService.insertRegisterLeave(registerLeaveEntity);

            int size1 = registerLeaveService.getListRegisterLeaveEmployeeId(2).size();
            Assert.assertEquals(size1, size);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


}
