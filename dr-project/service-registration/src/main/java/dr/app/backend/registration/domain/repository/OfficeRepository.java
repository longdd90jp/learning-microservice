package dr.app.backend.registration.domain.repository;

import dr.app.backend.registration.domain.entity.Office;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeRepository extends MongoRepository<Office, String> {
}
