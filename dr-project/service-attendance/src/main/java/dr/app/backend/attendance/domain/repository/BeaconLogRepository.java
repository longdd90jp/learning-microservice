package dr.app.backend.attendance.domain.repository;

import dr.app.backend.attendance.domain.entity.BeaconLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeaconLogRepository extends MongoRepository<BeaconLog, String>, CustomBeaconLogRepository{
    List<BeaconLog> findByOfficeId(String officeId);
}
