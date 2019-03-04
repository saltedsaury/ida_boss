/**
 * 初始化保险理赔详情对话框
 */
var CompensateTradeInfoDlg = {
    compensateTradeInfoData : {}
};

/**
 * 清除数据
 */
CompensateTradeInfoDlg.clearData = function() {
    this.compensateTradeInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CompensateTradeInfoDlg.set = function(key, val) {
    this.compensateTradeInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CompensateTradeInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
CompensateTradeInfoDlg.close = function() {
    parent.layer.close(window.parent.CompensateTrade.layerIndex);
}

/**
 * 收集数据
 */
CompensateTradeInfoDlg.collectData = function() {
    this
    .set('id')
    .set('tradeNo')
    .set('insuranceTrade')
    .set('effectiveAmount')
    .set('ccy')
    .set('compensateAmount')
    .set('compensateCcy')
    .set('status')
    .set('operatorNo')
    .set('createTime')
    .set('modifiedTime')
    .set('customerNo');
}

/**
 * 提交添加
 */
CompensateTradeInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/compensateTrade/add", function(data){
        Feng.success("添加成功!");
        window.parent.CompensateTrade.table.refresh();
        CompensateTradeInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.compensateTradeInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
CompensateTradeInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/compensateTrade/update", function(data){
        Feng.success("修改成功!");
        window.parent.CompensateTrade.table.refresh();
        CompensateTradeInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.compensateTradeInfoData);
    ajax.start();
}

$(function() {

});
