<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page session="false"%>
<%@ page isELIgnored="false"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<style type="text/css">
html,body{
    height: 100%;
    width: 100%;
}
#header {
	background-color: black;
	color: white;
	text-align: center;
	padding: 5px;
	height: 15%;
    width: 100%;
}

#body {
	background-color: #CCFFFF;
	color: black;
	clear: both;
	text-align: center;
	padding: 5px;
	overflow: hidden;
	background-size: cover;
	height: 75%;
    width: 100%;
}

#footer {
	background-color: black;
	color: white;
	clear: both;
	text-align: center;
	padding: 5px;
	height: 10%;
    width: 100%;
}


</style>

<meta charset="utf-8">
     <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>

</head>
<body>

	<div id="header">
		<h1 aligin="center">Welcome to this web</h1>
	</div>
	<div id="body">

		<form action="Load" method="post" >
			<p>
				Username: <input type="text" name="username" />
			</p>
			<p>
				Password: <input type="password" name="password" />
			</p>
			<a href="RegistView">Sign in</a> 
			<input type="submit" value="Sign up" />
		</form>
		<p aligin="center" color="red">${message}</p>
	</div>
	<div id="footer">
		<h3 aligin="center">Copyright © Chongfei Wang</h3>
	</div>
</html>