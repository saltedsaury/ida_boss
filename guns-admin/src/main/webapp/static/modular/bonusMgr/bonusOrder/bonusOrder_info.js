/**
 * 初始化分红管理详情对话框
 */
var BonusOrderInfoDlg = {
    bonusOrderInfoData : {}
};

/**
 * 清除数据
 */
BonusOrderInfoDlg.clearData = function() {
    this.bonusOrderInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
BonusOrderInfoDlg.set = function(key, val) {
    this.bonusOrderInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
BonusOrderInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
BonusOrderInfoDlg.close = function() {
    parent.layer.close(window.parent.BonusOrder.layerIndex);
}

/**
 * 收集数据
 */
BonusOrderInfoDlg.collectData = function() {
    this
    .set('id')
    .set('tradeNo')
    .set('customerNo')
    .set('investNo')
    .set('planNo')
    .set('periods')
    .set('ccy')
    .set('amount')
    .set('status')
    .set('operatorNo')
    .set('remark')
    .set('createTime')
    .set('modifiedTime');
}

/**
 * 提交添加
 */
BonusOrderInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/bonusOrder/add", function(data){
        Feng.success("添加成功!");
        window.parent.BonusOrder.table.refresh();
        BonusOrderInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.bonusOrderInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
BonusOrderInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/bonusOrder/update", function(data){
        Feng.success("修改成功!");
        window.parent.BonusOrder.table.refresh();
        BonusOrderInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.bonusOrderInfoData);
    ajax.start();
}

$(function() {

});
