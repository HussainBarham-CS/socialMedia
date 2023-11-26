package com.example.socialmedia.Controller.UserController;

import com.example.socialmedia.CurrentUser;
import com.example.socialmedia.Security.AppUserService;
import com.example.socialmedia.Security.JwtResponse;
import com.example.socialmedia.Security.SignInRequest;
import com.example.socialmedia.Security.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/v1/sparx/user/getNewToken")
public class NewTokenByRefreshToken extends CurrentUser {

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private AppUserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public JwtResponse getNewToken() {
        SignInRequest signInRequest =SignInRequest.builder()
                .username(getCurrentUser().getUsername())
                .password(getCurrentUser().getPassword())
                .build();

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = userService.loadUserByUsername(signInRequest.getUsername());
        String token = tokenUtil.generateToken(userDetails);
        String refreshToken = tokenUtil.generateRewfreshToken(userDetails);

        JwtResponse response = JwtResponse.builder()
                .token(token)
                .refreshToken(refreshToken)
                .expirationToken(String.valueOf(tokenUtil.getClaims(token).getExpiration()))
                .expirationRefreshToken(String.valueOf(tokenUtil.getClaims(refreshToken).getExpiration()))
                .tokenType("Bearer")
                .build();
        return response;
    }

}