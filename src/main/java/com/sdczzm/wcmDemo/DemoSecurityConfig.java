package com.sdczzm.wcmDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

/**
 * 安全认证配置类
 * @author QiHuifang
 *
 */
@Component
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter{
	
	  @Autowired
	  private MyUserDetailsService userDetailService;
	  
	  public static final String PASSWORD_ENCODER_SALT = "sdczzm";
	
	  @Override
	    protected void configure(HttpSecurity http) throws Exception {
		http.
		authorizeRequests()
				.antMatchers("/", "/index", "/login", "/logout").permitAll()
				.and().authorizeRequests().anyRequest().authenticated().and()
				.formLogin().permitAll().and().logout()
				.logoutSuccessUrl("/hello").permitAll().and().csrf().disable();
	    }

	  @Override
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	      auth.userDetailsService(userDetailService).passwordEncoder(md5PasswordEncoder());
	      auth.eraseCredentials(false);
	  }

	  
	  @Bean
	  public Md5PasswordEncoder md5PasswordEncoder() {
	      return new Md5PasswordEncoder() {
	          @Override
	          public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
	              return super.isPasswordValid(encPass, rawPass, PASSWORD_ENCODER_SALT);
	          }
	      };
	  }
	  
	  
	  public static void main(String[] args) {
		    System.out.println(new DemoSecurityConfig().md5PasswordEncoder().encodePassword("001", PASSWORD_ENCODER_SALT));
		}
}
