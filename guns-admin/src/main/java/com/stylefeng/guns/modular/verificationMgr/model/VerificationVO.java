package com.stylefeng.guns.modular.verificationMgr.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author sue123
 * @since 2019-02-13
 */
public class VerificationVO extends Model<VerificationVO> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("user_id")
    private Integer userId;
    @TableField("real_name")
    private String realName;
    @TableField("id_number")
    private String idNumber;
    private String gender;
    private String address;
    @TableField("zip_code")
    private String zipCode;
    private String province;
    private String city;
    private String area;
    /**
     * ？
     */
    private String race;
    @TableField("idcard_issued_by")
    private String idcardIssuedBy;
    @TableField("idcard_valid_date")
    private String idcardValidDate;
    private String avatar;
    @TableField("id_card_front")
    private String idCardFront;
    @TableField("id_card_back")
    private String idCardBack;
    @TableField("updated_at")
    private Date updatedAt;
    @TableField("created_at")
    private Date createdAt;


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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getIdcardIssuedBy() {
        return idcardIssuedBy;
    }

    public void setIdcardIssuedBy(String idcardIssuedBy) {
        this.idcardIssuedBy = idcardIssuedBy;
    }

    public String getIdcardValidDate() {
        return idcardValidDate;
    }

    public void setIdcardValidDate(String idcardValidDate) {
        this.idcardValidDate = idcardValidDate;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getIdCardFront() {
        return idCardFront;
    }

    public void setIdCardFront(String idCardFront) {
        this.idCardFront = idCardFront;
    }

    public String getIdCardBack() {
        return idCardBack;
    }

    public void setIdCardBack(String idCardBack) {
        this.idCardBack = idCardBack;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "VerificationVO{" +
        "id=" + id +
        ", userId=" + userId +
        ", realName=" + realName +
        ", idNumber=" + idNumber +
        ", gender=" + gender +
        ", address=" + address +
        ", zipCode=" + zipCode +
        ", province=" + province +
        ", city=" + city +
        ", area=" + area +
        ", race=" + race +
        ", idcardIssuedBy=" + idcardIssuedBy +
        ", idcardValidDate=" + idcardValidDate +
        ", avatar=" + avatar +
        ", idCardFront=" + idCardFront +
        ", idCardBack=" + idCardBack +
        ", updatedAt=" + updatedAt +
        ", createdAt=" + createdAt +
        "}";
    }
}
