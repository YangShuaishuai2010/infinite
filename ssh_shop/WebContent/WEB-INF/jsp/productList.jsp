<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>帅帅商城</title>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/product.css" rel="stylesheet" type="text/css"/>

</head>
<body>
	<div class="container header">
		<div class="span5">
			<div class="logo">
				<a href="http://localhost:8080/mango/">
					<img src="${pageContext.request.contextPath}/images/r___________renleipic_01/logo.gif" alt="帅帅商城">
				</a>
			</div>
		</div>
		<div class="span9">
			<div class="headerAd">
				<img src="image\r___________renleipic_01/header.jpg" alt="正品保障" title="正品保障" height="50" width="320">
			</div>	
		</div>
		
		<%@ include file="menu.jsp" %>
		
	</div>
	<div class="container productList">
		<div class="span6">
			<div class="hotProductCategory">
				<s:iterator var="c" value="#session.cList">
					<dl>
						<dt>
							<a href="${pageContext.request.contextPath}/product_findByCid.action?cid=<s:property value="#c.cid"/>&currentPage=1"><s:property value="#c.cname"/></a><!-- 一级分类的商品名称 -->
						</dt>
						<s:iterator var="cs" value="#c.categorySeconds">
							<dd>
								<a href="${pageContext.request.contextPath }/product_findByCsid.action?csid=<s:property value="#cs.csid"/>&currentPage=1"><s:property value="#cs.csname"/></a><!-- 二级分类的商品名称 -->
							</dd>
						</s:iterator>
					</dl>
				</s:iterator>	
			</div>
		</div>
		<div class="span18 last">
			<form id="productForm" action="${pageContext.request.contextPath}/images/蔬菜 - Powered By Mango Team.htm" method="get">
				<div id="result" class="result table clearfix">
					<ul>
						<s:iterator var="p" value="pageBean.list">	
							<li>
								<a href="${pageContext.request.contextPath }/product_findByPid.action?pid=<s:property value="#p.pid"/>">
									<img src="${pageContext.request.contextPath}/<s:property value="#p.image"/>" width="170" height="170"  style="display: inline-block;">	   
									<span style='color:green'>
										<s:property value="#p.pname"/>
									</span>
									<span class="price">
										商城价： ￥<s:property value="#p.shop_price"/>
									</span>
								</a>
							</li>
						</s:iterator>
					</ul>
				</div>
				<div class="pagination">
					<span>第<s:property value="pageBean.currentPage"/>/<s:property value="pageBean.totalPage"/>页</span>
					<s:if test="cid !=null">
						<s:if test="pageBean.currentPage!=1">
							<a class="firstPage" href="${pageContext.request.contextPath }/product_findByCid.action?cid=<s:property value="cid" />&currentPage=1" >&nbsp;</a>
							<a class="previousPage" href="${pageContext.request.contextPath }/product_findByCid.action?cid=<s:property value="cid" />&currentPage=<s:property value="pageBean.currentPage-1"/>" >&nbsp;</a>
						</s:if>
							
						<s:iterator var="i" begin="1" end="pageBean.totalPage">
							<s:if test="pageBean.currentPage!=#i">
								<a href="${pageContext.request.contextPath }/product_findByCid.action?cid=<s:property value="cid" />&currentPage=<s:property value="#i"/>"><s:property value="#i"/></a>
							</s:if>
							<s:else>
								<span class="currentPage"><s:property value="#i"/></span>
							</s:else>
						</s:iterator>
							
						<s:if test="pageBean.currentPage!=1">
							<a class="nextPage" href="${pageContext.request.contextPath }/product_findByCid.action?cid=<s:property value="cid" />&currentPage=<s:property value="pageBean.currentPage+1"/>">&nbsp;</a>
							<a class="lastPage" href="${pageContext.request.contextPath }/product_findByCid.action?cid=<s:property value="cid" />&currentPage=<s:property value="pageBean.totalPage"/>" >&nbsp;</a>
						</s:if>
					</s:if>
						
					<s:if test="csid!=null">
						<s:if test="pageBean.currentPage!=1">
							<a class="firstPage" href="${pageContext.request.contextPath }/product_findByCsid.action?csid=<s:property value="csid" />&currentPage=1" >&nbsp;</a>
							<a class="previousPage" href="${pageContext.request.contextPath }/product_findByCsid.action?csid=<s:property value="csid" />&currentPage=<s:property value="pageBean.currentPage-1"/>" >&nbsp;</a>
						</s:if>
							
						<s:iterator var="i" begin="1" end="pageBean.totalPage">
							<s:if test="pageBean.currentPage!=#i">
								<a href="${pageContext.request.contextPath }/product_findByCsid.action?csid=<s:property value="csid" />&currentPage=<s:property value="#i"/>"><s:property value="#i"/></a>
							</s:if>
							<s:else>
								<span class="currentPage"><s:property value="#i"/></span>
							</s:else>
						</s:iterator>
							
						<s:if test="pageBean.currentPage!=1">
							<a class="nextPage" href="${pageContext.request.contextPath }/product_findByCsid.action?csid=<s:property value="csid" />&currentPage=<s:property value="pageBean.currentPage+1"/>">&nbsp;</a>
							<a class="lastPage" href="${pageContext.request.contextPath }/product_findByCsid.action?csid=<s:property value="csid" />&currentPage=<s:property value="pageBean.totalPage"/>" >&nbsp;</a>
						</s:if>
					</s:if>
				</div>
			</form>
		</div>
	</div>
	<div class="container footer">
		<div class="span24">
			<div class="footerAd">
				<img src="${pageContext.request.contextPath}/images/footer.jpg" width="950" height="52" alt="我们的优势" title="我们的优势">
			</div>
		</div>
		<div class="span24">
			<ul class="bottomNav">
				<li>
					<a >关于我们</a>
					|
				</li>
				<li>
					<a>联系我们</a>
					|
				</li>
				<li>
					<a >诚聘英才</a>
					|
				</li>
				<li>
					<a >法律声明</a>
					|
				</li>
				<li>
					<a>友情链接</a>
					|
				</li>
				<li>
					<a target="_blank">支付方式</a>
					|
				</li>
				<li>
					<a  target="_blank">配送方式</a>
					|
				</li> 
				<li>
					<a >官网</a>
					|
				</li>
				<li>
					<a >论坛</a>	
				</li>
			</ul>
		</div>
		<div class="span24">
			<div class="copyright">
				Copyright©2000-2017 网上商城 版权所有
			</div>
		</div>
	</div>
</body>
</html>