package com.stylefeng.guns.modular.verificationMgr.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.modular.system.model.File;
import com.stylefeng.guns.modular.verificationMgr.model.Verification;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sue123
 * @since 2019-02-13
 */
public interface IVerificationService extends IService<Verification> {

    Page<Verification> queryverificationList(Verification verification, Page<Verification> page);

    List<File> getUserFile(String id);
}
