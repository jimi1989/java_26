<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>车管家ERP-订单列表</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <%@ include file="../include/css.jsp" %>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">
    <%@ include file="../include/header.jsp" %>
    <jsp:include page="../include/sider.jsp">
        <jsp:param name="menu" value="order"/>
    </jsp:include>

    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                订单查询
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">

            <div class="box no-border">
                <div class="box-body">
                    <form class="form-inline">
                        <input type="text" name="licenceNo" placeholder="车牌号码" class="form-control" value="${param.licenceNo}">
                        <input type="text" name="tel" placeholder="车主手机号码" class="form-control"  value="${param.tel}">
                        <input type="hidden" name="startTime" id="startTime" >
                        <input type="hidden" name="endTime" id="endTime">
                        <input type="text" class="form-control" id="time" placeholder="下单日期选择">
                        <button class="btn btn-default">搜索</button>
                    </form>
                </div>
            </div>

            <!-- Default box -->
            <div class="box">
                <div class="box-body">
                    <ul class="nav nav-tabs">
                        <li id="undone" class="${type == 'done' ? '' : 'active'}"><a href="/order/undone/list">未完成订单</a></li>
                        <li id="done" class="${type == 'done' ? 'active' : ''}"><a href="/order/done/list">已完成订单</a></li>
                    </ul>
                    <table class="table">
                        <thead>
                        <tr>
                            <th>订单号</th>
                            <th>车主姓名</th>
                            <th>车主电话</th>
                            <th>车型</th>
                            <th>车牌号码</th>
                            <th>状态</th>
                            <th>订单金额</th>
                            <th>日期</th>
                            <th>#</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${page.list}" var="order">
                            <tr>
                                <td>${order.id}</td>
                                <td>${order.customer.userName}</td>
                                <td>${order.customer.tel}</td>
                                <td>${order.car.carType}</td>
                                <td>${order.car.licenceNo}</td>
                                <td>${order.stateName}</td>
                                <td>${order.orderMoney}</td>
                                <td><fmt:formatDate value="${order.createTime}" pattern="yyyy-MM-dd"/></td>
                                <td><a href="/order/${order.id}/detail" class="label label-primary">详情</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <ul id="pagination" class="pagination pull-right"></ul>
                </div>
                <!-- /.box-body -->

            </div>
            <!-- /.box -->

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
        var startDate = "${param.startTime}";
        var endDate = "${param.endTime}";

        if(startDate && endDate) {
            $('#time').val(startDate + " / " + endDate);
        }

        $("#pagination").twbsPagination({
            totalPages :  ${page.pages},
            visiblePages : 7,
            first : '首页',
            last:'末页',
            prev:'上一页',
            next:'下一页',
            href:"/order/done/list?p={{number}}&startTime=" + startDate + "&endTime=" + endDate + "&licenceNo=" + encodeURIComponent('${param.licenceNo}') + "&tel=${param.tel}"
        });

        var locale = {
            "format": 'YYYY-MM-DD',
            "separator": " - ",//
            "applyLabel": "确定",
            "cancelLabel": "取消",
            "fromLabel": "起始时间",
            "toLabel": "结束时间'",
            "customRangeLabel": "自定义",
            "weekLabel": "W",
            "daysOfWeek": ["日", "一", "二", "三", "四", "五", "六"],
            "monthNames": ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
            "firstDay": 1
        };


        $('#time').daterangepicker({
            autoUpdateInput:false,
            "locale": locale,
            "opens":"right",
            "timePicker":false
        },function(start,end) {
            $("#startTime").val(start.format('YYYY-MM-DD'));
            $("#endTime").val(end.format('YYYY-MM-DD'));

            $('#time').val(start.format('YYYY-MM-DD') + " / " + end.format('YYYY-MM-DD'));
        });
    })
</script>
</body>
</html>
