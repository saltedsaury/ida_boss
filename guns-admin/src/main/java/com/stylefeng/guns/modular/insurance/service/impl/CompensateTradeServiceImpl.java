package com.stylefeng.guns.modular.insurance.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.core.common.constant.DatasourceEnum;
import com.stylefeng.guns.core.enums.InvestStatus;
import com.stylefeng.guns.core.mutidatasource.annotion.DataSource;
import com.stylefeng.guns.modular.insurance.model.CompensateTrade;
import com.stylefeng.guns.modular.insurance.dao.CompensateTradeMapper;
import com.stylefeng.guns.modular.insurance.model.CompensateTradeVo;
import com.stylefeng.guns.modular.insurance.service.ICompensateTradeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author stylefeng123
 * @since 2019-03-04
 */
@Slf4j
@Service
@DataSource(name = DatasourceEnum.DATA_SOURCE_FINANCING)
public class CompensateTradeServiceImpl extends ServiceImpl<CompensateTradeMapper, CompensateTrade> implements ICompensateTradeService {
    @Override
    public Page<CompensateTrade> queryTradeList(CompensateTrade trade, Page<CompensateTrade> page){
        EntityWrapper<CompensateTrade> wrapper = new EntityWrapper<>();
        try{
            if (trade.getStatus()!=null && trade.getStatus() != "") {
                wrapper.eq("status", trade.getStatus());
            }
            page = this.selectPage(page,wrapper);
        }catch (Exception e){
            log.error("query compensate trade for form error,{}",e.getMessage());
        }
        return page;
    }

    @Override
    public void auditing(CompensateTradeVo vo){
        CompensateTrade entity = new CompensateTrade();
        entity.setId(Long.valueOf(vo.getId()));
        entity.setStatus(InvestStatus.PREPARE.getCode());
        baseMapper.updateById(entity);
    }
}
