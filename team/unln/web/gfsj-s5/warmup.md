**题名：**warmup
**地址：**攻防世界web高手进阶区第五题

# 解法
本题是一个文件包含漏洞。
查看源码，暗示有个source.php
内容如下（加了注释）：
```
<?php
    highlight_file(__FILE__);
    class emmm
    {
        public static function checkFile(&$page)
        {
            $whitelist = ["source"=>"source.php","hint"=>"hint.php"];
            if (! isset($page) || !is_string($page)) {
                echo "you can't see it";
                return false;
            }

            if (in_array($page, $whitelist)) {
                return true;
            } //11111

            $_page = mb_substr(
                $page,
                0,
                mb_strpos($page . '?', '?')
            );
            if (in_array($_page, $whitelist)) {
                return true;
            } //22222

            $_page = urldecode($page);
            $_page = mb_substr(
                $_page,
                0,
                mb_strpos($_page . '?', '?')
            );
            if (in_array($_page, $whitelist)) {
                return true;
            } //33333
            echo "you can't see it";
            return false;
        }
    }

    if (! empty($_REQUEST['file'])//file非空才执行函数
        && is_string($_REQUEST['file'])
        && emmm::checkFile($_REQUEST['file']) //emmm类的checkFile
    ) {
        include $_REQUEST['file']; //要构造一个名为file的一个表单值
        exit;
    } else {
        echo "<br><img src=\"https://i.loli.net/2018/11/01/5bdb0d93dc794.jpg\" />"; //这就是我们看到的滑稽
    }  
?>
```
发现还有一个hint.php，查看后猜测应该还有ffffllllaaaagggg.php
本质还是要构造payload，绕过白名单。一共有3次机会绕过。第一次是不可能了，看下面两个。
mb_strpos返回查找内容在字符串中首次出现的位置。mb_substr（）是截取字符串的。
在白名单后加？然后再写上/../../../../ffffllllaaaagggg。
网上都是加的%253f，实际中似乎都可以。
这里的souce.php?会被视为一个目录。然后又回退了三次，是不是有点离谱……
正常做题我感觉还是挺难想的。

附资料：https://www.cnblogs.com/leixiao-/p/10265150.html

