## Write-up

### 前置知识

1.每种语言都有一个程序入口（如：C语言 main函数），而Android程序的入口就是Main Activity函数。Activity   是Android的核心类（android.app.Activity）,在Activity类有onCreate事件方法，一般用于对Activity进行初始化，并且通过setContentView方法将View放到Activity上，绑定后，Activity会显示View上的控件。

MainAcitvity.java文件下的MainActivity类：
		 onCreate()是创建窗体的入口函数。
 		onCreateOptionsMenu()是创建当前Activity的菜单函数。
         onOptionsItemSelected()是响应菜单按钮点击事件函数。
         PlaceolderFragment内部类是实现自定义fragment。

### 正题

第一次做Mobile题，流程也是和我想象中差不多的——工具逆向-＞找解flag切入点-＞写脚本解flag

##### 工具逆向

用的工具是JEB3.0 beta，逆向得到源代码的操作过程倒是蛮简单的，不过不知道具体的实现流程是什么样的，日后研究一下。

##### 找Flag切入点

反编译导出代码后直奔com文件夹找到MainActivity.java，发现onCreate()中有如下内容

```java
public void onClick(View arg5) {
                if(MainActivity.a(this.a.findViewById(0x7F0B0075).getText().toString()).booleanValue()) {
                    Toast.makeText(this.a, "You are right!", 1).show();
                }
                else {
                    Toast.makeText(this.a, "You are wrong! Bye~", 1).show();
                    new Timer().schedule(new TimerTask() {
                        public void run() {
                            System.exit(1);
                        }
                    }, 2000);
                }
            }
```

没有直接线索（只有一个根据输入内容正误输出文本的if-else语句），于是根据其中的方法调用往上找，发现

```java
    private static char a(String arg1, b arg2, a arg3) {
        return arg3.a(arg2.a(arg1));
    }

    static Boolean a(String arg1) {
        return MainActivity.b(arg1);
    }

    private static Boolean b(String arg8) { //arg8为输入的flag
        Boolean v0_1;
        int v0 = 0;
        if(!arg8.startsWith("flag{")) {
            v0_1 = Boolean.valueOf(false);
        }
        else if(!arg8.endsWith("}")) {
            v0_1 = Boolean.valueOf(false);
        }
        else {
            String v2 = arg8.substring(5, arg8.length() - 1);
            b v4 = new b(Integer.valueOf(2));
            a v5 = new a(Integer.valueOf(3));
            StringBuilder v3 = new StringBuilder();
            int v1 = 0;
            while(v0 < v2.length()) {		//遍历字符串
                v3.append(MainActivity.a(v2.charAt(v0) + "", v4, v5));
                Integer v6 = Integer.valueOf(v4.b().intValue() / 25);
                if(v6.intValue() > v1 && v6.intValue() >= 1) {
                    ++v1;
                }

                ++v0;
            }

            v0_1 = Boolean.valueOf(v3.toString().equals("wigwrkaugala"));
        }

        return v0_1;
    }

    protected void onCreate(Bundle arg3) {
        super.onCreate(arg3);
        this.setContentView(2130968603);
        this.findViewById(2131427446).setOnClickListener(new View$OnClickListener(((Context)this)) {
            public void onClick(View arg5) {
                if(MainActivity.a(this.a.findViewById(2131427445).getText().toString()).booleanValue()) {
                    Toast.makeText(this.a, "You are right!", 1).show();
                }
                else {
                    Toast.makeText(this.a, "You are wrong! Bye~", 1).show();
                    new Timer().schedule(new TimerTask() {
                        public void run() {
                            System.exit(1);
                        }
                    }, 2000);
                }
            }
        });
    }

```

else{}内的语句大概含义是把输入的字符串和v4（b new的对象，初始输入int值为2）,v5（a new的对象，初始输入int值为3）传入带有三个形参的a()方法中，执行a.a(b.a(“字符”))，返回结果是一个字符类型的值，将每个我们输入的值执行后返回，拼接起来与”wigwrkaugala“比较。那么接下来的步骤很明显了，要看b.java和a.java。

b.java

```java
public class b {
    public static ArrayList a;
    static String b;
    Integer[] c;
    static Integer d;

    static {
        b.a = new ArrayList();
        b.b = "abcdefghijklmnopqrstuvwxyz";
        b.d = Integer.valueOf(0);
    }

    public b(Integer arg9) {
        super();
        this.c = new Integer[]{Integer.valueOf(8), Integer.valueOf(25), Integer.valueOf(17), Integer.valueOf(23), Integer.valueOf(7), Integer.valueOf(22), Integer.valueOf(1), Integer.valueOf(16), Integer.valueOf(6), Integer.valueOf(9), Integer.valueOf(21), Integer.valueOf(0), Integer.valueOf(15), Integer.valueOf(5), Integer.valueOf(10), Integer.valueOf(18), Integer.valueOf(2), Integer.valueOf(24), Integer.valueOf(4), Integer.valueOf(11), Integer.valueOf(3), Integer.valueOf(14), Integer.valueOf(19), Integer.valueOf(12), Integer.valueOf(20), Integer.valueOf(13)};
        int v0;
        for(v0 = arg9.intValue(); v0 < this.c.length; ++v0) {
            b.a.add(this.c[v0]);
        }

        for(v0 = 0; v0 < arg9.intValue(); ++v0) {
            b.a.add(this.c[v0]);
        }
    }

    public static void a() {
        int v0 = b.a.get(0).intValue();
        b.a.remove(0);
        b.a.add(Integer.valueOf(v0));
        b.b = b.b + "" + b.b.charAt(0);
        b.b = b.b.substring(1, 27);
        b.d = Integer.valueOf(b.d.intValue() + 1);
    }

    public Integer a(String arg5) {
        int v0 = 0;
        Integer v1 = Integer.valueOf(0);
        if(b.b.contains(arg5.toLowerCase())) {
            Integer v2 = Integer.valueOf(b.b.indexOf(arg5));
            while(v0 < b.a.size() - 1) {
                if(b.a.get(v0) == v2) {
                    v1 = Integer.valueOf(v0);
                }

                ++v0;
            }
        }
        else {
            if(arg5.contains(" ")) {
                v1 = Integer.valueOf(-10);
                goto label_24;
            }

            v1 = Integer.valueOf(-1);
        }

    label_24:
        b.a();
        return v1;
    }

    public Integer b() {
        return b.d;
    }
}
```

实例化v4后，

v4.a（类似于一个循环的索引表）为{17,23,7,22,1,16,6,9,21,0,15,5,10,18,2,24,4,11,3,14,19,12,20,13,17,23}

v4.b 为“abcdefghijklmnopqrstuvwxyz”

v4.c 为{8,25,17,23,7,22,1,16,6,9,21,0,15,5,10,18,2,24,4,11,3,14,19,12,20,13}

v4.d为0

a.java

```java
public class a {
    public static ArrayList a;
    static String b;
    Integer[] c;
    static Integer d;

    static {
        a.a = new ArrayList();
        a.b = "abcdefghijklmnopqrstuvwxyz";
        a.d = Integer.valueOf(0);
    }

    public a(Integer arg8) {
        super();
        this.c = new Integer[]{Integer.valueOf(7), Integer.valueOf(14), Integer.valueOf(16), Integer.valueOf(21), Integer.valueOf(4), Integer.valueOf(24), Integer.valueOf(25), Integer.valueOf(20), Integer.valueOf(5), Integer.valueOf(15), Integer.valueOf(9), Integer.valueOf(17), Integer.valueOf(6), Integer.valueOf(13), Integer.valueOf(3), Integer.valueOf(18), Integer.valueOf(12), Integer.valueOf(10), Integer.valueOf(19), Integer.valueOf(0), Integer.valueOf(22), Integer.valueOf(2), Integer.valueOf(11), Integer.valueOf(23), Integer.valueOf(1), Integer.valueOf(8)};
        int v0;
        for(v0 = arg8.intValue(); v0 < this.c.length; ++v0) {
            a.a.add(this.c[v0]);
        }

        for(v0 = 0; v0 < arg8.intValue(); ++v0) {
            a.a.add(this.c[v0]);
        }
    }

    public static void a() {
        a.d = Integer.valueOf(a.d.intValue() + 1);
        if(a.d.intValue() == 25) {
            int v0 = a.a.get(0).intValue();
            a.a.remove(0);
            a.a.add(Integer.valueOf(v0));
            a.d = Integer.valueOf(0);
        }
    }

    public char a(Integer arg5) {
        char v0_1;
        int v0 = 0;
        Integer v1 = Integer.valueOf(0);
        if(arg5.intValue() == -10) {
            a.a();
            v0_1 = " ".charAt(0);
        }
        else {
            while(v0 < a.a.size() - 1) {
                if(a.a.get(v0) == arg5) {
                    v1 = Integer.valueOf(v0);
                }

                ++v0;
            }

            a.a();
            v0_1 = a.b.charAt(v1.intValue());
        }

        return v0_1;
    }
}
```

v5同理，

v4.a为{21,4,24,25,20,5,15,9,17,6,13,3,18,12,10,19,0,22,2,11,23,1,8,7,14,16}

v4.b 为“abcdefghijklmnopqrstuvwxyz”

v4.c 为{7,14,16,21,4,24,25,20,5,15,9,17,6,13,3,18,12,10,19,0,22,2,11,23,1,8}

v4.d为0



根据MainActivity里的代码继续分析流程

```java
private static char a(String arg1, b arg2, a arg3) {
        return arg3.a(arg2.a(arg1));
    }
```

arg2.a(arg1)具体实现代码在b.java中

```java
   public Integer a(String arg5) {
        int v0 = 0;                              //v0=0
        Integer v1 = Integer.valueOf(0);         //v1=0
        if(b.b.contains(arg5.toLowerCase())) {   //判断条件：arg5全部转为小写形式，数字不受影响，若类b的变量b包含该字符则进入花括号内的代码，其中，变量b是小写字母表
            Integer v2 = Integer.valueOf(b.b.indexOf(arg5)); //v2=arg5所在的字母表的索引位置
            while(v0 < b.a.size() - 1) {     //遍历b.a，其中b.a是一个数组
            //在a中查找v2的位置
                if(b.a.get(v0) == v2) {
                    v1 = Integer.valueOf(v0);
                }
 
                ++v0;
            }
        }         //如果传入的字符串不是字母，而是数字或者其他字符
        else {
            if(arg5.contains(" ")) {  //如果传入的是空格，跳转到label_24
                v1 = Integer.valueOf(-10);
                goto label_24;
            }
            //传入的不是空格，返回-1
 
            v1 = Integer.valueOf(-1);
        }
 
    label_24:
        b.a();     //传入的是空格，执行一个同名无参的重载方法a()
        return v1;
```

arg3.a()在a.java中

```java
public char a(Integer arg5) {
        char v0_1;                      //定义处理结果
        int v0 = 0;                     
        Integer v1 = Integer.valueOf(0); 
        if(arg5.intValue() == -10) {    //如果传入的值为-10，即char是空格，执行一个同名无参的重载方法a()
            a.a();
            v0_1 = " ".charAt(0);    //然后返回一个空格
        }
        else {             //传入的值不是空格
            while(v0 < a.a.size() - 1) {      //遍历数表a
                if(a.a.get(v0) == arg5) {   //若数表中有传入的数值，则v1=数表中该数值的下标
                    v1 = Integer.valueOf(v0);
                }
 
                ++v0;
            }
            
            a.a();    //执行重载方法a()
            v0_1 = a.b.charAt(v1.intValue());  //返回a类的成员变量b中v1下标的字符
        }
 
        return v0_1;
    }
```

##### 脚本解flag

分析得出基本逻辑是输入明文flag，进行变换后得到密文”wigwrkaugala“

```Java

import java.util.ArrayList;
 
public class easyjava {
    public static void main(String[] args) {
        int v0 = 0;
        StringBuilder result = new StringBuilder();
        String input = "********";
        Encrpyt_a e_a = new Encrpyt_a(3);
        Encrpyt_b e_b = new Encrpyt_b(2);
        while(v0 < input.length()){
            result.append(e_a.en(e_b.en(input.charAt(v0) + "")));
        }
    }
}
 
class Encrpyt_a{
    public static ArrayList array;
    static String str;
    int[] int_c;
    static int int_d;
    static {
        array = new ArrayList();
        str = "abcdefghijklmnopqrstuvwxyz";
        int_d = 0;
    }
 
    public Encrpyt_a(int arg1){
        int_c = new int[]{7, 14, 16, 21, 4, 24, 25, 20, 5, 15, 9, 17, 6, 13, 3, 18, 12, 10, 19, 0, 22, 2, 11, 23, 1, 8};
        for(int i = arg1; i < int_c.length; i++){
            array.add(int_c[i]);
        }
        for(int i = 0; i < arg1; i++){
            array.add(int_c[i]);
        }
    }
 
    public char en(int arg2){
        char c0;
        int v0 = 0;
        int v1 = 0;
        if(arg2 == -10){
            en_1();
            c0 = " ".charAt(0);
        }
        else{
            while (v0 < array.size() - 1){
                if((int)array.get(v0) == arg2){
                    v1 = v0;
                }
                v0++;
            }
            en_1();
            c0 = str.charAt(v1);
        }
        return c0;
    }
 
    public static void en_1(){
        int_d += 1;
        if(int_d == 25){
            int v0 = (int)array.get(0);
            array.remove(0);
            array.add(v0);
            int_d = 0;
        }
    }
}
 
class Encrpyt_b{
    public static ArrayList array;
    static String str;
    int[] int_c;
    static int int_d;
    static {
        array = new ArrayList();
        str = "abcdefghijklmnopqrstuvwxyz";
        int_d = 0;
    }
 
    public Encrpyt_b(int arg1){
        int_c = new int[]{8, 25, 17, 23, 7, 22, 1, 16, 6, 9, 21, 0, 15, 5, 10, 18, 2, 24, 4, 11, 3, 14, 19, 12, 20, 13};
        for(int i = arg1; i < int_c.length; i++){
            array.add(int_c[i]);
        }
        for(int i = 0; i < arg1; i++){
            array.add(int_c[i]);
        }
    }
 
    public int en(String arg2){
        int v0 = 0;
        int v1 = 0;
        if(str.contains(arg2.toLowerCase())){
            int v2 = str.indexOf(arg2);
            while(v0 < array.size() - 1){
                if((int)array.get(0) == v2){
                    v1 = v0;
                }
                v0++;
            }
        }
        else{
            if(arg2.contains(" ")) {
                v1 = -10;
                en_1();
                return v1;
            }
            v1 = -1;
        }
        return v1;
    }
 
    public static void en_1(){
        int v0 = (int)array.get(0);
        array.remove(0);
        array.add(v0);
        str = str + "" + str.charAt(0);
        str = str.substring(1, 27);
        int_d += 1;
    }
}
```

原理类似于20世纪上半叶的Enigma机,写出逆向过程的脚本即可（据说有多解?）。



```python

index_b = [17, 23, 7, 22, 1, 16, 6, 9, 21, 0, 15, 5, 10, 18, 2, 24, 4, 11, 3, 14, 19, 12, 20, 13, 8, 25]
index_a = [21, 4, 24, 25, 20, 5, 15, 9, 17, 6, 13, 3, 18, 12, 10, 19, 0, 22, 2, 11, 23, 1, 8, 7, 14, 16]
alphabet = "abcdefghijklmnopqrstuvwxyz"
s = "wigwrkaugala"
re1 = []
for i in s:
    re1.append(index_a[alphabet.index(i)])
print(re1)
flag = ''
for i in re1:
    s2 = index_b[i]
    flag += b[s4]
    index_b.append(index_b[0])
    index_b.remove(index_b[0])
    alphabet += alphabet[0]
    alphabet = alphabet[1:]
print (flag)
```

