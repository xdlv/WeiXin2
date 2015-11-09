Ext.define("TrackCar.view.UserBind",{
    extend: "Ext.Container",
    fullscreen: true,

    requires: [
        "TrackCar.view.UserBindController",
        "TrackCar.view.UserBindModel",
        "Ext.TitleBar",
        "Ext.field.Text",
        "Ext.form.Panel",
        "Ext.form.FieldSet",
        "Ext.layout.VBox",
        "Ext.Button"
    ],

    controller: "userbind",
    viewModel: {
        type: "userbind"
    },

    layout: {
        type: 'vbox'
    },
    items: [{
        xtype: 'titlebar',
        title: 'Click me',
        style: 'background-color:#1985D0;',
        docked : 'top',
        height : 50
    },{
        xtype: 'formpanel',
        items: [{
            xtype: 'fieldset',
            margin: '10 0 10 0',
            layout:'vbox',
            items:[{
                xtype: 'textfield',
                label: 'Username',
                maxLength: 10,
                placeHolder: 'Enter your username'
            },{
                xtype: 'textfield',
                label: 'Password',
                maxLength: 10,
                placeHolder: 'Enter your password'
            },{
                margin: '10 0 0 0',
                xtype: 'button',
                ui :'confirm',
                text: 'Login'
            }]
        }]
    }]
});
