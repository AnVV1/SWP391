package com.c0821g1.sprint1.controller;

import com.c0821g1.sprint1.dto.FloorsDTO;
import com.c0821g1.sprint1.entity.floor.Floors;
import com.c0821g1.sprint1.service.impl.FloorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "/api/floors")
public class FloorsRestController {
    @Autowired
    FloorServiceImpl floorService;

    @GetMapping("/list")
    public ResponseEntity<List<Floors>> findAllFloors() {
        List<Floors> floors = floorService.findAllFloors();
        if (floors.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(floors, HttpStatus.OK);
    }

    @GetMapping("/area")
    public ResponseEntity<String> findAllFloorsArea() {
        String floorsDTO = floorService.findAllFloorsArea();
        if (floorsDTO==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(floorsDTO, HttpStatus.OK);
    }


    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Floors> findFloorsById(@PathVariable Integer id) {
        Floors floors = floorService.findById(id);
        if (floors==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(floors, HttpStatus.OK);
    }


    @DeleteMapping(value = "/delete-flag/{id}")
    public ResponseEntity<Floors> deleteFlagFloorsById(@PathVariable Integer id) {
        Floors floors = this.floorService.findById(id);
        if (floors==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        floors.setFloorDeleteFlag(true);
        this.floorService.editFloors(floors);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
