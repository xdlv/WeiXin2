Ext.define('TrackCar.Application', {
    extend: 'Ext.app.Application',
    requires: [

    ],
    name: 'TrackCar',
    
    controllers: ['Root@TrackCar.controller'],
    models: ['User','UserCompany','Dzlist','ImportDzRecord'],
    stores: [
        // TODO: add global / shared stores here
    ],
    
    launch: function () {
        
    },

    onAppUpdate: function () {
        window.localStorage.clear();
        try {window.applicationCache.update();}catch(e){}
        window.location.reload();
    }
});
