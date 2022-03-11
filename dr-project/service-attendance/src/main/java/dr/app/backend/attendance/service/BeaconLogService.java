package dr.app.backend.attendance.service;

import dr.app.backend.attendance.domain.entity.BeaconLog;
import dr.app.backend.attendance.domain.repository.BeaconLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BeaconLogService {
    private final BeaconLogRepository beaconLogRepository;

    public List<BeaconLog> findBeaconLogByOffice(String officeId) {
        return beaconLogRepository.findByOfficeId("5c3c6dcf9f91b20029e248c0");
    }
}
