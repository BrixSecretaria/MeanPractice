<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>
<script src="js/script.js"></script>
<title>Welcome to Login Page</title>
</head>
<body>
	<form method="post" action="login" style="background:#98bf21;height:100px;width:100px;position:absolute;">
            <center>
            <table border="1" width="30%" cellpadding="3">
                <thead>
                    <tr>
                        <th colspan="2">Login Here</th>
                    </tr>
                </thead>
                <tbody id="table-body">
                    <tr id="user-name">
                        <td>User Name</td>
                        <td><input type="text" name="uname" value="" /></td>
                    </tr>
                    <tr id="user-password">
                        <td>Password</td>
                        <td><input type="password" name="pass" value="" /></td>
                    </tr>    
                    <tr>
                    <td></td>
                        <td><input id="login-button" type="submit" value="Login" />
                        <input type="reset" value="Reset" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">Yet Not Registered!! <a href="registration.jsp">Register Here</a></td>
                    </tr>
                </tbody>
            </table>
            </center>
        </form>
</body>
</html>