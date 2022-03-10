package dr.app.backend.registration.domain.entity;

import dr.app.core.autogen.grpc.registration.REInstallationBeacon;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "installation_beacons")
public class InstallationBeacon extends BasicEntity {
    @Id
    private String id;

    /**
     * オフィスID
     */
    @Indexed
    private String officeId;

    /**
     * ビーコン勤怠エリアID
     */
    private String beaconAttendanceAreaId;

    /**
     * ビーコンMr管理エリアID
     */
    private String beaconMrManagementAreaId;

    /**
     * ビーコン名
     */
    private String name;

    /**
     * MACアドレス
     */
    private String mac;

    /**
     * iBeaconにおけるUUID
     */
    private String uuid;

    /**
     * iBeaconにおけるMajor値
     */
    private Integer major;

    /**
     * iBeaconにおけるMinor値
     */
    private Integer minor;

    /**
     * 備考
     */
    private String note;

    /**
     * MQTTデバイスとして登録するかどうかのフラグ
     */
    private boolean isMqttDevice;

    /**
     * ドキュメントが削除されたかどうかのフラグ
     */
    private boolean deleted = false;

    /**
     * InstallationBeaconAreaLinkHistoryのId（ビーコン勤怠エリア紐付け履歴）のリスト
     */
    private List<String> attendanceAreaHistoryIds;

    /**
     * InstallationBeaconAreaLinkHistoryのId（ビーコンMr管理エリア紐付け履歴）のリスト
     */
    private List<String> mrManagementAreaHistoryIds;

    /**
     * ビーコン情報をREInstallationBeaconに変換する
     *
     * @param beacon ビーコン情報
     * @return REInstallationBeacon
     */
    public static REInstallationBeacon buildREInstallationBeacon(InstallationBeacon beacon) {
        final REInstallationBeacon.Builder builder = REInstallationBeacon.newBuilder()
                .setInstallationBeaconId(StringUtils.defaultString(beacon.getId()))
                .setName(StringUtils.defaultString(beacon.getName()))
                .setOfficeId(StringUtils.defaultString(beacon.getOfficeId()))
                .setMac(StringUtils.defaultString(beacon.getMac()))
                .setUuid(StringUtils.defaultString(beacon.getUuid()))
                .setNote(StringUtils.defaultString(beacon.getNote()))
                .setIsMqttDevice(beacon.isMqttDevice())
                .setLinkedBeaconAttendanceAreaId(StringUtils.defaultString(beacon.getBeaconAttendanceAreaId()))
                .setLinkedBeaconMrManagementAreaId(StringUtils.defaultString(beacon.getBeaconMrManagementAreaId()))
                .setDeleted(beacon.isDeleted())
                .setUpdated(beacon.getUpdated().getTime());
        if (beacon.getMajor() != null) {
            builder.setMajor(beacon.getMajor());
        }
        if (beacon.getMinor() != null) {
            builder.setMinor(beacon.getMinor());
        }
        return builder.build();
    }
}
