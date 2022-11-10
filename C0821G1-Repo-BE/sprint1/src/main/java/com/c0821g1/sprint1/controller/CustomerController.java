package com.c0821g1.sprint1.controller;

import com.c0821g1.sprint1.dto.CustomerDTO;
import com.c0821g1.sprint1.entity.contract.Contract;
import com.c0821g1.sprint1.entity.customer.Customer;
import com.c0821g1.sprint1.entity.employee.Employee;
import com.c0821g1.sprint1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/customer/")
@CrossOrigin("http://localhost:4200/")
public class CustomerController {
    @Autowired
    private CustomerService customerService;


    @GetMapping(value = "list")
    public ResponseEntity<Page<Customer>> showListCustomer(@PageableDefault(value = 5) Pageable pageable) {
        Page<Customer> customers = this.customerService.getAll(pageable);
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    // Tây mượn để lấy list danh sách khách hàng
    @GetMapping(value = "/list-select")
    public ResponseEntity<List<CustomerDTO>>  getAll(){
        List<CustomerDTO> customerDTO  = new ArrayList<>();
        List<Customer> employeeListSearch = this.customerService.getAll1();
        for (Customer d: employeeListSearch) {
            CustomerDTO customerDTO1  = new CustomerDTO();
            customerDTO1.setCustomerId(d.getCustomerId());
            customerDTO1.setCustomerCode(d.getCustomerCode());
            customerDTO1.setCustomerName(d.getCustomerName());
            customerDTO1.setCustomerIdentifyNumber(d.getCustomerIdentifyNumber());
            customerDTO1.setCustomerEmail(d.getCustomerEmail());
            customerDTO1.setCustomerDateOfBirth(d.getCustomerDateOfBirth());
            customerDTO1.setCustomerAddress(d.getCustomerAddress());
            customerDTO1.setCustomerStatus(d.getCustomerStatus());
            customerDTO1.setCustomerDeleteFlag(d.getCustomerDeleteFlag());
            customerDTO.add(customerDTO1);
        }
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    //          VyLTT- detail customer
    @GetMapping(value = "{id}")
    public ResponseEntity<Customer> getDetailCustomer(@PathVariable Integer id) {
        Optional<Customer> customerObj = this.customerService.findById(id);
        if (!customerObj.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>((Customer) customerObj.get(), HttpStatus.OK);
    }

    //      VyLTT- delete customer
    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Integer id) {
        Optional<Customer> customerObj = this.customerService.findById(id);
        if (!customerObj.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.customerService.deleteCustomer(id);
        return new ResponseEntity<>(customerObj.get(), HttpStatus.OK);
    }

    //    VyLTT - search by name, email, phone, identify number
    @GetMapping(value = "search")
    public ResponseEntity<Page<Customer>> searchCustomer(
            @PageableDefault(value = 5) Pageable pageable,
            @RequestParam(defaultValue = "") String customer_name,
            @RequestParam(defaultValue = "") String customer_email,
            @RequestParam(defaultValue = "") String customer_phone,
            @RequestParam(defaultValue = "") String customer_identify_number
    ) {
        Page<Customer> customersNewPage = customerService.findCustomerByNameAndEmailAndPhoneAndIdentify
                (pageable, customer_name, customer_email, customer_phone, customer_identify_number);

        if (customersNewPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customersNewPage, HttpStatus.OK);

    }
}
