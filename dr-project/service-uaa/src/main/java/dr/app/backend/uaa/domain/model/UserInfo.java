package dr.app.backend.uaa.domain.model;

import lombok.Data;

@Data
public class UserInfo {
    private String userId;
    private String officeUserId;
    private OfficeType officeType;
    private String firstName;
    private String lastName;
}
