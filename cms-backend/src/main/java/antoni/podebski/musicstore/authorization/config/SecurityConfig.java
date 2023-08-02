package antoni.podebski.musicstore.authorization.config;

import antoni.podebski.musicstore.authorization.OperatorAuthenticationEntryPoint;
import antoni.podebski.musicstore.authorization.OperatorAuthenticationHandler;
import antoni.podebski.musicstore.authorization.OperatorAuthenticationProvider;
import antoni.podebski.musicstore.authorization.OperatorLogoutHandler;
import antoni.podebski.musicstore.authorization.principal.OperatorPrincipalService;
import antoni.podebski.musicstore.operator.repository.OperatorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

	@Value("${http.headers.cors.allowed.origins:}")
	private String[] corsOirigins;

	private final ObjectMapper mapper;

	public SecurityConfig(ObjectMapper mapper) {
		this.mapper = mapper;
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public OperatorPrincipalService principalService(OperatorRepository repository) {
		return new OperatorPrincipalService(repository);
	}

	@Bean
	public OperatorAuthenticationProvider authenticationProvider(BCryptPasswordEncoder passwordEncoder,
			OperatorPrincipalService operatorPrincipalService) {
		return new OperatorAuthenticationProvider(passwordEncoder, operatorPrincipalService);
	}

	@Bean
	public OperatorAuthenticationHandler authenticationHandler() {
		return new OperatorAuthenticationHandler(mapper);
	}

	@Bean
	public OperatorAuthenticationEntryPoint authenticationEntryPoint() {
		return new OperatorAuthenticationEntryPoint(mapper);
	}

	@Bean
	public OperatorLogoutHandler logoutHandler() {
		return new OperatorLogoutHandler();
	}

	@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor() {
		return new MethodValidationPostProcessor();
	}

	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http, OperatorAuthenticationProvider provider) throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class).authenticationProvider(provider).build();
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();

		if (corsOirigins.length > 0)
			corsConfiguration.setAllowedOrigins(Arrays.asList(corsOirigins));

		corsConfiguration.setAllowedMethods(
				List.of(HttpMethod.GET.name(), HttpMethod.POST.name(), HttpMethod.DELETE.name(), HttpMethod.OPTIONS.name(),
						HttpMethod.PUT.name()));

		corsConfiguration.setAllowedHeaders(List.of(HttpHeaders.AUTHORIZATION, HttpHeaders.CONTENT_TYPE));
		corsConfiguration.setAllowCredentials(true);

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfiguration);

		return source;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {
		OperatorAuthenticationHandler authenticationHandler = authenticationHandler();
		//@formatter:off
		return http
				.exceptionHandling()
					.authenticationEntryPoint(authenticationEntryPoint())
				.and()
				.authorizeHttpRequests()
					.requestMatchers("/api/login").permitAll()
					.anyRequest().permitAll()
//					.anyRequest().authenticated()
				.and()
				.anonymous().disable()
				.formLogin()
					.loginProcessingUrl("/api/login")
					.successHandler(authenticationHandler)
					.failureHandler(authenticationHandler)
				.and()
				.logout()
					.logoutUrl("/api/logout")
					.invalidateHttpSession(true)
					.clearAuthentication(true)
					.logoutSuccessHandler(logoutHandler())
				.and()
				.authenticationManager(authenticationManager)
				.cors()
				.and()
				.csrf().disable()
				.build();
		//@formatter:on
	}

}
