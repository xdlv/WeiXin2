Ext.define('TrackCar.view.user.AddUserModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.user-adduser',
    data: {
        name: 'TrackCar',
        operation: 'saveUser'
    },
    formulas: {
        /*userRoleEditable: function(get){
            return get('user').get('userRole') == 0;
        }*/
    },
    stores:{
        comboStore: {
            fields: ['name', 'value'],
            data : [
                {"value":"0", "name":"超级用户"},
                {"value":"1", "name":"普通用户"}
            ]
        }
    }

});
