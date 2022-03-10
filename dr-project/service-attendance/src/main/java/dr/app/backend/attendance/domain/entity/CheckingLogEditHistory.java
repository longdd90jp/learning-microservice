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
@Document(collection = "checking_log_edit_histories")
@CompoundIndexes({
        @CompoundIndex(
                name = "checking_log_edit_histories_idx_01",
                def = "{'officeUserId' : 1, 'targetDate': 2, 'isDeleted':3}"
        )
})
public class CheckingLogEditHistory extends BasicEntity {
    @Id
    private String id;
    //所属ユーザーId
    private String officeUserId;
    //打刻機Id
    private String deviceId;
    //打刻時間
    private Date checkedAt;
    //打刻タイプ
    private CheckingType checkingType;
    //対象日
    private String targetDate;
    //コメント
    private String comment;
    //削除フラグ
    private boolean isDeleted;
    //編集者ユーザーID（officeUserId）
    private String lastUpdateOfficeUserId;
    //編集時刻
    private Date lastUpdated;
    //編集シリアル
    private int serial;
    //UUID
    private String uuid;

    private Boolean isPostConfirm;
}
