package com.c0821g1.sprint1.controller;


import com.c0821g1.sprint1.dto.ContractDTO;
import com.c0821g1.sprint1.entity.contract.Contract;
import com.c0821g1.sprint1.service.ContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("api/contract")
public class ContractController {

    @Qualifier("contractServiceImpl")

    @Autowired
    private ContractService contractService;

    //      tim kiem + phan trang
//      Đông nguyễn
    @GetMapping("/contract-list")
    public ResponseEntity<Page<Contract>> findContractByNameAndCodeAndDate(
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "") String code,
            @RequestParam(defaultValue = "") String start,
            @RequestParam(defaultValue = "") String end,
            @RequestParam(defaultValue = "0") int page
    ) {
        System.out.println("Hello");
        Pageable pageable = PageRequest.of(page, 7);
        Page<Contract> contractNewPage = contractService.findAllContractByNameAndCodeAndDatePage(name,code,start,end,pageable);
        System.out.println(contractNewPage);
        if (contractNewPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractNewPage, HttpStatus.OK);

    }

    //      Xoá danh sách hợp đồng
//      Đông nguyễn
    @DeleteMapping("delete-contract/{id}")
    public ResponseEntity<Contract> deleteCustomer(@PathVariable Integer id) {
        Optional<Contract> contractOptional = contractService.findContractById(id);
        if (!contractOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        contractService.deleteContract(id);
        return new ResponseEntity<>(contractOptional.get(), HttpStatus.NO_CONTENT);
    }

    //      Xoá danh sách hợp đồng
//      Đông nguyễn
    @GetMapping("/{id}")
    public ResponseEntity<Object> findContractById(@PathVariable Integer id){
        Optional<Contract> contractOptional = contractService.findContractById(id);
        if (!contractOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contractOptional,HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Object> findContractById1(@PathVariable Integer id){
        ContractDTO contractDTO = new ContractDTO();
        Contract contract = contractService.findContractById1(id);

        contractDTO.setContractId(contract.getContractId());
        contractDTO.setContractCode(contract.getContractCode());
        contractDTO.setContractExpired(contract.getContractExpired());
        contractDTO.setContractDateStart(contract.getContractDateStart());
        contractDTO.setContractDateEnd(contract.getContractDateEnd());
        contractDTO.setPrice(contract.getPrice());
        contractDTO.setContractDeposit(contract.getContractDeposit());
        contractDTO.setContractTaxCode(contract.getContractTaxCode());
        contractDTO.setContractImageUrl(contract.getContractImageUrl());
        contractDTO.setContractTotal(contract.getContractTotal());
        contractDTO.setContractContent(contract.getContractContent());
        contractDTO.setCustomerId(contract.getCustomer().getCustomerId());
        contractDTO.setEmployeeId(contract.getEmployee().getEmployeeId());
        contractDTO.setSpaceId(contract.getSpaces().getSpaceId());
        contractDTO.setContractDeleteFlag(contract.getContractDeleteFlag());
        contractDTO.setCheckFlag(contract.getCheckFlag());
        return new ResponseEntity<>(contractDTO,HttpStatus.OK);
    }



    //    Tây chức năng create hợp đồng
    @PostMapping("/add")
    public ResponseEntity<Object> addContract(@Valid @RequestBody ContractDTO contractDTO, BindingResult bindingResult) {

        if(contractService.existsContractByCode(contractDTO.getContractCode())){
            bindingResult.rejectValue("contractCode", "Mã hợp đồng đã tồn tại.");
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.BAD_REQUEST);
        }

        new ContractDTO().validate(contractDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.NOT_MODIFIED);
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDTO, contract);
        contractService.addContract(contractDTO);
        return new ResponseEntity<>(contractDTO,HttpStatus.CREATED);


    }


    //    Tây chức năng edit hợp đồng
    @PatchMapping("/update/{id}")
    public ResponseEntity<Object> updateContract(@Valid @RequestBody ContractDTO contractDTO, BindingResult bindingResult, @PathVariable("id") Integer id) {
        try {
            new ContractDTO().validate(contractDTO,bindingResult);
            if (bindingResult.hasErrors()){
                return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.NOT_MODIFIED);
            }

            contractDTO.setContractId(id);
            contractService.editContract(contractDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (RuntimeException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/check")
    public ResponseEntity<Boolean> checkDate(@RequestParam("date1")String date, @RequestParam("date2") String date2){
        boolean check = this.contractService.checkDate(date,date2);
        return new ResponseEntity<>(check,HttpStatus.OK);
    }
}
