package com.stylefeng.guns.modular.bonusMgr.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.common.constant.factory.PageFactory;
import com.stylefeng.guns.core.enums.BizType;
import com.stylefeng.guns.core.enums.InvestStatus;
import com.stylefeng.guns.modular.system.model.vo.BonusOrderVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.BonusOrder;
import com.stylefeng.guns.modular.bonusMgr.service.IBonusOrderService;

/**
 * 分红管理控制器
 *
 * @author fengshuonan
 * @Date 2019-02-13 16:31:35
 */
@Controller
@RequestMapping("/bonusOrder")
public class BonusOrderController extends BaseController {

    private String PREFIX = "/bonusMgr/bonusOrder/";

    @Autowired
    private IBonusOrderService bonusOrderService;

    /**
     * 跳转到分红管理首页
     */
    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("orderStatus",InvestStatus.values());
        return PREFIX + "bonusOrder.html";
    }

    /**
     * 获取分红管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(BonusOrder condition) {
        Page<BonusOrder> page = new PageFactory<BonusOrder>().defaultPage();
        page = bonusOrderService.queryOrderList(condition,page);
        return super.packForBT(page);
    }

    /**
     * 审核分红
     */
    @RequestMapping(value = "/auditing")
    @ResponseBody
    public Object update(BonusOrderVO bonusOrder) {
        bonusOrderService.auditing(bonusOrder);
        return SUCCESS_TIP;
    }

}
