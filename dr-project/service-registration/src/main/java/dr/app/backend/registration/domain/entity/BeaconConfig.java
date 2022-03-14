package dr.app.backend.registration.domain.entity;

import dr.app.backend.registration.domain.model.BeaconType;
import dr.app.backend.registration.domain.model.InstallationType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "beacapp_config")
public class BeaconConfig extends BasicEntity {
    /** ID */
    @Id
    private String id;

    /** オフィスID */
    private String officeId;
    /** サブスクリプションId */
    private String subscriptionId;
    /** オフィスID */
    private String officeCode;
    /** APIキー */
    private String apiKey;
    /** 管理者ID */
    private String adminId;
    /** 設置種別 */
    private InstallationType installationType;
    /** バッチ実行に関するステータス */
    private Status status = Status.COMMON;

    /** バッチ実行に関するステータス */
    public enum Status {
        /** 一般的に、クロンジョブで実行される対象 */
        COMMON(0),
        /** パラメーター指定で動作している状態 */
        CUSTOM(1);

        private int status;

        Status(int status) { this.status = status; }
    }

    /** 有効かどうか */
    private boolean isBlocked;

    /** ビーコンの種類 */
    private BeaconType beaconType = BeaconType.BEACAPP;
}
