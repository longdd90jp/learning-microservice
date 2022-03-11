package dr.app.backend.attendance.api.controller;

import dr.app.backend.attendance.api.request.ListCheckingLogRequest;
import dr.app.backend.attendance.api.response.ListCheckingLogResponse;
import dr.app.backend.attendance.service.CheckingLogService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AT0023Controller {
    private final CheckingLogService checkingLogService;

    @GetMapping(value = "/dr/log/list_checking_log")
    public ResponseEntity<ListCheckingLogResponse> getListCheckingLog(@RequestBody ListCheckingLogRequest request) {
        ListCheckingLogResponse response = checkingLogService.findCheckingLogForUser(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
