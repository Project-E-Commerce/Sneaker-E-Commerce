package E_commerce.Sneaker.dtos.request;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class RefreshTokenRequest {
    String token;
}
