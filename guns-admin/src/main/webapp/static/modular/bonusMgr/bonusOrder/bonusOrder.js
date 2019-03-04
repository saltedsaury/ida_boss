/**
 * 分红管理管理初始化
 */
var BonusOrder = {
    id: "BonusOrderTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
BonusOrder.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '自增id', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '交易流水', field: 'tradeNo', visible: true, align: 'center', valign: 'middle'},
            {title: '客户号', field: 'customerNo', visible: true, align: 'center', valign: 'middle'},
            {title: '投资编号', field: 'investNo', visible: true, align: 'center', valign: 'middle'},
            {title: '收益计划编号', field: 'planNo', visible: true, align: 'center', valign: 'middle'},
            {title: '期数', field: 'periods', visible: true, align: 'center', valign: 'middle'},
            {title: '币种', field: 'ccy', visible: true, align: 'center', valign: 'middle'},
            {title: '金额', field: 'amount', visible: true, align: 'center', valign: 'middle'},
            {title: '状态', field: 'status', visible: true, align: 'center', valign: 'middle'},
            {title: '操作员', field: 'operatorNo', visible: true, align: 'center', valign: 'middle'},
            {title: '备注', field: 'remark', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
            {title: '修改时间', field: 'modifiedTime', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
BonusOrder.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        BonusOrder.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加分红管理
 */
BonusOrder.openAddBonusOrder = function () {
    var index = layer.open({
        type: 2,
        title: '添加分红管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/bonusOrder/bonusOrder_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看分红管理详情
 */
BonusOrder.openBonusOrderDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '分红管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/bonusOrder/bonusOrder_update/' + BonusOrder.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除分红管理
 */
BonusOrder.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/bonusOrder/delete", function (data) {
            Feng.success("删除成功!");
            BonusOrder.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("bonusOrderId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询分红管理列表
 */
BonusOrder.search = function () {
    var queryData = {};
    queryData['status'] = $("#orderStatus").val();
    BonusOrder.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = BonusOrder.initColumn();
    var table = new BSTable(BonusOrder.id, "/bonusOrder/list", defaultColunms);
    table.setPaginationType("server");
    BonusOrder.table = table.init();
});

BonusOrder.auditing = function () {
    if (this.check()) {
        //提交信息
        var ajax = new $ax(Feng.ctxPath + "/bonusOrder/auditing", function (data) {
            Feng.success("审核成功!");
            window.BonusOrder.table.refresh();
        }, function (data) {
            Feng.error("审核失败!" + data.responseJSON.message + "!");
        });
        ajax.set(this.seItem);
        ajax.start();
    }
};
