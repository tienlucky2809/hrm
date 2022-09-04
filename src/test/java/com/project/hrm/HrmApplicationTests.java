package com.project.hrm;

import com.project.hrm.entities.RelationEntity;
import com.project.hrm.exception.ResponseMessage;
import com.project.hrm.models.Relation;
import com.project.hrm.service.RelationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@SpringBootTest
@ActiveProfiles("dev")
class HrmApplicationTests {

    @Test
    void contextLoads() {
    }

}
