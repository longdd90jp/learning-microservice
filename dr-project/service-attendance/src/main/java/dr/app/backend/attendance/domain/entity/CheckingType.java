package dr.app.backend.attendance.domain.entity;

public enum CheckingType {
    //打刻機
    CT_CLOCK(0),

    //手動編集
    CT_EDIT(1),

    /** Type Check for web */
    CT_WEB(2),

    /** Type check for application */
    CT_MOBILE(3),

    //ビーコン打刻
    CT_BEACON(4),

    /** Type check for import CSV */
    CT_DATA(5);

    final int type;

    CheckingType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
