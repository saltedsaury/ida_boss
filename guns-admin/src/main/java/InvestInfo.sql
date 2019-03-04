INSERT INTO `guns`.`sys_menu` (`id`, `code`, `pcode`, `pcodes`, `name`, `icon`, `url`, `num`, `levels`, `ismenu`, `tips`, `status`, `isopen`)
VALUES ('1095608060251066374', 'redemptMenu', '0', '[0],', '赎回管理', '', '', '99', '1', '1', NULL, '1', '0');

INSERT INTO `guns`.`sys_menu` (`id`, `code`, `pcode`, `pcodes`, `name`, `icon`, `url`, `num`, `levels`, `ismenu`, `tips`, `status`, `isopen`)
VALUES ('1095608060251066370', 'redempt', 'redemptMenu', '[0],[redemptMenu],', '赎回管理', '', '/redempt', '99', '2', '1', NULL, '1', '0');
INSERT INTO `guns`.`sys_menu` (`id`, `code`, `pcode`, `pcodes`, `name`, `icon`, `url`, `num`, `levels`, `ismenu`, `tips`, `status`, `isopen`)
VALUES ('1095608060251066371', 'redempt_list', 'redempt', '[0],[redemptMenu],[redempt],', '赎回管理列表', '', '/redempt/list', '99', '3', '0', NULL, '1', '0');
INSERT INTO `guns`.`sys_menu` (`id`, `code`, `pcode`, `pcodes`, `name`, `icon`, `url`, `num`, `levels`, `ismenu`, `tips`, `status`, `isopen`)
VALUES ('1095608060251066373', 'redempt_update', 'redempt', '[0],[redemptMenu],[redempt],', '赎回管理更新', '', '/redempt/update', '99', '3', '0', NULL, '1', '0');

INSERT INTO `guns`.`sys_menu` (`id`, `code`, `pcode`, `pcodes`, `name`, `icon`, `url`, `num`, `levels`, `ismenu`, `tips`, `status`, `isopen`)
VALUES ('1095608060251066375', 'earlyRedempt', 'redemptMenu', '[0],[redemptMenu],', '提前赎回管理', '', '/redempt/earlyRedempt', '99', '2', '1', NULL, '1', '0');
INSERT INTO `guns`.`sys_menu` (`id`, `code`, `pcode`, `pcodes`, `name`, `icon`, `url`, `num`, `levels`, `ismenu`, `tips`, `status`, `isopen`)
VALUES ('1095608060251066376', 'earlyRedempt_list', 'earlyRedempt', '[0],[redemptMenu],[earlyRedempt],', '提前赎回管理列表', '', '/redempt/list', '99', '3', '0', NULL, '1', '0');
INSERT INTO `guns`.`sys_menu` (`id`, `code`, `pcode`, `pcodes`, `name`, `icon`, `url`, `num`, `levels`, `ismenu`, `tips`, `status`, `isopen`)
VALUES ('1095608060251066377', 'earlyRedempt_update', 'earlyRedempt', '[0],[redemptMenu],[earlyRedempt],', '提前赎回管理更新', '', '/redempt/update', '99', '3', '0', NULL, '1', '0');
