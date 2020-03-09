# Easy_Crypto

## 题目

```
get buf unsign s[256]

get buf t[256]

we have key:hello world

we have flag:????????????????????????????????


for i:0 to 256
    
set s[i]:i

for i:0 to 256
    set t[i]:key[(i)mod(key.lenth)]

for i:0 to 256
    set j:(j+s[i]+t[i])mod(256)
        swap:s[i],s[j]

for m:0 to 37
    set i:(i + 1)mod(256)
    set j:(j + S[i])mod(256)
    swap:s[i],s[j]
    set x:(s[i] + (s[j]mod(256))mod(256))
    set flag[m]:flag[m]^s[x]

fprint flagx to file
```
加密后文本见附件


## 解法

已经知道加密方式了，就仿照着写个解密脚本就好了

```
f=open('enc.txt','rb')
c=f.read()
t=[]
key='hello world'
temp=''
s=[]
t=[]

for i in range(256):
    s.append(i)

for i in range(256):
    t.append(key[i % len(key)])

j=0
for i in range(256):
    j=(j+s[i]+ord(t[i]))%256
    s[i],s[j]=s[j],s[i]

i=0
j=0
for m in c:
    i=(i+1)%256
    j=(j+s[i])%256
    s[i],s[j]=s[j],s[i]
    x=(s[i]+(s[j]%256))%256
    temp+=chr(m^s[x])

print(temp)
```
结果即为答案：**EIS{55a0a84f86a6ad40006f014619577ad3}**