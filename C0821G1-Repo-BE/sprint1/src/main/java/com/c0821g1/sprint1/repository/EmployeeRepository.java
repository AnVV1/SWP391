package com.c0821g1.sprint1.repository;


import com.c0821g1.sprint1.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Query(value = "SELECT * from employee e " +
            "join app_users a on e.app_user_id = a.id " +
            "where a.username =?1 and e.employee_delete_flag = false ", nativeQuery = true)
    Employee findEmployeeByAppUser(String username);



    @Query(value = "select * from  employee where employee_delete_flag = false ", nativeQuery = true)
    Page<Employee> findAllEmployee(Pageable pageable);

    @Query(value = "select * from employee where employee_name like concat('%',:employeeName,'%') " +
            "and employee_date_of_birth like concat('%',:employeeDateOfBirth,'%') and employee_email like concat('%',:employeeEmail,'%')" +
            " and employee_address like concat('%',:employeeAddress,'%') and employee_delete_flag = false", nativeQuery = true)
    Page<Employee> searchEmployeeByNameOrDateOfBirthOrEmailOrAddress(Pageable pageable, @Param("employeeName") String employeeName
            , @Param("employeeDateOfBirth") String employeeDateOfBirth, @Param("employeeEmail") String employeeEmail, @Param("employeeAddress") String employeeAddress);

    @Transactional
    @Modifying
    @Query(value = "update employee  set employee_delete_flag = true where employee_id = :id", nativeQuery = true)
    void deleteEmployee(@Param("id") Integer id);

    // lấy id
    @Query(value = "select * from employee where employee_id=?", nativeQuery = true)
    Optional<Employee> findEployeeById(Integer id);


    @Modifying
    @Transactional
    @Query(value = "insert into employee(employee_address," +
            "employee_code," +
            "employee_date_of_birth," +
            "employee_delete_flag," +
            "employee_email," +
            "employee_gender," +
            "employee_image," +
            "employee_name," +
            "employee_phone," +
            "employee_start_date," +
            "app_users_id," +
            "employee_position_id) " +
            "values (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12)", nativeQuery = true)
    void saveEmployee(String employeeAddress, String employeeCode, String employeeDateOfBirth, Boolean employeeDeleteFlag,
                      String employeeEmail, String employeeGender, String employeeImage, String employeeName,
                      String employeePhone, String employeeStartDate, Integer appUserAppUserId, Integer employeePositionId);



    @Transactional
    @Modifying
    @Query(value = "update employee as e " +
            "set e.employee_address =?1,e.employee_code =?2" +
            ",e.employee_date_of_birth =?3,e.employee_delete_flag =?4," +
            "e.employee_email =?5,e.employee_gender =?6," +
            "e.employee_image =?7,e.employee_name= ?8,e.employee_phone= ?9,e.employee_start_date= ?10," +
            "e.app_user_id= ?11,e.employee_position_id= ?12 " +
            "where employee_id =?13", nativeQuery = true)
    void editEmployee(String employeeAddress, String employeeCode, String employeeDateOfBirth, Boolean employeeDeleteFlag,
                      String employeeEmail, String employeeGender, String employeeImage, String employeeName,
                      String employeePhone, String employeeStartDate, Integer appUserAppUserId, Integer employeePositionId,
                      Integer employeeId);


    @Modifying
    @Transactional
    @Query(value = "insert into app_users(username," +
            "password)" +
            "values  (?1,?2);", nativeQuery = true)
    void createEmployeeAccount( String appUserName, String appUserPassword);


    @Query(value = "SELECT  * " +
            "from employee  " +
            "where employee_email =?1", nativeQuery = true)
    Employee getEmployeeByEmail(String employeeEmail);


    @Query(value = "SELECT * " +
            "from employee  " +
            "where employee_code =?1", nativeQuery = true)
    List<Employee> getEmployeeByCode(String employeeCode);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO app_users( deleted, is_enabled, password, username) " +
            "VALUES (?1, ?2, ?3, ?4 );", nativeQuery = true)
    void createEmployeeAccount1(Boolean appUserDelete,Boolean appUserEnable,String appUserPassword, String appUserUsername);
}
