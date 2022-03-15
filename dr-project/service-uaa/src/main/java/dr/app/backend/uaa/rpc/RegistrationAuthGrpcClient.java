package dr.app.backend.uaa.rpc;

import com.google.common.annotations.VisibleForTesting;
import dr.app.core.autogen.grpc.registration.RELoginRequest;
import dr.app.core.autogen.grpc.registration.RELoginUserResponse;
import dr.app.core.autogen.grpc.registration.RegistrationAuthGrpc;
import io.grpc.Channel;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RegistrationAuthGrpcClient {
    // Logger
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(RegistrationAuthGrpcClient.class);

    // Instance variables
    // ------------------------------------------------------------------------
    @GrpcClient("registration")
    private Channel channel;

    // Constructors
    // ------------------------------------------------------------------------
    public RegistrationAuthGrpcClient() {
    }

    @VisibleForTesting
    public RegistrationAuthGrpcClient(final Channel channel) {
        this.channel = channel;
    }

    // gRPC Clients
    // ------------------------------------------------------------------------
    /**
     * ログイン.
     *
     * @return ログイン情報
     */
    public RELoginUserResponse getLoginInfo(final String loginId) {
        RegistrationAuthGrpc.RegistrationAuthBlockingStub stub = RegistrationAuthGrpc.newBlockingStub(channel);
        RELoginRequest req = RELoginRequest.newBuilder().setLoginId(loginId).build();
        return stub.getLoginInfo(req);
    }
}
