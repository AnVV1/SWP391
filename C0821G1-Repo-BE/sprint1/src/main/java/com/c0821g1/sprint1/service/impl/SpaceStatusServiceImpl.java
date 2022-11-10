package com.c0821g1.sprint1.service.impl;

import com.c0821g1.sprint1.entity.space.SpacesStatus;
import com.c0821g1.sprint1.repository.SpaceStatusRepository;
import com.c0821g1.sprint1.service.SpaceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpaceStatusServiceImpl implements SpaceStatusService {
    @Autowired
    private SpaceStatusRepository spaceStatusRepository;


    @Override
    public List<SpacesStatus> getAllSpacesStatus() {
        return spaceStatusRepository.getAllSpacesStatus();
    }
}