package com.example.smarthouseapi.service.impl;

import com.example.smarthouseapi.entity.Room;
import com.example.smarthouseapi.entity.User;
import com.example.smarthouseapi.repository.UserRepository;
import com.example.smarthouseapi.service.interfaces.UserServiceI;
import lombok.RequiredArgsConstructor;
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
        Collection<SimpleGrantedAuthority> authorities=new ArrayList<>();
        //add user roles
        if(user.getHouse()!=null)
                authorities.add(new SimpleGrantedAuthority(user.getHouse().getId()));
        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),authorities);
    }
}
