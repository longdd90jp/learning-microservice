package dr.app.backend.registration.domain.repository;

import dr.app.backend.registration.domain.entity.InstallationBeacon;
import dr.app.core.autogen.grpc.registration.REListInstallationBeaconRequest;

import java.util.List;

public interface CustomInstallationBeaconRepository {
    List<InstallationBeacon> findAllByMacAndDeletedNotOrderByUpdated(String mac, boolean deleted);

    List<InstallationBeacon> findByKeywordAndOfficeIdAndStatusesWithinLimit(String keyword, String officeId,
                                                                            REListInstallationBeaconRequest.LinkStatus linkStatusForAttendanceArea,
                                                                            REListInstallationBeaconRequest.LinkStatus linkStatusForMrManagementArea,
                                                                            int offset, int limit);

    long countByKeywordAndOfficeId(String keyword, String officeId);
}
