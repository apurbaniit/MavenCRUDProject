<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript">
	function validate() {
		$("#branchIDs").val($("#branchId").val());
		return true;
	}
	$(document).ready(function() {
		  $(window).keydown(function(event){
		    if(event.keyCode == 13) {
		      event.preventDefault();
		      return false;
		    }
		  });
		});
</script>
<style>
label {
	width: 120px;
	display: inline-block;
}
</style>
</head>
<body>
<h2>Add Agent Details</h2>
	<form action="addAgent" name="addAgent" method="post"
		onsubmit="return validate();">
		<label>Agent Name: </label>
		<input type="text" name="agent_name" required />
		</br> 
		<label>Agent Code: </label>
		<input type="text" name="agent_code" required />
		</br> 
		<div>
		<label>Country: </label>
		<select tabindex="1" id="branchId" name="branchId" style="color: black;" multiple>
			<c:if test="${!empty branch}">
				<c:forEach items="${branch}" var="branch">
					<option value="${branch.id}"><c:out
							value="${branch.branch_name}" /></option>
				</c:forEach>
			</c:if>
		</select> <input type="hidden" id="branchIDs" name="branchIDs">
		</div>
		</br>
		<button type="submit">save</button>
		<button>
			<a href="${pageContext.request.contextPath}/home">Cancle</a>
		</button>
	</form>
</body>

</html>