package com.c0821g1.sprint1.service;

import com.c0821g1.sprint1.dto.ContractDTO;
import com.c0821g1.sprint1.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;


public interface ContractService {


    Page<Contract> findAllContractByNameAndCodeAndDatePage(String name, String code, String start , String end, Pageable pageable);

    Optional<Contract> findContractById(Integer id);
    Contract findContractById1(Integer id);
    void editContract(ContractDTO contractDTO);

    void addContract(ContractDTO contractDTO);
    boolean existsContractByCode(String contractCode);
    void deleteContract(Integer id);

    boolean checkDate(String date, String date2);
}
