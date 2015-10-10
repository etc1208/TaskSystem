<%--
  Created by IntelliJ IDEA.
  User: yh
  Date: 2015/10/9
  Time: 20:53
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
  <title>登录</title>
  <base href="<%=basePath%>">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="cache-control" content="no-store">
  <meta http-equiv="expires" content="0">
  <%
    response.setHeader("Pragma","No-cache");
    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setDateHeader("Expires",0);
  %>

  <!-- The styles -->
  <link id="bs-css" href="resources/css/bootstrap-cerulean.min.css" rel="stylesheet">
  <link href="resources/css/charisma-app.css" rel="stylesheet">
  <style>
    footer {
      bottom: 0;
      width: 100%;
    }
    #tips{
      text-align: center;
      font-weight: bold;
      color: #36A7E8;
    }
  </style>

  <link rel="shortcut icon" href="resources/img/favicon.ico">
</head>
<body>
<div class="ch-container">
  <div class="row">

    <div class="row">
      <div class="col-md-12 center login-header">
        <h2>任务管理平台</h2>
      </div>
      <!--/span-->
    </div><!--/row-->

    <div class="row" style="height:483px">
      <div class="well col-md-5 center login-box">
        <div class="alert alert-info">
          请输入帐号密码登录
          <p style="color:red;">${exception.message}</p>
        </div>

        <form class="form-horizontal" action="login" method="post">
          <fieldset>
            <div class="input-group input-group-lg">
              <span class="input-group-addon"><i class="glyphicon glyphicon-user red"></i></span>
              <input type="text" class="form-control" placeholder="帐号" name="username" required>
            </div>
            <div class="clearfix"></div><br>

            <div class="input-group input-group-lg">
              <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
              <input type="password" class="form-control" placeholder="密码" name="password" required>
            </div>
            <div class="clearfix"></div><br>


            <div class="clearfix"></div>

            <p class="center col-md-5">
              <button type="submit" class="btn btn-primary">登录</button>
            </p>
          </fieldset>
        </form>
      </div>

      <!--/span-->
    </div><!--/row-->
  </div><!--/fluid-row-->

</div><!--/.fluid-container-->
<div id='tips'>友情提示：为保证最佳体验效果，若您正在使用IE浏览器，请尽量使用IE10及以上版本;其他类型浏览器在使用期间若出现网站布局混乱等情况，请切换浏览器模式！</div>
<footer>
  <div class="jumbotron" style="margin-top:25px">
    <div class="container">
      <div class="row">
        <div class="col-xs-12">
          <div class="submit">
            <p class="text-center"> <a>任务管理平台</a></p>
            <p class="text-center">Copyright&copy; 2015</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</footer>
</body>
</html>
