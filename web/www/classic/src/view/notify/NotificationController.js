Ext.define('TrackCar.view.notify.NotificationController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.notify-notification',


    notifyMessage: function(btn){
        //您当前下发的是2015年10月份对账通知，下发后对账数据将不可以再次更改，是否确定下发
        var currentDate = new Date();
        var year = currentDate.getFullYear();
        var month = currentDate.getMonth();
        var message = Ext.util.Format.format('您当前下发的是{0}年{1}月份对账通知，' +
            '下发后对账数据将不可以再次更改，是否确定下发?',year,month);
        Ext.MessageBox.confirm("提示",message ,function(v){
            if (v == 'no'){
                return;
            }
            TrackCar.Util.ajax({
                url : 'notifyMessage.cmd',
                success: function(obj) {
                    Ext.MessageBox.alert('下发通知',obj.msg);
                    grid.getStore().reload();
                }
            });
        },this);
        /*var grid = btn.up('grid');
        var record = grid.getSelection()[0];*/
        /*Ext.Ajax.request({
            url : 'notifyMessage.cmd',
            /!*params: {
                'importDzRecord.year' : record.get('year'),
                'importDzRecord.month' : record.get('month')
            },*!/
            success: function(response, opts) {
                var obj = Ext.decode(response.responseText);
                Ext.MessageBox.alert('成功',obj.msg);
                grid.getStore().reload();
            },
            failure: function(response, opts) {
                var obj = Ext.decode(response.responseText);
                Ext.MessageBox.alert('失败',obj.msg);
            }
        });*/
    }/*,

    onSelectionChange : function(selModel, selectedRecs){
        var button = this.lookupReference('notifyButton');
        if (selectedRecs.length < 1){
            button.setDisabled(true);
            return;
        }
        button.setDisabled(false);
    }*/
    
});
