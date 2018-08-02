<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>更新信息</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/subjectUpdate.do">
    辩题编号： ${subjects.subId}<input type="hidden" name="subId" value="${subjects.subId}"><br>
    <%--系：<input type="text" name="deparId" value="${subjects.deparId}"><br>--%>
    辩题名称：<input type="text" name="subName" value="${subjects.subName}"><br>
    <%--辩题注意事项：<input type="text" name="subDetail" value="${subjects.subDetail}"><br>--%>
    <%--答辩辩题总共数量：<input type="text" name="submount" value="${subjects.submount}"><br>--%>
    答辩辩题描述：<input type="text" name="subDesc" value="${subjects.subDesc}"><br>
    <%--答辩地点：<input type="text" name="subPalce" value="${subjects.subPalce}"><br>--%>

    <input type="submit" value="提交">
    <input type="reset" value="重写">

</form>
<a href="${pageContext.request.contextPath}/subjectUpdateView.do"></a>
</body>
</html>