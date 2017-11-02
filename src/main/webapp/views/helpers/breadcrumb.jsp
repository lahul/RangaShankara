<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<ol class="breadcrumb">
	<c:set var="length" value="${fn:length(arr)}"></c:set>
		<c:forEach items="${arr}" var="item" varStatus="loop" >
			<c:choose>
		    <c:when test="${loop.index==length-1}">
		        <li>${item[0]}</li>
		    </c:when>
		    <c:otherwise>
		        <li><a href="${item[1]}">${item[0]}</a></li>
		    </c:otherwise>
		</c:choose>
         	
         </c:forEach>
</ol>