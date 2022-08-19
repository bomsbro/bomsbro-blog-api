package com.bomsbro.common.config;


import com.bomsbro.common.security.JwtAccessDeniedHandler;
import com.bomsbro.common.security.JwtAuthenticationEntryPoint;
import com.bomsbro.common.security.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true) //preAuthorize 어노테이션을 메소드에 추가하기 위해 사용
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final TokenProvider tokenProvider;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //role hierachy
    @Bean
    public RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        String hierarchy = "ROLE_admin > ROLE_user \n " +
                "ROLE_user > ROLE_guest";
        roleHierarchy.setHierarchy(hierarchy);
        return roleHierarchy;
    }

    //role hierachy
    @Bean
    public DefaultWebSecurityExpressionHandler expressionHandler() {
        DefaultWebSecurityExpressionHandler expressionHandler = new DefaultWebSecurityExpressionHandler();
        expressionHandler.setRoleHierarchy(roleHierarchy());
        return expressionHandler;
    }

    // h2 database 테스트가 원활하도록 관련 API 들은 전부 무시
    // swagger관련 url도 무시
    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers(
                        "/h2-console/**"
                        , "/favicon.ico"
                        , "/swagger-ui/**"
                        , "/swagger-resources/**"
                        , "/v3/api-docs"
                );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 세션을 사용하지 않는 tokken 방식을 사용하기 위해 CSRF 설정 Disable
        http.csrf().disable()

                // exception handling 할 때 우리가 만든 클래스 entypoint, denied 등.. 을 추가
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler)

                // h2-console 을 위한 설정을 추가
                .and()
                .headers()
                .frameOptions()
                .sameOrigin()

                //cors설정정
//                .and()
//                .cors()
//                .configurationSource(corsConfigurationSource())

                // 시큐리티는 기본적으로 세션을 사용
                // 여기서는 세션을 사용하지 않기 때문에 세션 설정을 Stateless 로 설정
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                // 로그인, 회원가입 API 는 토큰이 없는 상태에서 요청이 들어오기 때문에 permitAll 설정
                .and()
                .authorizeRequests()
//                .antMatchers("/test/admin")
//                .hasRole("admin")
//                .antMatchers("/test/member")
//                .hasRole("member")
                .antMatchers("/**")
                .permitAll()
                .anyRequest().authenticated()   // 나머지 API 는 전부 인증 필요

                // JwtFilter 를 addFilterBefore 로 등록했던 JwtSecurityConfig 클래스를 적용
                .and()
                .apply(new JwtSecurityConfig(tokenProvider));
    }
}
