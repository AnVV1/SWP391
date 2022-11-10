package com.c0821g1.sprint1.controller;

import com.c0821g1.sprint1.dto.CustomerDTO;
import com.c0821g1.sprint1.dto.SpaceListDTO;
import com.c0821g1.sprint1.dto.SpacesDTO;
import com.c0821g1.sprint1.entity.customer.Customer;
import com.c0821g1.sprint1.entity.space.Spaces;
import com.c0821g1.sprint1.service.SpaceService;
import com.c0821g1.sprint1.service.SpaceStatusService;
import com.c0821g1.sprint1.service.SpaceTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping (value = "api/spaces")
public class SpaceController {

    @Autowired
    private SpaceService spaceService;

    @Autowired
    private SpaceTypeService spaceTypeService;

    @Autowired
    private SpaceStatusService spaceStatusService;
    //    DuDH - Tạo mới Space
    @PostMapping (value = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registerSpace (@RequestBody @Valid SpacesDTO spacesDTO, BindingResult bindingResult){
        if(spaceService.existsSpaceByCode(spacesDTO.getSpaceCode())){
            bindingResult.rejectValue("spaceCode","Mã mặt bằng đã tồn tại");
        }

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.BAD_REQUEST);
        }
        Spaces spacesObj = new Spaces();
        BeanUtils.copyProperties(spacesDTO, spacesObj);
        spacesObj.setSpaceDeleteFlag(false);
        spaceService.saveNewSpace(spacesObj);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //    DuDH - Tìm kiếm theo ID Space
    @GetMapping(value = "/{id}")
    public ResponseEntity<Spaces> findByID(@PathVariable Integer id) {
        return new ResponseEntity<>(spaceService.findById(id), HttpStatus.OK);
    }

    // Tây mượn để lấy list danh sách khách hàng
    @GetMapping(value = "/list-select")
    public ResponseEntity<List<SpacesDTO>>  getAll(){
        List<SpacesDTO> spacesDTOS  = new ArrayList<>();
        List<Spaces> spacesList = this.spaceService.getAll1();
        for (Spaces d: spacesList) {
            SpacesDTO spacesDTO  = new SpacesDTO();
            spacesDTO.setSpaceId(d.getSpaceId());
            spacesDTO.setSpaceCode(d.getSpaceCode());
//            spacesDTO.setSpaceArea(d.getSpaceArea());
//            spacesDTO.setSpacePrice(d.getSpacePrice());
//            spacesDTO.setSpaceManagerFee(d.getSpaceManagerFee());
//            spacesDTO.setSpaceNote(d.getSpaceNote());
//            spacesDTO.setSpaceImage(d.getSpaceImage());
//            spacesDTO.setSpaceDeleteFlag(d.getSpaceDeleteFlag());
//            spacesDTO.setCustomerDeleteFlag(d.getCustomerDeleteFlag());
            spacesDTOS.add(spacesDTO);
        }
        return new ResponseEntity<>(spacesDTOS, HttpStatus.OK);
    }

    //    DuDH - Chỉnh sửa Space
    @PatchMapping(value = "/edit/{id}")
    public ResponseEntity<Object> editSpace(@RequestBody @Valid SpacesDTO spacesDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.BAD_REQUEST);
        }
        Spaces spacesObj = new Spaces();
        BeanUtils.copyProperties(spacesDTO, spacesObj);
//        spacesObj.setSpaceDeleteFlag(false);
        spaceService.editSpace(spacesObj);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<Page<SpaceListDTO>> findAllSpace(Pageable pageable) {
        List<SpaceListDTO> spaceListDTOS = spaceService.findAllSpace();
        Page<SpaceListDTO> pages = new PageImpl<>(spaceListDTOS, pageable, spaceListDTOS.size());
        if (pages.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(pages, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public void deleteSpaceById(@PathVariable Integer id) {
        spaceService.deleteById(id);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<SpaceListDTO>> searchSpace(@RequestParam(value = "floorName", defaultValue = "") String floorName,
                                                          @RequestParam(value = "spaceCode", defaultValue = "") String spaceCode,
                                                          @RequestParam(value = "spaceArea", defaultValue = "") String spaceArea,
                                                          @RequestParam(value = "spaceTypeName", defaultValue = "") String spaceTypeName,
                                                          @RequestParam(value = "spaceStatusName", defaultValue = "") String spaceStatusName, Pageable pageable) {
        List<SpaceListDTO> spaceListDTOS = spaceService.searchSpace(floorName, spaceCode, spaceArea, spaceTypeName, spaceStatusName);
        Page<SpaceListDTO> pages = new PageImpl<>(spaceListDTOS, pageable, spaceListDTOS.size());
        if (pages.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pages, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<SpaceListDTO> findSpaceById(@PathVariable("id") Integer id) {
        SpaceListDTO spaceListDTO = spaceService.findSpaceById(id);
        if (spaceListDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(spaceListDTO, HttpStatus.OK);
    }
}