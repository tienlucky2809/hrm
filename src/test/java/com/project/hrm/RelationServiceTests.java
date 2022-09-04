package com.project.hrm;

import com.project.hrm.entities.RelationEntity;
import com.project.hrm.exception.ResponseMessage;
import com.project.hrm.service.RelationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@SpringBootTest
@ActiveProfiles("dev")
@Transactional
public class RelationServiceTests {
    @Autowired
    private RelationService relationService;

    @Test
    void insertRelationEntity_WhiteSpaces_firstName() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        RelationEntity newRelationEntity = new RelationEntity();
        newRelationEntity.setFirstName("   ");
        newRelationEntity.setLastName("Marco");
        newRelationEntity.setSex('M');
        newRelationEntity.setBirthDay(dateFormat.parse("31-05-1989"));
        newRelationEntity.setRelationship("Midfielder");
        newRelationEntity.setEmployeeId(1);
        newRelationEntity.setTypeId(1);
        newRelationEntity.setRegisteredDate(dateFormat.parse("31-05-1989"));
        newRelationEntity.setIdentityNumber("123456789");
        newRelationEntity.setInsuranceNumber("987654321");
        ResponseMessage responseMessage = relationService.insertRelation(newRelationEntity);
        Assertions.assertEquals("fail", responseMessage.getStatus());
        Assertions.assertEquals("wrong information, please check it",
                responseMessage.getMessage());
    }

    @Test
    void insertRelationEntity_Without_firstName() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        RelationEntity newRelationEntity = new RelationEntity();
//        newRelationEntity.setFirstName("Reus");
        newRelationEntity.setLastName("Marco");
        newRelationEntity.setSex('M');
        newRelationEntity.setBirthDay(dateFormat.parse("31-05-1989"));
        newRelationEntity.setRelationship("Midfielder");
        newRelationEntity.setEmployeeId(1);
        newRelationEntity.setTypeId(1);
        newRelationEntity.setRegisteredDate(dateFormat.parse("31-05-1989"));
        newRelationEntity.setIdentityNumber("123456789");
        newRelationEntity.setInsuranceNumber("987654321");
        ResponseMessage responseMessage = relationService.insertRelation(newRelationEntity);
        Assertions.assertEquals("fail", responseMessage.getStatus());
        Assertions.assertEquals("wrong information, please check it",
                responseMessage.getMessage());
    }

    @Test
    void insertRelationEntity_WhiteSpaces_lastName() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        RelationEntity newRelationEntity = new RelationEntity();
        newRelationEntity.setFirstName("Reus");
        newRelationEntity.setLastName("   ");
        newRelationEntity.setSex('M');
        newRelationEntity.setBirthDay(dateFormat.parse("31-05-1989"));
        newRelationEntity.setRelationship("Midfielder");
        newRelationEntity.setEmployeeId(1);
        newRelationEntity.setTypeId(1);
        newRelationEntity.setRegisteredDate(dateFormat.parse("31-05-1989"));
        newRelationEntity.setIdentityNumber("123456789");
        newRelationEntity.setInsuranceNumber("987654321");
        ResponseMessage responseMessage = relationService.insertRelation(newRelationEntity);
        Assertions.assertEquals("fail", responseMessage.getStatus());
        Assertions.assertEquals("wrong information, please check it",
                responseMessage.getMessage());
    }

    @Test
    void insertRelationEntity_Without_lastName() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        RelationEntity newRelationEntity = new RelationEntity();
        newRelationEntity.setFirstName("Reus");
//        newRelationEntity.setLastName("Marco");
        newRelationEntity.setSex('M');
        newRelationEntity.setBirthDay(dateFormat.parse("31-05-1989"));
        newRelationEntity.setRelationship("Midfielder");
        newRelationEntity.setEmployeeId(1);
        newRelationEntity.setTypeId(1);
        newRelationEntity.setRegisteredDate(dateFormat.parse("31-05-1989"));
        newRelationEntity.setIdentityNumber("123456789");
        newRelationEntity.setInsuranceNumber("987654321");
        ResponseMessage responseMessage = relationService.insertRelation(newRelationEntity);
        Assertions.assertEquals("fail", responseMessage.getStatus());
        Assertions.assertEquals("wrong information, please check it",
                responseMessage.getMessage());
    }

    @Test
    void insertRelationEntity_WrongFormat_sex() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        RelationEntity newRelationEntity = new RelationEntity();
        newRelationEntity.setFirstName("Reus");
        newRelationEntity.setLastName("Marco");
        newRelationEntity.setSex('N');
        newRelationEntity.setBirthDay(dateFormat.parse("31-05-1989"));
        newRelationEntity.setRelationship("Midfielder");
        newRelationEntity.setEmployeeId(1);
        newRelationEntity.setTypeId(1);
        newRelationEntity.setRegisteredDate(dateFormat.parse("31-05-1989"));
        newRelationEntity.setIdentityNumber("123456789");
        newRelationEntity.setInsuranceNumber("987654321");
        ResponseMessage responseMessage = relationService.insertRelation(newRelationEntity);
        Assertions.assertEquals("fail", responseMessage.getStatus());
        Assertions.assertEquals("wrong information, please check it",
                responseMessage.getMessage());
    }

    @Test
    void insertRelationEntity_Without_sex() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        RelationEntity newRelationEntity = new RelationEntity();
        newRelationEntity.setFirstName("Reus");
        newRelationEntity.setLastName("Marco");
//        newRelationEntity.setSex('M');
        newRelationEntity.setBirthDay(dateFormat.parse("31-05-1989"));
        newRelationEntity.setRelationship("Midfielder");
        newRelationEntity.setEmployeeId(1);
        newRelationEntity.setTypeId(1);
        newRelationEntity.setRegisteredDate(dateFormat.parse("31-05-1989"));
        newRelationEntity.setIdentityNumber("123456789");
        newRelationEntity.setInsuranceNumber("987654321");
        ResponseMessage responseMessage = relationService.insertRelation(newRelationEntity);
        Assertions.assertEquals('\0', newRelationEntity.getSex());
        Assertions.assertEquals("fail", responseMessage.getStatus());
        Assertions.assertEquals("wrong information, please check it",
                responseMessage.getMessage());
    }

    @Test
    void insertRelationEntity_Without_employeeId() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        RelationEntity newRelationEntity = new RelationEntity();
        newRelationEntity.setFirstName("Reus");
        newRelationEntity.setLastName("Marco");
        newRelationEntity.setSex('M');
        newRelationEntity.setBirthDay(dateFormat.parse("31-05-1989"));
        newRelationEntity.setRelationship("Midfielder");
//        newRelationEntity.setEmployeeId(1);
        newRelationEntity.setTypeId(1);
        newRelationEntity.setRegisteredDate(dateFormat.parse("31-05-1989"));
        newRelationEntity.setIdentityNumber("123456789");
        newRelationEntity.setInsuranceNumber("987654321");
        ResponseMessage responseMessage = relationService.insertRelation(newRelationEntity);
        Assertions.assertEquals(0, newRelationEntity.getEmployeeId());
        Assertions.assertEquals("fail", responseMessage.getStatus());
        Assertions.assertEquals("wrong information, please check it",
                responseMessage.getMessage());
    }

    @Test
    void insertRelationEntity_Without_registeredDate() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        RelationEntity newRelationEntity = new RelationEntity();
        newRelationEntity.setFirstName("Reus");
        newRelationEntity.setLastName("Marco");
        newRelationEntity.setSex('M');
        newRelationEntity.setBirthDay(dateFormat.parse("31-05-1989"));
        newRelationEntity.setRelationship("Midfielder");
        newRelationEntity.setEmployeeId(1);
        newRelationEntity.setTypeId(1);
//        newRelationEntity.setRegisteredDate(dateFormat.parse("31-05-1989"));
        newRelationEntity.setIdentityNumber("123456789");
        newRelationEntity.setInsuranceNumber("987654321");
        ResponseMessage responseMessage = relationService.insertRelation(newRelationEntity);
        Assertions.assertNull(newRelationEntity.getRegisteredDate());
        Assertions.assertEquals("fail", responseMessage.getStatus());
        Assertions.assertEquals("wrong information, please check it",
                responseMessage.getMessage());
    }

    @Test
    void insertRelationEntity_notExists_employeeId() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        RelationEntity newRelationEntity = new RelationEntity();
        newRelationEntity.setFirstName("Reus");
        newRelationEntity.setLastName("Marco");
        newRelationEntity.setSex('M');
        newRelationEntity.setBirthDay(dateFormat.parse("31-05-1989"));
        newRelationEntity.setRelationship("Midfielder");
        newRelationEntity.setEmployeeId(100);
        newRelationEntity.setTypeId(1);
        newRelationEntity.setRegisteredDate(dateFormat.parse("31-05-1989"));
        newRelationEntity.setIdentityNumber("123456789");
        newRelationEntity.setInsuranceNumber("987654321");
        ResponseMessage responseMessage = relationService.insertRelation(newRelationEntity);
        Assertions.assertEquals("fail", responseMessage.getStatus());
        Assertions.assertEquals("this relation is not related to any employee, " +
                "please check employee information", responseMessage.getMessage());
    }

    @Test
    @Rollback
    void insertRelationEntity_valid() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        RelationEntity newRelationEntity = new RelationEntity();
        newRelationEntity.setId(7);
        newRelationEntity.setFirstName("Luis");
        newRelationEntity.setLastName("Suarez");
        newRelationEntity.setSex('M');
        newRelationEntity.setBirthDay(dateFormat.parse("24-01-1987"));
        newRelationEntity.setRelationship("Striker");
        newRelationEntity.setEmployeeId(1);
        newRelationEntity.setTypeId(1);
        newRelationEntity.setRegisteredDate(dateFormat.parse("16-10-2004"));
        newRelationEntity.setIdentityNumber("Barca-to-ATM");
        newRelationEntity.setInsuranceNumber("Uruguay");
        ResponseMessage responseMessage = relationService.insertRelation(newRelationEntity);
        Assertions.assertEquals("success", responseMessage.getStatus());
        Assertions.assertEquals("your relation has been added", responseMessage.getMessage());
    }
}
