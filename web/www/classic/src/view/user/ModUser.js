Ext.define("TrackCar.view.user.ModUser", {
	extend : "Ext.grid.Panel",

	requires : [ "TrackCar.view.user.ModUserController",
			"TrackCar.view.user.ModUserModel" ],

	controller : "user-moduser",
	viewModel : {
		type : "user-moduser"
	},

	margin: '10',
	columns : [ {
		text : "用户名",
		sortable : true,
		dataIndex : 'name'
	}, {
		text : "邮箱",
		dataIndex : 'mail'
	} ],
	columnLines : true,
	bind : '{loginUsers}',
	selModel : {
		type : 'checkboxmodel',
		listeners : {
			selectionchange : 'onSelectionChange'
		}
	},
	bbar : {
		xtype : "pagingtoolbar",
		displayInfo : true,
		bind: '{loginUsers}'
	},
	
	tbar: {
        margin: '0 0 10 10',
		xtype: 'container',
		layout: 'hbox',
        items: [{
			xtype: 'button',
            text: '增加用户',
            handler: 'addUser'
        },{
            margin: '0 0 0 10',
            reference: 'removeButton',
            text: '删除用户',
            xtype: 'button',
            disabled: true,
            handler: 'delUser'
        }]
	}
});
