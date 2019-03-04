/**
 * 赎回管理管理初始化
 */
var Redempt = {
    id: "InvestInfoTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Redempt.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '自增流水', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '交易流水', field: 'tradeNo', visible: true, align: 'center', valign: 'middle'},
            {title: '业务类型', field: 'bizType', visible: true, align: 'center', valign: 'middle'},
            {title: '客户号', field: 'customerNo', visible: true, align: 'center', valign: 'middle'},
            {title: '产品码', field: 'productNo', visible: true, align: 'center', valign: 'middle'},
            {title: '收益计划编号', field: 'planNo', visible: true, align: 'center', valign: 'middle'},
            {title: '币种', field: 'ccy', visible: true, align: 'center', valign: 'middle'},
            {title: '金额', field: 'amount', visible: true, align: 'center', valign: 'middle'},
            {title: '手续费', field: 'fee', visible: true, align: 'center', valign: 'middle'},
            {title: '罚金', field: 'fine', visible: true, align: 'center', valign: 'middle'},
            {title: '状态', field: 'status', visible: true, align: 'center', valign: 'middle'},
            {title: '操作员', field: 'operatorNo', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
            {title: '修改时间', field: 'modifiedTime', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Redempt.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Redempt.seItem = selected[0];
        return true;
    }
};

/**
 * 查询赎回管理列表
 */
Redempt.search = function () {
    var queryData = {};
    //queryData['condition'] = $("#condition").val();
    queryData['bizType'] = '2';
    queryData['status'] = $("#orderStatus").val();
    Redempt.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Redempt.initColumn();
    var table = new BSTable(Redempt.id, "/redempt/list", defaultColunms);
    table.setPaginationType("server");
    Redempt.table = table.init();
    Redempt.search();
});
