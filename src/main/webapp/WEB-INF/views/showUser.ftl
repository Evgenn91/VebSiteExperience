<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset = "UTF-8">
    <title>User</title>
</head>

<body>
<h1>User info</h1>
<table>
     <tr>
       <td>Id</td>
      <td>${user.id}</td>
     </tr>
     <tr>
       <td>Name</td>
       <td>${user.name}</td>
     </tr>
    <tr>
        <td>Email</td>
        <td>${user.email}</td>
    </tr>
    <tr>
        <td>Age</td>
        <td>${user.age}</td>
    </tr>
</table>

<a href = "/users">Back</a>

</body>
</html>