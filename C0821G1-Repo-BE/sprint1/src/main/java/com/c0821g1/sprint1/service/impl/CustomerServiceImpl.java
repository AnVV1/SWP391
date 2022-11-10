package com.c0821g1.sprint1.service.impl;

import com.c0821g1.sprint1.service.CustomerService;
import org.springframework.stereotype.Service;
import com.c0821g1.sprint1.entity.customer.Customer;
import com.c0821g1.sprint1.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Page<Customer> getAll(Pageable pageable) {
        return customerRepository.findAllCustomer(pageable);
    }

    @Override
    public List<Customer> getAll1() {
        return this.customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return customerRepository.findById(id);
    }

    //    VyLTT - search by name, email, phone, identify number
    @Override
    public Page<Customer> findCustomerByNameAndEmailAndPhoneAndIdentify(Pageable pageable,
                                                                        String customer_name,
                                                                        String customer_email,
                                                                        String customer_phone,
                                                                        String customer_identify_number) {
        return customerRepository.getByCustomerNameAndCustomerEmailAndCustomerPhoneAndCustomerIdentifyNumber
                (pageable, customer_name, customer_email, customer_phone, customer_identify_number);
    }

    //    VyLTT - delete customer
    @Override
    public void deleteCustomer(Integer id) {
        customerRepository.deleteCustomer(id);
    }

}

