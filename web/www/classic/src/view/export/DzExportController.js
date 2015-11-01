Ext.define('TrackCar.view.export.DzExportController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.export-dzexport',

    queryDzlist: function (btn) {
        var form = btn.up('form');
        var userid = form.down('textfield[name=dzlist.userid]').getValue();
        var confirm = form.down('checkbox[name=confirm]').checked;
        var unconfirm = form.down('checkbox[name=unconfirm]').checked;
        var parms = {};
        if (!Ext.isEmpty(userid)){
            parms['dzlist.userid'] = userid;
        }
        if (confirm != unconfirm){
            parms['dzlist.isok'] = confirm ? 'Y' : 'N';
        }
        this.getStore('store').reload({
            params: parms
        });
    },

    exportDzlist: function (btn) {

    }

});
