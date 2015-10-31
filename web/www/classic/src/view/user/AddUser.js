Ext.define("TrackCar.view.user.AddUser", {
	extend : "Ext.window.Window",

	requires : [ "TrackCar.view.user.AddUserController",
			"TrackCar.view.user.AddUserModel" ],

	controller : "user-adduser",
	viewModel : {
		type : "user-adduser"
	},

	title : '增加用户',
	
	width : 350,
	modal : true,
	layout : 'fit',
	items : [ {
		xtype : 'form',
		margin: '10',
		items : [ {
			xtype : 'fieldset',
			title : '用户信息',
			items : [ {
				name : 'user.name',
				xtype: 'textfield',
				fieldLabel : '用户名'
			}, {
				xtype: 'textfield',
				name : 'user.pwd',
				inputType : 'password',
				fieldLabel : '密码'
			}, {
				xtype: 'textfield',
				name : 'user.mail',
				fieldLabel : '邮箱'
			} ]
		} ],
		buttons: [{
			text: '保存',
			handler: 'saveUser'
		},{
			text: '取消',
			handler: function(btn){
				btn.up('window').close();
			}
		}]
	} ]
});
