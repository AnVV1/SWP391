package com.c0821g1.sprint1.dto;

import com.c0821g1.sprint1.entity.employee.EmployeePosition;
import com.c0821g1.sprint1.entity.security.AppUser;
import javax.validation.constraints.NotBlank;


public class EmployeeDTO {

    private int employeeId;
    @NotBlank(message = "Mã nhân viên không được để trống")
    private String employeeCode;

    @NotBlank(message = "Tên không được để trống")
//    @Size(min = 6, max = 40, message = "Tên phải từ 6 đến 40 ký tự")
    private String employeeName;
    private String employeeDateOfBirth;
    private String employeeGender;
    private String employeeAddress;

    @NotBlank(message = "Số điện thoại không được để trống")
//    @Pattern(regexp = "^(0?)(3[2-9]|5[6|89]|7[0|6-9]|8[0-6|89]|9[0-4|6-9])[0-9]{7}$", message = "Số điện thoại phải nhập đúng định dạng")
    private String employeePhone;

    @NotBlank(message = "Email không được để trống")
//    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+.[a-z]{2,6}$",message = "Email phải nhập đúng định dạng abc@xyz.com")
    private String employeeEmail;


    private String employeeStartDate;
    //    @NotBlank(message = "Ảnh không được để trống")
    private String employeeImage;
    private Boolean employeeDeleteFlag;


    //   @NotNull(message = "Vị trí không được để trống")
    private EmployeePosition employeePosition;


    private AppUser appUser;

    public EmployeeDTO() {
    }


    public EmployeeDTO(int employeeId, String employeeCode, String employeeName, String employeeDateOfBirth, String employeeGender, String employeeAddress, String employeePhone, String employeeEmail, String employeeStartDate, String employeeImage, Boolean employeeDeleteFlag, EmployeePosition employeePosition, AppUser appUser) {
        this.employeeId = employeeId;
        this.employeeCode = employeeCode;

        this.employeeName = employeeName;
        this.employeeDateOfBirth = employeeDateOfBirth;
        this.employeeGender = employeeGender;
        this.employeeAddress = employeeAddress;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeStartDate = employeeStartDate;
        this.employeeImage = employeeImage;
        this.employeeDeleteFlag = employeeDeleteFlag;
        this.employeePosition = employeePosition;
        this.appUser = appUser;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeDateOfBirth() {
        return employeeDateOfBirth;
    }

    public void setEmployeeDateOfBirth(String employeeDateOfBirth) {
        this.employeeDateOfBirth = employeeDateOfBirth;
    }

    public String getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeStartDate() {
        return employeeStartDate;
    }

    public void setEmployeeStartDate(String employeeStartDate) {
        this.employeeStartDate = employeeStartDate;
    }

    public String getEmployeeImage() {
        return employeeImage;
    }

    public void setEmployeeImage(String employeeImage) {
        this.employeeImage = employeeImage;
    }

    public Boolean getEmployeeDeleteFlag() {
        return employeeDeleteFlag;
    }

    public void setEmployeeDeleteFlag(Boolean employeeDeleteFlag) {
        this.employeeDeleteFlag = employeeDeleteFlag;
    }

    public EmployeePosition getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(EmployeePosition employeePosition) {
        this.employeePosition = employeePosition;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
