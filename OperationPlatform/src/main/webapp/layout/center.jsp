
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    function addTabs(options) {
        var t = $('#index_loginCenterTabs');
        if (t.tabs('exists', options.title)) {
            t.tabs('select', options.title);
        } else {
            t.tabs('add', options);
        }
    }
</script>
<div data-options="region:'center',title:'Main Title'">
    <div id="index_loginCenterTabs" class="easyui-tabs" data-options="fit:true,border:false">

    </div>
</div>