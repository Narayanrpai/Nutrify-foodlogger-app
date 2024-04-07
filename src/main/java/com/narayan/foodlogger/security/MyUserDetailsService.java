package com.narayan.foodlogger.security;

import com.narayan.foodlogger.repositories.UserRepository;
import com.narayan.foodlogger.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Primary
@Service
public class MyUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Mono<User> userMono = userRepository.findUserByUsername(username);
        if (userMono.block() == null){
            log.error("User not found! MyUserDetailsService -----");
            throw new RuntimeException("User does not exist!");
        }

        return userMono.map(MyUserDetails::new).block();
    }
}
