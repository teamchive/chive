## Write-up

RSA的原理我在2020i春秋新春公益赛里有简要介绍，这里直接上脚本。

```Python
import gmpy2 #gmpy2天下第一（破音
p=473398607161  
q=4511491
e=17
d=gmpy2.invert(e, (p-1)*(q-1))
print (d)
```

