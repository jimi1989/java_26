<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>车管家ERP-新增订单</title>

    <style>
        .td_title {
            font-weight: bold;
        }

        .table>tbody>tr>td {
            vertical-align: middle;
        }

    </style>
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
            <h1 style="text-align: center">
                保养维修单
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">

            <div class="box">
                <div class="box-header with-border">
                    <h3 class="box-title">客户车辆信息</h3>
                </div>
                <div class="box-body">
                    <table class="table">
                        <tr>
                            <td class="td_title">车牌号:</td>
                            <td style="width: 280px">
                                <input type="text" id="carLisence" class="form-control" value="${car.licenceNo}">

                            </td>
                            <td >
                            <span class="input-group-btn">
                                <button type="button" class="btn btn-info btn-flat" id="search"><i class="fa fa-search"></i></button>
                            </span>
                            </td>
                            <td class="td_title">客户姓名:</td>
                            <td id="userName">${customer.userName}</td>
                            <td class="td_title">身份证号:</td>
                            <td>${customer.idCard}</td>
                        </tr>
                        <tr>
                            <td class="td_title">车主电话:</td>
                            <td>${customer.tel}</td>
                            <td></td>
                            <td class="td_title">车型:</td>
                            <td id="carType">${car.carType}</td>
                            <td class="td_title">车辆识别码:</td>
                            <td>${car.carNo}</td>

                        </tr>
                    </table>

                </div>
            </div>
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">项目选择</h3>
                </div>

                <div class="box-body">
                    <div class="form-inline">
                        <select class="form-control" name="" id="">
                            <option value="">请选择项目</option>
                            <option value="">小保养-2工时</option>
                            <option value="">大保养-3工时</option>
                            <option value="">轮胎更换-1工时</option>
                            <option value="">钣金喷漆-2工时</option>
                        </select>
                        <button class="btn btn-info">选择</button>
                    </div>
                    <br>
                    <table class="table table-bordered " style="border-width: 2px;" id="infoForm">
                        <thead>
                        <tr>
                            <th>项目代码</th>
                            <th>项目名称</th>
                            <th>工时费用</th>
                        </tr>
                        </thead>
                        <tbody id="addTr">
                        <tr>
                            <td>xn001</td>
                            <td>小保养</td>
                            <td>150</td>
                        </tr>
                        </tbody>
                        <tfoot>
                        <tr>
                            <td colspan="4" class="td_title">小计 ：150元</td>
                        </tr>
                        </tfoot>
                    </table>
                </div>
            </div>

            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">选择配件</h3>
                </div>

                <div class="box-body">

                    <div class="form-inline">
                        <select class="form-control" name="type" id="type">
                            <option value="">请选择配件类型</option>
                            <option value="">机油</option>
                            <option value="">机滤</option>
                            <option value="">轮胎</option>
                            <option value="">喷漆</option>
                        </select>
                        <select class="form-control" name="parts" id="parts">
                            <option value="">请选择配件</option>
                            <option value="">嘉实多机油 1L</option>
                            <option value="">嘉实多机油 4L</option>
                            <option value="">长城机油 1L</option>
                        </select>
                        <button class="btn btn-info">选择</button>
                    </div>
                    <br>
                    <table class="table table-bordered " style="border-width: 2px;" id="partsInfoForm">
                        <thead>
                        <tr>
                            <th>编号</th>
                            <th>名称</th>
                            <th>单价</th>
                            <th>数量</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>xn001</td>
                            <td>嘉实多润滑油</td>
                            <td>50</td>
                            <td><button type="button" class="btn btn-box-tool" id="minus"><i class="fa fa-minus"></i></button>
                                <span>1</span>
                                <button type="button" class="btn btn-box-tool" id="plus"><i class="fa fa-plus"></i></button></td>
                        </tr>

                        </tbody>
                        <tfoot>
                        <tr>
                            <td colspan="4" class="td_title">小计 ：200元</td>
                        </tr>
                        </tfoot>
                    </table>
                </div>
            </div>

            <button class="btn btn-info btn-block btn-lg">下单</button>

            <div class="modal fade" tabindex="-1" role="dialog" id="addUserModal">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title">添加用户</h4>
                        </div>
                        <div class="modal-body">
                            <form id="addCarForm" action="/car/new" method="post" class="form">
                                <div class="form-group">
                                    <label>车牌号码：</label>
                                    <input type="text" id="newCarLisence" name="licenceNo" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>车辆识别码：</label>
                                    <input type="text" name="carNo" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>车辆型号</label>
                                    <input type="text" name="carType" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>车主姓名：</label>
                                    <input type="text" name="userName" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>车主身份证：</label>
                                    <input type="text" name="idCard" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>车主电话：</label>
                                    <input type="text" name="tel" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>颜色：</label>
                                    <input type="text" name="color" class="form-control">
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <button type="button" class="btn btn-primary" id="addCar">添加</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->

        </section>
        <!-- /.content -->


    </div>
    <!-- /.content-wrapper -->


    <%@ include file="../include/footer.jsp" %>

</div>
<!-- ./wrapper -->
<%@ include file="../include/js.jsp" %>
<script>
    $(function() {
        //点击放大镜
        $("#search").click(function() {
            // 如果车牌号未空，不能发起请求
            $.get("/car/check",{"licenseNo":$("#carLisence").val()}).done(function(res){

                if (res.state == 'success') {
                    // 如果已存在显示车辆信息
                    $("#userName").text(res.data.customer.userName);
                    $("#carType").text(res.data.carType);

                } else {
                    // 如果不存在则打开模态框新增车辆信息
                    $("#newCarLisence").val($("#carLisence").val());
                    $("#addUserModal").modal({
                        show:true,
                        backdrop:'static'
                    });
                }
            }).error(function(){
                layer.msg("系统异常")
            })


        });

        $("#addCar").click(function() {
            $("#addCarForm").submit();
        })

    })
</script>
</body>
</html>
