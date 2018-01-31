<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script type="text/javascript">
		function postForm(method){
			var form = document.getElementById('formDel');
			form.elements["dispatch"].value = method;
			form.submit();
		}
		function cancel(){
			document.all['goHome'].click();
		}
	</script>
</head>
<bean:define id="login" name="user" property="login"/>
<bean:define id="phone" name="user" property="phone"/>
<bean:define id="email" name="user" property="email"/>
<%
String userName = ((com.keylesson.persistence.User)request.getAttribute("user")).getName();
String userAge = String.valueOf(((com.keylesson.persistence.User)request.getAttribute("user")).getAge());
%>
<body>
	<html:form action="/user" styleId="formDel">
		<html:hidden property="dispatch" />
		<h1>do you really want to delete this item?</h1>
		<table>
			<tr>
				<td>Login</td>
				<html:hidden property="login" value="${login}" />
				<td><bean:write property="login" name="user" /></td>
			</tr>
			<tr>
				<td>User name</td>
				<html:hidden property="name" value="<%=userName%>"/>
				<td><bean:write property="name" name="user" /></td>
			</tr>
			<tr>
				<td>User age</td>
				<html:hidden property="age" value="<%=userAge%>"/>
				<td><bean:write property="age" name="user"/></td>
			</tr>
			<tr>
				<td>Phone number</td>
				<html:hidden property="phone" value="${phone}"/>
				<td><bean:write property="phone" name="user"/></td>
			</tr>
			<tr>
				<td>Email</td>
				<html:hidden property="email" value="${email}"/>
				<td><bean:write property="email" name="user"/></td>
			</tr>
			<tr>
				<td align="left"><html:button value="Confirm" property=""
					onclick="postForm('delUser')" />
				</td>
				<td align="right"><html:button value="Cancel" property=""
					onclick="cancel()" />
				</td>
			</tr>
		</table>
	</html:form>
	<br><br>
	<html:link styleId="goHome" href="${pageContext.request.contextPath}/"> Home </html:link>
</body>
</html>