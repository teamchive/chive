**题名：**xff_referer
**hint：**X老师告诉小宁其实xff和referer是可以伪造的。
**地址：**攻防世界web新手区第九题

# 解法
在bp里分别加入。
X-Forwarded-For: 123.123.123.123
Referer: https:\/\/www.google.com
