package dr.app.backend.uaa.api.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String loginId;
    private String password;
}
