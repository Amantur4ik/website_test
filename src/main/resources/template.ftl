<!DOCTYPE html>
<html>
<head>
    <title>User</title>
</head>
<body>
<h1>Hello ${name}!</h1>
<p>Age: ${age}</p>
<p>Email: ${email}</p>

<h3>Skills</h3>
<ul>
    <#list skills as skill>
        <li>${skill}</li>
    </#list>
</ul>
</body>
</html>
