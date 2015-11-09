Ext.define("TrackCar.view.user.AddUser", {
	extend : "Ext.window.Window",

	requires : [ "TrackCar.view.user.AddUserController",
			"TrackCar.view.user.AddUserModel" ],

	controller : "user-adduser",
	viewModel : {
		type : "user-adduser"
	},

	title : '用户信息',
	
	width : 350,
	modal : true,
	layout : 'fit',
	items : [ {
		xtype : 'form',
		margin: '10',
		items : [ {
			xtype : 'fieldset',
			title : '用户信息',
			items : [{
                xtype: 'textfield',
                name: 'user.id',
                hidden: true,
                bind: '{user.id}'
            }, {
				name : 'user.name',
				xtype: 'textfield',
				fieldLabel : '用户名',
				bind: '{user.name}'
			}, {
				xtype: 'textfield',
				name : 'user.pwd',
				inputType : 'password',
				fieldLabel : '密码',
				bind: '{user.pwd}'
			}, {
				xtype: 'textfield',
				name : 'user.mail',
				fieldLabel : '邮箱',
				bind: '{user.mail}'
			},{
                xtype:'combo',
                name: 'user.userRole',
                bind : {
                    disabled: '{!superUser}',
                    value: '{user.userRole}'
                },
                fieldLabel: '角色',
                queryMode: 'local',
                displayField: 'name',
				value: '1',
                editable: false,
                valueField: 'value',
                store:Ext.create('Ext.data.Store', {
                    fields: ['name', 'value'],
                    data : [
                        {"value":"0", "name":"超级用户"},
                        {"value":"1", "name":"普通用户"}
                    ]
                })
            } ]
		} ],
		buttons: [{
			text: '保存',
			bind: {handler: '{operation}'}
		},{
			text: '取消',
			handler: function(btn){
				btn.up('window').close();
			}
		}]
	} ]
});
