package dr.app.backend.uaa.api.response;

import dr.app.backend.uaa.domain.model.OfficeInfo;
import dr.app.backend.uaa.domain.model.TokenInfo;
import dr.app.backend.uaa.domain.model.UserInfo;
import lombok.Data;

@Data
public class LoginResponse {
    private TokenInfo token;
    private UserInfo user;
    private OfficeInfo office;
}
