package com.stylefeng.guns.modular.investMgr.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.core.common.constant.DatasourceEnum;
import com.stylefeng.guns.core.mutidatasource.annotion.DataSource;
import com.stylefeng.guns.modular.investMgr.dao.InvestMapper;
import com.stylefeng.guns.modular.investMgr.model.Invest;
import com.stylefeng.guns.modular.investMgr.model.InvestRecord;
import com.stylefeng.guns.modular.redemptMgr.dao.InvestInfoMapper;
import com.stylefeng.guns.modular.investMgr.service.IInvestInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
@DataSource(name = DatasourceEnum.DATA_SOURCE_FINANCING)
public class InvestInfoServiceImpl extends ServiceImpl<InvestMapper, Invest> implements IInvestInfoService {


    @Override
    public Page<InvestRecord> queryInvestList(InvestRecord invest, Page page){
        try{
            List<InvestRecord> investRecords= this.baseMapper.getInvestRecord(page,invest.getStatus());
            page.setRecords(investRecords);
        }catch (Exception e){
            log.error("query wallet for form error,{}",e.getMessage());
        }
        return page;
    }


}
