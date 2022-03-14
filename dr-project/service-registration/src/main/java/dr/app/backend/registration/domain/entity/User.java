package dr.app.backend.registration.domain.entity;

import com.google.common.collect.Lists;
import lombok.Data;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Document(collection = "user")
public class User extends BasicEntity{
    /** ID */
    @Id
    private String id;

    /**
     * ユーザーID （旧システムのusers.idから移行する）
     */
    private String oldId;

    /** ログインID */
    @Indexed
    private String loginId;

    /** メールアドレス */
    @Indexed
    private String mailAddress;

    /** 仮パスワード */
    private String temporaryPassword;

    /** パスワード */
    private String password;

    /** 所属している事業所 */
    @DBRef(lazy = true)
    private List<OfficeUser> officeUsers = Lists.newArrayList();

    /** 最終ログイン日時 */
    private Date lastLoginDate;

    // flag personal identity
    boolean personalFlag ;

    // flag personal verification
    boolean verificationFlag ;

    // date verification
    private Date accepted;

    /** 一時退避 */
    private Stash stash;


    // Public Methods
    // ------------------------------------------------------------------------

    /**
     * 所属している事業所を追加します.
     *
     * @param officeUser {@link OfficeUser}
     * @return 所属している事業所リスト
     */
    public List<OfficeUser> addOfficeUser(OfficeUser officeUser) {
        officeUsers.add(officeUser);
        return officeUsers;
    }

    /**
     * Get OfficeUser by officeId.
     */
    public OfficeUser getOfficeUserByOfficeId(String officeId) {
        List<OfficeUser> officeUsers = getOfficeUsers().stream()
                .filter(ou -> ou.getOfficeId().equals(officeId))
                .collect(Collectors.toList());
        if (officeUsers.isEmpty()) {
            throw new IllegalArgumentException("No OfficeUser with specified officeId");
        }
        if (officeUsers.size() > 1) {
            throw new IllegalStateException("Multiple OfficeUsers matches with specified officeId");
        }
        return officeUsers.get(0);
    }

    /** アカウント無効 */
    public void invalidStatus() {

        if (this.stash == null) {
            // アカウント削除時にログインIDやメールアドレスを再利用できるように退避させておく
            this.stash = new Stash();
            this.stash.setLoginId(this.loginId);
            this.stash.setMailAddress(this.mailAddress);

            // 新規ユーザが再利用できるように値を削除する
            this.loginId = null;
            this.mailAddress = null;
        }
    }

    /** アカウント復活 */
    public void revivalStatus() {

        if (this.stash != null) {
            // 退避させていた情報を元に戻す
            this.loginId = this.stash.loginId;
            this.mailAddress = this.stash.mailAddress;

            // 退避情報を削除
            this.stash = null;
        }
    }

    // Inner Classes
    // ------------------------------------------------------------------------

    /** 一時退避用クラス(アカウント削除時) */
    @Data
    public class Stash {

        /** ログインID */
        private String loginId;
        /** 通知先メールアドレス */
        private String mailAddress;
    }
}
