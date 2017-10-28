<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<ol class="breadcrumb">
		<c:forEach items="${arr}" var="item" >
         <li><a href="${item[1]}">${item[0]}</a></li></c:forEach>
</ol>