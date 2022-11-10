package com.c0821g1.sprint1.repository;


import com.c0821g1.sprint1.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select * from customer where customer_delete_flag = false ", nativeQuery = true)
    Page<Customer> findAllCustomer(Pageable pageable);


    @Query(value = "select * from customer where customer_name like concat('%',:customer_name,'%') " +
            "and customer_email like concat('%',:customer_email,'%') and customer_phone like concat('%',:customer_phone,'%')" +
            " and customer_identify_number like concat('%',:customer_identify_number,'%') and customer_delete_flag = false", nativeQuery = true)
    Page<Customer> getByCustomerNameAndCustomerEmailAndCustomerPhoneAndCustomerIdentifyNumber(Pageable pageable,
                                                                                              @Param("customer_name") String customer_name,
                                                                                              @Param("customer_email") String customer_email,
                                                                                              @Param("customer_phone") String customer_phone,
                                                                                              @Param("customer_identify_number") String customer_identify_number);

    @Transactional
    @Modifying
    @Query(value = "update customer set customer_delete_flag = 1 where customer_id = :id", nativeQuery = true)
    void deleteCustomer(@Param("id") Integer id);
}


