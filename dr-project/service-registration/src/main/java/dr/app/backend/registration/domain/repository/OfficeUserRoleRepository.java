package dr.app.backend.registration.domain.repository;

import dr.app.backend.registration.domain.entity.OfficeUserRole;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfficeUserRoleRepository extends MongoRepository<OfficeUserRole, String> {
    List<OfficeUserRole> findByOfficeUserId(String officeUserId);
}
