**题名：**PHP2
**地址：**攻防世界web高手进阶区第八题

# 解法
这题涉及源码泄露，因为用户无法直接看到php文件内容，服务器引入phps后缀的文件来给用户查看源码。
源码见下：
```
<?php
if("admin"===$_GET[id]) {
  echo("<p>not allowed!</p>");
  exit();
}

$_GET[id] = urldecode($_GET[id]);
if($_GET[id] == "admin")
{
  echo "<p>Access granted!</p>";
  echo "<p>Key: xxxxxxx </p>";
}
?>

Can you anthenticate to this website?
```
一方面要使得admin不等于$_GET[id]
另一方面要使得admin等于urldecode($_GET[id])
显然是两次解码后才相等。url解码只会解码一次，所以引入%25来解析为%，最终payload可以为?id=%2561dmin