package com.stylefeng.guns.modular.investMgr.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.modular.investMgr.model.Invest;
import com.baomidou.mybatisplus.service.IService;
import com.stylefeng.guns.modular.investMgr.model.InvestRecord;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sue123
 * @since 2019-02-13
 */
public interface IInvestInfoService extends IService<Invest> {


    Page<InvestRecord> queryInvestList(InvestRecord invest, Page page);
}
