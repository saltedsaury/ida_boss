package com.stylefeng.guns.modular.investMgr.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class InvestRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增流水
     */
    private Long id;
    /**
     * 交易流水
     */
    private String tradeNo;
    /**
     * 业务类型 0-投资 1-赎回 2-提前赎回
     */
    private String bizType;
    /**
     * 客户号
     */
    private String customerNo;
    /**
     * 产品码
     */
    private String productNo;
    /**
     * 收益计划编号
     */
    private String planNo;
    /**
     * 币种
     */
    private String ccy;
    /**
     * 金额
     */
    private BigDecimal amount;
    /**
     * 手续费
     */
    private BigDecimal fee;
    /**
     * 罚金
     */
    private BigDecimal fine;
    /**
     * 状态
     */
    private String status;
    /**
     * 操作员
     */
    private String operatorNo;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date modifiedTime;

    private String agreementNo;

    private String investCycle;

    private String investTremType;

    private String revenueRate;

    private String insuranceNo;

}
