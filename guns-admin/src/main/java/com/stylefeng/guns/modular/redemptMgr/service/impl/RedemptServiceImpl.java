package com.stylefeng.guns.modular.redemptMgr.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.core.common.constant.DatasourceEnum;
import com.stylefeng.guns.core.enums.InvestStatus;
import com.stylefeng.guns.core.mutidatasource.annotion.DataSource;
import com.stylefeng.guns.modular.investMgr.dao.InvestMapper;
import com.stylefeng.guns.modular.investMgr.model.Invest;
import com.stylefeng.guns.modular.redemptMgr.dao.InvestInfoMapper;
import com.stylefeng.guns.modular.redemptMgr.model.Redempt;
import com.stylefeng.guns.modular.redemptMgr.model.RedemptVO;
import com.stylefeng.guns.modular.redemptMgr.service.IRedemptService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
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
public class RedemptServiceImpl extends ServiceImpl<InvestInfoMapper, Redempt> implements IRedemptService {

    @Override
    public Page<Redempt> queryRedemptList(Redempt redempt,Page page){
        EntityWrapper<Redempt> wrapper = new EntityWrapper<>();
        try{
            wrapper.eq("biz_type",redempt.getBizType());
            if (redempt.getStatus()!=null && redempt.getStatus() != ""){
                wrapper.eq("status",redempt.getStatus());
            }
            page = this.selectPage(page,wrapper);
        }catch (Exception e){
            log.error("query wallet for form error,{}",e.getMessage());
        }
        return page;
    }

    @Override
    public void auditingEarlyRedempt(RedemptVO redempt){
        Redempt entity = new Redempt();
        entity.setId(Long.valueOf(redempt.getId()));
        entity.setStatus(InvestStatus.PREPARE.getCode());
        baseMapper.updateById(entity);
    }
}
