## Write-up

#### Step 1：

用JEB3反编译题目给的apk文件，先行分析MainActivity中代码，发现onClick方法中

```java
public void onClick(View arg6) {
        switch(arg6.getId()) {
            case 2131165187: {
                if(this.c.getText().length() != 0 && this.d.getText().length() != 0) {
                    String v0 = this.c.getText().toString();
                    String v1 = this.d.getText().toString();
                    Log.e("test", v0 + " test2 = " + v1);
                    Intent v2 = new Intent(((Context)this), SecondActivity.class);
                    v2.putExtra("ili", v0);
                    v2.putExtra("lil", v1);
                    this.startActivity(v2);
                    return;
                }

                Toast.makeText(((Context)this), "不能为空", 1).show();
                break;
            }
        }
    }
```

获取用户输入的两个字符串并使用SecondActivity进行处理，于是解析SecondActivity，发现如下代码

```java
if(Encryto.doRawData(this, v1 + v2).equals("VEIzd/V2UPYNdn/bxH3Xig==")) 
```

其对用户输入的两个字符串进行加密后与"VEIzd/V2UPYNdn/bxH3Xig=="进行比对。于是寻找加密算法，在Encryto（疑似拼写错误？）中发现

```java
static {
        System.loadLibrary("JNIEncrypt");
    }
```

网上搜索了一下JNI加密，了解到安卓开发中可以将加密方法打包到so文件中，能够实现对字符串的加密。

那么接下来的步骤就很清晰了，需要破解.so文件来分析加密方法。

#### Step 2：

Libraries文件夹下有三个子文件夹，根据名字推测应该是不同架构下执行的so文件。导出一个用IDA分析后发现使用了AES对称加密，密钥是"thisisthekey=="(发现一个奇怪的地方，Typora中在句末输入中文双引号时会将整对引号一并删除）。

```c
v14 = 0;
    v13 = '==ye';
    v12 = 'ktse';
    v11 = 'tasi';
    v10 = 'siht';
    v4 = (char *)(*(int (__cdecl **)(int, int, _DWORD))(*(_DWORD *)a1 + 676))(a1, a4, 0);
    v5 = AES_128_ECB_PKCS5Padding_Encrypt(v4, (int)&v10);
```

现在只剩下最后一个关键的问题：应该去解密什么样的字符串？继续从反编译出的代码中寻找答案，发现在FileDataActivity中有

```java
this.c.setText(Encryto.decode(this, "9YuQ2dk8CSaCe7DTAmaqAA=="));
```

用在线工具配合密钥得到Cas3_0f_A_CAK3，即为本题Flag