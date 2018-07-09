<%@ taglib prefix="s" uri="http://shiro.apache.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/20 0020
  Time: 下午 5:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>PermSys</title>
    <link rel="stylesheet" href="webjars/bootstrap/3.3.5/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/plugin/alert/BeAlert.css"/>
    <script src="webjars/jquery/3.1.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="/plugin/alert/BeAlert.js"></script>
    <script src="/js/send.js"></script>

    <style>
        .col-md-2,.list-group,.dropdown-menu{
            padding: 0px;
        }
        .navbar{
            margin-bottom: 0;

        }

        .navbar-right{
            margin-right: 0;
        }

        .col-md-2{
            heigt:calc(100vh - 52px);
            background:#5bc0de;
        }
        .list-group-item{
            margin: 0px;
        }

        .list-group li{
            background-color: #5bc0de;
        }

        .list-group-item{
            border-left: none;
            border-right: none;
        }

        .add{
            margin:20px 0;
        }
    </style>


</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="navbar navbar-default">
            <div class="navbar-header">
                <a href="javascript:void(0)" class="navbar-brand">PermSYS</a>
            </div>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="javascript:void(0)"><s:principal property="username"></s:principal> </a> </li>
                <li><a href="/logout">logout</a> </li>
            </ul>
        </div>

    </div>
    <div class="row">
        <div class="col-md-2">
            <ul class="list-group">
                <li class="list-group-item">
                    <a href="javascript:void(0)" data-toggle="dropdown" id="menu1">系统管理</a>
                    <ul class="dropdown-menu">
                        <li><a href="javascript:void(0)" onclick="getData('/sysUserList',1)">管理员</a> </li>
                        <li><a href="javascript:void(0)" onclick="getData('/sysRoleList',1)">角色管理</a> </li>
                        <li><a href="javascript:void(0)" onclick="">权限管理</a> </li>
                    </ul>
                </li>
                <li class="list-group-item">
                    <a href="javascript:void(0)" data-toggle="dropdown" id="menu1">数据管理</a>
                    <ul class="dropdown-menu">
                        <li><a href="javascript:void(0)">用户管理</a> </li>
                        <li><a href="javascript:void(0)">商品管理</a> </li>
                        <li><a href="javascript:void(0)">订单管理</a> </li>
                    </ul>
                </li>
                <li class="list-group-item">
                    <a href="javascript:void(0)">日志管理</a>
                </li>
            </ul>
        </div>
        <div class="col-md-10" id="content">

        </div>
    </div>

</div>

</body>
</html>
