package com.c0821g1.sprint1.repository;


import com.c0821g1.sprint1.entity.employee.EmployeePosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePositionRepository extends JpaRepository<EmployeePosition,Integer> {

}
