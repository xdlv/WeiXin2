Ext.define('TrackCar.controller.Root', {
    extend: 'Ext.app.Controller',
    requires: ['Ext.data.TreeStore'],
    
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
        var menu = {
            type: 'tree',
            root: {
                expanded: true,
                children: [{
                    text: '用户管理',
                    iconCls: 'x-fa fa-user',
                    leaf: true,
                    view: 'user.ModUser',
                    routeId: 'user-ModUser'
                },{
                    text: '导入导出',
                    iconCls: 'x-fa fa-wrench',
                    children: [{
                        text: '手机号码导入',
                        iconCls: 'x-fa fa-share-alt',
                        leaf: true,
                        view : 'importA.ImportTelphone',
                        routeId: 'importA-ImportTelphone'
                    },{
                        text: '对账文件导入',
                        iconCls: 'x-fa fa-flag',
                        view: 'importA.ImportDz',
                        routeId: 'importA-ImportDz',
                        leaf: true
                    },{
                        text: '对账结果导出',
                        view: 'exportA.DzExport',
                        routeId: 'exportA-DzExport',
                        iconCls: 'x-fa fa-signal',
                        leaf: true
                    }]
                },{
                    text: '消息通知',
                    view: 'notify.Notification',
                    routeId : 'notify-Notification',
                    iconCls: 'x-fa fa-music',
                    leaf: true
                }]
            }
        };
        // normal user, remove some menus
        if (user.get('userRole') == 1){
            menu = {
                type: 'tree',
                root: {
                    expanded: true,
                    children: [{
                        text: '导入导出',
                        iconCls: 'x-fa fa-wrench',
                        children: [{
                            text: '对账结果导出',
                            view: 'exportA.DzExport',
                            routeId: 'exportA-DzExport',
                            iconCls: 'x-fa fa-signal',
                            leaf: true
                        }]
                    }]
                }
            };
        }
    	Ext.create('TrackCar.view.main.Main',{
    		session: this.session,
    		viewModel: {
    			data : {
    				currentUser : user
    			},
				stores: {
					navItems: menu
				}
    		}
    	});
    }
});
