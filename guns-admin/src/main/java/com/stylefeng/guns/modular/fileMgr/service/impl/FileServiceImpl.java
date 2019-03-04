package com.stylefeng.guns.modular.fileMgr.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.core.common.constant.DatasourceEnum;
import com.stylefeng.guns.core.mutidatasource.annotion.DataSource;
import com.stylefeng.guns.modular.system.model.File;
import com.stylefeng.guns.modular.system.dao.FileMapper;
import com.stylefeng.guns.modular.fileMgr.service.IFileService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author stylefeng123
 * @since 2019-02-18
 */
@Slf4j
@Service
@DataSource(name = DatasourceEnum.DATA_SOURCE_BIZ)
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements IFileService {

    @Override
    public File getFileByNo(String fileNo){
        EntityWrapper<File> wrapper = new EntityWrapper<>();
        File file = new File();
        try{
            wrapper.eq("file_no",fileNo);
            file = this.selectOne(wrapper);
        }catch (Exception e){

        }
        return file;
    }
}
