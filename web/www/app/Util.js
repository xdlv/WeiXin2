Ext.define('TrackCar.Util', {
    singleton: true,

    ajax: function(obj){
        Ext.Ajax.request({
            url: obj.url,
            method : obj.method ? obj.method : 'POST',
            params: obj.params,
            scope: obj.scope,
            success : function(response){
                var jsonObj = Ext.decode(response.responseText, true);
                if (jsonObj == null || !jsonObj.success){
                    jsonObj.success(jsonObj);
                } else {
                    if (jsonObj.failure){
                        jsonObj.failure(jsonObj);
                    } else {
                        Ext.MessageBox.alert('提示','操作失败:' + jsonObj == null ? "" : jsonObj.msg);
                    }
                }
            },
            failure: function(response){
                var jsonObj = Ext.decode(response.responseText, true);
                if (jsonObj.failure){
                    jsonObj.failure(jsonObj);
                } else {
                    Ext.MessageBox.alert('提示','操作失败:' + jsonObj == null ? "" : jsonObj.msg);
                }
            }
        });
    }
});