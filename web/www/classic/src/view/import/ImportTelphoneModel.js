Ext.define('TrackCar.view.import.ImportTelphoneModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.import-importtelphone',
    data: {
        fieldLabel: '请选择手机号码文件',
        columnsA : [ {
            text : '客商编号',
            sortable : true,
            dataIndex : 'code'
        }, {
            text : 'SCM客商名称',
            dataIndex : 'companyName'
        },{
            text : '地方',
            dataIndex : 'area'
        } ,{
            text: '目前是否有业务往来',
            dataIndex: 'business'
        },{
            text: '微信对账客户联系人',
            dataIndex: 'wxContractName1'
        },{
            text: '微信对账客户手机号码',
            dataIndex: 'wxContractPhone1'
        },{
            text: '业务经理（信息负责人）',
            dataIndex : 'managerName'
        }]
    },

    stores: {
        store:{
            model: 'UserCompany',
            session : true,
            autoLoad: true
        }
    }

});
