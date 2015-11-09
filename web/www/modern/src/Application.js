Ext.define('TrackCar.Application', {
    extend: 'Ext.app.Application',

    launch: function(){
        Ext.Viewport.add(Ext.create('TrackCar.view.UserBind'));
    }
});