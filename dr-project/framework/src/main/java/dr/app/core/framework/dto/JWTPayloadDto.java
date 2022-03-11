package dr.app.core.framework.dto;

import lombok.Data;

@Data
public class JWTPayloadDto {
    private String userId;
    private String username;
    private long iat;
    private long exp;
}
