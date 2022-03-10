package dr.app.backend.registration.domain.respository;

import dr.app.backend.registration.domain.entity.BeaconAttendanceArea;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeaconAttendanceAreaRepository extends MongoRepository<BeaconAttendanceArea, String> {
    List<BeaconAttendanceArea> findByOfficeIdAndDeletedFalse(String officeId);
}
