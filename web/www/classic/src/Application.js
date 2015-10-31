Ext.define('TrackCar.Application', {
    extend: 'Ext.app.Application',
    requires: ['TrackCar.view.user.*'],
    name: 'TrackCar',
    
    controllers: ['Root@TrackCar.controller'],
    requires: ['TrackCar.view.import.*'],
    models: ['User','UserCompany'],
    stores: [
        // TODO: add global / shared stores here
    ],
    
    launch: function () {
        
    },

    onAppUpdate: function () {
        Ext.Msg.confirm('Application Update', 'This application has an update, reload?',
            function (choice) {
                if (choice === 'yes') {
                    window.location.reload();
                }
            }
        );
    }
});
