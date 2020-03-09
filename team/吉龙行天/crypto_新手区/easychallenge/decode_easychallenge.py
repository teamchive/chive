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
