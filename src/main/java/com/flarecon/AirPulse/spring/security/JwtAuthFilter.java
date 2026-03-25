package com.flarecon.AirPulse.spring.security;

import com.flarecon.AirPulse.Constants;
import com.flarecon.AirPulse.utils.jwt.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String authHeader = request.getHeader(Constants.TOKEN_HEADER_KEY);
        if (authHeader != null && authHeader.startsWith((Constants.TOKEN_PREFIX))) {
            String token = authHeader.substring(Constants.TOKEN_PREFIX.length());

            if (jwtUtil.validateToken(token)) {
                String username = jwtUtil.checkExpirationAndExtractUsername(token);
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, null, List.of());
                SecurityContextHolder.getContext().setAuthentication(auth);
                log.info("authenticated {}", username);
            }
            else {
                log.error("auth failed");
            }
        }

        filterChain.doFilter(request, response);
    }
}
