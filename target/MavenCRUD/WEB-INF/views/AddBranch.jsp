<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.js"></script>
<meta charset="ISO-8859-1">
<title>Add Branch</title>
</head>
<body>
<h2>Add Branch Details</h2>
	<form action="addBranch" name="addBranch" method="post" onSubmit="return validate();">
		<label>Branch Name: </label>
		<input type="text" id="branch_name"	name="branch_name" onchange="getBranchName(this.value);" required /></br>
		<label>Country: </label>
		<select id="countryId" name="countryId" style="color: black;">
			<option selected="selected" value="-1">Country</option>
			<c:if test="${!empty country}">
				<c:forEach items="${country}" var="country">
					<option value="${country.id}"><c:out
							value="${country.countryName}" /></option>
				</c:forEach>
			</c:if>
		</select> 
		</br> 
		<label>Branch Code: </label>
		<input type="text" id="branch_code" name="branch_code" onchange="getBranchCode(this.value);" required />
		</br> 
		<label>Branch Address: </label>
		<input type="text"name="branch_address" /> </br>
		<button type="submit">save</button>
		<button>
			<a href="${pageContext.request.contextPath}/home">Cancle</a>
		</button>

	</form>
</body>
<script type="text/javascript">
$(document).ready(function() {
	  $(window).keydown(function(event){
	    if(event.keyCode == 13) {
	      event.preventDefault();
	      return false;
	    }
	  });
	});
	function validate() {
		if ($("#countryId").val() == '-1') {
			alert("please select country!!");
			return false;
		}
	}
	function getBranchName(name) {
		$.ajax({
			type : "GET",
			url : "${pageContext.request.contextPath}/checkBranchNameDetails",
			data : "branch_name=" + name,
			dataType : 'text',
			success : function(response) {
				if (response != "") {
					alert(response);
					$("#branch_name").val("");
				}

			}
		});
	}
	function getBranchCode(code) {
		$.ajax({
			type : "GET",
			url : "${pageContext.request.contextPath}/checkBranchCodeDetails",
			data : "branch_code=" + code,
			dataType : 'text',
			success : function(response) {
				if (response != "") {
					alert(response);
					$("#branch_code").val("");
				}

			}
		});
	}
</script>
<style>
label {
	width: 120px;
	display: inline-block;
}
</style>
</html>