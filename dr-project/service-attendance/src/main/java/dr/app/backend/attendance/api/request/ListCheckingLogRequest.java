package dr.app.backend.attendance.api.request;

import lombok.Data;

@Data
public class ListCheckingLogRequest {
    private String officeUserId;
    private String targetDate;
}
