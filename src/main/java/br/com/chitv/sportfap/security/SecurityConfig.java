package br.com.chitv.sportfap.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//@Configuration
@EnableWebSecurity
//@Order(Integer.MAX_VALUE-7)
@ComponentScan(basePackages = { "br.com.chitv.sportfap" })
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("customJogadorDetailsService")
	private CustomJogadorDetailsService customUserDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/secured/**", "/views/**").hasAnyRole("ADMIN", "USER")
				.and()
			.formLogin()
				.loginPage("/public/login.xhtml")
				.loginProcessingUrl("/login")
				.defaultSuccessUrl("/secured/home.xhtml")
				.usernameParameter("username")
				.passwordParameter("password")
				.failureUrl("/public/login.xhtml?error")
				.and()
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/public/login.xhtml?logout");
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jogadorDetailsService(this.customJogadorDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

}