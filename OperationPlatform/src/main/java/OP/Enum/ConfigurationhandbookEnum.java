package OP.Enum;

/**
 * Created by Administrator on 14-2-24.
 */
public enum ConfigurationhandbookEnum {
    UNEFFECTIVE_STATUS(0,"已删除"),
    EFFECTIVE_STATUS(1,"正常"),;

    private int code;
    private String desc;

    ConfigurationhandbookEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
