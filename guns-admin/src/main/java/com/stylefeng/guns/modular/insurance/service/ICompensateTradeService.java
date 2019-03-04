package com.stylefeng.guns.modular.insurance.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.modular.insurance.model.CompensateTrade;
import com.baomidou.mybatisplus.service.IService;
import com.stylefeng.guns.modular.insurance.model.CompensateTradeVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author stylefeng123
 * @since 2019-03-04
 */
public interface ICompensateTradeService extends IService<CompensateTrade> {

    Page<CompensateTrade> queryTradeList(CompensateTrade trade, Page<CompensateTrade> page);

    void auditing(CompensateTradeVo vo);
}
