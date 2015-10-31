Ext.define('TrackCar.view.user.ModUserModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.user-moduser',
    data: {
        name: 'TrackCar'
    },
    
    stores: {
    	loginUsers:{
    		model: 'User',
    		session : true,
    		autoLoad: true
    	}
    }
});
