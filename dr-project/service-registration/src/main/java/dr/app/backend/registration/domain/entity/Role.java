package dr.app.backend.registration.domain.entity;

import dr.app.core.autogen.grpc.registration.RERole;
import dr.app.core.framework.utils.DateUtil;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * ロール一覧
 */
@Data
@Document(collection = "roles")
public class Role extends BasicEntity {

    // Private Variables
    // --------------------------------------------------------------------------
    /** ID */
    @Id
    private String id;
    /** ロールコード */
    @Indexed(unique = true)
    private String code;
    /** ロール名 */
    private String name;
    /** 表示順 */
    private Integer displayOrder;
    /** ロール追加日 */
    private Date added;
    /** ロール削除日 */
    private Date deleted;
    /** 機能コード */
    @Indexed
    private String functionCode;
    /** 機能表示順 */
    private Integer functionDisplayOrder;

    public RERole toRERole() {
        RERole.Builder builder = RERole.newBuilder();
        builder.setId(getId());
        builder.setCode(StringUtils.defaultString(getCode()));
        builder.setName(StringUtils.defaultString(getName()));
        builder.setDisplayOrder(getDisplayOrder());
        builder.setDeleted(StringUtils.defaultString(DateUtil.formatUTC(getDeleted())));
        builder.setCreated(StringUtils.defaultString(DateUtil.formatUTC(getCreated())));
        builder.setCreator(StringUtils.defaultString(getCreator()));
        builder.setUpdated(StringUtils.defaultString(DateUtil.formatUTC(getUpdated())));
        builder.setUpdater(StringUtils.defaultString(getUpdater()));
        return builder.build();
    }
}