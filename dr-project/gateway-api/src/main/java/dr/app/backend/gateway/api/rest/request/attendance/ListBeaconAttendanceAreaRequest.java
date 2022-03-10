package dr.app.backend.gateway.api.rest.request.attendance;

import lombok.Data;

@Data
public class ListBeaconAttendanceAreaRequest extends BaseATRequest {
    private String officeId;
}
