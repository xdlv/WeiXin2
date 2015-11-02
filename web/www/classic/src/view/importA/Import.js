Ext.define("TrackCar.view.importA.Import", {
    extend : "Ext.container.Container",

    requires : [ "TrackCar.view.importA.ImportController",
        "TrackCar.view.importA.ImportModel",
        'Ext.toolbar.Paging',
        'Ext.grid.Panel',
        'Ext.form.field.File'
    ],

    controller : "import-import",
    viewModel : {
        type : "import-import"
    },

    margin: '10 10 0 10',
    layout : {
        type: 'vbox',
        align: 'stretch'
    },

    items : [ {
        xtype: 'form',
        layout: 'hbox',
        items: [{
            xtype : 'filefield',
            name: 'excel',
            labelWidth: 150,
            required: 'true',
            bind : {
                fieldLabel: '{fieldLabel}'
            },
            buttonText: '选择文件',
            flex: 1
        },{
            margin: '0 0 0 10',
            xtype: 'button',
            text: '导入',
            handler: 'importClick'
        }]
    }, {
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
    } ]
});
