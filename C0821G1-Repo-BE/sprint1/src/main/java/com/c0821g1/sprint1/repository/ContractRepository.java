package com.c0821g1.sprint1.repository;

import com.c0821g1.sprint1.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ContractRepository  extends JpaRepository<Contract,Integer> {
    @Transactional
    @Modifying

//      xoá contract

    @Query(value = "update contract set contract_delete_flag = 1 where contract_id = ?", nativeQuery = true)
    void deleteContract(Integer id);

    //      list + page + search contract

    @Query(value = " select * from contract \n" +
            " left Join customer on contract.customer_id = customer.customer_id \n" +
            " left Join spaces on contract.space_id = spaces.space_id \n" +
            " where contract.contract_delete_flag = 0 and customer.customer_name like concat('%',:name,'%') \n" +
            " and spaces.space_code like concat('%',:code,'%') \n" +
            " and contract.contract_date_start like concat('%',:start,'%') \n" +
            " and contract.contract_date_end like concat('%',:end,'%')", nativeQuery = true,
            countQuery = " select count(*) from contract \n " +
                    " left Join customer on contract.customer_id = customer.customer_id \n" +
                    " left Join spaces on contract.space_id = spaces.space_id \n" +
                    " where contract.contract_delete_flag = 0 and customer.customer_name like concat('%',:name,'%') \n" +
                    " and spaces.space_code like concat('%',:code,'%') \n" +
                    " and contract.contract_date_start like concat('%',:start,'%') \n" +
                    " and contract.contract_date_end like concat('%',:end,'%')")
    Page<Contract> findAllContractByNameAndCodeAndDate(@Param("name") String name,
                                                       @Param("code") String code,
                                                       @Param("start") String start,
                                                       @Param("end") String end,
                                                       @Param("page") Pageable pageable);
    //      lấy id contract

    @Query(value = "SELECT * FROM contract WHERE contract.contract_id = ?", nativeQuery = true)
    Optional<Contract> findContractById(Integer id);


    @Transactional
    @Modifying
    @Query(value = "update Contract as c " +
            "set c.contract_expired =?1,c.contract_date_start =?2,c.contract_date_end =?3" +
            ",c.contract_total =?4,c.contract_content =?5," +
            "c.contract_delete_flag =?6,c.employee_id =?7," +
            "c.customer_id =?8,c.space_id= ?9,c.price= ?10,c.contract_deposit= ?11,c.contract_tax_code = ?12,c.contract_image_url = ?13,c.contract_code =?14,c.check_flag =?15 where contract_id =?16", nativeQuery = true)
    void editContract(String contractexpired, String contractdatestart,
                      String contractdateend, String contracttotal, String contractcontent, Boolean deleteflag
            , Integer employeeid, Integer customerid, Integer spaceid,Integer price
            ,Integer contractdeposit,String contracttaxcode,String contractimageurl,String code,Integer checkflag,Integer contractid);


    @Modifying
    @Transactional
    @Query(value = "insert into Contract(contract_expired,contract_date_start," +
            "contract_date_end,contract_total," +
            "contract_content,contract_id,contract_delete_flag,customer_id,employee_id,space_id,price,contract_deposit,contract_tax_code,contract_image_url,contract_code,check_flag) " +
            "values (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13,?14,?15,?16)", nativeQuery = true)
    void saveContract(String contractExpired, String contractDatestart,
                      String contractdateend, String contracttotal, String contractcontent,
                      Integer contractid, Boolean deleteflag,Integer customerid,
                      Integer employeeid,Integer spaceid,Integer price,
                      Integer deposit,String taxcode,String image,String code,Integer checkflag);


    @Query(value = "SELECT * " +
            "from contract  " +
            "where contract_code =?1", nativeQuery = true)
    Contract existsContractByCode(String contractCode);


    @Query(value = "SELECT * FROM contract WHERE contract.contract_id = ?",nativeQuery = true)
    Contract findById1(Integer id);
}
