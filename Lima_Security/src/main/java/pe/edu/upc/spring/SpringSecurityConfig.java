package pe.edu.upc.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import pe.edu.upc.spring.auth.handler.LoginSuccessHandler;
import pe.edu.upc.spring.serviceimpl.JpaUserDetailsService;

@EnableGlobalMethodSecurity(securedEnabled=true)
@Configuration

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
			
			.antMatchers("/plan/bienvenido/**").permitAll()
			.antMatchers("/compra/listar2/**").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/detalleDispositivoPlan/**").access("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER')")
			.antMatchers("/detalleServicioXPlan/**").access("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER')")
			.antMatchers("/dispositivo/**").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/pago/listar/**").not().access("hasRole('ROLE_USER')")
			.antMatchers("/pago/**").access("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER')")
			.antMatchers("/plan/**").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/servicio/**").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/compra/**").access("hasRole('ROLE_USER')")
			.antMatchers("/welcome/**").permitAll() .and()			
			.formLogin().successHandler(successHandler).loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/plan/bienvenido")
			.permitAll().and().logout().logoutSuccessUrl("/login").permitAll().and().exceptionHandling().accessDeniedPage("/error_403");
			
			/*.antMatchers("/welcome/**").access("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER')")*/
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	


	
	public void configureGlobal(AuthenticationManagerBuilder build) throws Exception{
		build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}
	
}
