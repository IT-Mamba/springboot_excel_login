<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

</head>
<body>

	<div class="row">
		<div
			class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
			<div class="login-panel panel panel-default">
				<div class="panel-heading">Log in ${result}</div>
				<div class="panel-body">
					<form role="form" action="/loginVerify" method="post">
						<fieldset>
							<div class="form-group">
								<input class="form-control" placeholder="username" id="username"
									name="username" autofocus="">
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="password" id="password"
									name="password" type="password" value="">
							</div>
							<div class="checkbox">
								<table>
									<tr>
										<td>验证码：</td>
										<td class="width50"><input id="checkcode"
											name="checkcode" type="text" class="width50" /></td>
										<td><img src="createImage" alt="验证码" title="点击更换" id="images"
											onclick="this.src='createImage?'+(new Date()).getTime();" /></td>
									</tr>
								</table>
							</div>
							<button type="submit" id="login" class="btn btn-primary">Login</button>
							<!-- <a href="/loginServlet" class="btn btn-primary">Login</a> -->
						</fieldset>
					</form>
				</div>
			</div>
		</div>
		<!-- /.col-->
	</div>
	<!-- /.row -->



	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script>
		!function($) {
			$(document)
					.on(
							"click",
							"ul.nav li.parent > a > span.icon",
							function() {
								$(this).find('em:first').toggleClass(
										"glyphicon-minus");
							});
			$(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
		}(window.jQuery);

		$(window).on('resize', function() {
			if ($(window).width() > 768)
				$('#sidebar-collapse').collapse('show')
		})
		$(window).on('resize', function() {
			if ($(window).width() <= 767)
				$('#sidebar-collapse').collapse('hide')
		})
	</script>
</body>

</html>
