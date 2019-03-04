package com.stylefeng.guns.core.enums;

public enum InvestStatus {

    AUDITING("0","待审核"),
    PREPARE("1","待处理"),
    SUCCESS("2","成功"),
    INVALID("3","失效"),
    FINISH("4","赎回完成");

    private String code;
    private String desc;

    InvestStatus(String code,String desc){
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
