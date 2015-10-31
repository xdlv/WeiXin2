Ext.define("TrackCar.view.import.Import", {
    extend : "Ext.container.Container",

    requires : [ "TrackCar.view.import.ImportController",
        "TrackCar.view.import.ImportModel" ],

    controller : "import-import",
    viewModel : {
        type : "import-import"
    },

    margin: '10',
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
