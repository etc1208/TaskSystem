<%--
  Created by IntelliJ IDEA.
  User: yh
  Date: 2015/10/10
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
  <base href="<%=basePath%>">
  <meta charset="utf-8">
  <title>任务管理平台</title>
  <meta name="viewport" content="user-scalable=no, width=device-width, initial-scale=1, maximum-scale=1">
  <link href="resources/css/bootstrap-cerulean.min.css" rel="stylesheet">
  <link href="resources/css/dataTables.bootstrap.css" rel='stylesheet'>
  <link href="resources/css/fullcalendar.css" rel='stylesheet'>
  <link href="resources/css/fullcalendar.print.css" rel='stylesheet'>
  <link href="resources/css/chosen.min.css" rel='stylesheet'>
  <link href="resources/css/colorbox.css" rel='stylesheet'>
  <link href="resources/css/responsive-tables.css" rel='stylesheet'>
  <link href="resources/css/bootstrap-tour.min.css" rel='stylesheet'>
  <link href="resources/css/jquery.noty.css" rel='stylesheet'>
  <link href="resources/css/noty_theme_default.css" rel='stylesheet'>
  <link href="resources/css/elfinder.min.css" rel='stylesheet'>
  <link href="resources/css/elfinder.theme.css" rel='stylesheet'>
  <link href="resources/css/jquery.iphone.toggle.css" rel='stylesheet'>
  <link href="resources/css/animate.min.css" rel='stylesheet'>
  <link href="resources/css/charisma-app.css" rel="stylesheet">
  <link href='resources/css/style.css' rel="stylesheet">
  <!-- The fav icon -->
  <link rel="shortcut icon" href="resources/img/favicon.ico">
</head>

<body>
<div class="navbar navbar-default" role="navigation">
  <div class="navbar-inner">
    <button type="button" class="navbar-toggle pull-left animated flip">
      <span class="sr-only">Toggle navigation</span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="#"> <img alt="Charisma Logo" src="resources/img/logo20.png" class="hidden-xs"/>
      <span>任务管理平台</span></a>

    <!-- user dropdown starts -->
    <div class="btn-group pull-right theme-container animated tada">
      <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
        <i class="glyphicon glyphicon-user"></i> <span>${sessionScope.admin}</span>
        <span class="caret"></span>
      </button>
      <ul class="dropdown-menu">
        <li><a href="#" id='personalData'>个人资料</a></li>
        <li class="divider"></li>
        <li><a href="logout" >注销</a></li>
      </ul>
    </div>
  </div>
</div>
<div class="ch-container">
  <div class="row">
    <!-- left menu starts -->
    <div class="col-sm-2 col-lg-2">
      <div>
      </div>
      <div class="sidebar-nav">
        <div class="nav-canvas">
          <div class="nav-sm nav nav-stacked">
          </div>
          <ul id = "leftMenu" class="nav nav-pills nav-stacked main-menu">
            <li class="active" id = "view">
              <a href="homePage"><i class="glyphicon glyphicon-user"></i><span>  用户管理</span></a>
            </li>

          </ul>
        </div>
      </div>
    </div>
    <!--/span-->
    <!-- left menu ends -->

    <noscript>
      <div class="alert alert-block col-md-12">
        <h4 class="alert-heading">警告!</h4>
        <p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a>
          enabled to use this site.</p>
      </div>
    </noscript>

    <div id="content" class="col-lg-10 col-sm-10">
      <!-- content starts -->
      <div>
        <ul class="breadcrumb">
          <li>
            <a href="#">主页</a>
          </li>
          <li>
            <a href="#">用户管理</a>
          </li>
        </ul>
      </div>

      <div class=" row">
        <div class="col-md-3 col-sm-3 col-xs-6">
          <a data-toggle="tooltip" title="6 new members." class="well top-block" href="#">
            <i class="glyphicon glyphicon-globe blue"></i>

            <div>总用户</div>
            <span class="notification" id="totalNumber">100</span>
          </a>
        </div>

        <div class="col-md-3 col-sm-3 col-xs-6">
          <a data-toggle="tooltip" title="4 new pro members." class="well top-block" href="#">
            <i class="glyphicon glyphicon-star green"></i>

            <div>警察</div>
            <span class="notification green" id="policeNumber">40</span>
          </a>
        </div>

        <div class="col-md-3 col-sm-3 col-xs-6">
          <a data-toggle="tooltip" title="$34 new sales." class="well top-block" href="#">
            <i class="glyphicon glyphicon-user yellow"></i>

            <div>普通用户</div>
            <span class="notification yellow">60</span>
          </a>
        </div>

        <div class="col-md-3 col-sm-3 col-xs-6">
          <a data-toggle="tooltip" title="12 new messages." class="well top-block" href="#">
            <i class="glyphicon glyphicon-ok-sign red"></i>

            <div>当前在线</div>
            <span class="notification red">46</span>
          </a>
        </div>
      </div>

      <div class="row">
        <div class="box col-md-12" style="margin-top:20px">
          <div class="box-inner">
            <div class="box-header well" data-original-title="">
              <h2><i class="glyphicon glyphicon-user"></i>  用户管理</h2>
            </div>

            <div class="box-content" id="test">
              <table class="table table-striped table-bordered table-condensed" id="statisticInfoTable">
                <!--<table class="table table-striped table-bordered bootstrap-datatable datatable responsive" id="proxyTable">-->
                <thead>
                <tr>
                  <th>用户名</th>
                  <th>密码</th>
                  <th>用户类型</th>
                  <th>当前位置</th>
                  <th>更新时间</th>
                  <th>登录时间</th>
                  <th>状态</th>
                  <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <tr><td>无</td><td>无</td><td>无</td><td>无</td><td>无</td><td>无</td><td>无</td><td>无</td></tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
        <!--/span-->
        <!--/span-->
      </div>

    </div><!--/#content.col-md-0-->
  </div><!--/fluid-row-->
</div>


<!-- jQuery -->
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/jquery.cookie.js"></script>
<script src="resources/js/jquery.history.js"></script>
<script src="resources/js/chosen.jquery.min.js"></script>
<script src="resources/js/jquery.autogrow-textarea.js"></script>
<script src="resources/js/jquery.iphone.toggle.js"></script>
<script src="resources/js/jquery.raty.min.js"></script>
<script src="resources/js/jquery.uploadify-3.1.min.js"></script>
<script src="resources/js/jquery.colorbox-min.js"></script>
<script src="resources/js/moment.js"></script>
<script src="resources/js/fullcalendar.min.js"></script>
<script src='resources/js/jquery.dataTables.min.js'></script>
<script src="resources/js/dataTables.bootstrap.js"></script>
<script src="resources/js/charisma.js"></script>
</body>
</html>

