package com.c0821g1.sprint1.repository;

import com.c0821g1.sprint1.entity.space.SpacesStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SpaceStatusRepository extends JpaRepository<SpacesStatus,Integer> {
    @Modifying
    @Transactional
    @Query(value = "select * from spaces_status", nativeQuery = true)
    List<SpacesStatus> getAllSpacesStatus();
}