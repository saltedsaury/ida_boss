package com.stylefeng.guns.modular.fileMgr.service;

import com.stylefeng.guns.modular.system.model.File;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author stylefeng123
 * @since 2019-02-18
 */
public interface IFileService extends IService<File> {

    File getFileByNo(String fileNo);
}
