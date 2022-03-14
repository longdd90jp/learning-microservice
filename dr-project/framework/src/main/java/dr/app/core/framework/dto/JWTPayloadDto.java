package dr.app.core.framework.dto;

import lombok.Data;

@Data
public class JWTPayloadDto {
    private String officeId;
    private String officeUserId;
}
