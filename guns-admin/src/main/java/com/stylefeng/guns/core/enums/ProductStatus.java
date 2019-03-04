package com.stylefeng.guns.core.enums;

public enum ProductStatus {
    INIT("0","初始化"),
    ONSAIL("1","上架"),
    PAUSE("2","停止购买"),
    OFFSHELVE("3","下架");

    private String code;
    private String desc;

    ProductStatus(String code,String desc){
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
