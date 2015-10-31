Ext.define('WX.view.HistoryQuery', {
	extend : 'Ext.form.Panel',
	xtype : 'hquery',
	config : {
		fullscreen : true,
		items : [ {
			docked : 'top',
			height : 20,
			xtype : 'titlebar',
			title : '历史查询'
		}, {
			xtype : 'fieldset',
			layout: 'vbox',
			items : [ {
				xtype: 'datepickerfield',
                label: '选择年月',
                name: 'queryDate',
                value: new Date(),
                dateFormat: 'Y-m',
                picker: {
                	cancelButton: '取消',
                	doneButton: '确认',
                	slotOrder : ['year','month']
                }
			}, {
				xtype : 'component',
				name : 'hqContent',
				padding: '30',
				height: 350,
				tpl : '<p>Name: {name}</p><p>Title: {title}</p>',
			}]
		}]
	}
});