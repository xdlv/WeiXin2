Ext.define('TrackCar.model.Dzlist',{
	extend: 'TrackCar.model.Base',

	fields: [
		{name: 'year', type : 'int'},
		{name: 'month', type: 'int'},
		'impdate','userid','username','isok','qmye',
		{name: 'zdxsk1', type: 'float'},
		{name: 'ysdsk1', type: 'float'},
        {name: 'zdfwk1', type:'float'},
		{name: 'jb1', type: 'float'},
		{name: 'fl1', type: 'float'},
		{name: 'zdxsk2', type: 'float'},
		{name: 'jb2', type: 'float'},
		{name: 'fl2', type: 'float'},
		{name: 'zdfwk2', type: 'float'},
		{name: 'qtyfdk2', type: 'float'}
	],

	proxy: {
		url: 'obtainDzlists.cmd',
		reader: {
			type: 'json',
			rootProperty: 'dzlists'
		}
	}
});