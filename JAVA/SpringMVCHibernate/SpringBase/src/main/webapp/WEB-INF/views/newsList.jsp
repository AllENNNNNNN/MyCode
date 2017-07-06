<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page session="false"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">
<title>NewsList</title>
</head>
<style type="text/css">
table{
	width:"400";
}
th{
	text-align:center;
}
td{
	text-align:left
}
</style>
<div>
<form action="search" method="post">
<select name="select">
<option value="userId">UserId</option>
<option value="newsTitle">Title</option>
</select>
<input type="text" name="searchContent">
<input type="submit" value="Search">
</form> 
</div>
<br>
<div>
<form action="publish" method="post">
<input type="text" name="title" value="newTitle">
<input type="text" name="content" value="newContent" >
<input type="submit" value="Publish">
</form>
</div>
<br>
<table  id="mytable" width="200" border="1">
  <caption>
    newsList
  </caption>
  <tbody>
    <tr>
      <th scope="col">Title</th>
      <th scope="col">Content</th>
      <th scope="col">Time</th>
      <th scope="col">Time</th>
    </tr>
    <c:forEach items="${newsList }" var="news">
        <tr>
      <td>${news.title }</td>
      <td>${news.content }</td>
      <td>${news.publishTime }</td>
      <td><a href="delete?id=${news.id }" >delete</a>
      <td><a href="modify?id=${news.id }">modify</a>
    </tr>
    </c:forEach>
  </tbody>
</table>

<body>
</body>
</html>