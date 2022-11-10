package com.c0821g1.sprint1.service.account;
import com.c0821g1.sprint1.entity.security.AppUser;


public interface IAppUserService {
    AppUser findAppUserByUserName(String userName);

    void saveAppUser(AppUser appUser);

    AppUser findAppUserByEmail(String email);

}