package com.project.hrm.service.impl;

import com.project.hrm.entities.RelationEntity;
import com.project.hrm.exception.ResponseMessage;
import com.project.hrm.repository.RelationRepository;
import com.project.hrm.service.RelationService;
import com.project.hrm.validator.RelationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationServiceImpl implements RelationService {

    @Autowired
    private RelationRepository relationRepository;

    @Autowired
    private RelationValidator relationValidator;

    @Override
    public ResponseMessage insertRelation(RelationEntity relationEntity) {
        if (!relationValidator.isValid(relationEntity)) {
            return new ResponseMessage("fail", "wrong information, please check it");
        } else if (!relationValidator.isEmployeeExist(relationEntity)) {
            return new ResponseMessage("fail",
                    "this relation is not related to any employee, " +
                            "please check employee information");
        } else{
            relationRepository.save(relationEntity);
            return new ResponseMessage("success", "your relation has been added");
        }

    }

    @Override
    public List<RelationEntity> getListRelation() {
        return relationRepository.findAll();
    }

    @Override
    public List<RelationEntity> getListRelationById(int id) {
        return relationRepository.findAllById(id);
    }

    @Override
    public List<RelationEntity> getListRelationByFirstName(String firstName) {
        return relationRepository.findAllByFirstName(firstName);
    }


}
