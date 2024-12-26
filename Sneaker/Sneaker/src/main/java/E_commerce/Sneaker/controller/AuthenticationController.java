package E_commerce.Sneaker.controller;

import E_commerce.Sneaker.Service.Authentication.AuthenticationService;
import E_commerce.Sneaker.dtos.request.IntrospectRequest;
import E_commerce.Sneaker.dtos.request.LogoutRequest;
import E_commerce.Sneaker.dtos.request.RefreshTokenRequest;
import E_commerce.Sneaker.dtos.response.ApiResponse;
import E_commerce.Sneaker.dtos.request.AuthenticationRequest;
import E_commerce.Sneaker.dtos.response.AuthenticationResponse;
import E_commerce.Sneaker.dtos.response.IntrospectResponse;
import com.nimbusds.jose.JOSEException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    /*@PostMapping("/login")
    private ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        var authResult = authenticationService.authenticateUser(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .result(authResult)
                .build();
    }*/

    @PostMapping("/login")
    private ApiResponse<AuthenticationResponse> authenticate(@RequestParam String username,
                                                                 @RequestParam String password){

        AuthenticationRequest request = new AuthenticationRequest(username, password);
        var authResult = authenticationService.authenticateUser(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .result(authResult)
                .build();
    }


    @PostMapping("/logout")
    private ApiResponse<Void> logout(@RequestBody LogoutRequest request)
            throws ParseException, JOSEException{
        authenticationService.logout(request);
        return ApiResponse.<Void>builder()
                .build();
    }

    @PostMapping("/refresh")
    private ApiResponse<AuthenticationResponse> refreshToken(@RequestBody RefreshTokenRequest request)
            throws ParseException, JOSEException {
        var authResult = authenticationService.refreshToken(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .result(authResult)
                .build();
    }

    @PostMapping("/introspect")
    private ApiResponse<IntrospectResponse> authenticate(@RequestBody IntrospectRequest request)
            throws ParseException, JOSEException {
        var authResult = authenticationService.introspect(request);
        return ApiResponse.<IntrospectResponse>builder()
                .result(authResult)
                .build();
    }
}
