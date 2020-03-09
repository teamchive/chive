**题名：**simple_php
**hint：**小宁听说php是最好的语言,于是她简单学习之后写了几行php代码。
**地址：**攻防世界web新手区第七题

# 解法
属于代码审计题。
php代码为：
```
﻿<?php
show_source(__FILE__);
include("config.php");
$a=@$_GET['a'];
$b=@$_GET['b'];
if($a==0 and $a){
    echo $flag1;
}
if(is_numeric($b)){
    exit();
}
if($b>1234){
    echo $flag2;
}
?>
```

a的那部分，前面是弱类型比较，false==0，false又为真。
b的那部分，可以用数字加字符，我随便写了一个3333a。
具体就是弱类型比较的特点。