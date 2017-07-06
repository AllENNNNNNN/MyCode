<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page session="false"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>modify</title>
</head>
<body>
		<form action="modifyed" method="post" >
			<p>
				Title: <input type="text" name="title"  value="${news.title }"/>
			</p>
			<p>
				Content: <input type="text" name="content" value="${news.content }"/>
			</p>
			<input type="submit" value="Modify" />
		</form>
</body>
</html>