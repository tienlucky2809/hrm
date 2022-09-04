package com.project.hrm.repository;

import com.project.hrm.entities.RelationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelationRepository extends JpaRepository<RelationEntity, Integer> {
    RelationEntity findById(int id);

    List<RelationEntity> findAllById(int id);

    List<RelationEntity> findAllByFirstName(String firstName);

    List<RelationEntity> findAllByFirstNameContains(String firstName);

    List<RelationEntity> findAllByLastName(String lastName);

    List<RelationEntity> findAllByLastNameContains(String lastName);

    List<RelationEntity> findAllByFirstNameContainsAndLastNameContains(String firstName, String lastName);

    List<RelationEntity> findAllByIdentityNumberContains(String identityNumber);


}
