package com.stylefeng.guns.modular.walletMgr.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.core.common.constant.DatasourceEnum;
import com.stylefeng.guns.core.mutidatasource.annotion.DataSource;
import com.stylefeng.guns.modular.system.model.User;
import com.stylefeng.guns.modular.system.service.impl.UserServiceImpl;
import com.stylefeng.guns.modular.walletMgr.model.Wallet;
import com.stylefeng.guns.modular.walletMgr.dao.WalletMapper;
import com.stylefeng.guns.modular.walletMgr.model.WalletVO;
import com.stylefeng.guns.modular.walletMgr.service.IWalletService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sue123
 * @since 2019-02-13
 */

@Slf4j
@Service
@DataSource(name = DatasourceEnum.DATA_SOURCE_SETTLEMENT)
public class WalletServiceImpl extends ServiceImpl<WalletMapper, Wallet> implements IWalletService {
    @Autowired
    private UserServiceImpl userService;

    @Override
    public Page<Wallet> queryWalletList(Wallet wallet, Page<Wallet> page){
        EntityWrapper<Wallet> wrapper = new EntityWrapper<>();
        try{
            wrapper.setSqlSelect("id","name","account_type","address","is_freeze","created_at","user_id");
            wrapper.eq("user_id",wallet.getUserId());
            page = this.selectPage(page,wrapper);
        }catch (Exception e){
            log.error("query wallet for form error,{}",e.getMessage());
        }
        return page;
    }

    @Override
    public WalletVO formatToVO(Wallet wallet){
        WalletVO vo = new WalletVO();
        vo.setAccountType(wallet.getAccountType().toString());
        vo.setAddress(wallet.getAddress());
        vo.setCreatedAt(wallet.getCreatedAt());
        vo.setId(wallet.getId().toString());
        vo.setIsFreeze(wallet.getIsFreeze().toString());
        vo.setName(wallet.getName());
        User user = userService.getById(wallet.getUserId().toString());
        vo.setAccount(user.getAccount());
        return vo;
    }

    @Override
    public Page<WalletVO> formatList(Page<Wallet> walletPage){
        Page<WalletVO> page = new Page<>();
        List<WalletVO> wallets = new ArrayList<>();
        for (Wallet wallet : walletPage.getRecords()){
            WalletVO vo = new WalletVO();
            vo = formatToVO(wallet);

            wallets.add(vo);
        }

        page.setRecords(wallets);
        page.setTotal(walletPage.getTotal());
        return page;
    }
}
