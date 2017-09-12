<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib uri="/struts-tags" prefix="s" %> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/linkmanCss/listLinkMan.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/linkmanJs/linkManList.js" ></script>
<title>联系人列表</title>
</head>
<body>
	<table id="linkmantable">
		<tr>
			<th><input type="checkbox" name="all" onclick="checkAll(this)"/>全选</th>
			<th><a	href="javascript:void(0)" onclick="sortTable()" >联系人姓名</a></th>
			<th>职务</th><th>所属客户</th><th>性别</th><th>手机</th><th>邮箱</th><th>地址</th>
		</tr>
		<c:forEach items="${LinkManAllList }" var="linkMan">
			<tr>
				<td><input type="checkbox" name="checkbox"/></td>
				<td style="display:none">${linkMan.lid }</td>
				<td>${linkMan.linkManName }</td>
				<td>${linkMan.linkManPost }</td>
				<td>${linkman.customer.customerName }</td>
				<td>${linkMan.gender }</td>
				<td>${linkMan.linkManPhone }</td>
				<td>${linkMan.linkManEmail }</td>
				<td>${linkMan.linkManAddress }</td>
				<td>
					<input type="button" value="删除" onclick="deleteLinkMan(this)"/>
					<a href="${pageContext.request.contextPath }/linkman_findOne.action?lid=${linkMan.lid }" target="mainBody">修改</a>
				</td>
			</tr>
		</c:forEach>
	
		<tr>
			<td>
				<input type="checkbox" name="all" onclick="checkAll(this)"/>全选
			</td>
			<td colspan="5">
				<input type="button" value="全选" onclick="checkByBut(0)"/>
				<input type="button" value="取消全选" onclick="checkByBut(2)"/>
				<input type="button" value="反选" onclick="checkByBut(1)"/>
				<input type="button" value="删除所选" onclick="deleteLinkMan()"/>
			</td>
		</tr>
	</table>

</body>
</html>