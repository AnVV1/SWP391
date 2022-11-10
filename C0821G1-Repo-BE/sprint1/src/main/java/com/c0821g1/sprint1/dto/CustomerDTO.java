package com.c0821g1.sprint1.dto;

public class CustomerDTO {

    private Integer customerId;
    private String customerCode;
    private String customerName;
    private String customerIdentifyNumber;
    private String customerEmail;
    private String customerPhone;
    private String customerDateOfBirth;
    private String customerAddress;
    private String customerStatus;
    private Boolean customerDeleteFlag;

    public CustomerDTO() {
    }


    public CustomerDTO(Integer customerId, String customerCode, String customerName, String customerIdentifyNumber, String customerEmail, String customerPhone, String customerDateOfBirth, String customerAddress, String customerStatus, Boolean customerDeleteFlag) {
        this.customerId = customerId;
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.customerIdentifyNumber = customerIdentifyNumber;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
        this.customerDateOfBirth = customerDateOfBirth;
        this.customerAddress = customerAddress;
        this.customerStatus = customerStatus;
        this.customerDeleteFlag = customerDeleteFlag;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerIdentifyNumber() {
        return customerIdentifyNumber;
    }

    public void setCustomerIdentifyNumber(String customerIdentifyNumber) {
        this.customerIdentifyNumber = customerIdentifyNumber;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerDateOfBirth() {
        return customerDateOfBirth;
    }

    public void setCustomerDateOfBirth(String customerDateOfBirth) {
        this.customerDateOfBirth = customerDateOfBirth;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }

    public Boolean getCustomerDeleteFlag() {
        return customerDeleteFlag;
    }

    public void setCustomerDeleteFlag(Boolean customerDeleteFlag) {
        this.customerDeleteFlag = customerDeleteFlag;
    }
}
