package E_commerce.Sneaker.controller;

import E_commerce.Sneaker.Service.Authentication.AuthenticationService;
import E_commerce.Sneaker.dtos.request.IntrospectRequest;
import E_commerce.Sneaker.dtos.request.LogoutRequest;
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

    @PostMapping("/login")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        var authResult = authenticationService.authenticateUser(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .result(authResult)
                .build();
    }

    @PostMapping("/logout")
    ApiResponse<Void> logout(@RequestBody LogoutRequest request)
            throws ParseException, JOSEException{
        authenticationService.logout(request);
        return ApiResponse.<Void>builder()
                .build();
    }

    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> authenticate(@RequestBody IntrospectRequest request)
            throws ParseException, JOSEException {
        var authResult = authenticationService.introspect(request);
        return ApiResponse.<IntrospectResponse>builder()
                .result(authResult)
                .build();
    }
}
