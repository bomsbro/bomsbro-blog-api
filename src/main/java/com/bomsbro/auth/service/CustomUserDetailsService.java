package com.bomsbro.auth.service;

import com.bomsbro.auth.model.entity.User;
import com.bomsbro.auth.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    /*Security에서 매우 중요한 서비스. 시큐리티의 userDetailService를 impl하고 UserRepo를 주입받음.
    * loadUserByUsername을 override함. 로그인시에 유저정보와 권한정보를 가져와서 .userdetails.User를 리턴
    *
    * */
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String userName) {
        return userRepository.findOneWithAuthoritiesByName(userName)
                .map(user -> createUser(userName, user))
                .orElseThrow(() -> new UsernameNotFoundException(userName + " -> 데이터베이스에서 찾을 수 없습니다."));
    }

    private org.springframework.security.core.userdetails.User createUser(String userName, User user) {
        if (!user.getActivated()) {
            throw new RuntimeException(userName + " -> 활성화되어 있지 않습니다.");
        }

        List<GrantedAuthority> grantedAuthorities = user.getUserAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthorityName()))
                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(user.getName(),
                user.getPassword(),
                grantedAuthorities);
    }
}
