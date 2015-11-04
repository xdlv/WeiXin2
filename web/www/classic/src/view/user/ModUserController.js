Ext.define('TrackCar.view.user.ModUserController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.user-moduser',
    
    addUser : function(btn){
    	Ext.create('TrackCar.view.user.AddUser', {}).show();
    },

    onSelectionChange: function(model, selected,opts){
        this.getReferences().removeButton.setDisabled(selected.length < 1);
    },
    delUser: function(btn){
        var users = btn.up('grid').getSelection();
        var ids = {};
        Ext.each(users, function(v,i){
            ids['users[' + i + '].id'] = v.get('id');
        });
        TrackCar.Util.ajax({
            url : 'deleteUser.cmd',
            params: ids,
            success: function(response, opts) {
                Ext.MessageBox.alert('删除用户',obj.msg);
                btn.up('grid').getStore().reload();
            }
        });
    }
});
