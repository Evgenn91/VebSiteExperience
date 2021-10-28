<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset = "UTF-8">
    <title>Create user page</title>
</head>
<body>

<form name="user" action="/updateUser" method="post">
    <p>Id</p>
    <input title = "Id" type="text" name="id" value="${user.id}">
    <p>Name</p>
    <input title = "Name" type="text" name="name" value="${user.name}">
    <p>Email</p>
    <input title = "Email" type="text" name="email" value="${user.email}">
    <p>Age</p>
    <input title = "Age" type="text" name="age" value="${user.age}">
    <input type ="submit" value="OK">
</form>

</body>
</html>