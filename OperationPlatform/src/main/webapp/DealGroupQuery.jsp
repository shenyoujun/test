<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 14-2-7
  Time: 下午5:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<input class="easyui-searchbox" data-options="prompt:'Please Input Value',menu:'#searchbydealgroupid',searcher:doSearch"
       style="width:300px;"/>

<div id="searchbydealgroupid" style="width:120px">
    <div data-options="name:'DealGroupID',iconCls:'icon-ok'">团购ID：</div>
    
</div>
<table id="searchresult" style="width:300px"></table>
<script>
    $('#searchresult').propertygrid({
        url: 'get_data.php',
        showGroup: true,
        scrollbarSize: 0

    });
    function doSearch(value, name) {
        $('#searchresult').datagrid('load', {
            name: value
        })
    }
</script>


</body>
</html>
