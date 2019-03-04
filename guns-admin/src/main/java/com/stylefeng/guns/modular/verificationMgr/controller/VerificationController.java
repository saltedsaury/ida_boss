package com.stylefeng.guns.modular.verificationMgr.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.common.constant.factory.PageFactory;
import com.stylefeng.guns.modular.system.model.File;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.verificationMgr.model.Verification;
import com.stylefeng.guns.modular.verificationMgr.service.IVerificationService;

import java.util.List;

/**
 * 实名认证管理控制器
 *
 * @author fengshuonan
 * @Date 2019-02-13 17:24:30
 */
@Controller
@RequestMapping("/verification")
public class VerificationController extends BaseController {

    private String PREFIX = "/verificationMgr/verification/";

    @Autowired
    private IVerificationService verificationService;

    /**
     * 跳转到实名认证管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "verification.html";
    }

    /**
     * 跳转到修改实名认证管理
     */
    @RequestMapping("/verification_update/{verificationId}")
    public String verificationUpdate(@PathVariable Integer verificationId, Model model) {
        List<File> files = verificationService.getUserFile(verificationId.toString());
        model.addAttribute("id",verificationId);
        model.addAttribute("item",files);
        LogObjectHolder.me().set(files);
        return PREFIX + "verification_edit.html";
    }

    /**
     * 获取实名认证管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(Verification condition) {
        Page<Verification> page = new PageFactory<Verification>().defaultPage();

        page = verificationService.queryverificationList(condition,page);
        return super.packForBT(page);
    }

    /**
     * 修改实名认证管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Verification verification) {
        verificationService.updateById(verification);
        return SUCCESS_TIP;
    }

    /**
     * 实名认证管理详情
     */
    @RequestMapping(value = "/detail/{verificationId}")
    @ResponseBody
    public Object detail(@PathVariable("verificationId") Integer verificationId) {
        return verificationService.selectById(verificationId);
    }
}
