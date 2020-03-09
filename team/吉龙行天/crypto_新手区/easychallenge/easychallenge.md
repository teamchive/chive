# easychallenge

## 题目

见附件easychallenge.pyc

## 解法

题目给出的为.pyc文件，那么先对其进行反编译，利用uncompyle即可反编译pyc文件。

`uncompyle6 xxx.pyc > xxx.py`

打开后可得代码
```
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
观察代码可知，该加密是通过对flag依次进行encode1、encode2、encode3得到最终的final，那么只需要编写脚本对final进行解码就可得出flag。

```
import base64

def decode1(ans):
    s = ''
    for i in ans:
        x = ord(i)-25
        x = x^36
        s += chr(x)

    return s

def decode2(ans):
    s = ''
    for i in ans:
        x = ord(i)^36
        x = x-36
        s += chr(x)

    return s

def decode3(ans):
    return base64.b32decode(ans)

final = 'UC7KOWVXWVNKNIC2XCXKHKK2W5NLBKNOUOSK3LNNVWW3E==='
# t = decode3(final)
# print(t)
t = '\xa0\xbe\xa7Z\xb7\xb5Z\xa6\xa0Z\xb8\xae\xa3\xa9Z\xb7Z\xb0\xa9\xae\xa3\xa4\xad\xad\xad\xad\xad\xb2'
flag =decode1(decode2(t))
print(flag)
```
运行后得到flag为**cyberpeace{interestinghhhhh}**