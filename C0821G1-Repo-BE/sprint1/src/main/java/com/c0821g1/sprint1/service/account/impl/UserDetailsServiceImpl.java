package com.c0821g1.sprint1.service.account.impl;
import com.c0821g1.sprint1.entity.security.AppUser;
import com.c0821g1.sprint1.repository.account.IAppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private IAppUserRepository iAppUserRepository;

    @Override
    public MyUserDetailsImpl loadUserByUsername(String s) throws UsernameNotFoundException {

        AppUser appUser = iAppUserRepository.getAppUserByUsername(s);
        return new MyUserDetailsImpl(appUser);
    }
}
