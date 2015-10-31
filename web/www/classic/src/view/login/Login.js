Ext.define("TrackCar.view.login.Login", {
	extend : "Ext.window.Window",
	requires : [ "TrackCar.view.login.LoginController",
			"TrackCar.view.login.LoginModel" ],

	controller : "login-login",
	viewModel : {
		type : "login-login"
	},
	cls : 'auth-locked-window',
	closable : false,
	resizable : false,
	autoShow : true,
	titleAlign : 'center',
	maximized : true,
	modal : true,
	header : false,

	layout : {
		type : 'hbox',
		align : 'center',
		pack : 'center'
	},
	items : [ {
		xtype : 'form',
		width : 400,
		bodyPadding : '20 20',
		layout : {
			type : 'vbox',
			align : 'stretch'
		},
		title : '用户登陆',
		defaults:{
			blankText: '该项不能为空'
		},
		items : [ {
			xtype : 'textfield',
			cls : 'auth-textbox',
			name : 'user.name',
			bind : '{userName}',
			height : 55,
			hideLabel : true,
			allowBlank : false,
			emptyText : '用户名'
		}, {
			xtype : 'textfield',
			cls : 'auth-textbox',
			height : 55,
			hideLabel : true,
			emptyText : '密码',
			inputType : 'password',
			name : 'user.pwd',
			bind : '{password}',
			allowBlank : false
		}, {
			xtype : 'button',
			reference : 'loginButton',
			formBind: true,
			scale : 'large',
			iconAlign : 'right',
			text : '登陆',
			listeners : {
				click : 'loginClick'
			}
		} ]
	} ]
});
