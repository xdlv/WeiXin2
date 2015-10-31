Ext.define('TrackCar.view.user.ModUserController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.user-moduser',
    
    addUser : function(btn){
    	Ext.create('TrackCar.view.user.AddUser', {}).show();
    }
});
