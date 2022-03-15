package dr.app.backend.registration.rpc;

import dr.app.backend.registration.service.LoginService;
import dr.app.core.autogen.grpc.registration.RELoginRequest;
import dr.app.core.autogen.grpc.registration.RELoginUserResponse;
import dr.app.core.autogen.grpc.registration.RegistrationAuthGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class RegistrationAuthGrpcServer extends RegistrationAuthGrpc.RegistrationAuthImplBase {
    private final Logger logger = LoggerFactory.getLogger(RegistrationAuthGrpcServer.class);
    private final LoginService loginService;

    public RegistrationAuthGrpcServer(LoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * ログイン情報を取得します.
     */
    @Override
    public void getLoginInfo(RELoginRequest request, StreamObserver<RELoginUserResponse> observer) {
        observer.onNext(loginService.getLoginInfo(request));
        observer.onCompleted();
    }
}
