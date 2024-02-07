package com.rdmfinal.ReservacionDeMesas_Final.application.service;

import com.rdmfinal.ReservacionDeMesas_Final.application.exception.DemoSecurityException;
import com.rdmfinal.ReservacionDeMesas_Final.application.lasting.EMessage;
import com.rdmfinal.ReservacionDeMesas_Final.application.lasting.ERole;
import com.rdmfinal.ReservacionDeMesas_Final.domain.dto.AuthenticationDto;
import com.rdmfinal.ReservacionDeMesas_Final.domain.dto.UserDto;
import com.rdmfinal.ReservacionDeMesas_Final.domain.entity.User;
import com.rdmfinal.ReservacionDeMesas_Final.domain.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public record AuthenticationService(
  UserRepository userRepository,
  JwtService jwtService,
  PasswordEncoder passwordEncoder,
  AuthenticationManager authenticationManager
) {

  public String register(UserDto userDto) throws DemoSecurityException {
      User user = User.builder()
        .firstName(userDto.firstName())
        .lastName(userDto.lastName())
        .email(userDto.email())
        .enable(true)
        .role(ERole.USER)
        .password(passwordEncoder().encode(userDto.password()))
        .build();

    try {
      userRepository.save(user);
      return jwtService.generateToken(user);
    } catch (RuntimeException e) {
      throw new DemoSecurityException(EMessage.USER_NOT_CREATED);
    }


  }

  public String login(AuthenticationDto authenticationDto) throws DemoSecurityException {
    authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(
        authenticationDto.email(),
        authenticationDto.password()
      )
    );
    User user = userRepository.findUserByEmail(
      authenticationDto.email()
    ).orElseThrow(
      () -> new DemoSecurityException(EMessage.USER_NOT_FOUND)
    );
    return jwtService().generateToken(user);
  }
}
