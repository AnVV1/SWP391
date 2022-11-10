package com.c0821g1.sprint1.service.impl;
import org.springframework.stereotype.Service;
import com.c0821g1.sprint1.entity.space.SpacesType;
import com.c0821g1.sprint1.repository.SpaceTypeRepository;
import com.c0821g1.sprint1.service.SpaceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpaceTypeServiceImpl implements SpaceTypeService {

    @Autowired
    private SpaceTypeRepository spaceTypeRepository;

    @Override
    public List<SpacesType> getAllSpacesType() {
        return spaceTypeRepository.getAllSpacesType();
    }
}