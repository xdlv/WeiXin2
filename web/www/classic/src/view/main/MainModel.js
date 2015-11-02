Ext.define('TrackCar.view.main.MainModel', {
	extend : 'Ext.app.ViewModel',
	alias : 'viewmodel.main-main',
	data: {
		
	},
	formulas: {
        selectionText: function(get) {
            var selection = get('treelist.selection'),
                path;
            if (selection) {
                path = selection.getPath('text');
                path = path.replace(/^\/Root/, '');
                return 'Selected: ' + path;
            } else {
                return 'No node selected';
            }
        }
    },

    stores: {
        navItems: {
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
                }/*,{
                    text: '对账查询',
                    iconCls: 'x-fa fa-home',
                    children: [{
                        text: '对账记录查询',
                        iconCls: 'x-fa fa-inbox',
                        leaf: true
                    },{
                        text: '对账结果查询',
                        iconCls: 'x-fa fa-database',
                        leaf: true
                    }]
                }*/,{
                    text: '消息通知',
                    view: 'notify.Notification',
                    routeId : 'notify-Notification',
                    iconCls: 'x-fa fa-music',
                    leaf: true
                }]
            }
        }
    }
});