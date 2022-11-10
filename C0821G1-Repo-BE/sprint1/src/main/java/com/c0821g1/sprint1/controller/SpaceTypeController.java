package com.c0821g1.sprint1.controller;

import com.c0821g1.sprint1.entity.space.SpacesType;
import com.c0821g1.sprint1.service.SpaceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/spaceType")
public class SpaceTypeController {
    @Autowired
    private SpaceTypeService spaceTypeService;

    @GetMapping ("/list")
    public ResponseEntity<List<SpacesType>> getAllSpacesType(){
        List<SpacesType> spacesTypeList = spaceTypeService.getAllSpacesType();
        return new ResponseEntity<>(spacesTypeList, HttpStatus.OK);
    }
}
