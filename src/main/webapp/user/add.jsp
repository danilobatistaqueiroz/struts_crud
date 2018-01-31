<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<html>
<head>
<script src="assets/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<font color="red">
		<html:errors/>
	</font>
	<html:form action="/addUser" styleId="formAdd">
		<table>
			<tr>
				<td>
					<bean:message key="label.user.login" /> : 
					<html:text property="login" size="30" />
				</td>
			</tr>
			<tr>
				<td>
					<bean:message key="label.user.name" /> : 
					<html:text property="name" size="80" />
				</td>
			</tr>
			<tr>
				<td>
					<bean:message key="label.user.age" /> :
					<html:text property="age" size="3" />
				</td>
			</tr>
			<tr>
				<td>
					<bean:message key="label.user.phone" /> : 
					<html:text property="phone" size="14" />
				</td>
			</tr>
			<tr>
				<td>
					<bean:message key="label.user.email" /> : 
					<html:text property="email" size="60" />
				</td>
			</tr>
			<tr>
				<td>
					<bean:message key="label.user.password" /> : 
					<html:password property="password" size="15" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<html:submit value="Add" />
				</td>
			</tr>
		</table>
	</html:form>
	
	<font color="green" size=2> 
		<logic:present name="success">
			User added successfully! 
		</logic:present>
	</font>
	
	<font color="red" size=2> 
		<logic:present name="failure">
			Ooops, an error occurred!! 
		</logic:present>
	</font>	
	<br><br>
	<html:link href="${pageContext.request.contextPath}/"> Home </html:link>
</body>
<script type="text/javascript">
	$(document).ready(function(){
		var $list = $("input[type='text']");
		$list.each(function(){
			$(this).attr('maxlength',$(this).attr('size'));
		});
	});
</script>
</html>