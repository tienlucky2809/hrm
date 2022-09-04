package com.project.hrm.service;

import com.project.hrm.entities.RelationEntity;
import com.project.hrm.exception.ResponseMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RelationService {
    ResponseMessage insertRelation(RelationEntity relationEntity);
    List<RelationEntity> getListRelation();
    List<RelationEntity> getListRelationById(int id);
    List<RelationEntity> getListRelationByFirstName(String firstName);
}
