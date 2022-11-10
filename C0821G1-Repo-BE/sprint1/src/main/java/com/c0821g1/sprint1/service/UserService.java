package com.c0821g1.sprint1.service;

import com.c0821g1.sprint1.dto.UserDTO;
import com.c0821g1.sprint1.entity.security.AppUser;

import java.util.List;

public interface UserService {
    AppUser changePassword(UserDTO changePasswordDTO);

    AppUser findById(Integer id);

    void save(AppUser appUser);

    List<AppUser> findAll();
}
