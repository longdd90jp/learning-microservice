package dr.app.backend.registration.domain.entity;

import dr.app.backend.registration.domain.model.PublishingType;
import lombok.Data;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "contact")
public class Contact {
    /** ID */
    @Id
    private String id;
    /** 郵便番号 */
    private String postalCode;
    /** 都道府県コード */
    private String prefectureCode;
    /** 住所1 */
    private String address1;
    /** 住所2 */
    private String address2;
    /** 電話番号 */
    private String phoneNo;
    /** FAX番号 */
    private String faxNo;
    /** メールアドレス */
    private String mailAddress;
    /** 携帯番号 */
    private String mobileNo;
    /** PHS番号 */
    private String phsNo;
    /** ホームページURL */
    private String homepageUrl;
    /** メールアドレス公開範囲 */
    private PublishingType mailAddressPublishingType;
    /** 携帯番号公開範囲 */
    private PublishingType mobileNoPublishingType;
    /** 団体コード */
    @Indexed
    private String cityId;
    /** 作成日時 */
    @CreatedDate
    private Date created;
    /** 作成者 */
    @CreatedBy
    private String creator;
    /** 更新日時 */
    @LastModifiedDate
    private Date updated;
    /** 更新者 */
    @LastModifiedBy
    private String updater;
}
