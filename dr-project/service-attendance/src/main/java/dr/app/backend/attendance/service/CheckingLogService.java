package dr.app.backend.attendance.service;

import dr.app.backend.attendance.api.request.ListCheckingLogRequest;
import dr.app.backend.attendance.api.response.ListCheckingLogResponse;
import dr.app.backend.attendance.domain.entity.CheckingLog;
import dr.app.backend.attendance.domain.repository.CheckingLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CheckingLogService {
    private final CheckingLogRepository checkingLogRepository;

    public ListCheckingLogResponse findCheckingLogForUser(ListCheckingLogRequest request) {
        List<CheckingLog> checkingLogs = checkingLogRepository.findCheckingLogByOfficeUserIdAndAndTargetDate(
                request.getOfficeUserId(), request.getTargetDate());
        ListCheckingLogResponse response = new ListCheckingLogResponse(checkingLogs);
        return response;
    }
}
