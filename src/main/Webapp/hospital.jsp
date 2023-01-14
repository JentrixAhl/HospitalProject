<%@ page import="com.company.HospitalProject.Services"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Service Menu</title>
</head>
<body>
	<h1>Welcome to Ahl in/out patient Hospital Page</h1>
	<p><% Services services = new Services();
	 out.print(services.getServices());
	%></p>
		<p>	Option 1. Get patients list.
		<br>Option 2. Get one patient.
		<br>Option 3. Admit a patient.
		<br>Option 4. Update patient´s details.
		<br>Option 5. Release a patient.
		</p>
</body>
</html>

