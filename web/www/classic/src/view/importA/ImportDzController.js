Ext.define('TrackCar.view.importA.ImportDzController', {
    extend: 'TrackCar.view.exportA.DzExportController',
    alias: 'controller.import-importdz',
    requires: [
        'Ext.window.Window',
        'Ext.picker.Date',
        'TrackCar.view.exportA.DzExportController'
    ],

    importClick: function (btn) {
        var file = btn.up('form').down('filefield').getValue();
        if (Ext.isEmpty(file)){
            return;
        }
        var me = this;
        var currentDate = new Date();
        var year = currentDate.getFullYear();
        var month = currentDate.getMonth();
        var message = Ext.util.Format.format('您正导入{0}年{1}月的对账信息，是否继续?',year,month);
        Ext.MessageBox.confirm("提示",message ,function(v){
                if (v == 'no'){
                    return;
                }
                this.uploadFile(btn,year,month);
        },this);
    },

    uploadFile : function(btn, year, month){
        var form = btn.up('form');
        var datePicker = form.down('datepicke')
        btn.up('form').getForm().submit({
            clientValidation: true,
            params: {year: year, month : month},
            url: 'importDzlist.cmd',
            waitTitle:"请稍候",
            waitMsg:"正在导入文件，请稍候。。。。。。",
            failure:function(form1,action){
                Ext.MessageBox.hide();
                Ext.MessageBox.alert('失败',action.result.msg);
            },
            success: function(form1,action){
                Ext.MessageBox.hide();
                Ext.MessageBox.alert('成功',action.result.msg);
            }
        });
    }
});
