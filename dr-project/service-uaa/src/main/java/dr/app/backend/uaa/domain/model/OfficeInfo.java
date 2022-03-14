package dr.app.backend.uaa.domain.model;

import lombok.Data;

@Data
public class OfficeInfo {
    private String officeId;
    private String name;
    private OfficeType officeType;
}
