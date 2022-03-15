package dr.app.backend.registration.domain.model;

import dr.app.core.autogen.grpc.registration.REManagementAuthority;
import lombok.Getter;

import java.util.EnumSet;

public enum ManagementAuthority {
    /** 全体管理者 */
    MP_1(REManagementAuthority.MP_1_VALUE, "全体管理者"),
    /** 所属管理者 */
    MP_2(REManagementAuthority.MP_2_VALUE, "所属管理者"),
    /** なし */
    MP_3(REManagementAuthority.MP_3_VALUE, "なし");

    @Getter
    final int code;
    @Getter final String jpLabel;

    ManagementAuthority(int code, String jpLabel) {
        this.code = code;
        this.jpLabel = jpLabel;
    }

    public REManagementAuthority asAuthority() {
        return REManagementAuthority.forNumber(code);
    }

    public REManagementAuthority asAuthorities() {
        return REManagementAuthority.forNumber(code);
    }

    public static ManagementAuthority atCode(final int code) {
        return EnumSet.allOf(ManagementAuthority.class).stream()
                .filter(s -> s.code == code)
                .findFirst()
                .orElse(null);
    }

    public static ManagementAuthority atName(final String name) {
        return EnumSet.allOf(ManagementAuthority.class).stream()
                .filter(s -> s.name().equals(name))
                .findFirst()
                .orElse(null);
    }
}
