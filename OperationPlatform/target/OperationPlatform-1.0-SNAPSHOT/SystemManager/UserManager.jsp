<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<script>
    $('#SystemManager_UserManager_dataGrid').datagrid({
        pagination: true,
        idField: 'id',
        fitColumns: true,
        toolbar: '#index_SystemManager_UserManager_SearchByName',
        url: '${pageContext.request.contextPath}/UserAction!dataGrid.action',
        columns: [
            [
                {field: 'id', title: 'id', width: 100},
                {field: 'name', title: 'Name', width: 100},
                {field: 'loginName', title: 'LoginName', width: 100},
                {field: 'email', title: 'Email', width: 100},
                {field: 'creatTime', title: 'CreatTime', width: 100}
            ]
        ]
    });

</script>

<table id="SystemManager_UserManager_dataGrid" data-options="fit:true,border:false"></table>
<div id="index_SystemManager_UserManager_SearchByName">
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">上传</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no',plain:true">删除</a>
</div>
</body>
</html>
