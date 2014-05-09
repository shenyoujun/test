<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OperationPlatform</title>
    <meta http-equiv="param" content="no-cache">
    <script type="text/javascript" src="jslib/jquery-easyui-1.3.5/jquery.min.js"></script>
    <script type="text/javascript" src="jslib/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="jslib/jquery-easyui-1.3.5/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="jslib/jquery-easyui-1.3.5/jsUtils.js"></script>
    <script type="text/javascript" src="jslib/uploadify/jquery.uploadify.min.js"></script>
    <link rel="stylesheet" href="jslib/jquery-easyui-1.3.5/themes/icon.css" type="text/css">
    <link rel="stylesheet" href="jslib/jquery-easyui-1.3.5/themes/default/easyui.css" type="text/css">
    <link rel="stylesheet" type="text/css" href="jslib/uploadify/uploadify.css" >
</head>

<body class="easyui-layout">
<div data-options="region:'north',border:false" style="height:60px;">north region</div>
<jsp:include page="layout/west.jsp"></jsp:include>

<div data-options="region:'south',border:false" style="height:50px;">south region</div>
<jsp:include page="layout/center.jsp"></jsp:include>
<jsp:include page="login.jsp"></jsp:include>
<jsp:include page="reg.jsp"></jsp:include>
<jsp:include page="ConfigurationHandbook/upLoad.jsp"></jsp:include>

</body>
</body>
</html>