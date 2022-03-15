package dr.app.backend.uaa.service;

import dr.app.backend.uaa.api.request.LoginRequest;
import dr.app.backend.uaa.api.response.LoginResponse;
import dr.app.backend.uaa.rpc.RegistrationAuthGrpcClient;
import dr.app.core.autogen.grpc.registration.RELoginUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    // Instance variables
    // ------------------------------------------------------------------------
    private RegistrationAuthGrpcClient registrationAuthGrpcClient;

    // Constructors
    // ------------------------------------------------------------------------
    @Autowired
    public LoginService(RegistrationAuthGrpcClient registrationAuthGrpcClient) {
        this.registrationAuthGrpcClient = registrationAuthGrpcClient;
    }

    // Methods
    // ------------------------------------------------------------------------

    public LoginResponse login(LoginRequest request) {
        RELoginUserResponse reLoginUserResponse = registrationAuthGrpcClient.getLoginInfo(request.getLoginId());
    }
}
