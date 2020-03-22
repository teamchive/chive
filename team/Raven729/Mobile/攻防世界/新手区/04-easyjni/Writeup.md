## Write-up

#### Step-1

阅读MainActivity，从

```java
if(MainActivity.a(this.b, this.a.findViewById(2131427445).getText().toString())) {
                    Toast.makeText(this.a, "You are right!", 1).show();
                }
                else {
                    Toast.makeText(this.a, "You are wrong! Bye~", 1).show();
                }
```

溯源至

```java
 private boolean a(String arg3) {
        boolean v0_1;
        try {
            v0_1 = this.ncheck(new a().a(arg3.getBytes()));
        }
        catch(Exception v0) {
            v0_1 = false;
        }

        return v0_1;
    }

    private native boolean ncheck(String arg1) {
    }
```

可知输入字符串先经过a.java中的代码进行加密后又用ncheck中的方法进行加密

#### Step-2

逆向过程即为先逆向ncheck的加密方法再逆向a.java的加密方法。

Libraries文件下的.so使用IDA（32bit）逆向分析可找到

```C
signed int __fastcall Java_com_a_easyjni_MainActivity_ncheck(int a1, int a2, int a3)
{
  int v3; // r8
  int v4; // r5
  int v5; // r8
  const char *v6; // r6
  int v7; // r0
  char *v8; // r2
  char v9; // r1
  int v10; // r0
  bool v11; // nf
  unsigned __int8 v12; // vf
  int v13; // r1
  signed int result; // r0
  char s1[32]; // [sp+3h] [bp-35h]
  char v16; // [sp+23h] [bp-15h]
  int v17; // [sp+28h] [bp-10h]

  v17 = v3;
  v4 = a1;
  v5 = a3;
  v6 = (const char *)(*(int (__fastcall **)(int, int, _DWORD))(*(_DWORD *)a1 + 676))(a1, a3, 0);
  if ( strlen(v6) == 32 )
  {
    v7 = 0;
    do
    {
      v8 = &s1[v7];
      s1[v7] = v6[v7 + 16];
      v9 = v6[v7++];
      v8[16] = v9;
    }
    while ( v7 != 16 );//前后十六位交换位置
    (*(void (__fastcall **)(int, int, const char *))(*(_DWORD *)v4 + 680))(v4, v5, v6);
    v10 = 0;
    do
    {
      v12 = __OFSUB__(v10, 30);
      v11 = v10 - 30 < 0;
      v16 = s1[v10];
      s1[v10] = s1[v10 + 1];
      s1[v10 + 1] = v16;
      v10 += 2;
    }
    while ( v11 ^ v12 );//两两交换位置
    v13 = memcmp(s1, "MbT3sQgX039i3g==AQOoMQFPskB1Bsc7", 0x20u);
    result = 0;
    if ( !v13 )
      result = 1;
  }
  else
  {
    (*(void (__fastcall **)(int, int, const char *))(*(_DWORD *)v4 + 680))(v4, v5, v6);
    result = 0;
  }
  return result;
}
```

解密后结果为

QAoOQMPFks1BsB7cbM3TQsXg30i9g3==

#### Step-3

接下来逆向a.java的解密方法，发现a.java实际上是改变了码表的BASE64编码，码表为i5jLW7S0GX6uf1cv3ny4q8es2Q+bdkYgKOIT/tAxUrFlVPzhmow9BHCMDpEaJRZN

#### Step-4

写脚本解密

```python
import base64
 
string1 = str.maketrans("i5jLW7S0GX6uf1cv3ny4q8es2Q+bdkYgKOIT/tAxUrFlVPzhmow9BHCMDpEaJRZN","ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/")
strEnBase64 = "QAoOQMPFks1BsB7cbM3TQsXg30i9g3==".translate(string1)
 
print (strEnBase64)
 
strFlag = base64.b64decode(strEnBase64)
 
print (strFlag)
```

得到flag{just_ANot#er_@p3}.