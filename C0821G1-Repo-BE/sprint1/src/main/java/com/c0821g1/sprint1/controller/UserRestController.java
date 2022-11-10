package com.c0821g1.sprint1.controller;


import com.c0821g1.sprint1.dto.UserDTO;
import com.c0821g1.sprint1.entity.security.AppUser;
import com.c0821g1.sprint1.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value = "api/employee")
public class UserRestController {

    final
    UserServiceImpl userServiceImpl;

    public UserRestController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }


    /**
     * created DuongNT
     * method updatePassword
     * @param userDTO
     * @return
     */

    @PutMapping("/changePassword")
    public ResponseEntity<AppUser> passwordUser(@RequestBody UserDTO userDTO) {
        if (userDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        System.out.println("controller" + userDTO);
        AppUser appUser = userServiceImpl.changePassword(userDTO);
        if(appUser==null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(appUser,HttpStatus.OK);
    }
}
