package com.stylefeng.guns.core.enums;

public enum BatchCode {
    BATCH_START("0000","默认起始节点"),
    B1001("B1001","申购确认"),
    B1002("B1002","分红计算"),
    B1003("B1003","分红确认"),
    B1004("B1004","提前赎回"),
    B1005("B1005","自动赎回");

    private String code;
    private String desc;

    BatchCode(String code,String desc){
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
