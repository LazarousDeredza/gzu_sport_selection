//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzu.sportsselection.security.services;

import com.gzu.sportsselection.security.models.User;
import com.gzu.sportsselection.security.models.UserPrincipal;
import com.gzu.sportsselection.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    public MyUserDetailsService() {
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found!");
        } else {
            return new UserPrincipal(user);
        }
    }


}
