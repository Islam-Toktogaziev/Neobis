package com.example.AvtoShop.Service;

import com.example.AvtoShop.Entity.User;

import com.example.AvtoShop.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {

    User save(UserRegistrationDto userRegistrationDto);




}
