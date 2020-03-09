# Stegano

## 题目

见附件

## 解法

先打开pdf，在文章中搜索flag，发现除了在正文中我们能直接看到的地方有，在背景中也存在着3个flag字符，于是ctrl+A全选选中所有字符，将其复制至记事本中查看后面的被隐藏起来的字符，发现多了这么一句话：**NoFlagHere! NoFlagHere! NoFlagHere! XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
BABA BBB BA BBA ABA AB B AAB ABAA AB B AA BBB BA AAA BBAABB AABA ABAA AB BBA BBBAAA ABBBB BA AAAB ABBBB AAAAA ABBBB BAAA ABAA AAABB BB AAABB AAAAA AAAAA AAAAB BBA AAABB
Close - but still not here !**

那么很容易就想到摩斯密码，将A替换成'.'，将B替换成'-'，利用摩斯密码解密可得**congratulations,flag:1nv151bl3m3554g3**。

另，如果利用010-Editor在二进制下打开该文件，查找flag会找到这么一句话

```
/Author(KeiDii)/Title(polar bear during a snow storm)/Subject(<| tr AB .- |>)/Creator(LaTeX /o/)/Producer(find mr.morse text)/Keywords(Could this be the flag? : Tm9wZSAsIG5vdCBoZXJlIDspCg==)
```
find mr.morse text也暗示着利用摩斯电码进行解密，而这串base64解码后是**Nope , not here ;)**。