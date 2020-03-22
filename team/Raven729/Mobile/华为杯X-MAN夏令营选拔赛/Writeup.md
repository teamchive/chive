## Write-up

#### Step-1：

分析MainActivity

```java
 try {
                    MainActivity.this.passt = Long.valueOf(MainActivity.this.pass.getText().toString()).longValue();
                    MainActivity.this.flagt = MainActivity.this.flag.getText().toString();
                }
                catch(Exception ) {
                    Toast.makeText(MainActivity.this.getApplicationContext(), "Input password as number & flag as string", 0).show();
                    return;
                }

                if(MainActivity.this.flagt.equals("")) {
                    Toast.makeText(MainActivity.this.getApplicationContext(), "No empty", 0).show();
                    return;
                }

                if(MainActivity.this.check(MainActivity.this.passt, MainActivity.this.flagt) == 1) {
                    Toast.makeText(MainActivity.this.getApplicationContext(), "flag right!", 0).show();
                }
                else {
                    Toast.makeText(MainActivity.this.getApplicationContext(), "flag wrong!", 0).show();
                }
```

可知，需要输入一段特定的数字和一段特定的字符串，程序最终会判断flag是否输入正确。

#### Step-2：

跟踪判断条件中的check方法

```java
public native int check(long arg1, String arg2) {
    }
```

及Factor

```java
public class Factor {
    public Factor() {
        super();
    }

    public static int factor(long arg2) {
        if(new BigInteger("3191754164302148184239").mod(new BigInteger(String.valueOf(arg2))).toString().equals("0")) {
            return 1;
        }

        return 0;
    }
}
```

首先确定password要通过分解大数3191754164302148184239得到（ 54407889919或者58663443281），不过这倒不是关键。

#### Step-3：

一路溯源对字符串的加密

```java
v11 = sub_F30(v5, a5);
  _android_log_print(3, "C_TAG", "hello.factor:off");
  return v11;
```

```java
v8 = sub_1028(v7, v4);
  __android_log_print(3, "C_TAG", "hello.factor:ben%d", v4);
  strcpy(&v10, "eG1hbntmYWM9NmJhczM0");
  __android_log_print(3, "C_TAG", "hello.factor:cc%s", &v10);
  __android_log_print(3, "C_TAG", "hello.factor:t%s", aAbcdefghijklmn);
  result = strcmp(v8, &v10);
  if ( _stack_chk_guard == v11 )
    result = result == 0;
  return result;
```

```
data:00005004 aAbcdefghijklmn DCB "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
```

疑似BASE64的码表，最终加密结果为eG1hbntmYWM9NmJhczM0==

#### Step-4

解到这里无法继续了，解出来一个破损的flag：xman{fac=6bas34。应该是码表被替换过，但是没分析处替换后的码表。到网上查WP发现替换后码表为ABCDEFGHIJKLNMOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz9123456780+/

重新尝试解码，得到xman{fact2bas3}