<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<table border="1px" width="80%" align="center">
    <tr>
        <td>id</td>
        <td>username</td>
    </tr>
    <#list userList as user>
    <tr>
        <td>${user.id}</td>
        <td>${user.name}</td>
    </tr>
    </#list>
</table>
</body>
</html>