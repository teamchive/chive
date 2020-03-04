# Railfence

## 题目
ccehgyaefnpeoobe{lcirg}epriec_ora_g

## 解法
观察题目发现题目所给字符串中直接有*cyberpeace{}* 字样，但是位置不正确，因此猜测加密方式为不改变字母而改变顺序的加密，那么很容易想到栅栏密码。

但是经过多次栅栏数尝试均不正确，并且观察到 *}* 并不在字符串末尾，使用普通的栅栏密码无法将其移至结尾处，因此尝试栅栏密码的变种，w型栅栏。

W型栅栏型加密与普通栅栏不同，例如明文为 *abcdefg*。key=3。则W型栅栏将明文写为
```
a               e
    b       d       f
        c               g
```
再将其依次读出得到密文*aebdfcg*。

因此通过尝试可得该栅栏密码的栏数为5，通过[网站](http://www.atoolbox.net/Tool.php?Id=777)解码可得答案为**cyberpeace{railfence_cipher_gogogo}**