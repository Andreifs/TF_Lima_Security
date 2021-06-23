package pe.edu.upc.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import pe.edu.upc.spring.auth.handler.LoginSuccessHandler;
import pe.edu.upc.spring.serviceimpl.JpaUserDetailsService;

public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private LoginSuccessHandler successHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		try {
			http.authorizeRequests()
			.antMatchers("/detalleDispositivoPlan/**").access("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER')")
			.antMatchers("/detalleServicioXPlan/**").access("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER')")
			.antMatchers("/dispositivo/**").access("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER')")
			.antMatchers("/pagocliente/**").access("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER')")
			.antMatchers("/pago/**").access("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER')")
			.antMatchers("/plan/**").access("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER')")
			.antMatchers("/servicio/**").access("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER')")
			.antMatchers("/welcome/**").access("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER')").and()
			.formLogin().successHandler(successHandler).loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/welcome/bienvenido")
			.permitAll().and().logout().logoutSuccessUrl("/login").permitAll().and().exceptionHandling().accessDeniedPage("/error_403");
			
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void configureGlobal(AuthenticationManagerBuilder build) throws Exception{
		build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}
	
	
}
