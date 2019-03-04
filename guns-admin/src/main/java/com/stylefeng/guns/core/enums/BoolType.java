package com.stylefeng.guns.core.enums;

public enum  BoolType {
    FALSE("0","APP"),
    TRUE("1","WEB");

    private String code;
    private String desc;

    private BoolType(String code,String desc){
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
