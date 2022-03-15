package dr.app.backend.registration.service;

import dr.app.backend.registration.domain.entity.Office;
import dr.app.backend.registration.domain.entity.OfficeUser;
import dr.app.backend.registration.domain.entity.OfficeUserRole;
import dr.app.backend.registration.domain.entity.User;
import dr.app.backend.registration.domain.model.OfficeType;
import dr.app.backend.registration.domain.repository.*;
import dr.app.core.autogen.grpc.registration.RELoginRequest;
import dr.app.core.autogen.grpc.registration.RELoginUserResponse;
import dr.app.core.framework.constant.Message;
import dr.app.core.framework.grpc.ServiceStatus;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final OfficeRepository officeRepository;
    private final UserRepository userRepository;
    private final OfficeUserRepository officeUserRepository;
    private final RoleRepository roleRepository;
    private final OfficeUserRoleRepository officeUserRoleRepository;

    /**
     * ログイン情報を取得する.
     *
     * @param request {@link RELoginRequest}
     * @return {@link RELoginUserResponse}
     */
    public RELoginUserResponse getLoginInfo(final RELoginRequest request) {
        // user info
        User user = userRepository.findFirstByLoginId(request.getLoginId());

        // check user
        if (user == null) {
            throw ServiceStatus.INVALID_ARGUMENT.withMessage("Notfound user")
                    .addError(Message.RE0022_E001_1).asStatusRuntimeException();
        }
        // check office user
        if (user.getOfficeUsers().isEmpty() || user.getOfficeUsers().get(0) == null) {
            throw ServiceStatus.INVALID_ARGUMENT.withMessage("Notfound user office")
                    .addError(Message.RE0022_E001_1).asStatusRuntimeException();
        }

        return createLoginUserResponse(user).build();
    }

    private RELoginUserResponse.Builder createLoginUserResponse(final User user) {
        return createLoginUserResponse(user, user.getOfficeUsers().get(0));
    }

    private RELoginUserResponse.Builder createLoginUserResponse(final User user,
                                                                final OfficeUser officeUser) {
        List<OfficeUserRole> officeUserRoles =
                officeUserRoleRepository.findByOfficeUserId(officeUser.getId());
        Optional<Office> officeOpt = officeRepository.findById(officeUser.getOfficeId());
        if (!officeOpt.isPresent()) {
            String msg = String.format("Office is not found. office_id=%s", officeUser.getOfficeId());
            throw ServiceStatus.INTERNAL.withMessage(msg).asStatusRuntimeException();
        }
        return createLoginUserResponse(user, officeUser, officeOpt.get(), officeUserRoles);
    }

    private RELoginUserResponse.Builder createLoginUserResponse(final User user,
                                                                final OfficeUser officeUser,
                                                                final Office office,
                                                                final List<OfficeUserRole> officeUserRoles) {
        RELoginUserResponse.Builder builder = RELoginUserResponse.newBuilder();
        builder.setUserId(user.getId());
        builder.setLoginId(user.getLoginId());
        builder.setPassword(user.getPassword());
        builder.setOfficeId(officeUser.getOfficeId());
        builder.setOfficeUserId(officeUser.getId());
        builder.setAccountStatuses(officeUser.getAccountStatuses());
        builder.setOfficeType(officeUser.getOfficeType().toMessage());
        if (OfficeType.MEDICAL == officeUser.getOfficeType()
                || OfficeType.DRUG_STORE == officeUser.getOfficeType()) {
            builder.setManagementAuthority(officeUser.getManagementAuthority().asAuthority());
        }
        builder.setPersonalFlag(user.isPersonalFlag());
        officeUserRoles.forEach(officeUserRole -> {
            builder.addRoleCodes(officeUserRole.getRoleCode());
        });
        builder.setOfficeSessionExpiration(office.getOfficeSessionExpiration());
        return builder;
    }
}
