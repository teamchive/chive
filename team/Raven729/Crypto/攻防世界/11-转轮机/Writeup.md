## Write-up

想象出N个同轴的刻有字母的铁环，根据密钥、密文给出的规则进行调整。

```python
import re
sss = '1: < ZWAXJGDLUBVIQHKYPNTCRMOSFE < 2: < KPBELNACZDTRXMJQOYHGVSFUWI < 3: < BDMAIZVRNSJUWFHTEQGYXPLOCK < 4: < RPLNDVHGFCUKTEBSXQYIZMJWAO < 5: < IHFRLABEUOTSGJVDKCPMNZQWXY < 6: < AMKGHIWPNYCJBFZDRUSLOQXVET < 7: < GWTHSPYBXIZULVKMRAFDCEONJQ < 8: < NOZUTWDCVRJLXKISEFAPMYGHBQ < 9: < XPLTDSRFHENYVUBMCQWAOIKZGJ < 10: < UDNAJFBOWTGVRSCZQKELMXYIHP < 11 < MNBVCXZQWERTPOIUYALSKDJFHG < 12 < LVNCMXZPQOWEIURYTASBKJDFHG < 13 < JZQAWSXCDERFVBGTYHNUMKILOP <'
m = 'NFQKSEVOQOFNP'
# 将sss转化为列表形式
content=re.findall(r'< (.*?) <',sss,re.S)
# re.S:DOTALL，此模式下，"."的匹配不受限制，可匹配任何字符，包括换行符
iv=[2,3,7,5,13,12,9,1,8,10,4,11,6]
print(content)
vvv=[]
for i in range(13):
    index=content[iv[i]-1].index(m[i])
    vvv.append(index)
print(vvv)

for i in range(0,26):
    flag=""
    for j in range(13):
        flag += content[iv[j]-1][(vvv[j]+i)%26]
    print(flag.lower())
```

fireinthehole

## 题外话

这flag内容是认真的么- -