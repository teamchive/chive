**题名：**upload1
**地址：**攻防世界web高手进阶区第十题

# 解法
属于文件上传漏洞，在服务器端没有检验，只在本地检查了上传文件后缀名。只需要用bp在传包的时候，修改文件名即可。
然后菜刀连接。
退一个目录，找到flag.php