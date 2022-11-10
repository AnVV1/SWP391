package com.c0821g1.sprint1.controller;


import com.c0821g1.sprint1.dto.EmployeeDTO;
import com.c0821g1.sprint1.entity.contract.Contract;
import com.c0821g1.sprint1.entity.employee.Employee;
import com.c0821g1.sprint1.entity.security.AppUser;
import com.c0821g1.sprint1.entity.security.Role;
import com.c0821g1.sprint1.service.EmployeePositionService;
import com.c0821g1.sprint1.service.EmployeeService;
import com.c0821g1.sprint1.service.account.impl.AppUserServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import javax.validation.Valid;

import java.util.Optional;
@RestController
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@RequestMapping(value = "/api/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmployeePositionService employeePositionService;
    @Autowired
    AppUserServiceImpl appUserService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<Employee>>  getAll(){
        List<Employee> employeeListSearch = this.employeeService.findAllEmployee();
        return new ResponseEntity<>(employeeListSearch, HttpStatus.OK);
    }

    // Tìm kiếm nhân viên
    @GetMapping(value = "/search")
    public ResponseEntity<Page<Employee>> searchEmployeeByNameOrDateOfBirthOrEmailOrAddress(@PageableDefault(value = 5) Pageable pageable,
                                                                                            @RequestParam(defaultValue = "") String employeeName,
                                                                                            @RequestParam(defaultValue = "") String employeeDateOfBirth,
                                                                                            @RequestParam(defaultValue = "") String employeeEmail,
                                                                                            @RequestParam(defaultValue = "") String employeeAddress
    ) {
        System.out.println("test");
        Page<Employee> employeeListSearch = employeeService.findAllEmployeeSearch(pageable, employeeName,
                employeeDateOfBirth, employeeEmail, employeeAddress);
        System.out.println(employeeListSearch);
        if (employeeListSearch.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employeeListSearch, HttpStatus.OK);
    }


    // xóa nhân viên.
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteEmployees(@PathVariable("id") Integer id) {
        Optional<Employee> employeeOptional = this.employeeService.findByIdOp(id);
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employeeService.deleteById(id);
        return new ResponseEntity<>(employeeOptional.get(), HttpStatus.OK);
    }

    // lấy id nhân viên
    @GetMapping(value = "/detail/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Integer id) {
        Optional<Employee> employee = employeeService.findByIdOp(id);
        if (!employee.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employee.get(), HttpStatus.OK);
    }


    //Bảo chỉnh sửa thông tin nhân viên
    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<Object> updateEmployee(@RequestBody @Valid EmployeeDTO employeeDTO,
                                                 BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.BAD_REQUEST);
        }


        //set role
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        AppUser appUser = appUserService.findAppUserByEmail(employeeDTO.getAppUser().getUsername());
        Set<Role> roleList = new HashSet<>();
        Role role = new Role();
        if (employee.getEmployeePosition().getEmployeePositionId() == 1) {
            role.setId(1);
        } else {
            role.setId(2);
        }
        roleList.add(role);
        appUser.setRoles(roleList);

        // chỉnh sửa nhân viên
        employeeService.editEmployee(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    //Bảo thêm mới nhân viên và đăng ký tài khoản cho nhân viên
    @PostMapping(value = "/create")
    public ResponseEntity<Object> createEmployee(@RequestBody @Valid EmployeeDTO employeeDTO, BindingResult bindingResult) {


//        Kiểm tra email và mã nhân viên có tồn tại trong DB hay không

        if (employeeService.existsEmployeeByCode(employeeDTO.getEmployeeCode())) {
            System.out.println("Lỗi");;
            bindingResult.rejectValue("employeeCode", "Mã nhân viên đã tồn tại!");
        }
        if (employeeService.existsEmployeeByEmail(employeeDTO.getEmployeeEmail())) {
            System.out.println("Test");
            bindingResult.rejectValue("employeeEmail", "Email đã tồn tại!");
        }
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.BAD_REQUEST);
        }
        //tạo tài khoản cho nhân viên với username là email và mật khẩu mặc định là 123456
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        AppUser appUser = new AppUser();
        appUser.setUsername(employee.getEmployeeEmail());
        appUser.setPassword("$2a$10$zpsUtU0PSZwmeSGKMW3PN.ud9V464dGj/ZyQqA3.5Rs4n0E9BoHH2");
        appUser.setDeleted(false);
        appUser.setEnabled(true);
        employeeService.createEmployeeAccount(appUser);
        appUser = appUserService.findAppUserByEmail(appUser.getUsername());
        employee.setAppUser(appUser);

        //set role
        Set<Role> roleList = new HashSet<>();
        Role role = new Role();
        if (employee.getEmployeePosition().getEmployeePositionId() == 1) {
            role.setId(1);
        } else {
            role.setId(2);
        }
        roleList.add(role);
        appUser.setRoles(roleList);

        //tạo mới nhân viên
        employee.setEmployeeDeleteFlag(false);
        employeeService.saveEmployee(employee);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}






