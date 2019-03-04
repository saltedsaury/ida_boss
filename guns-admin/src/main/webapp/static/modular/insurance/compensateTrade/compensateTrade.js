/**
 * 保险理赔管理初始化
 */
var CompensateTrade = {
    id: "CompensateTradeTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
CompensateTrade.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: 'ID', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '流水号', field: 'tradeNo', visible: true, align: 'center', valign: 'middle'},
            {title: '保险投资编号', field: 'insuranceTrade', visible: true, align: 'center', valign: 'middle'},
            {title: '保单生效金额', field: 'effectiveAmount', visible: true, align: 'center', valign: 'middle'},
            {title: '保单原币种', field: 'ccy', visible: true, align: 'center', valign: 'middle'},
            {title: '理赔金额', field: 'compensateAmount', visible: true, align: 'center', valign: 'middle'},
            {title: '理赔币种', field: 'compensateCcy', visible: true, align: 'center', valign: 'middle'},
            {title: '状态', field: 'status', visible: true, align: 'center', valign: 'middle'},
            {title: '操作员', field: 'operatorNo', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
            {title: '修改时间', field: 'modifiedTime', visible: true, align: 'center', valign: 'middle'},
            {title: '用户ID', field: 'customerNo', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
CompensateTrade.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        CompensateTrade.seItem = selected[0];
        return true;
    }
};

/**
 * 删除保险理赔
 */
CompensateTrade.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/compensateTrade/delete", function (data) {
            Feng.success("删除成功!");
            CompensateTrade.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("compensateTradeId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询保险理赔列表
 */
CompensateTrade.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    CompensateTrade.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = CompensateTrade.initColumn();
    var table = new BSTable(CompensateTrade.id, "/compensateTrade/list", defaultColunms);
    table.setPaginationType("client");
    CompensateTrade.table = table.init();
});


CompensateTrade.auditing = function () {
    if (this.check()) {
        //提交信息
        var ajax = new $ax(Feng.ctxPath + "/compensateTrade/auditing", function (data) {
            Feng.success("审核成功!");
            window.CompensateTrade.table.refresh();
        }, function (data) {
            Feng.error("审核失败!" + data.responseJSON.message + "!");
        });
        ajax.set(this.seItem);
        ajax.start();
    }
};