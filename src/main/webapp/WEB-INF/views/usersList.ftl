<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset = "UTF-8">
    <title>Title</title>
</head>
<body>
      <h1>Users list</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Age</th>
    </tr>
    <#list users as user>
        <tr>
           <td><a href="/user/${user.id}">${user.id}</a></td>
           <td>${user.name}</td>
           <td>${user.email}</td>
           <td>${user.age}</td>
            <td><a href="/delete/${user.id}">Delete</a></td>
            <td><a href="/update/${user.id}">Update</a></td>
        </tr>
    </#list>
</table>

<a href ="/addUser">Create user</a>
</body>
</html>