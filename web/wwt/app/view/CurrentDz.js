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
                xtype: 'textfield',
                disabled: 'true',
                name: 'dzResult',
                label: '对账结果'
            },{
                xtype : 'component',
                name : 'hqContent',
                padding: '30',
                height: 400
            },{
                xtype:'container',
                layout: 'hbox',
                margin: '10',
                items:[{
                    xtype: 'button',
                    ui : 'confirm',
                    text: '无异议',
                    name: 'confirmDz',
                    disabled : false,
                    flex: 1
                },{
                    margin: '0 0 0 10',
                    xtype: 'button',
                    ui : 'normal',
                    text: '有异议',
                    name: 'reject',
                    disabled : false,
                    flex: 1
                }]
            }]
        }]
    }
});