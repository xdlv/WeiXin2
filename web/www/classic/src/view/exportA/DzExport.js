Ext.define("TrackCar.view.exportA.DzExport", {
    extend: "Ext.container.Container",

    requires: [
        "TrackCar.view.exportA.DzExportController",
        "TrackCar.view.exportA.DzExportModel",
        'Ext.form.field.Date'
    ],

    controller: "export-dzexport",
    viewModel: {
        type: "export-dzexport"
    },
    margin: '10 10 0 10',
    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    items: [{
        xtype: 'form',
        items: [{
            xtype: 'fieldset',
            layout: {type: 'vbox', align: 'stretch'},
            items: [{
                xtype: 'container',
                layout: {type: 'hbox', align: 'stretch'},
                items: [{
                    xtype: 'textfield',
                    fieldLabel: '客户名称',
                    name: 'username',
                    flex: 2,
                    labelWidth : 70
                }, {
                    xtype: 'textfield',
                    labelAlign: 'right',
                    fieldLabel: '电话号码',
                    name: 'phone',
                    flex: 1
                }, {
                    xtype: 'container',
                    layout: 'hbox',
                    margin: '0 20 0 20',
                    items: [{
                        xtype: 'checkbox',
                        boxLabel: '己确认',
                        name: 'confirm',
                        inputValue: 'Y'
                    }, {
                        margin: '0 0 0 10',
                        xtype: 'checkbox',
                        boxLabel: '未确认',
                        name: 'unconfirm',
                        inputValue: 'N'
                    }],
                    flex: 1
                }]
            }, {
                xtype: 'container',
                margin: '8 0 0 0',
                layout: {type: 'hbox', align: 'stretch'},
                items: [{
                    xtype: 'textfield',
                    fieldLabel: '客户编码',
                    name: 'userid',
                    flex: 4,
                    labelWidth : 70
                },{
                    xtype: 'datefield',
                    fieldLabel: '属期',
                    labelAlign: 'right',
                    name: 'yearMonth',
                    flex: 2,
                    labelWidth : 40,
                    format: 'Y年m月',
                }, {
                    margin: '0 0 0 5',
                    xtype: 'button',
                    text: '查询',
                    handler: 'queryDzlist',
                    flex: 1
                }, {
                    margin: '0 0 0 5',
                    xtype: 'button',
                    text: '导出',
                    handler: 'exportDzlist',
                    flex: 1
                }]
            }]
        }]
    }, {
        xtype: 'grid',
        margin: '10 0 0 0',
        flex: 1,
        bind: {
            columns: '{columnsA}',
            store: '{store}'
        },
        bbar: {
            xtype: "pagingtoolbar",
            displayInfo: true,
            bind: '{store}'
        }

    }]
});
