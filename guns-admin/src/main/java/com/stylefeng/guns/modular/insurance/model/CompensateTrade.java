package com.stylefeng.guns.modular.insurance.model;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 
 * </p>
 *
 * @author stylefeng123
 * @since 2019-03-04
 */
@TableName("compensate_trade")
public class CompensateTrade extends Model<CompensateTrade> {

    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * 流水号
     */
    @TableField("trade_no")
    private String tradeNo;
    /**
     * 保险投资编号
     */
    @TableField("insurance_trade")
    private String insuranceTrade;
    /**
     * 保单生效金额
     */
    @TableField("effective_amount")
    private BigDecimal effectiveAmount;
    /**
     * 保单原币种
     */
    private String ccy;
    /**
     * 理赔金额
     */
    @TableField("compensate_amount")
    private BigDecimal compensateAmount;
    /**
     * 理赔币种
     */
    @TableField("compensate_ccy")
    private String compensateCcy;
    /**
     * 状态
     */
    private String status;
    /**
     * 操作员
     */
    @TableField("operator_no")
    private String operatorNo;
    @TableField("create_time")
    private Date createTime;
    @TableField("modified_time")
    private Date modifiedTime;
    @TableField("customer_no")
    private String customerNo;


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

    public String getInsuranceTrade() {
        return insuranceTrade;
    }

    public void setInsuranceTrade(String insuranceTrade) {
        this.insuranceTrade = insuranceTrade;
    }

    public BigDecimal getEffectiveAmount() {
        return effectiveAmount;
    }

    public void setEffectiveAmount(BigDecimal effectiveAmount) {
        this.effectiveAmount = effectiveAmount;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public BigDecimal getCompensateAmount() {
        return compensateAmount;
    }

    public void setCompensateAmount(BigDecimal compensateAmount) {
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

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
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
