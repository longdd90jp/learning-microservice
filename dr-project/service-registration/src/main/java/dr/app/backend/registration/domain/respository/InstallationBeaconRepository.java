package dr.app.backend.registration.domain.respository;

import dr.app.backend.registration.domain.entity.InstallationBeacon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstallationBeaconRepository extends MongoRepository<InstallationBeacon, String>, CustomInstallationBeaconRepository {
    List<InstallationBeacon> findAllByOfficeId(String officeId);
}
