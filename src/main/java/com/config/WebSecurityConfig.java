package com.config;

import com.security.SecUserSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private SecUserSecurity secUserService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    protected void configure(HttpSecurity httpSecurity) throws Exception{
    httpSecurity.authorizeRequests().antMatchers("/index*","/static*//**",String.format("%s*", "/opt/img")).permitAll()
//            .antMatchers("/getAll").hasAnyRole("ADMIN","USER_ROLE").anyRequest().authenticated()
//            .antMatchers("/show").hasAnyRole("ADMIN","USER_ROLE").anyRequest().authenticated()
            .and().formLogin().loginPage("/index").permitAll()
            .defaultSuccessUrl("/getAll")
            .failureUrl("/show").usernameParameter("username")
            .passwordParameter("password")
            .and()
            .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/index").permitAll()
            .and().csrf().and().exceptionHandling().authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/index")).and().exceptionHandling().accessDeniedPage("/accessDenied");
}


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(secUserService).passwordEncoder(passwordEncoder());
    }

}
