package dr.app.backend.uaa.api.request;

import lombok.Data;

@Data
public class RefreshTokenRequest {
    private String accessToken;
    private String refreshToken;
}
