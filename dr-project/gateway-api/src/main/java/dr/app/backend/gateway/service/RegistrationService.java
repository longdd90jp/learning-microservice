package dr.app.backend.gateway.service;

import dr.app.core.autogen.grpc.registration.REListBeaconAreaRequest;
import dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse;
import dr.app.core.autogen.grpc.registration.RegistrationGrpc;
import io.grpc.Channel;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @GrpcClient(value = "registration")
    private Channel registrationChannel;

    public REListBeaconAttendanceAreaResponse getListBeaconAttendanceArea(final String officeId) {
        RegistrationGrpc.RegistrationBlockingStub stub = RegistrationGrpc.newBlockingStub(registrationChannel);
        REListBeaconAreaRequest request = REListBeaconAreaRequest.newBuilder()
                .setOfficeId(officeId)
                .build();
        return stub.listBeaconAttendanceArea(request);
    }
}
