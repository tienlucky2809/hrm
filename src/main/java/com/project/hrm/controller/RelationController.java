package com.project.hrm.controller;

import com.project.hrm.entities.RelationEntity;
import com.project.hrm.exception.ResponseMessage;
import com.project.hrm.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
public class RelationController {

    @Autowired
    private RelationService relationService;

    @RequestMapping(value = "/api/add-relation", method = RequestMethod.POST)
    public ResponseEntity<ResponseMessage> add(@Valid @RequestBody RelationEntity relationEntity) {
        return new ResponseEntity<>(relationService.insertRelation(relationEntity), HttpStatus.OK);
    }

    @RequestMapping(value = "/api/get-relations", method = RequestMethod.GET)
    public ResponseEntity<List<RelationEntity>> findAll() {
        return new ResponseEntity<>(relationService.getListRelation(), HttpStatus.OK);
    }

    @RequestMapping(value = "/api/get-relations-by-id", method = RequestMethod.GET)
    public ResponseEntity<List<RelationEntity>> findAllById(@RequestParam(value = "id", required = false) int id) {
        return new ResponseEntity<>(relationService.getListRelationById(id), HttpStatus.OK);
    }
}