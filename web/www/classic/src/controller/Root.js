Ext.define('TrackCar.controller.Root', {
    extend: 'Ext.app.Controller',
    
    onLaunch : function(){
    	//create session for application scope
    	this.session = new Ext.data.Session({
            autoDestroy: false
        });
    	
    	this.login = Ext.create('TrackCar.view.login.Login',{
    		autoShow: true,
    		session : this.session,
    		listeners: {
                scope: this,
                login: 'onLogin'
            }
    	});
    },
    onLogin: function(view,user){
    	this.login.destroy();
    	Ext.create('TrackCar.view.main.Main',{
    		session: this.session,
    		viewModel: {
    			data : {
    				currentUser : user
    			}
    		}
    	});
    }
});
