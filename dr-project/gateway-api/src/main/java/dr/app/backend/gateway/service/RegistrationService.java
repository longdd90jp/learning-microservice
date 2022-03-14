package dr.app.backend.gateway.service;

import io.grpc.Channel;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RegistrationService {
    @GrpcClient("registration")
    private Channel registrationChannel;
}
