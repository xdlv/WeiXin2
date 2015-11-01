Ext.define('TrackCar.view.notify.NotificationModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.notify-notification',
    data: {
        columnsA : [ {
            text : '年份',
            sortable : true,
            dataIndex : 'year'
        }, {
            text : '月份',
            dataIndex : 'month'
        },{
            text : '导入日期',
            type: 'date',
            dataIndex : 'importDate'
        } ]
    },

    stores: {
        store:{
            model: 'ImportDzRecord',
            session : true,
            autoLoad: true
        }
    }

});
