package dr.app.backend.registration.domain.model;

import dr.app.core.autogen.grpc.registration.REOfficeType;

public enum OfficeType {
    /** 医療機関 */
    MEDICAL,
    /** 製薬企業 */
    PHARMACY,
    /** 薬局 */
    DRUG_STORE,
    /** その他 */
    OTHER;

    public REOfficeType toMessage() {
        return REOfficeType.valueOf(name());
    }

    static public OfficeType valueOf(REOfficeType message) {
        return OfficeType.valueOf(message.name());
    }
}

