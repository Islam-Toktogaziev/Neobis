package com.example.AvtoShop.Service;


import com.example.AvtoShop.Entity.Role;
import com.example.AvtoShop.Entity.User;
import com.example.AvtoShop.Repository.UserRepository;
import com.example.AvtoShop.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;


@Service
public class  UserServiceImpl implements UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }


    @Override
    public User save(UserRegistrationDto userRegistrationDto) {
        User user = new User(userRegistrationDto.getUserName(),
                bCryptPasswordEncoder.encode(userRegistrationDto.getPassword()));
        user.setRoles(Collections.singleton(new Role(1L,"ROLE_USER") ));
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(userName);

        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password!");
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),user.getRoles());
    }


    private Collection <? extends GrantedAuthority> mapRolesToAuthorities (Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
