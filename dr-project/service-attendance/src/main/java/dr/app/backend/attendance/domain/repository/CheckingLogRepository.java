package dr.app.backend.attendance.domain.repository;

import dr.app.backend.attendance.domain.entity.CheckingLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckingLogRepository extends MongoRepository<CheckingLog, String> {
    public List<CheckingLog> findCheckingLogByOfficeUserIdAndAndTargetDate(String officeUserId, String targetDate);
}
