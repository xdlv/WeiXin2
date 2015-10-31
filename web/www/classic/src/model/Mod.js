Ext.define('TrackCar.model.Mod',{
	extend: 'TrackCar.model.Base',
	
	fields : ['name','url','routerId','parentId'],
	
    manyToMany : 'User'
});