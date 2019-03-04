/**
 * 初始化实名认证管理详情对话框
 */
var VerificationInfoDlg = {
    verificationInfoData : {}
};

/**
 * 清除数据
 */
VerificationInfoDlg.clearData = function() {
    this.verificationInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
VerificationInfoDlg.set = function(key, val) {
    this.verificationInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
VerificationInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
VerificationInfoDlg.close = function() {
    parent.layer.close(window.parent.Verification.layerIndex);
}

/**
 * 收集数据
 */
VerificationInfoDlg.collectData = function() {
    this
    .set('id')
    .set('userId')
    .set('realName')
    .set('idNumber')
    .set('gender')
    .set('address')
    .set('zipCode')
    .set('province')
    .set('city')
    .set('area')
    .set('race')
    .set('idcardIssuedBy')
    .set('idcardValidDate')
    .set('avatar')
    .set('idCardFront')
    .set('idCardBack')
    .set('updatedAt')
    .set('createdAt');
}

/**
 * 提交添加
 */
VerificationInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/verification/add", function(data){
        Feng.success("添加成功!");
        window.parent.Verification.table.refresh();
        VerificationInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.verificationInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
VerificationInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/verification/update", function(data){
        Feng.success("修改成功!");
        window.parent.Verification.table.refresh();
        VerificationInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.verificationInfoData);
    ajax.start();
}

$(function() {

});
