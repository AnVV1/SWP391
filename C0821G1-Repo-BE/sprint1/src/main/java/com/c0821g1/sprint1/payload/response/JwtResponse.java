package com.c0821g1.sprint1.payload.response;
import java.util.List;

public class JwtResponse {

    private String jwtToken;
    private String username;
    private String name;
    private String dayOfBirth;
    private String gender;
    private String address;
    private String phone;
    private String email;
    private Integer idEmployee;
    private String urlImg;
    private List<String> roles;

    public JwtResponse() {
    }

    public JwtResponse(String jwtToken, String username, String name, String dayOfBirth, String gender, String address, String phone, String email, Integer idEmployee, String urlImg) {
        this.jwtToken = jwtToken;
        this.username = username;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.idEmployee = idEmployee;
        this.urlImg = urlImg;
    }

    public JwtResponse(String jwtToken, String username, String name, String dayOfBirth, String gender, String address, String phone, String email, Integer idEmployee, String urlImg, List<String> roles) {
        this.jwtToken = jwtToken;
        this.username = username;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.idEmployee = idEmployee;
        this.urlImg = urlImg;
        this.roles = roles;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
