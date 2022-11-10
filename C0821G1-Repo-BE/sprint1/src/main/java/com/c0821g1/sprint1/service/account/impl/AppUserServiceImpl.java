package com.c0821g1.sprint1.service.account.impl;
import com.c0821g1.sprint1.entity.security.AppUser;
import com.c0821g1.sprint1.repository.account.IAppUserRepository;
import com.c0821g1.sprint1.service.account.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AppUserServiceImpl implements IAppUserService {

    @Autowired
    private IAppUserRepository appUserRepository;

    
    @Override
    public AppUser findAppUserByUserName(String userName) {
        return appUserRepository.getAppUserByUsername(userName);
    }

    @Override
    public void saveAppUser(AppUser appUser) {
        appUserRepository.save(appUser);
    }

    @Override
    public AppUser findAppUserByEmail(String email) {
        return appUserRepository.findAppUserByEmail(email);
    }
}