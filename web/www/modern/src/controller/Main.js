Ext.define('TrackCar.controller.Main', {
    extend: 'Ext.app.Controller',
    
    config: {
        refs: {
        	hqContent: 'component[name=hqContent]'
        },
        control: {
        	'button[text=获取验证码]' : {
				tap: 'getValidateCode'
			},
			'button[text=绑定]' : {
				tap: 'bindUser'
			},
			'datepickerfield[name=queryDate]' : {
				change : 'chooseDateForHistory'
			}
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
		    url: '../sendValidateCode.cmd',
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
    	btn.setText(time + '秒后重发');
		btn.ui = 'normal';
    	if (time < 1){
    		btn.setText('获取验证码');
    		btn.ui = 'action-round';
    	} else {
    		window.setTimeout(this.waitValidateCode(btn,time),1000);
    	}
    },
    
    bindUser : function (btn){
    	Ext.Msg.alert('Title', 'The quick brown fox jumped over the lazy dog.', Ext.emptyFn);
    },
    chooseDateForHistory : function(picker, newDate, oldDate,opt){
    	if (this.getHqContent()){
    		this.getHqContent().setData({name:'XD',title:'LV'});
    	}
    }
});
