package com.c0821g1.sprint1.service.impl;


import com.c0821g1.sprint1.entity.employee.EmployeePosition;
import com.c0821g1.sprint1.repository.EmployeePositionRepository;
import com.c0821g1.sprint1.service.EmployeePositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeePositionServiceImpl implements EmployeePositionService {
    @Autowired
    EmployeePositionRepository employeePositionRepository;
    @Override
    public List<EmployeePosition> findAll() {
        return employeePositionRepository.findAll();
    }
}
