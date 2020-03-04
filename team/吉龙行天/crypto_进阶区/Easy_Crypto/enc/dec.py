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
