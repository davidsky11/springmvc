<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<!-- 接收参数total，总记录数 -->
<c:set var="total" value="${param.total }" />
<!-- 接收参数pageSize，每页最多显示的记录数 -->
<c:set var="pageSize" value="${param.pageSize }" />
<!-- 接收参数pageEnumShow，每次枚举的页面索引数 -->
<c:set var="pageEnumShow" value="${param.pageEnumShow }" />
<!-- 接收参数pageUrl，要分页的页面URL -->
<c:set var="pageUrl" value="${param.pageUrl }" />

<c:choose>
	<c:when test="${total > 0 }">
		<c:choose>
			<c:when test="${total % pageSize == 0 }">
				<c:set var="pageTotal" value="${total / pageSize }" />
			</c:when>
			<c:otherwise>
				<c:set var="pageTotal" value="${(total - total%pageSize) / pageSize + 1 }" />
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${empty param.pageIndex }">
				<c:set var="pageIndex" value="1" />
			</c:when>
			<c:otherwise>
				<c:set var="pageIndex" value="${param.pageIndex }" />
			</c:otherwise>
		</c:choose>
		<table>
		<tr>
			<c:choose>
				<c:when test="${pageTotal > pageEnumShow }">
					<c:choose>
						<c:when test="${pageTotal - pageEnumShow + 1 >= pageIndex }">
							<c:set var="pageStart" value="${pageIndex }" />
							<c:set var="pageEnd" value="${pageIndex + pageEnumShow - 1 }" />
						</c:when>
						<c:otherwise>
							<c:set var="pageStart" value="${pageTotal - pageEnumShow + 1 }" />
							<c:set var="pageEnd" value="${pageTotal }" />
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:otherwise>
					<c:set var="pageStart" value="${pageIndex }" />
					<c:set var="pageEnd" value="${pageTotal }" />
				</c:otherwise>
			</c:choose>
			<c:if test="${pageIndex > 1 }">
				<td nowrap="nowrap">
					<a href="${pageUrl }?pageIndex=${pageIndex - 1}">
						<img alt="" src="img/prev.gif" border="0" />
						<br/>
						<span style="font-size: 12pt;font-weight:bold">Previous</span>
					</a>
				</td>
			</c:if>
			<c:forEach begin="${pageStart }" end="${pageEnd }" var="i">
				<td nowrap="nowrap">
					<c:choose>
						<c:when test="${i == pageIndex && pageIndex == 1 }">
							<img alt="" src="img/first.gif" border="0" />
							<br/>
							1
						</c:when>
						<c:when test="${pageIndex != i }">
							<a href="${pageUrl }?pageIndex=${i }" >
								<img alt="" src="img/page.gif" border="0" />
								<br/>
								<c:out value="${i }" />
							</a>
						</c:when>
						<c:when test="${pageIndex == i && pageIndex != pageTotal }">
							<img alt="" src="img/current.gif" border="0" />
							<br/>
							<c:out value="${i }" />
						</c:when>
						<c:when test="${pageIndex == pageTotal && pageIndex == i }">
							<img alt="" src="img/last.gif" border="0" />
							<br/>
							<c:out value="${pageIndex }" />
						</c:when>
					</c:choose>
				</td>
			</c:forEach>
			<c:if test="${pageIndex < pageTotal }">
				<td nowrap="nowrap">
					<a href="${pageUrl }?pageIndex=${pageIndex + 1 }">
						<img alt="" src="img/next.gif" border="0" />
						<br/>
						<span style="font-size: 12pt;font-weight:bold">Next</span>
					</a>
				</td>
			</c:if>
		</tr>
		</table>
	</c:when>
	<c:otherwise>
		暂无任何记录!!
	</c:otherwise>
</c:choose>
