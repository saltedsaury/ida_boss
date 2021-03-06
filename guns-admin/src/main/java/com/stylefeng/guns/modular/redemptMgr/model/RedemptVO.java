package com.stylefeng.guns.modular.redemptMgr.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author sue123
 * @since 2019-02-13
 */
public class RedemptVO {

    private static final long serialVersionUID = 1L;

    /**
     * 自增流水
     */
    private String id;
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
    private String amount;
    /**
     * 手续费
     */
    private String fee;
    /**
     * 罚金
     */
    private String fine;
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
    private String createTime;
    /**
     * 修改时间
     */
    private String modifiedTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getPlanNo() {
        return planNo;
    }

    public void setPlanNo(String planNo) {
        this.planNo = planNo;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getFine() {
        return fine;
    }

    public void setFine(String fine) {
        this.fine = fine;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOperatorNo() {
        return operatorNo;
    }

    public void setOperatorNo(String operatorNo) {
        this.operatorNo = operatorNo;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        return "Redempt{" +
        "id=" + id +
        ", tradeNo=" + tradeNo +
        ", bizType=" + bizType +
        ", customerNo=" + customerNo +
        ", productNo=" + productNo +
        ", planNo=" + planNo +
        ", ccy=" + ccy +
        ", amount=" + amount +
        ", fee=" + fee +
        ", fine=" + fine +
        ", status=" + status +
        ", operatorNo=" + operatorNo +
        ", createTime=" + createTime +
        ", modifiedTime=" + modifiedTime +
        "}";
    }
}
