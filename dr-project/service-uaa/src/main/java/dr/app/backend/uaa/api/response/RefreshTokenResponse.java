package dr.app.backend.uaa.api.response;

import lombok.Data;

@Data
public class RefreshTokenResponse {
    private String errorCode;
    private String accessToken;
    private String refreshToken;
}
