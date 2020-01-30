<h3>Edit details:-</h3>
<form method="post" action="updateEmployees">
	<input type="hidden" name="id" value="${employee.id}">
	First Name:<input name="fname" value="${employee.fname}">
	Last Name:<input name="lname" value="${employee.lname}">
	Number:<input type="number" name="number" value="${employee.number}">
	<input type="submit" value="Edit">
</form>
