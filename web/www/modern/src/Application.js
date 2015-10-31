Ext.application({
    name: 'TrackCar',

    requires: [
        'Ext.MessageBox',
        'TrackCar.view.*',
        'Ext.TitleBar',
        'Ext.form.FieldSet',
        'Ext.field.DatePicker'
    ],
    controllers: ['Main'],
    views: [
        'Main'
    ],

    icon: {
        '57': 'resources/icons/Icon.png',
        '72': 'resources/icons/Icon~ipad.png',
        '114': 'resources/icons/Icon@2x.png',
        '144': 'resources/icons/Icon~ipad@2x.png'
    },

    isIconPrecomposed: true,

    startupImage: {
        '320x460': 'resources/startup/320x460.jpg',
        '640x920': 'resources/startup/640x920.png',
        '768x1004': 'resources/startup/768x1004.png',
        '748x1024': 'resources/startup/748x1024.png',
        '1536x2008': 'resources/startup/1536x2008.png',
        '1496x2048': 'resources/startup/1496x2048.png'
    },
    
    onReady: function() {
    	Ext.Date.monthNames = ['一月','二月','三月','四月','五月'
    	    	                ,'六月','七月','八月','九月','十月','十一月','十二月'];
    },

    launch: function() {
        // Destroy the #appLoadingIndicator element
        Ext.fly('appLoadingIndicator').destroy();
        
        var href = window.location.href;
        if (href.indexOf("userBind") != -1){
        	Ext.Viewport.add(Ext.create('TrackCar.view.Main'));
        } else {
        	Ext.Viewport.add(Ext.create('TrackCar.view.HistoryQuery'));
        }
    },

    onUpdated: function() {
        Ext.Msg.confirm(
            "Application Update",
            "This application has just successfully been updated to the latest version. Reload now?",
            function(buttonId) {
                if (buttonId === 'yes') {
                    window.location.reload();
                }
            }
        );
    }
});