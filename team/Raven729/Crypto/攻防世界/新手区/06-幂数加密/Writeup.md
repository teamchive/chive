## Write-up

二进制幂数加密利用的原理即：任意的十进制数都可以用2^n或2^n+2^m+……的形式表示，进而作为字母序号数来加密明文，密文以0作间隔。

#### 脚本

```Python
cipher="8842101220480224404014224202480122"
cipher=cipher.split("0")
flag=''
for i in range(0,len(cipher)):
     str = cipher[i]
     list=[]
     sum=0
     for j in str:
        list.append(j)
        length = len(list)
     for k in range(0,length):
        sum+=int(list[k])
     flag+=chr(sum+64)
print (flag)
```

## 题外话

标题先放在这，内容想不出来了 XD