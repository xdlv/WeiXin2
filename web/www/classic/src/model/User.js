Ext.define('TrackCar.model.User', {
	extend : 'TrackCar.model.Base',

	fields : [ 'name', 'pwd', 'mail' ],
	
    proxy: {
        url: 'obtainUsers.cmd',
        reader: {
        	type: 'json',
        	rootProperty: 'users'
        }
    }
});