
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div data-options="region:'west',title:'功能导航'" style="width:200px;border:0px" >
    <div id="aa" class="easyui-accordion" data-options="fit:true">
        <div title="系统菜单" data-options="iconCls:'icon-save',border:false">
            <ul class="easyui-tree"
                data-options="url:'${pageContext.request.contextPath}/MenuAction!getTree.action',
                onLoadSuccess:function(node, data){$(this).tree('expandAll')},onClick:function(node){
                var url = '${pageContext.request.contextPath}'+node.attributes.url;
                addTabs({title:node.text,href:url,closable:true})}"></ul>
        </div>
        <div title="Title2" data-options="iconCls:'icon-reload'">

        </div>

    </div>

</div>
