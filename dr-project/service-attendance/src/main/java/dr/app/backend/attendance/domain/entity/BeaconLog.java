package dr.app.backend.attendance.domain.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "beacon_logs")
public class BeaconLog extends BasicEntity {

    @Id
    private String id;

    /** オフィスID */
    @Indexed
    private String officeId;

    /** ビーコン検知ログID */
    private Integer logId;

    /** 検知した時刻*/
    @Indexed
    private Date eventTimestamp;

    /** ビーコンのユーザナンバー */
    @Indexed
    private String userNumber;

    /** ビーコンのユーザー名 */
    private String userName;

    /** 所属名 */
    private String departmentName;

    /** フロア名 */
    private String floorName;

    /** ビーコン名 */
    private String beaconName;

    /** インストール済みデバイス */
    private String installedDeviceName;

    /** マップ名 */
    private String mapImageName;

    /** rssi */
    private String rssi;

    /** 横座標名 */
    private Long coordinateX;

    /** 縦座標名 */
    private Long coordinateY;

    /** 取得先 */
    private Origin origin;

    public enum Origin {
        BEACAPP(0),
        DRJOY(1);

        final int type;

        Origin(int type) {
            this.type = type;
        }

        public int getType() {
            return type;
        }
    }
}
