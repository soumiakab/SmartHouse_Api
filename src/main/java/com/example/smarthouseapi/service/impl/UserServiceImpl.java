package com.example.smarthouseapi.service.impl;

import com.example.smarthouseapi.entity.Room;
import com.example.smarthouseapi.entity.User;
import com.example.smarthouseapi.repository.UserRepository;
import com.example.smarthouseapi.service.interfaces.UserServiceI;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserServiceI , UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        log.info(String.valueOf(user));
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getOne(String id){

        Optional<User> found = userRepository.findById(id);
        if (found.isEmpty()) {
            return Optional.empty();
        }
        return found;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =this.userRepository.findByUserName(username);
        log.info("user name"+username);
        Collection<SimpleGrantedAuthority> authorities=new ArrayList<>();
        //add user roles
        //if(user.getHouse().getId()!=null)
                authorities.add(new SimpleGrantedAuthority("user"));
        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),authorities);
    }
}
