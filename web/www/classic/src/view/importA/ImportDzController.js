Ext.define('TrackCar.view.importA.ImportDzController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.import-importdz',
    requires: ['Ext.window.Window'],

    importClick: function (btn) {
        var me = this;
        var win = Ext.create('Ext.window.Window',{
            title: '请选择所属期',
            width: 300,
            heigh: 200,
            layout: 'fit',
            items: [{
                xtype: 'form',
                margin: '10',
                defaults: {
                    anchor: '100%',
                    xtype: 'textfield'
                },
                items: [{
                    fieldLabel: '年',
                    name: 'year'
                },{
                    fieldLabel: '月',
                    name : 'month'
                }],
                buttons: [{
                    text: '确认',
                    handler: function (button) {
                        me.uploadFile(btn, button.up('form').getValues());
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

    uploadFile : function(btn, values){
        btn.up('form').getForm().submit({
            clientValidation: true,
            params: values,
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
