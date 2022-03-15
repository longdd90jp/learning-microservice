package dr.app.backend.registration.rpc;

import dr.app.backend.registration.service.BeaconAttendanceAreaService;
import dr.app.backend.registration.service.InstallationBeaconService;
import dr.app.backend.registration.service.LoginService;
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
    private final LoginService loginService;

    public RegistrationGrpcServer(InstallationBeaconService installationBeaconService,
                                  BeaconAttendanceAreaService beaconAttendanceAreaService,
                                  LoginService loginService) {
        this.installationBeaconService = installationBeaconService;
        this.beaconAttendanceAreaService = beaconAttendanceAreaService;
        this.loginService = loginService;
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
