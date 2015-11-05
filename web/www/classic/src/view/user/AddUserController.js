Ext.define('TrackCar.view.user.AddUserController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.user-adduser',
    
    saveUser: function(btn){
    	var params = btn.up('form').getValues();
    	var win = btn.up('window');
    	Ext.Ajax.request({
    		url: '../saveUser.cmd',
    		method: 'POST',
    		params: params,
    		success: function(response){
    			Ext.Msg.alert('用户信息','操作成功');
    			win.close();
    		},
    		failure: function(response){
    			Ext.Msg.alert('用户信息' ,'操作错误');
    		}
    	});
    }
});
