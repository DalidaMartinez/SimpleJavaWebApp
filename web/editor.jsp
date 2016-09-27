<%-- 
    Document   : editor
    Created on : Sep 26, 2016, 9:47:06 AM
    Author     : DalidasMac
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Email Editor</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
        <h1><span style="color: darkcyan">Registered Users</span></h1>
        </body>
        <body>
    <c:forEach var="email" items="${emailEntry}">
        <p>${email.id} ${email.firstname} ${email.lastname}</p>
    </c:forEach>
        <form method="POST" action="emailEditorServlet">
            <h1><span style="color: darkcyan">Please Register your Email</span></h1>
            <table>
                <tr><td>ID: </td><td><input type="text" name="emailID" /></td></tr>
                <tr><td>First Name: </td><td><input type="text" name="firstname" /></td></tr>
                <tr><td>Last Name: </td><td><input type="text" name="lastname" /></td></tr>
                <tr><td><input type="submit" value="Submit" name="action"/></td></tr>
            </table>
        </form>
        <form method="POST" action="emailEditorServlet">
        
         <h1><span style="color: darkcyan">Search an email Record by Last Name</span></h1>
            <table>
                <tr><td>Last Name: </td><td><input type="text" name="lastname" /></td></tr>
                <tr><td><input type="submit" value="Search" name="action"/></td></tr>
            </table>
        </form>
        <form method="POST" action="emailEditorServlet">
            <h1><span style="color: darkcyan">Show All Records</span></h1>
            <table>
                <tr><td><input type="submit" value="Show All" name="action" /></td></tr>
            </table>
        </form>
        <form method="POST" action="emailEditorServlet">
            <h1><span style="color: darkcyan">Edit a Record</span></h1>
            <table>
                <tr><td>ID: </td><td><input type="text" name="emailID" /></td></tr>
                <tr><td>First Name: </td><td><input type="text" name="firstname" /></td></tr>
                <tr><td>Last Name: </td><td><input type="text" name="lastname" /></td></tr>
                <tr><td><input type="submit" value="Edit" name="action"/></td></tr>
                <tr><td>Response from Server: ${message1}</td></tr>
            </table>
        </form>
        <form method="POST" action="emailEditorServlet">
            <h1><span style="color: darkcyan">Delete a Record by ID</span></h1>
            <table>
                <tr><td>ID: </td><td><input type="text" name="emailID" /></td></tr>
                <tr><td><input type="submit" value="Delete" name="action" /></td></tr>
                <tr><td>Response from Server: ${message2}</td></tr>
            </table>
        </form>
        <form method="POST" action="emailEditorServlet">
            <h1><span style="color: darkcyan">Show Number of Records in the Database</span></h1>
            <table>
                <tr><td><input type="submit" value="Total Records" name="action" /></td></tr>
                <tr><td>Total number of records is: ${message3}</td></tr>
            </table>
        </form>
    </body>
</html>
