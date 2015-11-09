Ext.define('WX.view.BindInfo', {
    extend: 'Ext.form.Panel',
    config: {
        fullscreen: true,
        layout: 'vbox',
        scrollable: null,
        items: [{
            xtype: 'fieldset',
            flex: 1,
            name: 'bindInfo',
            padding: '30',
            scrollable: {
                direction: 'vertical'
            },
            title: '绑定信息',
            tpl : '手机号：{phone}<p></p><p>微信标识：{openid}</p>'
        }]
    }
});