package com.stylefeng.guns.modular.system.model.vo;

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
public class BonusOrderVO {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    private String id;
    /**
     * 交易流水
     */
    private String tradeNo;
    /**
     * 客户号
     */
    private String customerNo;
    /**
     * 投资编号
     */
    private String investNo;
    /**
     * 收益计划编号
     */
    private String planNo;
    /**
     * 期数
     */
    private String periods;
    /**
     * 币种
     */
    private String ccy;
    /**
     * 金额
     */
    private String amount;
    /**
     * 状态
     */
    private String status;
    /**
     * 操作员
     */
    private String operatorNo;
    /**
     * 备注
     */
    private String remark;
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

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getInvestNo() {
        return investNo;
    }

    public void setInvestNo(String investNo) {
        this.investNo = investNo;
    }

    public String getPlanNo() {
        return planNo;
    }

    public void setPlanNo(String planNo) {
        this.planNo = planNo;
    }

    public String getPeriods() {
        return periods;
    }

    public void setPeriods(String periods) {
        this.periods = periods;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        return "BonusOrder{" +
        "id=" + id +
        ", tradeNo=" + tradeNo +
        ", customerNo=" + customerNo +
        ", investNo=" + investNo +
        ", planNo=" + planNo +
        ", periods=" + periods +
        ", ccy=" + ccy +
        ", amount=" + amount +
        ", status=" + status +
        ", operatorNo=" + operatorNo +
        ", remark=" + remark +
        ", createTime=" + createTime +
        ", modifiedTime=" + modifiedTime +
        "}";
    }
}
