package com.stylefeng.guns.modular.insurance.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author stylefeng123
 * @since 2019-03-04
 */
public class CompensateTradeVo{

    private String id;
    /**
     * 流水号
     */
    private String tradeNo;
    /**
     * 保险投资编号
     */
    private String insuranceTrade;
    /**
     * 保单生效金额
     */
    private String effectiveAmount;
    /**
     * 保单原币种
     */
    private String ccy;
    /**
     * 理赔金额
     */
    private String compensateAmount;
    /**
     * 理赔币种
     */
    private String compensateCcy;
    /**
     * 状态
     */
    private String status;
    /**
     * 操作员
     */
    private String operatorNo;
    private String createTime;
    private String modifiedTime;
    private String customerNo;

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

    public String getInsuranceTrade() {
        return insuranceTrade;
    }

    public void setInsuranceTrade(String insuranceTrade) {
        this.insuranceTrade = insuranceTrade;
    }

    public String getEffectiveAmount() {
        return effectiveAmount;
    }

    public void setEffectiveAmount(String effectiveAmount) {
        this.effectiveAmount = effectiveAmount;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getCompensateAmount() {
        return compensateAmount;
    }

    public void setCompensateAmount(String compensateAmount) {
        this.compensateAmount = compensateAmount;
    }

    public String getCompensateCcy() {
        return compensateCcy;
    }

    public void setCompensateCcy(String compensateCcy) {
        this.compensateCcy = compensateCcy;
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

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    @Override
    public String toString() {
        return "CompensateTrade{" +
        "id=" + id +
        ", tradeNo=" + tradeNo +
        ", insuranceTrade=" + insuranceTrade +
        ", effectiveAmount=" + effectiveAmount +
        ", ccy=" + ccy +
        ", compensateAmount=" + compensateAmount +
        ", compensateCcy=" + compensateCcy +
        ", status=" + status +
        ", operatorNo=" + operatorNo +
        ", createTime=" + createTime +
        ", modifiedTime=" + modifiedTime +
        ", customerNo=" + customerNo +
        "}";
    }
}
