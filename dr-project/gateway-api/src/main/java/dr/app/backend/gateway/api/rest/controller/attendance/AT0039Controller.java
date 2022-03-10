package dr.app.backend.gateway.api.rest.controller.attendance;

import dr.app.backend.gateway.api.rest.request.attendance.ListBeaconAttendanceAreaRequest;
import dr.app.backend.gateway.api.rest.response.attendance.ListBeaconAttendanceAreaResponse;
import dr.app.backend.gateway.service.RegistrationService;
import dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AT0039Controller extends AbstractATBaseController {
    private final RegistrationService registrationService;

    @ApiOperation(value = "ビーコンエリア一覧取得API")
    @GetMapping(value = "/dr/at/beacon/list_beacon_area")
    public ResponseEntity<ListBeaconAttendanceAreaResponse> getListBeaconArea(@RequestBody ListBeaconAttendanceAreaRequest request) {
        REListBeaconAttendanceAreaResponse response = this.registrationService.getListBeaconAttendanceArea(request.getOfficeId());
        return new ResponseEntity<>(new ListBeaconAttendanceAreaResponse(response), HttpStatus.OK);
    }
}
