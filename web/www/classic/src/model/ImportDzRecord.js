Ext.define('TrackCar.model.ImportDzRecord', {
    extend: 'TrackCar.model.Base',

    fields: [
        {name: 'year', type: 'int'},
        {name: 'month', type: 'int'},
        {
            name: 'importDate', type: 'date'
            , convert: function (value) { return value.substring(0,10); }
        },'notification'
    ],
    proxy: {
        url: 'obtainImportDzRecord.cmd',
        reader: {
            type: 'json',
            rootProperty: 'importDzRecords'
        }
    }
});
