Ext.define('TrackCar.view.exportA.DzExportController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.export-dzexport',

    queryDzlist: function (btn) {
        this.getStore('store').reload({
            params: this.prepareParams(btn)
        });
    },

    exportDzlist: function (btn) {
        var params = this.prepareParams(btn);
        params.limit = 200000;
        var url = 'downLoadDzlists.cmd?';
        for (var v in params){
            url += '&';
            url+= v + '=' + params[v]
        }
        console.log(url);
        window.open(url,'_self');
       /* btn.up('form').getForm().submit({
            url : 'downLoadDzlists.cmd',
            params: params
        });*/
    },

    prepareParams: function(btn){
        var form = btn.up('form');
        var confirm = form.down('checkbox[name=confirm]').checked;
        var unconfirm = form.down('checkbox[name=unconfirm]').checked;
        var yearMonth = form.down('datefield').getValue();
        var parms = form.getValues();
        delete parms.yearMonth;
        if (Ext.isEmpty(parms['dzlist.userid'])){
            delete parms['dzlist.userid'];
        }
        if (Ext.isEmpty(parms['dzlist.username'])){
            delete parms['dzlist.username'];
        } else {
            parms['dzlist.username'] = encodeURIComponent(parms['dzlist.username']);
        }
        if (Ext.isEmpty(parms['dzlist.phone'])){
            delete parms['dzlist.phone'];
        }
        if (confirm != unconfirm){
            parms['dzlist.isOkQuery'] = confirm ? 'Y' : 'N';
        }
        if (yearMonth){
            parms['dzlist.year'] = yearMonth.getUTCFullYear();
            parms['dzlist.month'] = yearMonth.getMonth();
        }
        return parms;
    }

});
