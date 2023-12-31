<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration page</title>
<style>
        .error {
            color: #ff0000;
        }

        .errorblock {
            color: #000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }
    </style>
</head>
<body>
	<h1>Registration</h1>
	<form:form modelAttribute="registration">
	<form:errors path="*" cssClass="errorblock" element="div"></form:errors>
		<table>
			<tr>
				<!-- <td>Name:</td> -->
				<spring:message code="name"> </spring:message>
				
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssClass="error"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add Registration">
				</td>
			</tr>

		</table>
	</form:form>
</body>
</html>