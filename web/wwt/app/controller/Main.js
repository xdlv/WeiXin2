Ext.define('WX.controller.Main', {
    extend: 'Ext.app.Controller',

    config: {
        dzTpl: "<p>&nbsp&nbsp&nbsp&nbsp尊敬的{username}（{userid}）客户，我公司与贵公司截止到{year}年{month}月{day}日期末余额       {qmye}元，其中应收终端销售款{zdxsk1}元，应收代收款{ysdsk1}元，应收终端服务款{zdfwk1}元，应收价保{jb1}     元，应收返利{fl1}元，预收终端销售款{zdxsk2}元，预收价保{jb2}元，预收返利{f2}元，预收终端服务款{zdfwk2}    元，预收其他应付预收抵款{qtyfdk2}        元。</p><p>说明：期末余额为正数，表示我司应收贵司余额，余额为负数，表示我司预收贵司余额。</p><p style='background-color:yellow'>（开发需求备注：此条信息中其中后面部分项目取数为零，则部分项目不要显示。）</p>",
        refs: {
            hqContent: 'component[name=hqContent]',
            confirmButton: 'button[text=确认对账]',
            validateButton: 'button[text=验证码]',
            bindButton: 'button[text=绑定]'
        },
        control: {
            'formpanel': {
                show: 'onReady'
            },
            'button[text=验证码]': {
                tap: 'getValidateCode'
            },
            'button[text=绑定]': {
                tap: 'bindUser'
            },
            'datepickerfield[name=queryDate]': {
                change: 'chooseDateForHistory'
            },
            'button[text=确认对账]': {
                tap: 'confirmDz'
            }
        }
    },

    loadDzRecord: function (success, year, month) {
        var parms = {
            openid: WX_PP.openId
        };
        if (year) {
            parms['dzlist.year'] = year;
        }
        if (month) {
            parms['dzlist.month'] = month;
        }
        Ext.Ajax.request({
            url: 'loadDzRecord.cmd',
            params: parms,
            scope: this,
            success: success,
            failure: function (response) {
                Ext.Msg.alert('错误', '操作失败，请稍后重试', Ext.emptyFn);
            }
        });
    },

    onReady: function (view) {
        if (WX_PP.viewId == 'CurrentDz') {
            //load the lasted dz record
            this.loadDzRecord(function (response) {
                var msg = Ext.JSON.decode(response.responseText, true);
                if (msg.dzlist) {
                    this.getHqContent().setTpl(this.getDzTpl());
                    this.getHqContent().setData(msg.dzlist);
                    this.getConfirmButton().setDisabled(false);
                    if (msg.dzlist.isok == 'Y') {
                        this.getConfirmButton().setText('己确认');
                        this.getConfirmButton().setDisabled(true);
                    }
                } else {
                    Ext.Msg.alert('当前对账', '当前没有记录', Ext.emptyFn);
                }
            });
        }
        if (WX_PP.viewId == 'Main' && WX_PP.phone){
            Ext.Msg.alert('用户绑定','该帐号当前己绑定,无法再次绑定');
            this.getValidateButton().setDisabled(true);
            this.getBindButton().setDisabled(true);
        }
    },
    getValidateCode : function(btn){
    	var phone = btn.up('container').down('textfield[name=phone]').getValue();
    	var regx = /^[1]\d{10}$/;
    	if (!regx.test(phone)){
    		Ext.Msg.alert('用户绑定', '手机号格式不正确，请重新输入', Ext.emptyFn);
    		return;
    	}
    	Ext.Ajax.request({
		    url: 'sendValidateCode.cmd',
		    params: {
		        phone: phone
		    },
		    scope: this,
		    success: function(response){
		    	var msg = Ext.JSON.decode(response.responseText,true);
		    	if (msg.success){
		    		this.waitValidateCode(btn, 60);
		    	} else {
		    		Ext.Msg.alert('用户绑定', msg.msg, Ext.emptyFn);
		    	}
		    },
		    failure: function(response){
		    	Ext.Msg.alert('用户绑定', '获取验证码失败，请稍后重试', Ext.emptyFn);
		    }
		});
    },
    waitValidateCode: function(btn, time){
    	btn.setText(time + '秒');
        btn.setDisabled(true);
    	if (time < 1){
    		btn.setText('验证码');
            btn.setDisabled(false);
    	} else {
			--time;
            var me = this;
            Ext.defer(function(){
                me.waitValidateCode(btn,time);
            },1000);
    	}
    },
    
    bindUser : function (btn){
        var main = btn.up('main');
        main.submit({
            url : 'userBind.cmd',
            waitTitle:"请稍候",
            params: {
                openid: WX_PP.openId
            },
            waitMsg:"正在进行用户绑定...",
            failure:function(form1,action){
                Ext.Msg.alert('绑定失败',action.msg,Ext.emptyFn);
            },
            success: function(form1,action){
                Ext.Msg.alert('绑定成功','请返回微信界面',Ext.emptyFn);
                main.destroy();
            }
        });
    },
    confirmDz : function(btn){
        var dzList = this.getHqContent().getData();
        if (!dzList){
            return;
        }
        Ext.Ajax.request({
            url : 'confirmDz.cmd',
            params: {
                'dzlist.year': dzList.year,
                'dzlist.month': dzList.month,
                'dzlist.userid': dzList.userid
            },
            success: function(response){
                var msg = Ext.JSON.decode(response.responseText,true);
                if (msg.success){
                    Ext.Msg.alert('确认对账', '对账己确认，谢谢使用', Ext.emptyFn);
                    btn.setDisabled(true);
                } else {
                    Ext.Msg.alert('确认对账', '确认失败，请稍后重试', Ext.emptyFn);
                }
            },
            failure: function(response){
                Ext.Msg.alert('确认对账', '确认失败，请稍后重试', Ext.emptyFn);
            }
        });
    },
    chooseDateForHistory : function(picker, newDate, oldDate,opt){
        if (!this.getHqContent()){
            return;
        }
        var value = picker.getValue();
        this.clearHqcontent();
        this.loadDzRecord(function(response){
            var msg = Ext.JSON.decode(response.responseText,true);
            if (msg.dzlist){
                this.getHqContent().setTpl(this.getDzTpl());
                this.getHqContent().setData(msg.dzlist);
            } else {
                Ext.Msg.alert('当前对账','没有对应的记录',Ext.emptyFn);
            }
        }, value.getFullYear(), value.getMonth() + 1);
    },
    clearHqcontent: function(){
        this.getHqContent().setTpl('没有数据');
        this.getHqContent().setData({});
    }
});
