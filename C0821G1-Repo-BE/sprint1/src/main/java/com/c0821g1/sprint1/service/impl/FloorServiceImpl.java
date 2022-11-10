package com.c0821g1.sprint1.service.impl;

import com.c0821g1.sprint1.dto.FloorsDTO;
import com.c0821g1.sprint1.entity.floor.Floors;
import com.c0821g1.sprint1.repository.FloorsRepository;
import com.c0821g1.sprint1.service.FloorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FloorServiceImpl implements FloorsService {
    @Autowired
    FloorsRepository floorsRepository;

    @Override
    public List<Floors> findAllFloors() {

        return this.floorsRepository.findAllFloors();
    }

    @Override
    public Optional<Floors> findFloorsById(Integer id) {
        return this.floorsRepository.findById(id);
    }

    @Override
    public void deleteFloorsById(Integer id) {
        this.floorsRepository.deleteById(id);
    }

    @Override
    public void editFloors(Floors floors) {
        this.floorsRepository.save(floors);
    }

    @Override
    public Floors findById(Integer id) {
        return this.floorsRepository.findById(id).orElse(null);
    }

    @Override
    public String findAllFloorsArea() {
        return floorsRepository.findAllFloorsArea();
    }
}
