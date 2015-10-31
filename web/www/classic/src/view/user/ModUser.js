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
		xtype: 'toolbar',
        items: [{
            text: '增加用户',
            handler: 'addUser'
        }, '-', {
            text: '修改用户',
            tooltip: 'Set options',
            iconCls: 'framing-buttons-option'
        },'-',{
            reference: 'removeButton',
            text: '删除用户',
            tooltip: 'Remove the selected item',
            iconCls:'framing-buttons-remove',
            disabled: true
        }]
	}
});
