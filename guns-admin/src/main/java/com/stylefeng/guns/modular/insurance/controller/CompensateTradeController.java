package com.stylefeng.guns.modular.insurance.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.common.constant.factory.PageFactory;
import com.stylefeng.guns.modular.insurance.model.CompensateTradeVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.insurance.model.CompensateTrade;
import com.stylefeng.guns.modular.insurance.service.ICompensateTradeService;

/**
 * 保险理赔控制器
 *
 * @author fengshuonan
 * @Date 2019-03-04 12:02:42
 */
@Controller
@RequestMapping("/compensateTrade")
public class CompensateTradeController extends BaseController {

    private String PREFIX = "/insurance/compensateTrade/";

    @Autowired
    private ICompensateTradeService compensateTradeService;

    /**
     * 跳转到保险理赔首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "compensateTrade.html";
    }

    /**
     * 获取保险理赔列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(CompensateTrade condition) {
        Page<CompensateTrade> page = new PageFactory<CompensateTrade>().defaultPage();
        page = compensateTradeService.queryTradeList(condition,page);
        return super.packForBT(page);
    }

    /**
     * 修改保险理赔
     */
    @RequestMapping(value = "/auditing")
    @ResponseBody
    public Object update(CompensateTradeVo compensateTrade) {
        compensateTradeService.auditing(compensateTrade);
        return SUCCESS_TIP;
    }

}
