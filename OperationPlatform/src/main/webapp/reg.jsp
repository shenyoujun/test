<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="index_regDialog" class="easyui-dialog" style="width:300px" data-options=
        "title:'Assinment',closable:false,modal: true,closed:true,buttons:[{
                    text:'确定',
                    iconCls:'icon-edit',
                    handler:function() {

                      $('#index_regForm').form('submit', {
            url: '${pageContext.request.contextPath}/UserAction!reg.action',
                        success: function (data) {
             var obj =jQuery.parseJSON(data);
                if(obj.success){
                    $('#index_regDialog').dialog('close');
                }
                $.messager.show({
                    title:'提示',
                    msg:obj.msg+obj.exception ,
                    showType:'show'
                })
            }});
                     }
               },{ text:'取消',
                    iconCls:'icon-undo',
                    handler:function() {
                     $('#index_regDialog').dialog('close');
                    }}]">
    <form id="index_regForm" method="post">
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
                <td><input name="passWord" type='password' class="easyui-validatebox" data-options="required:true"></td>
            </tr>
            <tr>
                <th>
                    再次输入密码
                </th>
                <td><input name="rePassWord" type='password' class="easyui-validatebox"
                           data-options="required:true,validType:'equalPwd[\'#index_regForm input[name=passWord]\']'">
                </td>
            </tr>
            <tr>
                <th>
                    Email
                </th>
                <td><input name="email" class="easyui-validatebox" data-options="required:true,validType:'email'"></td>
            </tr>
            <tr>
                <th>
                    姓名
                </th>
                <td><input name="name" class="easyui-validatebox" data-options="required:true"></td>
            </tr>
        </table>
    </form>
</div>