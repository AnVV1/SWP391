package com.c0821g1.sprint1.entity.contract;

import com.c0821g1.sprint1.entity.customer.Customer;
import com.c0821g1.sprint1.entity.employee.Employee;
import com.c0821g1.sprint1.entity.space.Spaces;
import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Contract implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contractId;
    private String contractCode;

    private String contractExpired;
    private String contractDateStart;
    private String contractDateEnd;
    private String contractTotal;
    private Integer price;
    private Integer contractDeposit;
    private String contractTaxCode;
    private String contractContent;
    private String contractImageUrl;
    private Boolean contractDeleteFlag;
    private int checkFlag;


    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = true)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employee_id",nullable = true)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "space_id",nullable = true)
    private Spaces spaces;

    public Contract() {
    }

    public Contract(int contractId, String contractCode, String contractExpired, String contractDateStart, String contractDateEnd, String contractTotal, Integer price, Integer contractDeposit, String contractTaxCode, String contractContent, String contractImageUrl, Boolean contractDeleteFlag, int checkFlag, Customer customer, Employee employee, Spaces spaces) {
        this.contractId = contractId;
        this.contractCode = contractCode;
        this.contractExpired = contractExpired;
        this.contractDateStart = contractDateStart;
        this.contractDateEnd = contractDateEnd;
        this.contractTotal = contractTotal;
        this.price = price;
        this.contractDeposit = contractDeposit;
        this.contractTaxCode = contractTaxCode;
        this.contractContent = contractContent;
        this.contractImageUrl = contractImageUrl;
        this.contractDeleteFlag = contractDeleteFlag;
        this.checkFlag = checkFlag;
        this.customer = customer;
        this.employee = employee;
        this.spaces = spaces;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getContractExpired() {
        return contractExpired;
    }

    public void setContractExpired(String contractExpired) {
        this.contractExpired = contractExpired;
    }

    public String getContractDateStart() {
        return contractDateStart;
    }

    public void setContractDateStart(String contractDateStart) {
        this.contractDateStart = contractDateStart;
    }

    public String getContractDateEnd() {
        return contractDateEnd;
    }

    public void setContractDateEnd(String contractDateEnd) {
        this.contractDateEnd = contractDateEnd;
    }

    public String getContractTotal() {
        return contractTotal;
    }

    public void setContractTotal(String contractTotal) {
        this.contractTotal = contractTotal;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(Integer contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public String getContractTaxCode() {
        return contractTaxCode;
    }

    public void setContractTaxCode(String contractTaxCode) {
        this.contractTaxCode = contractTaxCode;
    }

    public String getContractContent() {
        return contractContent;
    }

    public void setContractContent(String contractContent) {
        this.contractContent = contractContent;
    }

    public String getContractImageUrl() {
        return contractImageUrl;
    }

    public void setContractImageUrl(String contractImageUrl) {
        this.contractImageUrl = contractImageUrl;
    }

    public Boolean getContractDeleteFlag() {
        return contractDeleteFlag;
    }

    public void setContractDeleteFlag(Boolean contractDeleteFlag) {
        this.contractDeleteFlag = contractDeleteFlag;
    }

    public int getCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(int checkFlag) {
        this.checkFlag = checkFlag;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Spaces getSpaces() {
        return spaces;
    }

    public void setSpaces(Spaces spaces) {
        this.spaces = spaces;
    }
}
