Ext.define('TrackCar.model.UserCompany', {
    extend: 'TrackCar.model.Base',

    fields: ['code', 'companyName', 'area'
        , 'business', 'wxContractName1', 'wxContractPhone1'
        , 'wxContractName2', 'wxContractPhone2'
        , 'managerName', 'remarkContent'],

    proxy: {
        url: '../obtainUserCompanys.cmd',
        reader: {
            type: 'json',
            rootProperty: 'userCompanys'
        }
    }
});