package com.saude.beneficiario.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.saude.beneficiario.repositories.UserRepository;
import com.saude.beneficiario.services.AuthenticationService;
import com.saude.beneficiario.services.TokenAuthenticationFilter;
import com.saude.beneficiario.services.TokenService;

@Configuration
@Order(1)
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private UserRepository repository;
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(authenticationService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        	.antMatchers(
                "/v2/api-docs", 
                "/swagger-resources/**",  
                "/swagger-ui/**", 
                "/webjars/**" ,
                "/swagger.json",
                "/actuator/**",
                "/api/**").permitAll()
        	.anyRequest().authenticated()
        	.and().csrf().disable()
        	.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        	.and().addFilterBefore(new TokenAuthenticationFilter(tokenService, repository), UsernamePasswordAuthenticationFilter.class);
    }

}