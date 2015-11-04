Ext.define('TrackCar.view.importA.ImportDzController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.import-importdz',
    requires: [
        'Ext.window.Window',
        'Ext.picker.Date'
    ],

    importClick: function (btn) {
        var file = btn.up('form').down('filefield').getValue();
        if (Ext.isEmpty(file)){
            return;
        }
        var me = this;
        var win = Ext.create('Ext.window.Window',{
            title: '请选择所属期',
            width: 300,
            heigh:180,
            layout: 'fit',
            items: [{
                xtype: 'form',
                margin: '10',
                items: [{
                    xtype: 'datepicker',
                    value: new Date(new Date().getFullYear()
                        , new Date().getMonth() - 1, new Date().getDay())
                }],
                buttons: [{
                    text: '确认',
                    handler: function (button) {
                        var value = this.up('form').down('datepicker').getValue();
                        me.uploadFile(btn, value.getUTCFullYear(),value.getMonth());
                        win.close();
                    }
                },{
                    text: '取消',
                    handler: function(button){
                        this.up('window').close();
                    }
                }]
            }]
        }).show();
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
                Ext.MessageBox.alert('Error',action.result.msg);
            },
            success: function(form1,action){
                Ext.MessageBox.hide();
                Ext.MessageBox.alert('Success',action.result.msg);
            }
        });
    }
    
});
