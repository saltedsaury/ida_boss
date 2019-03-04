package com.stylefeng.guns.modular.bonusMgr.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.modular.system.model.BonusOrder;
import com.baomidou.mybatisplus.service.IService;
import com.stylefeng.guns.modular.system.model.vo.BonusOrderVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sue123
 * @since 2019-02-13
 */
public interface IBonusOrderService extends IService<BonusOrder> {

    Page<BonusOrder> queryOrderList(BonusOrder wallet, Page<BonusOrder> page);

    void auditing(BonusOrderVO bonusOrderVO);
}
