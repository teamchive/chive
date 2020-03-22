## Write-up

OpenSSL使用 PEM 文件格式存储证书和密钥。PEM 实质上是 Base64 编码的二进制内容，再加上开始和结束行，此题即利用OpenSSL解出

```
raven@raven-virtual-machine:~/challenges$ openssl rsa -pubin -text -modulus -in warmup -in pubkey.pem
RSA Public-Key: (256 bit)
Modulus:
    00:c2:63:6a:e5:c3:d8:e4:3f:fb:97:ab:09:02:8f:
    1a:ac:6c:0b:f6:cd:3d:70:eb:ca:28:1b:ff:e9:7f:
    be:30:dd
Exponent: 65537 (0x10001)
Modulus=C2636AE5C3D8E43FFB97AB09028F1AAC6C0BF6CD3D70EBCA281BFFE97FBE30DD
writing RSA key
-----BEGIN PUBLIC KEY-----
MDwwDQYJKoZIhvcNAQEBBQADKwAwKAIhAMJjauXD2OQ/+5erCQKPGqxsC/bNPXDr
yigb/+l/vjDdAgMBAAE=
-----END PUBLIC KEY-----
```

对得到的Modulus进行进制转换方便分解
$$
87924348264132406875276140514499937145050893665602592992418171647042491658461
$$
在[factordb.com]()进行分解后得到
$$
275127860351348928173285174381581152299 
$$
和
$$
319576316814478949870590164193048041239
$$
知道p、q、e，求密钥文件

```
root@raven:~/下载/rsatool-master# python rsatool.py -o private.pem -e 65537 -p 275127860351348928173285174381581152299 -q 319576316814478949870590164193048041239
Using (p, q) to initialise RSA instance

n =
c2636ae5c3d8e43ffb97ab09028f1aac6c0bf6cd3d70ebca281bffe97fbe30dd

e = 65537 (0x10001)

d =
1806799bd44ce649122b78b43060c786f8b77fb1593e0842da063ba0d8728bf1

p = 275127860351348928173285174381581152299 (0xcefbb2cf7e18a98ebedc36e3e7c3b02b)

q = 319576316814478949870590164193048041239 (0xf06c28e91c8922b9c236e23560c09717)

Saving PEM as private.pem

```

然后，解密输出flag

```
root@raven:~/下载/rsatool-master# openssl rsautl -decrypt -in flag.enc -inkey private.pem
PCTF{256b_i5_m3dium}
```

## 题外话

嘶，供题是不是有奖励啊（战术后仰