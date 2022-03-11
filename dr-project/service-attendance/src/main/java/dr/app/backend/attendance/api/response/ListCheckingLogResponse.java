package dr.app.backend.attendance.api.response;

import dr.app.backend.attendance.domain.entity.CheckingLog;
import dr.app.backend.attendance.domain.entity.CheckingType;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class ListCheckingLogResponse {
    private List<CheckingLogResponse> checkingLogs;

    @Data
    public static class CheckingLogResponse {
        private String id;
        //事務所Id
        private String officeId;
        //所属ユーザーId
        private String officeUserId;
        //打刻時間
        private Date checkedAt;
        //打刻タイプ
        private CheckingType checkingType;
        //対象日
        private String targetDate; //yyyyMMdd
        //コメント
        private String comment;

        private Boolean isPostConfirm;
    }

    public ListCheckingLogResponse(List<CheckingLog> checkingLogEntityList) {
        checkingLogs = new ArrayList<>();
        checkingLogEntityList.forEach(item -> {
            CheckingLogResponse checkingLogResponse = new CheckingLogResponse();
            BeanUtils.copyProperties(item, checkingLogResponse);
            checkingLogs.add(checkingLogResponse);
        });
    }
}
