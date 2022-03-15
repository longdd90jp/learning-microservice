package dr.app.backend.registration.service;

import dr.app.backend.registration.domain.entity.BeaconAttendanceArea;
import dr.app.backend.registration.domain.repository.BeaconAttendanceAreaRepository;
import dr.app.core.autogen.grpc.registration.REBeaconAttendanceArea;
import dr.app.core.autogen.grpc.registration.REBeaconType;
import dr.app.core.autogen.grpc.registration.REListBeaconAreaRequest;
import dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class BeaconAttendanceAreaService {
    private final BeaconAttendanceAreaRepository beaconAttendanceAreaRepository;

    public REListBeaconAttendanceAreaResponse listBeaconAttendanceArea(final REListBeaconAreaRequest request) {
        // get areas
        List<BeaconAttendanceArea> beaconAttendanceAreas = beaconAttendanceAreaRepository.findByOfficeIdAndDeletedFalse(request.getOfficeId());
        // mapping to grpc
        List<REBeaconAttendanceArea> reBeaconAttendanceAreas = beaconAttendanceAreas.stream()
                .map(area -> {
                    final String key = area.getId();
                    return REBeaconAttendanceArea.newBuilder()
                            .setId(area.getId())
                            .setName(area.getName())
                            .setDefaultStayReason(area.toREDefaultStayReason())
                            .setColor(area.getColor())
                            .setLinkedBeaconCount(0)
                            .setOfficeId(area.getOfficeId())
                            .setBeaconType(REBeaconType.DRJOY)
                            .build();
                }).collect(Collectors.toList());
        // return
        return REListBeaconAttendanceAreaResponse.newBuilder()
                .addAllBeaconAttendanceArea(reBeaconAttendanceAreas)
                .setNotLinkedBeaconCount(0)
                .setAllCount(beaconAttendanceAreas.size())
                .build();
    }
}
