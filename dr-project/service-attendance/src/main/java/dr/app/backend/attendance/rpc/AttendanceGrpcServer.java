package dr.app.backend.attendance.rpc;

import dr.app.backend.attendance.service.BeaconLogService;
import dr.app.core.autogen.grpc.attendance.AttendanceGrpc;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class AttendanceGrpcServer extends AttendanceGrpc.AttendanceImplBase {
    private static Logger logger = LoggerFactory.getLogger(AttendanceGrpcServer.class);

    private final BeaconLogService beaconLogService;

    @Autowired
    public AttendanceGrpcServer(BeaconLogService beaconLogService) {
        this.beaconLogService = beaconLogService;
    }
}
