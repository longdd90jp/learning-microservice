package dr.app.backend.uaa.service;

import dr.app.backend.uaa.api.request.LoginRequest;
import dr.app.backend.uaa.api.request.RefreshTokenRequest;
import dr.app.backend.uaa.api.response.LoginResponse;
import dr.app.backend.uaa.api.response.RefreshTokenResponse;
import dr.app.backend.uaa.domain.model.OfficeInfo;
import dr.app.backend.uaa.domain.model.OfficeType;
import dr.app.backend.uaa.domain.model.TokenInfo;
import dr.app.backend.uaa.domain.model.UserInfo;
import dr.app.backend.uaa.rpc.RegistrationAuthGrpcClient;
import dr.app.core.autogen.grpc.registration.RELoginUserResponse;
import dr.app.core.autogen.grpc.registration.REOfficeInfo;
import dr.app.core.autogen.grpc.registration.REUserInfo;
import dr.app.core.framework.constant.ErrorCode;
import dr.app.core.framework.dto.GeneratedTokenDto;
import dr.app.core.framework.dto.JWTPayloadDto;
import dr.app.core.framework.utils.JwtTokenUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LoginService {
    // Instance variables
    // ------------------------------------------------------------------------
    private JwtTokenUtil jwtTokenUtil;
    private RegistrationAuthGrpcClient registrationAuthGrpcClient;

    // Constructors
    // ------------------------------------------------------------------------
    @Autowired
    public LoginService(RegistrationAuthGrpcClient registrationAuthGrpcClient, JwtTokenUtil jwtTokenUtil) {
        this.registrationAuthGrpcClient = registrationAuthGrpcClient;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    // Methods
    // ------------------------------------------------------------------------

    public LoginResponse login(LoginRequest request) {
        LoginResponse response = new LoginResponse();
        RELoginUserResponse reLoginUserResponse = registrationAuthGrpcClient.getLoginInfo(request.getLoginId());

        // validate password
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(!encoder.matches(request.getPassword(), reLoginUserResponse.getPassword())) {
            throw new IllegalArgumentException("Invalid user name or password");
        }
        // token
        response.setToken(buildTokenInfo(reLoginUserResponse));
        // office info
        response.setOffice(buildOfficeInfo(reLoginUserResponse));
        // user info
        response.setUser(buildUserInfo(reLoginUserResponse));
        return response;
    }

    private TokenInfo buildTokenInfo(RELoginUserResponse reLoginUser) {
        JWTPayloadDto payloadDto = new JWTPayloadDto();
        payloadDto.setUserId(reLoginUser.getUserId());
        payloadDto.setOfficeUserId(reLoginUser.getOfficeUserId());
        payloadDto.setOfficeId(reLoginUser.getOfficeId());
        payloadDto.setOfficeType(reLoginUser.getUserInfo().getOfficeType().name());

        long targetTime = new Date().getTime();
        TokenInfo tokenInfo = new TokenInfo();

        // access token
        GeneratedTokenDto tokenDto = jwtTokenUtil.generateAccessToken(payloadDto, targetTime);
        tokenInfo.setAccessToken(tokenDto.getGeneratedToken());
        tokenInfo.setAccessTokenExpireTime(tokenDto.getExpireTime());

        // refresh token
        tokenDto = jwtTokenUtil.generateRefreshToken(targetTime);
        tokenInfo.setRefreshToken(tokenDto.getGeneratedToken());
        tokenInfo.setRefreshTokenExpireTime(tokenDto.getExpireTime());
        return tokenInfo;
    }

    private UserInfo buildUserInfo(RELoginUserResponse reLoginUser) {
        UserInfo userInfo = new UserInfo();
        REUserInfo reUserInfo = reLoginUser.getUserInfo();
        userInfo.setUserId(reLoginUser.getUserId());
        userInfo.setOfficeUserId(reLoginUser.getOfficeUserId());
        userInfo.setFirstName(reUserInfo.getFirstName());
        userInfo.setLastName(reUserInfo.getLastName());
        userInfo.setOfficeType(OfficeType.valueOf(reUserInfo.getOfficeType().name()));
        return userInfo;
    }

    private OfficeInfo buildOfficeInfo(RELoginUserResponse reLoginUser) {
        OfficeInfo officeInfo = new OfficeInfo();
        REOfficeInfo reOfficeInfo = reLoginUser.getOfficeInfo();
        officeInfo.setOfficeId(reLoginUser.getOfficeId());
        officeInfo.setName(reOfficeInfo.getName());
        officeInfo.setOfficeType(OfficeType.valueOf(reOfficeInfo.getOfficeType().name()));
        return officeInfo;
    }

    public RefreshTokenResponse refreshToken(RefreshTokenRequest request) {
        RefreshTokenResponse response = new RefreshTokenResponse();

        // verify refresh token
        String errorCode = jwtTokenUtil.verifyJWTRefreshToken(request.getRefreshToken());
        if(StringUtils.isNotEmpty(errorCode)) {
            response.setErrorCode(errorCode);
            return response;
        }

        // verify access token
        errorCode = jwtTokenUtil.verifyJWTAccessToken(request.getAccessToken());
        if(StringUtils.isNotEmpty(errorCode) && !ErrorCode.ERR_TOKEN_001.equals(errorCode)) {
            response.setErrorCode(errorCode);
            return response;
        }

        // refresh token
        long targetTime = new Date().getTime();
        try {
            JWTPayloadDto payloadDto = jwtTokenUtil.getPayloadFromJWT(request.getAccessToken());
            response.setAccessToken(jwtTokenUtil.generateAccessToken(payloadDto, targetTime).getGeneratedToken());
        } catch (Exception ex) {
            response.setErrorCode(ErrorCode.ERR_COMMON_001);
            return response;
        }
        response.setRefreshToken(jwtTokenUtil.generateRefreshToken(targetTime).getGeneratedToken());
        return response;
    }
}
