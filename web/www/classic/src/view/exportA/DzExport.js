Ext.define("TrackCar.view.exportA.DzExport",{
    extend: "Ext.container.Container",

    requires: [
        "TrackCar.view.exportA.DzExportController",
        "TrackCar.view.exportA.DzExportModel"
    ],

    controller: "export-dzexport",
    viewModel: {
        type: "export-dzexport"
    },
    margin: '10 10 0 10',
    layout : {
        type: 'vbox',
        align: 'stretch'
    },
    items: [{
        xtype: 'form',
        items: [{
            xtype: 'fieldset',
            layout: 'hbox',
            items:[{
                xtype: 'textfield',
                fieldLabel : '客户编码',
                name: 'dzlist.userid',
                flex: 2
            },{
                /*xtype: 'combo',
                margin: '0 0 0 10',
                fieldLabel : '是否确认',
                name: 'dzlist.isok',
                bind: '{comboxStore}',
                queryMode: 'local',
                displayField: 'name',
                valueField: 'value',
                flex: 1*/
                xtype: 'container',
                layout: 'hbox',
                margin: '0 20 0 20',
                items: [{
                    xtype: 'checkbox',
                    boxLabel: '己确认',
                    name: 'confirm',
                    inputValue: 'Y'
                },{
                    margin:'0 0 0 10',
                    xtype: 'checkbox',
                    boxLabel: '未确认',
                    name: 'unconfirm',
                    inputValue: 'N'}
                ],
                flex: 1
            },{
                margin:'0 0 0 5',
                xtype: 'button',
                text: '查询',
                handler: 'queryDzlist'
            },{
                margin:'0 0 0 5',
                xtype: 'button',
                text: '导出',
                handler: 'exportDzlist'
            }]
        }]
    },{
        xtype : 'grid',
        margin: '10 0 0 0',
        flex: 1,
        bind : {
            columns : '{columnsA}',
            store : '{store}'
        },
        bbar : {
            xtype : "pagingtoolbar",
            displayInfo : true,
            bind : '{store}'
        }

    }]
});
