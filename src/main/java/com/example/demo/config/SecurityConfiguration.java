//package com.example.demo.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//public class SecurityConfiguration {
//	@Bean
//	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
//		UserDetails admin=User.withUsername("husain").password(encoder.encode("admin")).roles("ADMIN","USER").build();
//		UserDetails user=User.withUsername("user").password(encoder.encode("user")).roles("USER").build();
//		
//		return new InMemoryUserDetailsManager(admin,user);
//		
//	}
//	
//	@Bean //if the url to be accessed without any security
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.csrf(csrf->csrf.disable()).authorizeHttpRequests(auth->
//		auth.requestMatchers("/products/retrieve","/swagger-ui/**","/swagger-ui.html/**","/v3/api-docs/**")
//		.permitAll().requestMatchers("/products/**").authenticated()).formLogin(withDefaults());
//		
//		return http.build();
//	}
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//}
