<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Agent Branch Details</h2>
	<table>
		<tr style="font-size: bold;">
			<td>ID</td>
			<td>Agent Name</td>
			<td>Branch Name</td>
			<td>Branch Code</td>
			<td>Country Name</td>
			<td>Address</td>
			<td>View</td>
			<td>Update</td>
			<td>Delete</td>
		</tr>
		<c:if test="${!empty agent}">
			<c:forEach items="${agent}" var="agent" varStatus="cnt">
				<tr>
					<td>${cnt.count}</td>
					<td>${agent.agent_name}</td>
					<td>${agent.branch.branch_name}</td>
					<td>${agent.branch.branch_code}</td>
					<td>${agent.branch.country.countryName}</td>
					<td>${agent.branch.branch_address}</td>
					<td><a href="viewBranch/${agent.branch.id}">View</a></td>
					<td><button>
							<a href="getBranch/${agent.branch.id}">Update</a>
						</button></td>
					<td><button>
							<a href="deleteAgent/${agent.id}">Delete</a>
						</button></td>
				</tr>
			</c:forEach>
		</c:if>
		</tbody>
	</table>
	<button>
		<a href="branch">Add</a>
	</button>
	<button>
		<a href="agent">Agent</a>
	</button>
</body>
<style>
td {
	border: 1px solid black;
}
</style>

</html>