package com.c0821g1.sprint1.service.impl;

import com.c0821g1.sprint1.dto.UserDTO;
import com.c0821g1.sprint1.entity.security.AppUser;
import com.c0821g1.sprint1.repository.UserRepository;
import com.c0821g1.sprint1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    final
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public AppUser changePassword(UserDTO userDTO) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//           String a = bCryptPasswordEncoder.encode("123");
//           System.out.println("aaa"+a);
        System.out.println(userDTO.getId());
        AppUser appUser = userRepository.findById(userDTO.getId()).orElse(null);
        System.out.println(appUser.getPassword());
        System.out.println("bcryp" + bCryptPasswordEncoder.encode(appUser.getPassword()));
        if (appUser != null ) {
//               appUser.getPassword()
//                       .equals(bCryptPasswordEncoder.encode(changePasswordDTO.getCurrentPassword()))

            if (bCryptPasswordEncoder.matches(userDTO.getCurrentPassword(),appUser.getPassword())) {
                System.out.println("vào");
                if (userDTO.getNewPassword().equals(userDTO.getConfirmPassword())) {
                    appUser.setPassword(bCryptPasswordEncoder.encode(userDTO.getNewPassword()));
                    System.out.println("hahha" +
                            appUser.getPassword());
                    return userRepository.save(appUser);
                }
            } else {
                return null;
            }
        }
        return null;
    }

    @Override
    public AppUser findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }


    @Override
    public void save(AppUser appUser) {
        userRepository.save(appUser);
    }

    @Override
    public List<AppUser> findAll() {
        return userRepository.findAll();
    }

    private static boolean compareCurrentPassword(String currentPass, String targetPass) {
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        String pw = bCryptPasswordEncoder.encode(targetPass);
//        System.out.println(pw);
        if (currentPass.equals("abc")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean compareNewPasswordAndConfirmPassword(String newPassword, String confirmPassword) {
        if (newPassword.equals(confirmPassword)) {
            return false;
        }
        return true;

    }
}
