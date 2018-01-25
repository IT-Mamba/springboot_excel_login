<%@ page language="java" import="java.sql.*,java.io.*,java.util.*"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/datepicker3.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">

<!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<script src="js/respond.min.js"></script>
<![endif]-->

</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#sidebar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><span>随便玩玩的</span>系统平台</a>
				<ul class="user-menu">
						<li><a href="logout"><span
									class="glyphicon glyphicon-log-out"></span> Logout</a></li>
						</ul>
				</ul>
			</div>
		</div>
		<!-- /.container-fluid -->
	</nav>

	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<form role="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search">
			</div>
		</form>
		<ul class="nav menu">
			<li class="active"><a href="index"><span
					class="glyphicon glyphicon-dashboard"></span> 首页</a></li>
			<li><a href="forms"><span class="glyphicon glyphicon-th"></span>
					导入解析EXCEL</a></li>
			<li role="presentation" class="divider"></li>
			<li><a href="login"><span
					class="glyphicon glyphicon-user"></span> Login Page</a></li>
		</ul>
	</div>
	<!--/.sidebar-->

	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="index"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">首页</li>
			</ol>
		</div>
		<!--/.row-->

		<div class="row">
			<div class="col-lg-12">
				<h3 class="page-header">首页</h3>
			</div>
			<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-body" ><tr>
						<h4 style="margin-left:500px"><a href="http://itmamba.com">主页地址</a></h4>
                    </div>
				</div>
			</div>
		</div><!--/.row-->
		</div>

		<script src="js/jquery-1.11.1.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/chart.min.js"></script>
		<script src="js/chart-data.js"></script>
		<script src="js/easypiechart.js"></script>
		<script src="js/easypiechart-data.js"></script>
		<script src="js/bootstrap-datepicker.js"></script>
		
		</script>
</body>

</html>
