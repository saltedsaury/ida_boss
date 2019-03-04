package com.stylefeng.guns.modular.system.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.Dept;
import com.stylefeng.guns.modular.system.service.IDeptService;

/**
 * test控制器
 *
 * @author fengshuonan
 * @Date 2018-06-08 16:01:11
 */
@Controller
@RequestMapping("/dept")
public class DeptController extends BaseController {

    private String PREFIX = "/system/dept/";

    @Autowired
    private IDeptService deptService;

    /**
     * 跳转到test首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "dept.html";
    }

    /**
     * 跳转到添加test
     */
    @RequestMapping("/dept_add")
    public String deptAdd() {
        return PREFIX + "dept_add.html";
    }

    /**
     * 跳转到修改test
     */
    @RequestMapping("/dept_update/{deptId}")
    public String deptUpdate(@PathVariable Integer deptId, Model model) {
        Dept dept = deptService.selectById(deptId);
        model.addAttribute("item",dept);
        LogObjectHolder.me().set(dept);
        return PREFIX + "dept_edit.html";
    }

    /**
     * 获取test列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return deptService.selectList(null);
    }

    /**
     * 新增test
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Dept dept) {
        deptService.insert(dept);
        return SUCCESS_TIP;
    }

    /**
     * 删除test
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer deptId) {
        deptService.deleteById(deptId);
        return SUCCESS_TIP;
    }

    /**
     * 修改test
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Dept dept) {
        deptService.updateById(dept);
        return SUCCESS_TIP;
    }

    /**
     * test详情
     */
    @RequestMapping(value = "/detail/{deptId}")
    @ResponseBody
    public Object detail(@PathVariable("deptId") Integer deptId) {
        return deptService.selectById(deptId);
    }
}
