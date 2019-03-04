package com.stylefeng.guns.modular.bonusMgr.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.core.common.constant.DatasourceEnum;
import com.stylefeng.guns.core.enums.InvestStatus;
import com.stylefeng.guns.core.mutidatasource.annotion.DataSource;
import com.stylefeng.guns.modular.system.model.BonusOrder;
import com.stylefeng.guns.modular.system.dao.BonusOrderMapper;
import com.stylefeng.guns.modular.bonusMgr.service.IBonusOrderService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.stylefeng.guns.modular.system.model.vo.BonusOrderVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
public class BonusOrderServiceImpl extends ServiceImpl<BonusOrderMapper, BonusOrder> implements IBonusOrderService {

    @Override
    public Page<BonusOrder> queryOrderList(BonusOrder order, Page<BonusOrder> page){
        EntityWrapper<BonusOrder> wrapper = new EntityWrapper<>();
        try{
            if (order.getStatus()!=null && order.getStatus() != "") {
                wrapper.eq("status", order.getStatus());
            }
            page = this.selectPage(page,wrapper);
        }catch (Exception e){
            log.error("query bonusOrder for form error,{}",e.getMessage());
        }
        return page;
    }

    @Override
    public void auditing(BonusOrderVO bonusOrderVO){
        BonusOrder entity = new BonusOrder();
        entity.setId(Long.valueOf(bonusOrderVO.getId()));
        entity.setStatus(InvestStatus.PREPARE.getCode());
        baseMapper.updateById(entity);
    }
}
