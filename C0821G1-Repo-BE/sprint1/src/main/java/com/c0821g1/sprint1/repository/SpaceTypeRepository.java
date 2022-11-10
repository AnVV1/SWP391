package com.c0821g1.sprint1.repository;

import com.c0821g1.sprint1.entity.space.SpacesType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SpaceTypeRepository extends JpaRepository<SpacesType,Integer> {

    @Modifying
    @Transactional
    @Query(value = "select * from spaces_type", nativeQuery = true)
    List<SpacesType> getAllSpacesType();
}