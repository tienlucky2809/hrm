package com.project.hrm;

import com.project.hrm.entities.EmployeeEntity;
import com.project.hrm.service.EmployeeService;
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
import java.util.ArrayList;
import java.util.List;

@Transactional
@Rollback
@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeTest {
    @Autowired
    EmployeeService employeeService;

    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    // test insert success
    @Test
    public void testInsertEmployeeSuccess() throws Exception {
        int size = employeeService.getListEmployee().size();
        System.out.println(size);
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setFirstName("tiena");
        employeeEntity.setLastName("luckya");
        employeeEntity.setEmail("tienlucky2809@gmail.com");
        employeeEntity.setSex("1");
        employeeEntity.setBirthday(dateFormat.parse("28-09-1996"));
        employeeEntity.setStartDate(dateFormat.parse("11-11-2020"));
        employeeEntity.setJobStatus(1);
        employeeEntity.setAddress1("ha noi");
        employeeEntity.setIdentityNumber("111");
        EmployeeEntity employeeEntity1 = employeeService.insertEmployee(employeeEntity);
        int size1 = employeeService.getListEmployee().size();
        Assert.assertEquals(size1, size + 1);
    }

    // test insert indentity number da ton tai, job-status = 1
    // id_no "002" da ton tai va job_status = 1
    // insert failed
    @Test
    public void testInsertEmployeeWithIDNOExistAndJS1() {
        try {
            int size = employeeService.getListEmployee().size();
            System.out.println(size);
            EmployeeEntity employeeEntity = new EmployeeEntity();
            employeeEntity.setFirstName("tiena");
            employeeEntity.setLastName("luckya");
            employeeEntity.setEmail("tienlucky2809@gmail.com");
            employeeEntity.setSex("1");
            employeeEntity.setBirthday(dateFormat.parse("28-09-1996"));
            employeeEntity.setStartDate(dateFormat.parse("11-11-2020"));
            employeeEntity.setJobStatus(1);
            employeeEntity.setAddress1("ha noi");
            employeeEntity.setIdentityNumber("001");
            //identity num da ton tai trong csdl
            EmployeeEntity employeeEntity1 = employeeService.insertEmployee(employeeEntity);
            int size1 = employeeService.getListEmployee().size();
            Assert.assertEquals(size1, size);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    // test insert indentity number da ton tai, job-status = 0
    // id_no "009" da ton tai va job_status = 0
    // insert success
    @Test
    public void testInsertEmployeeIDNOExistAndJS0() {
        try {
            int size = employeeService.getListEmployee().size();
            System.out.println(size);
            EmployeeEntity employeeEntity = new EmployeeEntity();
            employeeEntity.setFirstName("tiena");
            employeeEntity.setLastName("luckya");
            employeeEntity.setEmail("tienlucky2809@gmail.com");
            employeeEntity.setSex("1");
            employeeEntity.setBirthday(dateFormat.parse("28-09-1996"));
            employeeEntity.setStartDate(dateFormat.parse("11-11-2020"));
            employeeEntity.setJobStatus(1);
            employeeEntity.setAddress1("ha noi");
            employeeEntity.setIdentityNumber("009");
            //identity num da ton tai trong csdl
            EmployeeEntity employeeEntity1 = employeeService.insertEmployee(employeeEntity);
            int size1 = employeeService.getListEmployee().size();
            Assert.assertEquals(size1, size + 1);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    // test Insert failed 1
    //sai dinh dang ten
    // failed
    @Test
    public void testInsertEmployeeFistNameFalse() {
        try {
            int size = employeeService.getListEmployee().size();
            System.out.println(size);
            EmployeeEntity employeeEntity = new EmployeeEntity();
            employeeEntity.setFirstName("tien1");
            //sai dinh dang ten
            employeeEntity.setLastName("luckya");
            employeeEntity.setEmail("tienlucky2809@gmail.com");
            employeeEntity.setSex("1");
            employeeEntity.setBirthday(dateFormat.parse("28-09-1996"));
            employeeEntity.setStartDate(dateFormat.parse("11-11-2020"));
            employeeEntity.setJobStatus(1);
            employeeEntity.setAddress1("ha noi");
            employeeEntity.setIdentityNumber("111");
            EmployeeEntity employeeEntity1 = employeeService.insertEmployee(employeeEntity);
            int size1 = employeeService.getListEmployee().size();
            Assert.assertEquals(size1, size);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    // test Insert failed 2
    // sai dinh dang email
    //failed
    @Test
    public void testInsertEmployeeEmailFalse() {
        try {
            int size = employeeService.getListEmployee().size();
            System.out.println(size);
            EmployeeEntity employeeEntity = new EmployeeEntity();
            employeeEntity.setFirstName("tien");
            employeeEntity.setLastName("luckya");
            employeeEntity.setEmail("tienlucky2809gmail.com");
            // sai dinh dang email
            employeeEntity.setSex("1");
            employeeEntity.setBirthday(dateFormat.parse("28-09-1996"));
            employeeEntity.setStartDate(dateFormat.parse("11-11-2020"));
            employeeEntity.setJobStatus(1);
            employeeEntity.setAddress1("ha noi");
            employeeEntity.setIdentityNumber("111");
            EmployeeEntity employeeEntity1 = employeeService.insertEmployee(employeeEntity);
            int size1 = employeeService.getListEmployee().size();
            Assert.assertEquals(size1, size);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    // test Insert failed 3
    //sai dinh dang date time
    //failed
    @Test
    public void testInsertEmployeeBirthdayFalse() {
        try {
            int size = employeeService.getListEmployee().size();
            System.out.println(size);
            EmployeeEntity employeeEntity = new EmployeeEntity();
            employeeEntity.setFirstName("tien");
            employeeEntity.setLastName("luckya");
            employeeEntity.setEmail("tienlucky2809gmail.com");
            employeeEntity.setSex("1");
            //sai dinh dang date time
            employeeEntity.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1996-28-09"));
            employeeEntity.setStartDate(dateFormat.parse("11-11-2020"));
            employeeEntity.setJobStatus(1);
            employeeEntity.setAddress1("ha noi");
            employeeEntity.setIdentityNumber("111");
            employeeService.insertEmployee(employeeEntity);
            int size1 = employeeService.getListEmployee().size();
            Assert.assertEquals(size1, size);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    // test Insert failed 4
    // khong khai bao firstName
    @Test
    public void testInsertEmployeeFirstNameNotExist() {
        try {
            int size = employeeService.getListEmployee().size();
            System.out.println(size);
            EmployeeEntity employeeEntity = new EmployeeEntity();
//        employeeEntity.setFirstName("tien");
            employeeEntity.setLastName("luckya");
            employeeEntity.setEmail("tienlucky2809gmail.com");
            employeeEntity.setSex("1");
            employeeEntity.setBirthday(dateFormat.parse("28-09-1996"));
            employeeEntity.setStartDate(dateFormat.parse("11-11-2020"));
            employeeEntity.setJobStatus(1);
            employeeEntity.setAddress1("ha noi");
            employeeEntity.setIdentityNumber("111");
            employeeService.insertEmployee(employeeEntity);
            int size1 = employeeService.getListEmployee().size();
            Assert.assertEquals(size1, size);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    // insert list employee
    // 1 true 1 false
    @Test
    public void testInsertListEmployee1True1False() {
        try {
            int size = employeeService.getListEmployee().size();
            List<EmployeeEntity> listEmployeeEntity = new ArrayList<EmployeeEntity>();
            EmployeeEntity employeeEntity = new EmployeeEntity();
            employeeEntity.setFirstName("tiena");
            employeeEntity.setLastName("luckya");
            employeeEntity.setEmail("tienlucky2809@gmail.com");
            employeeEntity.setSex("1");
            employeeEntity.setBirthday(dateFormat.parse("28-09-1996"));
            employeeEntity.setStartDate(dateFormat.parse("11-11-2020"));
            employeeEntity.setJobStatus(1);
            employeeEntity.setAddress1("ha noi");
            employeeEntity.setIdentityNumber("111");
            listEmployeeEntity.add(employeeEntity);

            EmployeeEntity employeeEntity2 = new EmployeeEntity();
            employeeEntity2.setFirstName("tien1");
            //sai dinh dang ten
            employeeEntity2.setLastName("luckya");
            employeeEntity2.setEmail("tienlucky2809@gmail.com");
            employeeEntity2.setSex("1");
            employeeEntity2.setBirthday(dateFormat.parse("28-09-1996"));
            employeeEntity2.setStartDate(dateFormat.parse("11-11-2020"));
            employeeEntity2.setJobStatus(1);
            employeeEntity2.setAddress1("ha noi");
            employeeEntity2.setIdentityNumber("111");
            listEmployeeEntity.add(employeeEntity2);
            employeeService.insertListEmployee(listEmployeeEntity);
            int size1 = employeeService.getListEmployee().size();
            Assert.assertEquals(size1, size + 1);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}
