Ext.define('TrackCar.view.exportA.DzExportController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.export-dzexport',

    queryDzlist: function (btn) {
        var form = btn.up('form');
        var userid = form.down('textfield[name=userid]').getValue();
        var phone = form.down('textfield[name=phone]').getValue();
        var username = form.down('textfield[name=username]').getValue();
        var confirm = form.down('checkbox[name=confirm]').checked;
        var unconfirm = form.down('checkbox[name=unconfirm]').checked;
        var parms = {};
        if (!Ext.isEmpty(userid)){
            parms['dzlist.userid'] = userid;
        }
        if (!Ext.isEmpty(phone)){
            parms['dzlist.phone'] = phone;
        }
        if (!Ext.isEmpty(username)){
            parms['dzlist.username'] = encodeURIComponent(username);
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
