Ext.define('WX.view.CurrentDz', {
    extend : 'Ext.form.Panel',
    xtype : 'currentQuery',
    config : {
        fullscreen : true,
        items : [ {
            docked : 'top',
            height : 20,
            xtype : 'titlebar',
            title : '当前对帐'
        }, {
            xtype : 'fieldset',
            layout: {
                type: 'vbox'
            },
            items : [{
                xtype : 'component',
                name : 'hqContent',
                padding: '30',
                height: 400
            },{
                xtype: 'button',
                ui : 'confirm',
                margin: '10',
                text: '确认对账',
                name: 'confirmDz',
                disabled : true
            }]
        }]
    }
});