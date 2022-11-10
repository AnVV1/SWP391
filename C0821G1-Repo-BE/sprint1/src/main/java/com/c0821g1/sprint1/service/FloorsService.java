package com.c0821g1.sprint1.service;


import com.c0821g1.sprint1.dto.FloorsDTO;
import com.c0821g1.sprint1.entity.floor.Floors;

import java.util.List;
import java.util.Optional;

public interface FloorsService {
    List<Floors> findAllFloors();

    Optional<Floors> findFloorsById(Integer id);

    void deleteFloorsById(Integer id);


    void editFloors(Floors floors);

    Floors findById(Integer id);

    String findAllFloorsArea();
}
