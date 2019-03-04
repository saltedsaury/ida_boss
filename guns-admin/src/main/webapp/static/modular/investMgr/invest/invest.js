/**
 * 申购管理管理初始化
 */
var Invest = {
    id: "InvestInfoTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Invest.initColumn = function () {
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
            {title: '协议编号', field: 'agreementNo', visible: true, align: 'center', valign: 'middle'},
            {title: '期限', field: 'investCycle', visible: true, align: 'center', valign: 'middle'},
            {title: '保险编号', field: 'insuranceNo', visible: true, align: 'center', valign: 'middle'},
            {title: '收益率', field: 'revenueRate', visible: true, align: 'center', valign: 'middle'},
            {title: '操作员', field: 'operatorNo', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
            {title: '修改时间', field: 'modifiedTime', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Invest.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Invest.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加申购管理
 */
Invest.openAddInvestInfo = function () {
    var index = layer.open({
        type: 2,
        title: '添加申购管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/invest/investInfo_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看申购管理详情
 */
Invest.openInvestInfoDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '申购管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/invest/investInfo_update/' + Invest.seItem.id
        });
        this.layerIndex = index;
    }
};


/**
 * 查询申购管理列表
 */
Invest.search = function () {
    var queryData = {};
    queryData['status'] = $("#orderStatus").val();
    Invest.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Invest.initColumn();
    var table = new BSTable(Invest.id, "/invest/list", defaultColunms);
    table.setPaginationType("server");
    Invest.table = table.init();
});
