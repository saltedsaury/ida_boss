package com.stylefeng.guns.modular.redemptMgr.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.common.constant.factory.PageFactory;
import com.stylefeng.guns.core.enums.BizType;
import com.stylefeng.guns.core.enums.InvestStatus;
import com.stylefeng.guns.modular.redemptMgr.model.Redempt;
import com.stylefeng.guns.modular.redemptMgr.model.RedemptVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.investMgr.model.Invest;
import com.stylefeng.guns.modular.redemptMgr.service.IRedemptService;

/**
 * 赎回管理控制器
 *
 * @author fengshuonan
 * @Date 2019-02-13 16:57:05
 */
@Controller
@RequestMapping("/redempt")
public class RedemptController extends BaseController {

    private String PREFIX = "/redemptMgr/redempt/";

    @Autowired
    private IRedemptService redemptService;

    /**
     * 跳转到赎回管理首页
     */
    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("orderStatus",InvestStatus.values());

        return PREFIX + "investInfo.html";
    }

    @RequestMapping("/earlyRedempt")
    public String earlyRedemptindex(Model model) {
        model.addAttribute("orderStatus",InvestStatus.values());

        return PREFIX + "earlyRedempt.html";
    }

    /**
     * 获取赎回管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(Redempt condition) {
        Page<Redempt> page = new PageFactory<Redempt>().defaultPage();
        page = redemptService.queryRedemptList(condition,page);
        return super.packForBT(page);
    }


    /**
     * 修改赎回管理
     */
    @RequestMapping(value = "/auditing")
    @ResponseBody
    public Object update(RedemptVO redempt) {
        redemptService.auditingEarlyRedempt(redempt);
        return SUCCESS_TIP;
    }

}
