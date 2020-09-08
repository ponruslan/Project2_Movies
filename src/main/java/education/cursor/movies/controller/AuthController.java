package education.cursor.movies.controller;

import education.cursor.movies.config.JwtProvider;
import education.cursor.movies.model.User;
import education.cursor.movies.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtProvider jwtProvider;

    @PostMapping("/auth")
    public ResponseEntity auth(@RequestBody User user) {
        try {
            String username = user.getUsername();
            String password = user.getPassword();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            User userFromDB = (User) userService.loadUserByUsername(username);

            if (userFromDB == null) {
                throw new UsernameNotFoundException("User with username: " + username + " not found");
            }
            String token = jwtProvider.generateToken(user.getUsername());
            Map<Object, Object> response = new HashMap<>();

            response.put("username", username);
            response.put("token", token);
            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }
}
