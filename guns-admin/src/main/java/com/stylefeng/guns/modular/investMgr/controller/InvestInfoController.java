package com.stylefeng.guns.modular.investMgr.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.enums.BizType;
import com.stylefeng.guns.core.enums.InvestStatus;
import com.stylefeng.guns.modular.investMgr.model.InvestRecord;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.investMgr.model.Invest;
import com.stylefeng.guns.modular.investMgr.service.IInvestInfoService;

/**
 * 申购管理控制器
 *
 * @author fengshuonan
 * @Date 2019-02-13 16:52:58
 */
@Controller
@RequestMapping("/invest")
public class InvestInfoController extends BaseController {

    private String PREFIX = "/investMgr/invest/";

    @Autowired
    private IInvestInfoService investInfoService;

    /**
     * 跳转到申购管理首页
     */
    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("orderStatus",InvestStatus.values());

        return PREFIX + "investInfo.html";
    }

    /**
     * 跳转到添加申购管理
     */
    @RequestMapping("/investInfo_add")
    public String investInfoAdd() {
        return PREFIX + "investInfo_add.html";
    }

    /**
     * 跳转到修改申购管理
     */
    @RequestMapping("/investInfo_update/{investInfoId}")
    public String investInfoUpdate(@PathVariable Integer investInfoId, Model model) {
        Invest investInfo = investInfoService.selectById(investInfoId);
        model.addAttribute("item",investInfo);
        LogObjectHolder.me().set(investInfo);
        return PREFIX + "investInfo_edit.html";
    }

    /**
     * 获取申购管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String status) {
        Page<InvestRecord> page = new Page<>();
        InvestRecord invest = new InvestRecord();
        invest.setStatus(status);
        page = investInfoService.queryInvestList(invest,page);
        return super.packForBT(page);
    }

    /**
     * 新增申购管理
     */

    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Invest investInfo) {
        investInfoService.insert(investInfo);
        return SUCCESS_TIP;
    }

    /**
     * 删除申购管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer investInfoId) {
        investInfoService.deleteById(investInfoId);
        return SUCCESS_TIP;
    }

    /**
     * 修改申购管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Invest investInfo) {
        investInfoService.updateById(investInfo);
        return SUCCESS_TIP;
    }

    /**
     * 申购管理详情
     */
    @RequestMapping(value = "/detail/{investInfoId}")
    @ResponseBody
    public Object detail(@PathVariable("investInfoId") Integer investInfoId) {
        return investInfoService.selectById(investInfoId);
    }
}
