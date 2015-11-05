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
            layout: {
                type: 'hbox',
                align: 'stretch'
            },
            items:[{
                xtype: 'container',
                layout: {
                    type: 'vbox',
                    align: 'stretch'
                },
                flex: 2,
                items: [{
                    xtype: 'textfield',
                    fieldLabel: '客户编码',
                    name: 'dzlist.userid',
                    labelWidth: 70
                }, {
                    xtype: 'textfield',
                    fieldLabel: '客户名称',
                    name: 'dzlist.username',
                    labelWidth: 70
                }]
            },{
                xtype: 'container',
                layout: {
                    type: 'vbox',
                    align: 'stretch'
                },
                flex: 2,
                items:[{
                    xtype: 'datefield',
                    fieldLabel: '所属账期',
                    labelAlign: 'right',
                    name: 'yearMonth',
                    format: 'Y年m月',
                },{
                    xtype: 'textfield',
                    labelAlign: 'right',
                    fieldLabel: '电话号码',
                    name: 'dzlist.phone',
                }]
            },{
                xtype:'container',
                layout: {
                    type: 'vbox',
                    align: 'stretch'
                },
                margin: '0 10 0 20',
                flex: 1,
                items:[{
                    xtype: 'container',
                    layout: {
                        type: 'hbox',
                        align: 'stretch'
                    },
                    items: [{
                        xtype: 'checkbox',
                        boxLabel: '己确认',
                        name: 'confirm',
                        inputValue: 'Y'
                    }, {
                        xtype: 'checkbox',
                        boxLabel: '未确认',
                        name: 'unconfirm',
                        inputValue: 'N'
                    }]
                },{
                    xtype: 'container',
                    margin: '3 0 0 0',
                    layout: {
                        type: 'hbox',
                        align: 'stretch'
                    },
                    items: [{
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