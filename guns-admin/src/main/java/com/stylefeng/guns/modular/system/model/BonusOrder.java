package com.stylefeng.guns.modular.system.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author sue123
 * @since 2019-02-13
 */
@TableName("bonus_order")
public class BonusOrder extends Model<BonusOrder> {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 交易流水
     */
    @TableField("trade_no")
    private String tradeNo;
    /**
     * 客户号
     */
    @TableField("customer_no")
    private String customerNo;
    /**
     * 投资编号
     */
    @TableField("invest_no")
    private String investNo;
    /**
     * 收益计划编号
     */
    @TableField("plan_no")
    private String planNo;
    /**
     * 期数
     */
    private Long periods;
    /**
     * 币种
     */
    private String ccy;
    /**
     * 金额
     */
    private BigDecimal amount;
    /**
     * 状态
     */
    private String status;
    /**
     * 操作员
     */
    @TableField("operator_no")
    private String operatorNo;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 修改时间
     */
    @TableField("modified_time")
    private Date modifiedTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getPeriods() {
        return periods;
    }

    public void setPeriods(Long periods) {
        this.periods = periods;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
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
