Ext.define('TrackCar.view.exportA.DzExportModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.export-dzexport',
    data: {
        columnsA : [ {
            text : '客户',
            sortable : true,
            dataIndex : 'userid'
        }, {
            text : '客户名称',
            dataIndex : 'username'
        },{
            text : '确认',
            dataIndex : 'isok'
        },{
            text : '期末余额',
            dataIndex : 'qmye'
        } ,{
            text: '应收-终端销售款',
            dataIndex: 'zdxsk1'
        },{
            text: '应收-应收代收款',
            dataIndex: 'ysdsk1'
        },{
            text: '应收-终端服务款',
            dataIndex: 'zdfwk1'
        },{
            text: '应收-价保',
            dataIndex : 'jb1'
        },{
            text: '应收-返利',
            dataIndex : 'fl1'
        },{
            text: '预收-终端销售款',
            dataIndex : 'zdxsk2'
        },{
            text: '预收-价保',
            dataIndex : 'jb2'
        },{
            text: '预收-返利',
            dataIndex : 'fl2'
        },{
            text: '预收-终端服务款',
            dataIndex : 'zdfwk2'
        },{
            text: '预收-其它应付抵款',
            dataIndex : 'qtyfdk2'
        }]
    },

    stores: {
        store:{
            model: 'Dzlist',
            session : true,
            autoLoad: true
        }
    }
});
