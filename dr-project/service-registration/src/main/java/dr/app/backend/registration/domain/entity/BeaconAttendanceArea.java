package dr.app.backend.registration.domain.entity;

import dr.app.core.autogen.grpc.registration.REDefaultStayReason;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "beacon_areas")
public class BeaconAttendanceArea extends BasicEntity {
    @Id
    private String id;

    /** エリア名 */
    private String name;

    /** オフィスID */
    @Indexed
    private String officeId;

    /** 表示色 */
    private int color;

    /** デフォルトの滞在理由 */
    private DefaultStayReason defaultStayReason;

    /** ドキュメントが削除されたかどうかのフラグ */
    private boolean deleted = false;

    public enum DefaultStayReason {
        // 業務
        WORK(0),
        // 自己研鑽
        RESEARCH(1),
        // その他
        OTHER(2);

        final int type;

        DefaultStayReason(int type) {
            this.type = type;
        }

        public int getType() {
            return type;
        }
    }

    public REDefaultStayReason toREDefaultStayReason() {
        switch (defaultStayReason) {
            case WORK:
                return REDefaultStayReason.WORK;
            case RESEARCH:
                return REDefaultStayReason.RESEARCH;
            default:
                return REDefaultStayReason.UNRECOGNIZED;
        }
    }
}
