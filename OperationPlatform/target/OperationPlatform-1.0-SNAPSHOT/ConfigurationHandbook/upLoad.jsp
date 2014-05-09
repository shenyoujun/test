<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript">
    $(function () {
        $("#ConfigurationHandbook_DocumentManager_Upload_form").uploadify({
            swf: '${pageContext.request.contextPath}/jslib/uploadify/uploadify.swf',
            uploader: '${pageContext.request.contextPath}/ConfigurationHandbookAction!upload.action',
            'auto': true, //是否自动开始
            'multi': true, //是否支持多文件上传
            'buttonText': 'Browse' ,//按钮上的文字
            'queueID'        : 'fileQueue',
            'fileObjName'   : 'documentName',
            'fileSizeLimit' : 10*1024*1024,
            'method'        : 'post',
            'fileTypeDesc'	 :'All Files',
            'fileTypeExts' :  '*.*'
        });
    });

</script>
<div id="ConfigurationHandbook_DocumentManager_Upload" class="easyui-dialog" title="My Dialog"
     style="width:600px;height:400px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{ text:'返回',
                    iconCls:'icon-undo',
                    handler:function() {
                     $('#ConfigurationHandbook_DocumentManager_Upload').dialog('close');
                     $('#ConfigurationHandbook_DocumentManager_DataGrid').datagrid('reload');
                    }}]">
    <input type="file" name="documentName"
           id="ConfigurationHandbook_DocumentManager_Upload_form"/>

    <div id="fileQueue"></div>
    <!--<a href="javascript:$('#ConfigurationHandbook_DocumentManager_Upload_form').uploadify('upload','*')">上传文件</a>
    <a href="javascript:$('#ConfigurationHandbook_DocumentManager_Upload_form').uploadify('cancel', '*')">取消所有上传</a>-->


</div>