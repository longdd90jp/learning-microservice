package dr.app.backend.registration.service;

import dr.app.backend.registration.domain.entity.InstallationBeacon;
import dr.app.backend.registration.domain.repository.InstallationBeaconRepository;
import dr.app.core.autogen.grpc.registration.REInstallationBeacon;
import dr.app.core.autogen.grpc.registration.REListInstallationBeaconRequest;
import dr.app.core.autogen.grpc.registration.REListInstallationBeaconResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class InstallationBeaconService {
    private final InstallationBeaconRepository installationBeaconRepository;

    public List<InstallationBeacon> findInstallationBeaconsByOfficeId(String officeId) {
        return installationBeaconRepository.findAllByOfficeId(officeId);
    }

    /**
     * 設置用ビーコンリストを検索し、取得する
     *
     * @param request 設置用ビーコンリストの検索条件
     * @return REListInstallationBeaconResponse
     */
    public REListInstallationBeaconResponse listInstallationBeacon(final REListInstallationBeaconRequest request) {
        final String keyword = request.getKeyword();
        final String officeId = request.getOfficeId();
        final int limit = request.getLimit();
        final int offset = request.getOffset();
        final REListInstallationBeaconRequest.LinkStatus linkStatusForAttendanceArea = request.getLinkStatusForAttendanceArea();
        final REListInstallationBeaconRequest.LinkStatus linkStatusForMrManagementArea = request.getLinkStatusForMrManagementArea();

        final List<REInstallationBeacon> beacons = installationBeaconRepository.findByKeywordAndOfficeIdAndStatusesWithinLimit(keyword, officeId,
                linkStatusForAttendanceArea, linkStatusForMrManagementArea, offset, limit)
                .stream()
                .map(InstallationBeacon::buildREInstallationBeacon)
                .collect(Collectors.toList());
        final long count = installationBeaconRepository.countByKeywordAndOfficeId(keyword, officeId);
        try {
            Thread.sleep(300000);
        } catch (Exception ex) {
        }
        return REListInstallationBeaconResponse.newBuilder()
                .addAllInstallationBeacons(beacons)
                .setAllCount(count)
                .build();
    }
}
