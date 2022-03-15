package dr.app.backend.registration.domain.entity;

import com.google.common.collect.Lists;
import dr.app.backend.registration.domain.model.ManagementAuthority;
import dr.app.backend.registration.domain.model.OfficeType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "officeUser")
@CompoundIndexes({
        @CompoundIndex(
                name = "user_class_account_statuses",
                def = "{'_class' : 1, 'accountStatuses' : 1}"
        ),
        @CompoundIndex(
                def = "{ 'created': 1 }",
                name = "created"
        ),
        @CompoundIndex(
                def = "{ 'firstEntryUpdated': 1 }",
                name = "first_entry_updated",
                sparse = true
        )}
)
public class OfficeUser {
    /** ID */
    @Id private String id;

    private String oldId;

    /** ユーザID */
    @Indexed
    private String userId;

    /** 事業所ID */
    @Indexed
    private String officeId;

    /** ログインID */
    @Indexed
    private String loginId;

    /** メールアドレス */
    @Indexed
    private String mailAddress;

    /** 仮パスワード*/
    private String temporaryPassword;

    /** 追加メールアドレス */
    @Indexed
    private List<String> additionalMailAddresses = Lists.newArrayList();

    /** 事業所区分 */
    @Indexed
    private OfficeType officeType;

    /** 所属ID */
    private String departmentId;

    /** 名 */
    private String firstName;

    /** 姓 */
    private String lastName;

    /** 名(かな) */
    private String firstNameKana;

    /** 姓(かな) */
    private String lastNameKana;

    /** 生年月日 */
    private Date birthDate;

    /** アカウントステータス */
    private int accountStatuses;

    // list areaType
    private List<String> areaTypeList = new ArrayList<>();

    /** 本人確認日時 */
    private Date identityVerificationDate;

    // First entry successfully
    private Date firstEntryUpdated;

    /** 管理権限 */
    private ManagementAuthority managementAuthority;
}
