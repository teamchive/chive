**题名：**command_execution
**hint：**小宁写了个ping功能,但没有写waf,X老师告诉她这是非常危险的，你知道为什么吗。
**地址：**攻防世界web新手区第十一题

# 解法
用命令连接符执行自己想执行的命令。可以用&也可以用|或者其它的。
find / -name flag.txt
然后cat /home/flag.txt