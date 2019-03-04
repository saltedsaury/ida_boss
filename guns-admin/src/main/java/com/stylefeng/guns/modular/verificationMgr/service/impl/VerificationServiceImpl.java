package com.stylefeng.guns.modular.verificationMgr.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.core.common.constant.DatasourceEnum;
import com.stylefeng.guns.core.mutidatasource.annotion.DataSource;
import com.stylefeng.guns.modular.fileMgr.service.IFileService;
import com.stylefeng.guns.modular.system.model.File;
import com.stylefeng.guns.modular.verificationMgr.model.Verification;
import com.stylefeng.guns.modular.verificationMgr.dao.VerificationMapper;
import com.stylefeng.guns.modular.verificationMgr.service.IVerificationService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sue123
 * @since 2019-02-13
 */
@Slf4j
@Service
@DataSource(name = DatasourceEnum.DATA_SOURCE_BIZ)
public class VerificationServiceImpl extends ServiceImpl<VerificationMapper, Verification> implements IVerificationService {

    @Autowired
    private IFileService fileService;
    @Override
    public Page<Verification> queryverificationList(Verification verification, Page<Verification> page){
        try{
            page = this.selectPage(page);
        }catch (Exception e){
            log.error("query verification for form error,{}",e.getMessage());
        }
        return page;
    }

    @Override
    public List<File> getUserFile(String id){
        Verification verification = this.selectById(id);
        String[] fileNos = verification.getFileNo().split(",");
        List<File> files = new ArrayList<>();

        for (int i = 0;i<fileNos.length;i++){
            File file= new File();
            file = fileService.getFileByNo(fileNos[i]);
            files.add(file);
        }

        return files;
    }
}
