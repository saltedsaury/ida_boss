package com.stylefeng.guns.core.enums;

/**
 * <p>交易状态</p>
 *
 * @author yehe
 * @version 1.0
 * @since 2019/1/9 11:43
 */
public enum TradeStatus {
    INIT("初始交易"),
    CLOSED("交易关闭"),
    FINISHED("交易完成"),
    SUCCESS("交易成功"),
    FAILURE("交易失败")
    ;

    /**
     * 描述
     */
    private String desc;

    /**
     * 私有构造方法
     *
     * @param desc 描述
     */
    TradeStatus(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

}
