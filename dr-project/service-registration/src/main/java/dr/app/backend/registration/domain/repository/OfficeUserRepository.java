package dr.app.backend.registration.domain.repository;

import dr.app.backend.registration.domain.entity.OfficeUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeUserRepository extends MongoRepository<OfficeUser, String> {
}
