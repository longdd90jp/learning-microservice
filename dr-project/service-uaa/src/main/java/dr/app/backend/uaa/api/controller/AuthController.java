package dr.app.backend.uaa.api.controller;

import dr.app.backend.uaa.api.request.LoginRequest;
import dr.app.backend.uaa.api.request.RefreshTokenRequest;
import dr.app.backend.uaa.api.response.LoginResponse;
import dr.app.backend.uaa.api.response.RefreshTokenResponse;
import dr.app.backend.uaa.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("auth")
public class AuthController {
    private final LoginService loginService;

    @PostMapping(value = "/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        LoginResponse response = loginService.login(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/refresh-token")
    public ResponseEntity<RefreshTokenResponse> login(@RequestBody RefreshTokenRequest request) {
        RefreshTokenResponse response = loginService.refreshToken(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
