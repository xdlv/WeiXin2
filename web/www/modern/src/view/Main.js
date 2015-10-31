Ext.define('TrackCar.view.Main', {
	extend : 'Ext.form.Panel',
	xtype : 'main',
	config : {
		fullscreen : true,
		items : [ {
			docked : 'top',
			height : 20,
			xtype : 'titlebar',
			title : '用户绑定'
		}, {
			xtype : 'fieldset',
			title : '',
			instructions : '(*请妥善保存你的帐号信息，一个手机号只能绑定一次)',
			items : [ {
				xtype: 'container',
				layout: 'hbox',
				items:[{
					xtype : 'textfield',
					label : '手机号',
					name : 'phone',
					labelWidth: 150,
					flex : 1
				}, {
					xtype: 'button',
					text : '获取验证码',
					ui: 'action-round',
					margin: '10'
				}]
			}, {
				xtype : 'textfield',
				label : '验证码',
				name : 'validateCode',
				labelWidth: 150,
			} ]
		}, {
			xtype : 'button',
			text : '绑定',
			ui : 'confirm',
			margin: '10'
		} ]
	}
});
