package com.wanted.employee.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	private final AuthenticationConfiguration authenticationConfiguration;

	public static final String[] GET_PUBLIC =
			new String[] {
					"/*",
			};

	public static final String[] POST_PUBLIC =
			new String[] {
					"/*",
					"/*/**"
			};
	public static final String[] PUT_PUBLIC =
			new String[] {
					"/*",
					"/*/**"
			};
	public static final String[] DELETE_PUBLIC =
			new String[] {
					"/*",
					"/*/**"
			};

	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http.httpBasic()
				.disable()
				.csrf().disable()
				.sessionManagement(
						session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				)
				.authorizeRequests(auth ->
						auth
								.antMatchers(HttpMethod.GET, GET_PUBLIC).permitAll()
								.antMatchers(HttpMethod.POST, POST_PUBLIC).permitAll()
								.antMatchers(HttpMethod.PUT, PUT_PUBLIC).permitAll()
								.antMatchers(HttpMethod.DELETE, DELETE_PUBLIC).permitAll()
								.anyRequest().authenticated())
				.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12);
	}

	@Bean
	public AuthenticationManager authenticationManager()
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
}
