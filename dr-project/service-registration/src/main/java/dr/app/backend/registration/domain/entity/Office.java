package dr.app.backend.registration.domain.entity;

import com.google.common.collect.Lists;
import dr.app.backend.registration.domain.model.AreaType;
import dr.app.backend.registration.domain.model.OfficeType;
import lombok.Data;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "office")
@CompoundIndexes({
        @CompoundIndex(
                name = "office_idx_1",
                def = "{'areaType.typeId' : 1}"
        )
})
public class Office extends BasicEntity{

    /** 事業所ID（旧システムのoffices.idから移行する） */
    private String oldId;

    /** オフィスID (医療機関でない場合: 業者マスタID, 医療機関の場合: 医療機関マスタID） */
    @Id
    private String id;

    /** オフィス名称 */
    @Indexed
    private String name;

    /** オフィス名称（カナ） */
    @Indexed
    private String nameKana;

    /** オフィス名称（イニシャル）*/
    private String nameInitial;

    /** オフィス名称（略称） */
    private String nameAbbreviation;

    /** 事業所区分 */
    @Indexed
    private OfficeType officeType;

    /** テスト用事業所 */
    private boolean isTestOffice;

    /** ユーザー単位でなく事業所単位で請求する */
    private Boolean isCombinedPaymentEnabled = false;

    /** 連絡先 */
    @DBRef
    private Contact contact;

    /** 会社からのメッセージ */
    private String message;

    /** カバー写真 */
    private String coverImage;

    /** 組織構造 */
    @DBRef(lazy = true)
    private List<Department> departments = Lists.newArrayList();

    // areaType
    private AreaType areaType ;

    // flag personal
    private boolean personalFlag;

    /** ビーコン情報 */
    @Field(value = "beacappConfig")
    private BeaconConfig beaconConfig;

    /**
     * セッション有効期限(second).
     * <pre>
     * 未設定または<code>0</code>が設定されている場合は無制限となる。
     * モバイルアプリには適用されない。
     * </pre>
     */
    private int sessionExpiration;

    /**
     * 支払い事業所区分
     * service-masterのpayment_office_typesコレクションを参照
     */
    private String paymentOfficeType;

    /**
     * セッション有効期限.
     *  0: 無効
     * -1: 無制限
     */
    private long officeSessionExpiration;

    @Indexed
    private String industryType;

    /**
     * GA/FA等のアナリティクスから除外する事業所の場合、true
     */
    private boolean analyticsExcludeFlag;

    /**
     * 管理画面で設定する備考のテキスト
     */
    private String adminNote;

    /** 削除日時 */
    private Date deleted;
    /** メールアドレスドメイン*/
    private List<String> domains;

    private String homePageUrl;

    // Helper methods
    // ------------------------------------------------------------------------
    public List<Department> addDepartment(Department department) {
        departments.add(department);
        return departments;
    }
}
