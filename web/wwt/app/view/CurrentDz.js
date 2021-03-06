Ext.define('WX.view.CurrentDz', {
    extend: 'Ext.form.Panel',
    xtype: 'currentQuery',
    requires: ['Ext.tab.Panel'],
    config: {
        fullscreen: true,
        layout: 'vbox',
        items: [{
            xtype: 'fieldset',
            flex: 1,
            name: 'hqContentCurrent',
            defaults: {
                styleHtmlContent: true
            },
            padding: 20
        }, {
            xtype: 'container',
            layout: 'hbox',
            margin: '10',
            items: [{
                xtype: 'button',
                ui: 'confirm',
                text: '无异议',
                name: 'confirmDz',
                hidden: true,
                flex: 1
            }, {
                margin: '0 0 0 10',
                xtype: 'button',
                ui: 'normal',
                text: '有异议',
                name: 'reject',
                hidden: true,
                flex: 1
            }]
        }]
    }
});