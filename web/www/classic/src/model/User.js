Ext.define('TrackCar.model.User', {
	extend : 'TrackCar.model.Base',

	fields : [ 'name', 'pwd', 'mail',{name : 'userRole' , type:'int'}],
	
    proxy: {
        url: 'obtainUsers.cmd',
        reader: {
        	type: 'json',
        	rootProperty: 'users'
        }
    }
});