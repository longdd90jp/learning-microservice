package dr.app.backend.uaa.service;

import dr.app.core.autogen.grpc.registration.REInstallationBeacon;
import dr.app.core.autogen.grpc.registration.REListInstallationBeaconRequest;
import dr.app.core.autogen.grpc.registration.REListInstallationBeaconResponse;
import dr.app.core.autogen.grpc.registration.RegistrationGrpc;
import io.grpc.Channel;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RegistrationService {
    @GrpcClient("registration")
    private Channel registrationChannel;

    public List<REInstallationBeacon> listInstallationBeacon() {
        REListInstallationBeaconRequest request = REListInstallationBeaconRequest.newBuilder()
                .setKeyword(StringUtils.EMPTY)
                .setOfficeId("5cd4c619470f5b00280c52e4")
                .setOffset(0)
                .setLimit(10)
                .setLinkStatusForAttendanceArea(REListInstallationBeaconRequest.LinkStatus.ALL)
                .setLinkStatusForMrManagementArea(REListInstallationBeaconRequest.LinkStatus.ALL)
                .build();
        final RegistrationGrpc.RegistrationBlockingStub stub = RegistrationGrpc.newBlockingStub(registrationChannel);
        final REListInstallationBeaconResponse response = stub.listInstallationBeacon(request);

        List<REInstallationBeacon> installationBeacons = response.getInstallationBeaconsList();
        return installationBeacons;
    }
}
