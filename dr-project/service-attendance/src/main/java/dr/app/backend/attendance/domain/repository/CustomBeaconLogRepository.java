package dr.app.backend.attendance.domain.repository;

import dr.app.backend.attendance.domain.entity.BeaconLog;

import java.util.Date;
import java.util.List;

public interface CustomBeaconLogRepository {
    List<BeaconLog> findByOfficeIdAndUserNumberBetweenDate(String officeId, String userNumber, Date start, Date end);
}
