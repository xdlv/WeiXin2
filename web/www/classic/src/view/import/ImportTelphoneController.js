Ext.define('TrackCar.view.import.ImportTelphoneController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.import-importtelphone',

    importClick: function (btn) {
        btn.up('form').getForm().submit({
            clientValidation: true,
            url: '../importTelephone.cmd',
            waitTitle:"请稍候",
            waitMsg:"正在导入文件，请稍候。。。。。。",
            failure:function(form1,action){
                Ext.MessageBox.hide();
                Ext.MessageBox.alert('Error',action.result.msg);
            },
            success: function(form1,action){
                Ext.MessageBox.hide();
                Ext.MessageBox.alert('Success',action.result.msg);
            }
        })
    }
});
