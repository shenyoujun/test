<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<script>
    $('#ConfigurationHandbook_DocumentManager_DataGrid').datagrid({
        pagination: true,
        idField: 'id',
        fitColumns: true,
        pageSize: 20,
        toolbar: [
            {
                text: '上传',
                iconCls: 'icon-add',
                plain: true,
                handler: function () {
                    $('#ConfigurationHandbook_DocumentManager_Upload').dialog('open')
                }
            },
            '-',
            {
                text: '删除',
                iconCls: 'icon-remove',
                handler: function () {
                    removeDocument()
                }
            }
        ],
        url: '${pageContext.request.contextPath}/ConfigurationHandbookAction!dataGrid.action',
        selectOnCheck: false,
        checkOnSelect: false,
        columns: [
            [
                {field: 'id', title: 'id', width: 100, checkbox: true},
                {field: 'documentNameFileName', title: 'documentNameFileName', width: 100},
                {field: 'documentOwner', title: 'documentOwner', width: 100},
                {field: 'length', title: 'ducumentNameContentLength', width: 100},
                {field: 'creatTime', title: 'creatTime', width: 100}
            ]
        ]
    });
    function removeDocument() {
        var rows = $('#ConfigurationHandbook_DocumentManager_DataGrid').datagrid('getChecked');
        var ids = [];
        if (rows.length > 0) {
            $.messager.confirm('确定', '您是否确认要删除已选中的项目', function (r) {
                if (r) {
                    for (var i = 0; i < rows.length; i++) {
                        ids.push(rows[i].id)
                    }
                    $.ajax({
                        url: '${pageContext.request.contextPath}/ConfigurationHandbookAction!delete.action',
                        data: {ids: ids.join(',')},
                        dataType: 'json',
                        success: function (r) {
                            $('#ConfigurationHandbook_DocumentManager_DataGrid').datagrid('load');
                            $('#ConfigurationHandbook_DocumentManager_DataGrid').datagrid('clearChecked');
                            $.messager.show({
                                title: '提示',
                                msg: r.msg
                            })
                        }
                    })
                }
            })

        } else {
            $.messager.show({
                title: '提示',
                msg: '请勾选需要删除的文件'
            })
        }
    }
</script>
<table id="ConfigurationHandbook_DocumentManager_DataGrid" data-options="fit:true,border:false"></table>

</body>
</html>
