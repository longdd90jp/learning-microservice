package dr.app.backend.gateway.model;

import dr.app.core.autogen.grpc.registration.REDefaultStayReason;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DefaultStayReason {
    /**
     * 業務
     */
    WORK("業務"),
    /**
     * 自己研鑽
     */
    RESEARCH("自己研鑽"),
    /**
     * その他
     */
    OTHER("その他"),
    ;

    private final String name;

    /**
     * REDefaultStayReasonをDefaultStayReasonに変換する
     * @param reDefaultStayReason REDefaultStayReason
     * @return DefaultStayReason
     */
    public static DefaultStayReason toDefaultStayReason(final REDefaultStayReason reDefaultStayReason) {
        switch (reDefaultStayReason) {
            case WORK:
                return DefaultStayReason.WORK;
            case RESEARCH:
                return DefaultStayReason.RESEARCH;
            default:
                return DefaultStayReason.OTHER;
        }
    }
}
