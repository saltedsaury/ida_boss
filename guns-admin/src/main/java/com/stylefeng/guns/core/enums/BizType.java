package com.stylefeng.guns.core.enums;

public enum BizType {

    INSURANCE("0","保险"),
    INVEST("1","投资"),
    REDEMPTION("2","赎回"),
    EARLYREDEMPATION("3","提前赎回");

    private String code;
    private String desc;

    BizType(String code,String desc){
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
