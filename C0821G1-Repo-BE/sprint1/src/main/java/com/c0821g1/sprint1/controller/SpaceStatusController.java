package com.c0821g1.sprint1.controller;

import com.c0821g1.sprint1.entity.space.SpacesStatus;
import com.c0821g1.sprint1.service.SpaceStatusService;
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
@RequestMapping(value = "/api/spaceStatus")
public class SpaceStatusController {
    @Autowired
    private SpaceStatusService spaceStatusService;

    @GetMapping("/list")
    public ResponseEntity<List<SpacesStatus>> getAllSpacesType(){
        List<SpacesStatus> spacesStatusList = spaceStatusService.getAllSpacesStatus();
        return new ResponseEntity<>(spacesStatusList, HttpStatus.OK);
    }
}
