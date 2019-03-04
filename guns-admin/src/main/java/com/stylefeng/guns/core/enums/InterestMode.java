package com.stylefeng.guns.core.enums;

public enum InterestMode {
    PRECYCLE("0","按期付息"),
    DISPOSABLE("1","一次性付息");

    private String code;
    private String desc;

    InterestMode(String code,String desc){
        this.code = code;
        this.desc = desc;
    }
    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
