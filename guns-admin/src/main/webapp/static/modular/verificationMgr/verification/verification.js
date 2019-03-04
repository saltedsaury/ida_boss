/**
 * 实名认证管理管理初始化
 */
var Verification = {
    id: "VerificationTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Verification.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: 'ID', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '用户ID', field: 'userId', visible: true, align: 'center', valign: 'middle'},
            {title: '真实姓名', field: 'realName', visible: true, align: 'center', valign: 'middle'},
            {title: '身份证号', field: 'idNumber', visible: true, align: 'center', valign: 'middle'},
            {title: '性别', field: 'gender', visible: true, align: 'center', valign: 'middle'},
            {title: '地址', field: 'address', visible: true, align: 'center', valign: 'middle'},
            {title: '邮编', field: 'zipCode', visible: true, align: 'center', valign: 'middle'},
            {title: '省', field: 'province', visible: true, align: 'center', valign: 'middle'},
            {title: '市', field: 'city', visible: true, align: 'center', valign: 'middle'},
            {title: '区', field: 'area', visible: true, align: 'center', valign: 'middle'},
            {title: '民族', field: 'race', visible: true, align: 'center', valign: 'middle'},
            {title: '身份证签发单位', field: 'idcardIssuedBy', visible: true, align: 'center', valign: 'middle'},
            {title: '身份证有效日期', field: 'idcardValidDate', visible: true, align: 'center', valign: 'middle'},
            {title: '更新时间', field: 'updatedAt', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createdAt', visible: true, align: 'center', valign: 'middle'},
            {title: '状态', field: 'status', visible: true, align: 'center', valign: 'middle'},
            {title: '文件编号', field: 'fileNo', visible: false, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Verification.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Verification.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加实名认证管理
 */
Verification.openAddVerification = function () {
    var index = layer.open({
        type: 2,
        title: '添加实名认证管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/verification/verification_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看实名认证管理详情
 */
Verification.openVerificationDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '实名认证管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/verification/verification_update/' + Verification.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除实名认证管理
 */
Verification.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/verification/delete", function (data) {
            Feng.success("删除成功!");
            Verification.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("verificationId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询实名认证管理列表
 */
Verification.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Verification.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Verification.initColumn();
    var table = new BSTable(Verification.id, "/verification/list", defaultColunms);
    table.setPaginationType("server");
    Verification.table = table.init();
});
