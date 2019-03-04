package com.stylefeng.guns.modular.redemptMgr.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.modular.investMgr.model.Invest;
import com.baomidou.mybatisplus.service.IService;
import com.stylefeng.guns.modular.redemptMgr.model.Redempt;
import com.stylefeng.guns.modular.redemptMgr.model.RedemptVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sue123
 * @since 2019-02-13
 */
public interface IRedemptService extends IService<Redempt> {

    Page<Redempt> queryRedemptList(Redempt redempt, Page page);

    void auditingEarlyRedempt(RedemptVO redempt);
}
