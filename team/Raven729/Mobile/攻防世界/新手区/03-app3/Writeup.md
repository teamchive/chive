## Write-up

#### Step-1

下载题目拿到的是.ab文件（Android备份文件），用android-backup-extractor提取源码，阅读MainActivity

```java
private void a() {
        SQLiteDatabase.loadLibs(((Context)this));
        this.b = new a(((Context)this), "Demo.db", null, 1);
        ContentValues v0 = new ContentValues();
        v0.put("name", "Stranger");
        v0.put("password", Integer.valueOf(123456));
        com.example.yaphetshan.tencentwelcome.a.a v1 = new com.example.yaphetshan.tencentwelcome.a.a();
        String v2 = v1.a(v0.getAsString("name"), v0.getAsString("password"));
        this.a = this.b.getWritableDatabase(v1.a(v2 + v1.b(v2, v0.getAsString("password"))).substring(0, 7));   //取处理后字符串前七位
        this.a.insert("TencentMicrMsg", null, v0);
    
```

综合com.example.yaphetshan.tencentwelcome下的.db文件考虑，可知需要得到数据库密码从其中得到flag。

#### Step-2

阅读a.java

```java
public class a {
    private String a;

    public a() {
        super();
        this.a = "yaphetshan";
    }

    public String a(String arg3) {                //拼接yaphetshan
        new b();
        return b.b(arg3 + this.a);
    }

    public String a(String arg4, String arg5) {
        return arg4.substring(0, 4) + arg5.substring(0, 4);//取name及password的前四个字符
    }

    public String b(String arg2, String arg3) {
        new b();
        return b.a(arg2);
    }
}

```

阅读b.java

```java
public class b {
    public b() {
        super();
    }

    public static final String a(String arg9) {            //MD5 + BASE16
        String v0_2;
        int v0 = 0;
        char[] v2 = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] v1 = arg9.getBytes();
            MessageDigest v3 = MessageDigest.getInstance("MD5");
            v3.update(v1);
            byte[] v3_1 = v3.digest();
            int v4 = v3_1.length;
            char[] v5 = new char[v4 * 2];
            int v1_1 = 0;
            while(v0 < v4) {
                int v6 = v3_1[v0];
                int v7 = v1_1 + 1;
                v5[v1_1] = v2[v6 >>> 4 & 15];
                v1_1 = v7 + 1;
                v5[v7] = v2[v6 & 15];
                ++v0;
            }

            v0_2 = new String(v5);
        }
        catch(Exception v0_1) {
            v0_2 = null;
        }

        return v0_2;
    }

    public static final String b(String arg9) {            //SHA-1 + BASE16
        String v0_2;
        int v0 = 0;
        char[] v2 = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] v1 = arg9.getBytes();
            MessageDigest v3 = MessageDigest.getInstance("SHA-1");
            v3.update(v1);
            byte[] v3_1 = v3.digest();
            int v4 = v3_1.length;
            char[] v5 = new char[v4 * 2];
            int v1_1 = 0;
            while(v0 < v4) {
                int v6 = v3_1[v0];
                int v7 = v1_1 + 1;
                v5[v1_1] = v2[v6 >>> 4 & 15];
                v1_1 = v7 + 1;
                v5[v7] = v2[v6 & 15];
                ++v0;
            }

            v0_2 = new String(v5);
        }
        catch(Exception v0_1) {
            v0_2 = null;
        }

        return v0_2;
    }
}
```

则将Stranger和123456两个字符串取前四个并拼接得到Stra1234，将Stra1234进行md5加密后用base16加密，前后分别拼接字符串Stra1234与字符串yaphetshan后用SHA-1加密，在用base16加密，最后取得到字符串的前七位。

#### Step-3

修改a.java和b.java直接写出Java程序即可

```java
package app3;

public class A {

    private String a;

    public A() {
        super();
        this.a = "yaphetshan";
    }

    public String a(String arg4, String arg5) {
        return arg4.substring(0, 4) + arg5.substring(0, 4);
    }

    public String a(String arg3) {
        new B();
        return B.b(arg3 + this.a);
    }

    public String b(String arg2, String arg3) {
        new B();
        return B.a(arg2);
    }

    public static void main(String args[]) { 
        A a = new A();
        String s1 = a.a("Stranger", "123456");
        String s2 = a.a(s1 + a.b(s1, "123456")).substring(0, 7);
        System.out.println(s2); 
    } 
}
```

```java
package app3;

import java.security.MessageDigest;

public class B {
    public B() {
        super();
    }

    public static final String a(String arg9) {
        String v0_2;
        int v0 = 0;
        char[] v2 = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] v1 = arg9.getBytes();
            MessageDigest v3 = MessageDigest.getInstance("MD5");
            v3.update(v1);
            byte[] v3_1 = v3.digest();
            int v4 = v3_1.length;
            char[] v5 = new char[v4 * 2];
            int v1_1 = 0;
            while(v0 < v4) {
                int v6 = v3_1[v0];
                int v7 = v1_1 + 1;
                v5[v1_1] = v2[v6 >>> 4 & 15];
                v1_1 = v7 + 1;
                v5[v7] = v2[v6 & 15];
                ++v0;
            }

            v0_2 = new String(v5);
        }
        catch(Exception v0_1) {
            v0_2 = null;
        }

        return v0_2;
    }

    public static final String b(String arg9) {
        String v0_2;
        int v0 = 0;
        char[] v2 = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] v1 = arg9.getBytes();
            MessageDigest v3 = MessageDigest.getInstance("SHA-1");
            v3.update(v1);
            byte[] v3_1 = v3.digest();
            int v4 = v3_1.length;
            char[] v5 = new char[v4 * 2];
            int v1_1 = 0;
            while(v0 < v4) {
                int v6 = v3_1[v0];
                int v7 = v1_1 + 1;
                v5[v1_1] = v2[v6 >>> 4 & 15];
                v1_1 = v7 + 1;
                v5[v7] = v2[v6 & 15];
                ++v0;
            }

            v0_2 = new String(v5);
        }
        catch(Exception v0_1) {
            v0_2 = null;
        }

        return v0_2;
    }
}
```

得到ae56f99，用DB Browser打开.db文件即可。