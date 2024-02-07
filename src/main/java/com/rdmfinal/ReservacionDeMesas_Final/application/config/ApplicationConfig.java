package com.rdmfinal.ReservacionDeMesas_Final.application.config;

import lombok.RequiredArgsConstructor;
import com.rdmfinal.ReservacionDeMesas_Final.application.lasting.EMessage;
import com.rdmfinal.ReservacionDeMesas_Final.domain.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

  private final UserRepository userRepository;

  @Bean
  public UserDetailsService userDetailsService() {
    return username -> userRepository.findUserByEmail(username)
      .orElseThrow(() -> new UsernameNotFoundException(
        EMessage.USER_NOT_FOUND.getMessage()
      ));
  }

  @Bean
  public AuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authenticationProvider
      = new DaoAuthenticationProvider();
    // Indexar el UserDetailsService
    authenticationProvider.setUserDetailsService(
      userDetailsService()
    );
    // Indexar el cifrado de contraseñas
    authenticationProvider.setPasswordEncoder(
      passwordEncoder()
    );
    return authenticationProvider;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public AuthenticationManager authenticationManager(
    AuthenticationConfiguration configuration
  ) throws Exception {
    return configuration.getAuthenticationManager();
  }

}
