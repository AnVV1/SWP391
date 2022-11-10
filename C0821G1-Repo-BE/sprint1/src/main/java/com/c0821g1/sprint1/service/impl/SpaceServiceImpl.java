package com.c0821g1.sprint1.service.impl;
import com.c0821g1.sprint1.entity.customer.Customer;
import com.c0821g1.sprint1.service.SpaceService;
import org.springframework.stereotype.Service;
import com.c0821g1.sprint1.dto.SpaceListDTO;
import com.c0821g1.sprint1.entity.space.Spaces;
import com.c0821g1.sprint1.repository.SpaceRepository;
import com.c0821g1.sprint1.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SpaceServiceImpl implements SpaceService {
    @Autowired
    private SpaceRepository spaceRepository;


    @Override
    public List<SpaceListDTO> findAllSpace() {
        return this.spaceRepository.findAllSpace();
    }

    @Override
    public void deleteById(Integer id) {
        spaceRepository.deleteSpaceById(id);
    }

    @Override
    public List<SpaceListDTO> searchSpace(String floorName, String spaceCode, String spaceArea, String spaceTypeName, String spaceStatusName) {
        return spaceRepository.searchSpace(floorName, spaceCode, spaceArea, spaceTypeName, spaceStatusName);
    }

    @Override
    public SpaceListDTO findSpaceById(Integer spaceId) {
        return spaceRepository.findSpaceById(spaceId);
    }


    @Override
    public void saveNewSpace(Spaces spaces) {
        spaceRepository.saveSpace(spaces.getFloors().getFloorId(), spaces.getSpaceArea(),
                spaces.getSpaceCode(), spaces.getSpaceDeleteFlag(), spaces.getSpaceImage(),
                spaces.getSpaceManagerFee(), spaces.getSpaceNote(), spaces.getSpacePrice(),
                spaces.getSpaceStatus().getSpaceStatusId(), spaces.getSpacesType().getSpaceTypeId());
    }


    @Override
    public Spaces findById(Integer id) {
        return spaceRepository.findById(id).orElse(null);
    }


    @Override
    public void save(Spaces spaces) {
        spaceRepository.save(spaces);
    }


    @Override
    public void editSpace(Spaces spaces) {
        spaceRepository.editSpace(spaces.getFloors().getFloorId(), spaces.getSpaceArea(),
                spaces.getSpaceCode(), spaces.getSpaceDeleteFlag(), spaces.getSpaceImage(),
                spaces.getSpaceManagerFee(), spaces.getSpaceNote(), spaces.getSpacePrice(),
                spaces.getSpaceStatus().getSpaceStatusId(), spaces.getSpacesType().getSpaceTypeId(), spaces.getSpaceId());
    }

    @Override
    public boolean existsSpaceByCode(String spaceCode) {
        return spaceRepository.existsSpaceByCode(spaceCode) != null;
    }


    @Override
    public List<Spaces> getAll1() {
        return this.spaceRepository.findAll();
    }
}