/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-1-26
 * Time: 下午1:46
 * To change this template use File | Settings | File Templates.
 */
$.extend($.fn.validatebox.defaults.rules, {
    equalPwd: {
        validator: function(value, param){
            return value ==$(param[0]).val() ;
        },
        message: '两次输入密码不一致'
    }
});