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
                服务订单查询
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">

            <div class="box no-border">
                <div class="box-body">
                    <form class="form-inline">
                        <input type="text" name="carVIN" placeholder="车牌号码" class="form-control">
                        <input type="text" name="ownerId" placeholder="车主手机号码" class="form-control">
                        <input type="hidden" name="startTime" id="startTime">
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
                        <li id="undone" class="${type == 'pay' ? '' : 'active'}"><a href=""  data-toggle='tab'>未完成订单</a></li>
                        <li id="history" class="${type == 'pay' ? 'active' : ''}"><a href="" data-toggle='tab'>已完成订单</a></li>
                    </ul>
                    <table class="table">
                        <thead>
                        <tr>
                            <th>订单号</th>
                            <th>车主姓名</th>
                            <th>车主电话</th>
                            <th>车型</th>
                            <th>状态</th>
                            <th>订单金额</th>
                            <th>#</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>100198763</td>
                            <td>王富贵</td>
                            <td>15937911234</td>
                            <td>奔驰S600</td>
                            <td>已完成</td>
                            <td>1200</td>
                            <td><a href="#" class="label label-primary">详情</a></td>
                        </tr>
                        <tr>
                            <td>100198763</td>
                            <td>王富贵</td>
                            <td>15937911234</td>
                            <td>奔驰S600</td>
                            <td>已完成</td>
                            <td>1200</td>
                            <td><a href="#" class="label label-primary">详情</a></td>
                        </tr>
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
        $("#pagination").twbsPagination({
            totalPages : 5,
            visiblePages : 7,
            first : '首页',
            last:'末页',
            prev:'上一页',
            next:'下一页',
            href:"#"
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

        var startDate = "";
        var endDate = "";

        if(startDate && endDate) {
            $('#time').val(startDate + " / " + endDate);
        }


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
