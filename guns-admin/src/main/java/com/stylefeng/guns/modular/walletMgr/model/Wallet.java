package com.stylefeng.guns.modular.walletMgr.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;

/**
 * <p>
 * 
 * </p>
 *
 * @author sue123
 * @since 2019-02-13
 */
public class Wallet extends Model<Wallet> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("user_id")
    private Integer userId;
    private String name;
    @TableField("public_key")
    private String publicKey;
    @TableField("account_type")
    private Integer accountType;
    private String address;
    @TableField("is_freeze")
    private Integer isFreeze;
    @TableField("encrypt_private_key")
    private String encryptPrivateKey;
    @TableField("user_type")
    private Integer userType;
    @TableField("created_at")
    private Date createdAt;
    @TableField("updated_at")
    private Date updatedAt;
    @TableField("deleted_at")
    private Date deletedAt;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getIsFreeze() {
        return isFreeze;
    }

    public void setIsFreeze(Integer isFreeze) {
        this.isFreeze = isFreeze;
    }

    public String getEncryptPrivateKey() {
        return encryptPrivateKey;
    }

    public void setEncryptPrivateKey(String encryptPrivateKey) {
        this.encryptPrivateKey = encryptPrivateKey;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "WalletVO{" +
        "id=" + id +
        ", userId=" + userId +
        ", name=" + name +
        ", publicKey=" + publicKey +
        ", accountType=" + accountType +
        ", address=" + address +
        ", isFreeze=" + isFreeze +
        ", encryptPrivateKey=" + encryptPrivateKey +
        ", userType=" + userType +
        ", createdAt=" + createdAt +
        ", updatedAt=" + updatedAt +
        ", deletedAt=" + deletedAt +
        "}";
    }
}
