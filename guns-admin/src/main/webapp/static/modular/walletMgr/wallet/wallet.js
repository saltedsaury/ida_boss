/**
 * 币池管理管理初始化
 */
var Wallet = {
    id: "WalletTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Wallet.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: 'ID', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '钱包名称', field: 'name', visible: true, align: 'center', valign: 'middle'},
            {title: '钱包类型', field: 'accountType', visible: true, align: 'center', valign: 'middle'},
            {title: '钱包地址', field: 'address', visible: true, align: 'center', valign: 'middle'},
            {title: '状态', field: 'isFreeze', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createdAt', visible: true, align: 'center', valign: 'middle'},
            {title: '操作人', field: 'account', visible: true, align: 'center', valign: 'middle'},
            {title: '操作', field: '', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Wallet.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Wallet.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加币池管理
 */
Wallet.openAddWallet = function () {
    var index = layer.open({
        type: 2,
        title: '添加币池管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/wallet/wallet_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看币池管理详情
 */
Wallet.openWalletDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '币池管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/wallet/wallet_update/' + Wallet.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除币池管理
 */
Wallet.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/wallet/delete", function (data) {
            Feng.success("删除成功!");
            Wallet.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("walletId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询币池管理列表
 */
Wallet.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Wallet.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Wallet.initColumn();
    var table = new BSTable(Wallet.id, "/wallet/list", defaultColunms);
    table.setPaginationType("server");
    Wallet.table = table.init();
});
