<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

   <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Allocation</title>
</head>
<body>
<div align="center">
	<f:form action="submitallocate" method="get">
	<label>Projects:</label>
	<select name="projectId">
	<core:forEach items="${plist}" var="pOb">
		<option value="${pOb.projectId}">${pOb.projectName}</option>
	</core:forEach>
	</select><br>
  
  <div>
	<label>Role:</label>
	<select name="roleId">
	<core:forEach items="${roleList}" var="rOb">
		<option value="${rOb.roleId}">${rOb.roleName} </option>
	</core:forEach>
	</select><br>
</div>

	<label>Location:</label>
	<div>
		<div class="custom-control custom-radio">	
 		<input type="radio" name="location" value="Onsite" checked> Onsite<br>
 		<input type="radio" name="location" value="Offshore"> Offshore<br>
		</div>  
<label>Employee:</label>
<select name="employeeId">

<core:forEach items="${elist}" var="eOb">

<option value="${eOb.employeeId}">${eOb.employeeName} </option>

</core:forEach>

</select><br>

</div>

<div class="form-group">

    <button type="submit" class="btn btn-primary">Submit</button>

</div>

</f:form>

</div>

</body>

</html>
</body>
</html>