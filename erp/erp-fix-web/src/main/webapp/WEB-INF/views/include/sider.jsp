<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 左侧菜单栏 -->
<aside class="main-sidebar">
    <section class="sidebar">
        <!-- 菜单 -->
        <ul class="sidebar-menu">
            <li class="header">系统功能</li>
            <!-- 汽车服务 -->
            <li class="treeview ${param.menu == 'order' ? 'active' : ''}">
                <a href="#">
                    <i class="fa fa-share-alt"></i> <span>维修保养服务</span>
                    <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/fix/list"><i class="fa fa-circle-o"></i>保养维修</a></li>
                    <li><a href="/check/list"><i class="fa fa-circle-o"></i>质量检测</a></li>
                </ul>
            </li>

        </ul>
    </section>
    <!-- /.sidebar -->
</aside>

