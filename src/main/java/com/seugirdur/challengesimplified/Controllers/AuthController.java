package com.seugirdur.challengesimplified.Controllers;

import com.seugirdur.challengesimplified.Dtos.AuthenticationDto;
import com.seugirdur.challengesimplified.Dtos.RegisterDto;
import com.seugirdur.challengesimplified.Services.AuthenticateService;
import com.seugirdur.challengesimplified.configs.security.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticateService authenticateService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterDto registerDto
    ) {
        return ResponseEntity.ok(authenticateService.register(registerDto));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationDto authenticationDto
    ) {
        return ResponseEntity.ok(authenticateService.authenticate(authenticationDto));

    }

}
