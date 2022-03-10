package dr.app.backend.registration.rpc;

import dr.app.backend.registration.service.BeaconAttendanceAreaService;
import dr.app.backend.registration.service.InstallationBeaconService;
import dr.app.core.autogen.grpc.registration.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class RegistrationGrpcServer extends RegistrationGrpc.RegistrationImplBase {
    private final Logger logger = LoggerFactory.getLogger(RegistrationGrpcServer.class);

    private final InstallationBeaconService installationBeaconService;
    private final BeaconAttendanceAreaService beaconAttendanceAreaService;

    public RegistrationGrpcServer(InstallationBeaconService installationBeaconService,
                                  BeaconAttendanceAreaService beaconAttendanceAreaService) {
        this.installationBeaconService = installationBeaconService;
        this.beaconAttendanceAreaService = beaconAttendanceAreaService;
    }

    @Override
    public void listInstallationBeacon(REListInstallationBeaconRequest request, StreamObserver<REListInstallationBeaconResponse> responseObserver) {
        responseObserver.onNext(installationBeaconService.listInstallationBeacon(request));
        responseObserver.onCompleted();
    }

    @Override
    public void listBeaconAttendanceArea(REListBeaconAreaRequest request,
                                         StreamObserver<REListBeaconAttendanceAreaResponse> responseObserver) {
        responseObserver.onNext(beaconAttendanceAreaService.listBeaconAttendanceArea(request));
        responseObserver.onCompleted();
    }
}
