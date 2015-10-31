Ext.define('TrackCar.view.login.LoginController', {
	extend : 'Ext.app.ViewController',
	alias : 'controller.login-login',

	loginClick : function(button) {
		var form = button.up('form');
		Ext.Ajax.request({
			url : 'userLogin.cmd',
			method : 'POST',
			params : form.getValues(),
			scope : this,
			success : this.loginSuccess
		});
	},
	loginSuccess : function(response) {
		var session = this.getView().getSession();
		
		var userReader = Ext.data.schema.Schema.lookupEntity('User').getProxy().getReader();
		//userReader.setConfig('rootProperty','users');
		var users = userReader.read(response, {
					recordCreator : session.recordCreator
				});
		if (users.getRecords().length < 1) {
			return;
		}
		var user = users.getRecords()[0];
		this.fireViewEvent('login', user);
	}

});
