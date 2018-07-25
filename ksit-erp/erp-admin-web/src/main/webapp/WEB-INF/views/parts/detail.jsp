<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>车管家ERP-配件详情</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <%@ include file="../include/css.jsp" %>
    <style>
        .td_title {
            font-weight: bold;
        }
        .star {
            font-size: 20px;
            color: #ff7400;
        }
    </style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">
    <%@ include file="../include/header.jsp" %>
    <%--<%@ include file="../include/sider.jsp" %>--%>
    <jsp:include page="../include/sider.jsp">
        <jsp:param name="menu" value="parts"/>
    </jsp:include>
    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                配件详情
            </h1>
        </section>
        <!-- Main content -->
        <section class="content">
            <!-- Default box -->
            <div class="panel panel-primary">
                <!-- Default panel contents -->
                <div class="panel-heading">${parts.partsName}</div>
                <!-- List group -->
                <ul class="list-group">
                    <li class="list-group-item">配件编号：${parts.partsNo}</li>
                    <li class="list-group-item">进价：${parts.inPrice}</li>
                    <li class="list-group-item">售价：${parts.salePrice}</li>
                    <li class="list-group-item">库存：${parts.inventory}</li>
                    <li class="list-group-item">产地：${parts.address}</li>
                </ul>
            </div>

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <%@ include file="../include/footer.jsp" %>
</div>
<!-- ./wrapper -->
<%@ include file="../include/js.jsp" %>
<script>
    $(function(){

    })
</script>
</body>
</html>

