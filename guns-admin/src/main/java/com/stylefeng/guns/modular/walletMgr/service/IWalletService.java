package com.stylefeng.guns.modular.walletMgr.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.modular.walletMgr.model.Wallet;
import com.baomidou.mybatisplus.service.IService;
import com.stylefeng.guns.modular.walletMgr.model.WalletVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sue123
 * @since 2019-02-13
 */
public interface IWalletService extends IService<Wallet> {

    Page<Wallet> queryWalletList(Wallet wallet, Page<Wallet> page);

    WalletVO formatToVO(Wallet wallet);

    Page<WalletVO> formatList(Page<Wallet> walletPage);
}
