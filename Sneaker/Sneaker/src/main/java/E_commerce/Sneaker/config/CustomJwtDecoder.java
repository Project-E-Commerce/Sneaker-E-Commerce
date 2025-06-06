package E_commerce.Sneaker.config;


import E_commerce.Sneaker.Service.Authentication.AuthenticationService;
import E_commerce.Sneaker.dtos.request.IntrospectRequest;
import com.nimbusds.jose.JOSEException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.text.ParseException;
import java.util.Objects;

@Component
public class CustomJwtDecoder implements JwtDecoder {

    @Value("${jwt.signerKey}")
    private String signerKey;

    @Autowired
    private AuthenticationService authenticationService;

    private NimbusJwtDecoder nimbusJwtDecoder;

    public CustomJwtDecoder(@Value("${jwt.signerKey}") String signerKey){
        SecretKeySpec secretKey = new SecretKeySpec(signerKey.getBytes(), "HS512");
        this.nimbusJwtDecoder = NimbusJwtDecoder
                .withSecretKey(secretKey)
                .macAlgorithm(MacAlgorithm.HS512)
                .build();
    }


/*    @Bean
    NimbusJwtDecoder nimbusJwtDecoder = new NimbusJwtDecoder()*/

    @Override
    public Jwt decode(String token) throws JwtException {

        try{
           var response =  authenticationService.introspect(IntrospectRequest.builder()
                    .token(token)
                    .build());
           if(!response.isValid()){
               throw new JwtException("Invalid token");
           }
        }catch (ParseException | JOSEException e){
            throw new JwtException(e.getMessage());
        }
        return nimbusJwtDecoder.decode(token);
    }
}
