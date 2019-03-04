package com.stylefeng.guns.modular.investMgr.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.modular.investMgr.model.Invest;
import com.stylefeng.guns.modular.investMgr.model.InvestRecord;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sue123
 * @since 2019-02-13
 */
public interface InvestMapper extends BaseMapper<Invest> {


    @Select("<script>" +
            "Select a.*,b.agreement_no,b.invest_cycle,b.invest_trem_type,b.revenue_rate,b.insurance_no" +
            " from invest_info a,invest_agreement b where a.biz_type = '1' and a.trade_no = b.invest_no" +
            "<if test='status!=null and status != \"\"'>" +
            " and a.status = #{status}" +
            "</if></script>")
    List<InvestRecord> getInvestRecord(Page page, @Param("status") String status);

}
