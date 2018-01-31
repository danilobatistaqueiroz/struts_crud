<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script type="text/javascript">
		function postForm(method){
			var form = document.getElementById('formSearch');
			form.elements["dispatch"].value = method;
			form.submit();
		}
	</script>
</head>
<body>
	<html:form action="/user" styleId="formSearch">
		<html:hidden property="dispatch" />
		<table>
			<tr>
				<td>User name</td>
				<td><html:text property="name" size="20" /></td>
				<td><html:button value="Search" property="" onclick="postForm('searchUsers')" /></td>
			</tr>
		</table>
	</html:form>
	
	<br>
	<logic:empty name="users" >
		<span>nothing</span>
	</logic:empty>
	<logic:notEmpty name="users" >
	<table width="100%">
		<tr>
			<td bgcolor="#FF9900">Login</td>
			<td bgcolor="#FF9900">Name</td>
			<td bgcolor="#FF9900">Age</td>
			<td bgcolor="#FF9900">Phone</td>
			<td bgcolor="#FF9900">Email</td>
			<td bgcolor="#FF9900" colspan="2"></td>
		</tr>
		<logic:iterate name="users" id="user">
			<tr>
				<td bgcolor="#DBEAF9"><bean:write name="user" property="login" /></td>
				<td bgcolor="#DBEAF9"><bean:write name="user" property="name" /></td>
				<td bgcolor="#DBEAF9"><bean:write name="user" property="age" /></td>
				<td bgcolor="#DBEAF9"><bean:write name="user" property="phone" /></td>
				<td bgcolor="#DBEAF9"><bean:write name="user" property="email" /></td>
				<td bgcolor="#DBEAF9">
					<html:link href="${pageContext.request.contextPath}/user.do?dispatch=goToEditPage" paramId="user" paramName="user" paramProperty="name">
						edit
					</html:link>
				</td>
				<td bgcolor="#DBEAF9">
					<html:link href="${pageContext.request.contextPath}/user.do?dispatch=goToDeletePage" paramId="user" paramName="user" paramProperty="name">
						delete
					</html:link>
				</td>
			</tr>
		</logic:iterate>
	</table>
	</logic:notEmpty>
		
	<br><br>
	<html:link href="${pageContext.request.contextPath}/"> Home </html:link>
</body>
</html>