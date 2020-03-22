## Write-up

给的是*.pyc文件，那涉及密码学的部分就必须要先行反编译该文件才能找出。

这里用uncompyle6去反编译一下得到如下代码

```python
import base64

def encode1(ans):
    s = ''
    for i in ans:
        x = ord(i) ^ 36
        x = x + 25
        s += chr(x)

    return s


def encode2(ans):
    s = ''
    for i in ans:
        x = ord(i) + 36
        x = x ^ 36
        s += chr(x)

    return s


def encode3(ans):
    return base64.b32encode(ans)


flag = ' '
print 'Please Input your flag:'
flag = raw_input()
final = 'UC7KOWVXWVNKNIC2XCXKHKK2W5NLBKNOUOSK3LNNVWW3E==='
if encode3(encode2(encode1(flag))) == final:
    print 'correct'
else:
    print 'wrong'
```

根据加密代码（用户输入一个flag值，flag依次通过三个函数进行加密，其中encode1和encode2是做异或和加和运算，encode3是调用base64库里的b32encode()函数进行base32运算。然后将结果与代码给定的final值进行比较(这里根据final结尾的三个”=”以及均为数字和大写字母的结构也能看出是进行了base32加密)，如果相等输出correct，如果不相等，输出wrong）如法炮制解密代码

```python
import base64

def decode1(ans):
	s = ''
	for i in ans:
		x  = i^36
		x  = x - 36
		s += chr(x)
	return s
	
def decode2(ans):
	s = ''
	for i in ans:
		x  = ord(i) - 25
		x  = x ^ 36
		s += chr(x)
	return s

def decode3(ans):
        return base64.b32decode(ans, casefold =False, map01= None)


number ="UC7KOWVXWVNKNIC2XCXKHKK2W5NLBKNOUOSK3LNNVWW3E==="
number = decode2(decode1(decode3(number)))
print (number)
```

## 题外话

从解题流程和解题思路上看都颇有Reverse的风格，改改应该就成了某比赛Reverse方向的签到题吧？