package com.stylefeng.guns.modular.walletMgr.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.common.annotion.Permission;
import com.stylefeng.guns.core.common.constant.factory.PageFactory;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.core.shiro.ShiroUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.walletMgr.model.Wallet;
import com.stylefeng.guns.modular.walletMgr.service.IWalletService;

/**
 * 币池管理控制器
 *
 * @author fengshuonan
 * @Date 2019-02-13 17:44:09
 */
@Controller
@RequestMapping("/wallet")
public class WalletController extends BaseController {

    private String PREFIX = "/walletMgr/wallet/";

    @Autowired
    private IWalletService walletService;

    /**
     * 跳转到币池管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "wallet.html";
    }

    /**
     * 跳转到添加币池管理
     */
    @RequestMapping("/wallet_add")
    public String walletAdd() {
        return PREFIX + "wallet_add.html";
    }

    /**
     * 跳转到修改币池管理
     */
    @RequestMapping("/wallet_update/{walletId}")
    public String walletUpdate(@PathVariable Integer walletId, Model model) {
        Wallet wallet = walletService.selectById(walletId);
        model.addAttribute("item",wallet);
        LogObjectHolder.me().set(wallet);
        return PREFIX + "wallet_edit.html";
    }

    /**
     * 获取币池管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list() {
        ShiroUser user = ShiroKit.getUser();
        Page<Wallet> page = new PageFactory<Wallet>().defaultPage();
        Wallet wallet = new Wallet();
        wallet.setUserId(user.getId());
        page = walletService.queryWalletList(wallet,page);
        return super.packForBT(walletService.formatList(page));
    }

    /**
     * 新增币池管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Wallet wallet) {
        walletService.insert(wallet);
        return SUCCESS_TIP;
    }

    /**
     * 删除币池管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer walletId) {
        walletService.deleteById(walletId);
        return SUCCESS_TIP;
    }

    /**
     * 修改币池管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Wallet wallet) {
        walletService.updateById(wallet);
        return SUCCESS_TIP;
    }

    /**
     * 币池管理详情
     */
    @RequestMapping(value = "/detail/{walletId}")
    @ResponseBody
    public Object detail(@PathVariable("walletId") Integer walletId) {
        return walletService.selectById(walletId);
    }
}
