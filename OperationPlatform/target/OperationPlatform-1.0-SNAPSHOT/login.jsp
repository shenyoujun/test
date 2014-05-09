<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="index_loginDialog" class="easyui-dialog" data-options="title:'Login',closable:false,modal: true,buttons:[{
                    text:'注册',
                    iconCls:'icon-edit',
                    handler:function(){
                    $('#index_regDialog').dialog('open');
                    }
               },{
                    text:'登入',
                    iconCls:'icon-help',
                    handler:function(){$('#index_loginform').form('submit', {
            url: '${pageContext.request.contextPath}/UserAction!login.action',
                        success: function (data) {

             var obj =jQuery.parseJSON(data);
                if(obj.success){
                    $('#index_loginDialog').dialog('close');
                }
                $.messager.show({
                    title:'提示',
                    msg:obj.msg ,
                    showType:'show'
                })

            }
        });}
               }]">
    <form id="index_loginform" method="post">
        <table>
            <tr>
                <th>
                    登入名
                </th>
                <td><input name="loginName" class="easyui-validatebox" data-options="required:true"></td>
            </tr>
            <tr>
                <th>
                    密码
                </th>
                <td><input name="passWord" type="password" class="easyui-validatebox" data-options="required:true"></td>
            </tr>
        </table>
    </form>
</div>
