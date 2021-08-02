<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Branch</title>
</head>
<body>
<h2>View Branch Details</h2>
	<form>
	<input type="number" name="branch_id" value="${branch.id}"hidden>
 	<label>Branch Name: </label><input type="text" name="branch_name" value="${branch.branch_name}" ReadOnly/></br>
 	<label>Country: </label><select tabindex="1" id="countryId" name="countryId" style="color: black;">
		<option  value="-1">Country</option>
		<c:if test="${!empty country}">
			<c:forEach items="${country}" var="country">
			
				<option value="${country.id}" ${branch.country.id eq country.id ?'selected' : ''}><c:out value="${country.countryName}"/></option>
			
			</c:forEach>
		</c:if>	
	</select>   
	</br>
 	<label>Branch Code: </label><input type="text" name="branch_code" value="${branch.branch_code}" ReadOnly/>
 	</br>
 	<label>Branch Address: </label><input type="text" name="branch_address" value="${branch.branch_address}" ReadOnly/>
 	</br>
 	<button><a href="${pageContext.request.contextPath}/home">Cancle</a></button>
 	
 </form>
</body>
<script type="text/javascript">
$('#countryId').css('pointer-events','none');
</script>
<style>
label {
	width: 120px;
	display: inline-block;
}
</style>
</html>