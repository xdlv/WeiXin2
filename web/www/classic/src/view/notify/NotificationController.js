Ext.define('TrackCar.view.notify.NotificationController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.notify-notification',

    notifyMessage: function(btn){
        var grid = btn.up('grid');
        var record = grid.getSelection()[0];
        Ext.Ajax.request({
            url : 'notifyMessage.cmd',
            params: {
                'importDzRecord.year' : record.get('year'),
                'importDzRecord.month' : record.get('month')
            },
            success: function(response, opts) {
                var obj = Ext.decode(response.responseText);
                Ext.MessageBox.alert('成功',obj.msg);
                grid.getStore().reload();
            },
            failure: function(response, opts) {
                var obj = Ext.decode(response.responseText);
                Ext.MessageBox.alert('失败',obj.msg);
            }
        });
    },

    onSelectionChange : function(selModel, selectedRecs){
        var button = this.lookupReference('notifyButton');
        if (selectedRecs.length < 1){
            button.setDisabled(true);
            return;
        }
        button.setDisabled(false);
    }
    
});
