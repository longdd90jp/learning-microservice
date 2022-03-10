package dr.app.backend.attendance.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@Document(collection = "checking_logs")
@CompoundIndexes({
        @CompoundIndex(
                name = "checking_log_idx_01",
                def = "{'officeUserId' : 1}"
        ),
        @CompoundIndex(
                name = "checking_log_idx_02",
                def = "{'syncRequestId' : 1}"
        ),
        @CompoundIndex(
                name = "checking_log_idx_04",
                def = "{'officeUserId' : 1, 'targetDate': 2}"
        )
})
public class CheckingLog extends BasicEntity{
    @Id
    private String id;
    //事務所Id
    private String officeId;
    //所属ユーザーId
    private String officeUserId;
    //打刻機Id
    private String deviceId;
    //打刻時間
    private Date checkedAt;
    //打刻タイプ
    private CheckingType checkingType;
    //対象日
    private String targetDate; //yyyyMMdd
    //コメント
    private String comment;
    //削除フラグ
    private boolean isDeleted = false;
    //編集者ユーザーID（officeUserId）
    private String lastUpdateOfficeUserId;
    //編集時刻
    private Date lastUpdated;
    //UUID
    private String uuid;
    //編集シリアル
    private int serial;

    private String syncRequestId;

    private Boolean isPostConfirm;
}
