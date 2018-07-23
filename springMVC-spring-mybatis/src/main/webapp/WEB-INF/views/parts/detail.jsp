<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>车管家ERP-配件详情</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="/static/plugins/font-awesome/css/font-awesome.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/static/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="/static/dist/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="/static/plugins/tree/css/metroStyle/metroStyle.css">
    <link rel="stylesheet" href="/static/plugins/datetimepicker/css/bootstrap-datetimepicker.min.css"/>
    <link rel="stylesheet" href="/static/plugins/daterangepicker/daterangepicker.css"/>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
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

    <!-- 顶部导航栏部分 -->
    <header class="main-header">
        <!-- Logo -->
        <a href="index2.html" class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini"><b>ERP</b></span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg"><b>车管家</b>ERP</span>
        </a>
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>

            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- User Account: style can be found in dropdown.less -->
                    <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img src="dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
                            <span class="hidden-xs">李美苏</span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- User image -->
                            <li class="user-header">
                                <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                                <p>
                                    李美苏
                                    <small>海外事业部</small>
                                </p>
                            </li>
                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="/profile" class="btn btn-default btn-flat">个人设置</a>
                                </div>
                                <div class="pull-right">
                                    <a href="/logout" class="btn btn-default btn-flat">安全退出</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </header>

    <!-- =============================================== -->

    <!-- 左侧菜单栏 -->
    <aside class="main-sidebar">
        <section class="sidebar">
            <!-- 菜单 -->
            <ul class="sidebar-menu">
                <li class="header">系统功能</li>
                <!-- 保养服务 -->
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-share-alt"></i> <span>保养服务</span>
                        <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="#"><i class="fa fa-circle-o"></i>历史订单查询</a></li>
                        <li><a href="#"><i class="fa fa-circle-o"></i>未完成订单查询</a></li>
                        <li><a href="#"><i class="fa fa-circle-o"></i>新建订单</a></li>
                    </ul>
                </li>
                <!-- 维修服务 -->
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-wrench"></i> <span>维修服务</span>
                        <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="#"><i class="fa fa-circle-o"></i>历史订单查询</a></li>
                        <li><a href="#"><i class="fa fa-circle-o"></i>未完成订单查询</a></li>
                        <li><a href="#"><i class="fa fa-circle-o"></i>新建订单</a></li>
                    </ul>
                </li>
                <!-- 库存管理 -->
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-home"></i> <span>库存管理</span>
                        <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="#"><i class="fa fa-circle-o"></i>配件管理</a></li>
                        <li><a href="#"><i class="fa fa-circle-o"></i>类型管理</a></li>
                        <li><a href="#"><i class="fa fa-circle-o"></i>配件入库</a></li>
                        <li><a href="#"><i class="fa fa-circle-o"></i>入库查询</a></li>
                        <li><a href="#"><i class="fa fa-circle-o"></i>出库查询</a></li>
                    </ul>
                </li>
                <!-- 结算管理 -->
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-jpy"></i> <span>结算管理</span>
                        <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="#"><i class="fa fa-circle-o"></i>订单结算</a></li>
                        <li><a href="#"><i class="fa fa-circle-o"></i>优惠券</a></li>
                    </ul>
                </li>
                <!-- 统计报表 -->
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-pie-chart"></i> <span>统计报表</span>
                        <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="#"><i class="fa fa-circle-o"></i>收入统计</a></li>
                    </ul>
                </li>


                <li class="header">系统管理</li>
                <!-- 部门员工管理 -->
                <li><a href="#"><i class="fa fa-users"></i> <span>员工管理</span></a></li>
            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>

    <!-- =============================================== -->

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

    <!-- 底部 -->
    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 1.0
        </div>
        <strong>Copyright &copy; 2010 -2017 <a href="http://almsaeedstudio.com">车管家</a>.</strong> All rights
        reserved.
    </footer>

</div>
<!-- ./wrapper -->

<!-- jQuery 2.2.3 -->
<script src="/static/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="/static/bootstrap/js/bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="/static/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="/static/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="/static/dist/js/app.min.js"></script>
<script src="/static/dist/js/jquery.twbsPagination.min.js"></script>
<script src="/static/plugins/datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<script src="/static/plugins/daterangepicker/moment.js"></script>
<script src="/static/plugins/daterangepicker/daterangepicker.js"></script>
<script>
    $(function(){

    })
</script>
</body>
</html>

