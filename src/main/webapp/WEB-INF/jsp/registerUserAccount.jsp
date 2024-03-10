<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register User Account</title>
</head>
<body>
<h2>Register User Account</h2>
<form:form modelAttribute="userAccount" method="post" action="registerUserAccount">
    <!-- UserAccount Fields -->
    <label for="accountNumber">Account Number:</label><br>
    <form:input path="accountNumber" required="required"/><br>
    <label for="socialSecurityNumber">Social Security Number:</label><br>
    <form:input path="socialSecurityNumber" required="required"/><br>
    <label for="firstName">First Name:</label><br>
    <form:input path="firstName" required="required"/><br>
    <label for="lastName">Last Name:</label><br>
    <form:input path="lastName" required="required"/><br>
    <label for="email">Email:</label><br>
    <form:input path="email" required="required"/><br>
    <!-- Telephone Fields -->
    <label for="telephoneNumber">Telephone Number:</label><br>
    <form:input path="telephone.number" required="required"/><br>
    <label for="telephoneType">Telephone Type:</label><br>
    <form:input path="telephone.type" required="required"/><br>
    <!-- Address Fields -->
    <label for="street">Street:</label><br>
    <form:input path="address.street" required="required"/><br>
    <label for="city">City:</label><br>
    <form:input path="address.city" required="required"/><br>
    <label for="county">County:</label><br>
    <form:input path="address.county" required="required"/><br>
    <label for="country">Country:</label><br>
    <form:input path="address.country" required="required"/><br>
    <label for="postalCode">Postal Code:</label><br>
    <form:input path="address.postalCode" required="required"/><br>
    <!-- Additional UserAccount Fields -->
    <label for="userAccountStatus">Account Status:</label><br>
    <form:form modelAttribute="userAccount" method="post" action="registerUserAccount">
        <!-- Other form fields... -->
        <form:select path="userAccountStatus">
            <form:options items="${userAccountStatuses}" />
        </form:select><br>
    </form:form>
    <label for="balance">Balance:</label><br>
    <form:input path="balance" type="number" step="0.01" required="required"/><br>
    <label for="username">Username:</label><br>
    <form:input path="userAccountCredentials.username" required="required"/><br>
    <label for="password">Password:</label><br>
    <form:password path="userAccountCredentials.password" required="required"/><br>
    <input type="submit" value="Register">
</form:form>
</body>
</html>
