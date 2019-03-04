package com.stylefeng.guns.modular.walletMgr.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

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

@Data
public class WalletVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String account;
    private String name;
    private String address;
    private String accountType;
    private String isFreeze;
    private Date createdAt;


}
