package com.c0821g1.sprint1.service.impl;

import com.c0821g1.sprint1.entity.employee.Employee;
import com.c0821g1.sprint1.entity.security.AppUser;
import com.c0821g1.sprint1.repository.EmployeeRepository;
import com.c0821g1.sprint1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAllEmployeeSearch(Pageable pageable, String employeeName, String employeeDateOfBirth, String employeeEmail, String employeeAddress) {
        return employeeRepository.searchEmployeeByNameOrDateOfBirthOrEmailOrAddress(pageable, employeeName, employeeDateOfBirth, employeeEmail, employeeAddress);
    }

    @Override
    public List<Employee> findAllEmployee() {
        return this.employeeRepository.findAll();
    }


    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteEmployee(id);
    }

    @Override
    public Optional<Employee> findByIdOp(Integer id) {
        return employeeRepository.findEployeeById(id);
    }


    @Override
    public void editEmployee(Employee employee) {
        employeeRepository.editEmployee(
                employee.getEmployeeAddress(),
                employee.getEmployeeCode(),
                employee.getEmployeeDateOfBirth(),
                employee.getEmployeeDeleteFlag(),
                employee.getEmployeeEmail(),
                employee.getEmployeeGender(),
                employee.getEmployeeImage(),
                employee.getEmployeeName(),
                employee.getEmployeePhone(),
                employee.getEmployeeStartDate(),
                (int) employee.getAppUser().getId(),
                employee.getEmployeePosition().getEmployeePositionId(),
                employee.getEmployeeId());
    }


    //Bảo tạo mới tài khoản nhân viên
    @Override
    public void createEmployeeAccount(AppUser appUser) {
        employeeRepository.createEmployeeAccount1(appUser.getDeleted(), appUser.getEnabled(),appUser.getPassword(),appUser.getUsername());
//        employeeRepository.createEmployeeAccount(appUser.getUsername(), appUser.getPassword());
    }

    @Override
    public Employee getEmployeeByUsername(String username) {
        return employeeRepository.findEmployeeByAppUser(username);
    }

    //Bảo kiểm tra email có tồn tại trong DB
    @Override
    public Boolean existsEmployeeByEmail(String employeEmail) {
        return employeeRepository.getEmployeeByEmail(employeEmail) != null;
    }

    //Bảo kiểm tra Code có tồn tại trong DB
    @Override
    public Boolean existsEmployeeByCode(String employeeCode) {
        return employeeRepository.getEmployeeByCode(employeeCode).size() != 0;
    }


    //Bảo thêm mới nhân viên
    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }




}
