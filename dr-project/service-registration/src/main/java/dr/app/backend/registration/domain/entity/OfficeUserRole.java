package dr.app.backend.registration.domain.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * オフィスユーザロール
 */
@Data
@Document(collection = "office_user_roles")
public class OfficeUserRole extends BasicEntity {

    // Private Variables
    // --------------------------------------------------------------------------
    /** ID */
    @Id
    private String id;
    /** オフィスユーザID */
    @Indexed
    private String officeUserId;
    /** オフィスID */
    @Indexed
    private String officeId;
    /** ロールID */
    private String roleId;
    /** ロールコード */
    private String roleCode;
    /** ロール付与日時 */
    private Date added;
}
