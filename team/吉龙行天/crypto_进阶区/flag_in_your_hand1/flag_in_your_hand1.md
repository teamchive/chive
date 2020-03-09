# Flag_in_your_hand1

## 题目

见附件

## 解法

下载好文件后发现是一个压缩文件，提取出来之后是一个html网页和一段js代码。打开网页发现要我们输入token，阅读网页源码

```
function getFlag() {
	var token = document.getElementById("secToken").value;
		ic = checkToken(token);
		fg = bm(token);
		showFlag()
}

function showFlag() {
	var t = document.getElementById("flagTitle");
	var f = document.getElementById("flag");
	t.innerText = !!ic ? "You got the flag below!!" : "Wrong!";
	t.className = !!ic ? "rightflag" : "wrongflag";
	f.innerText = fg;
}
```
得知我们的目的是让ic值为true，找到js代码中的check函数

```
function ck(s) {
    try {
        ic
    } catch (e) {
        return;
    }
    var a = [118, 104, 102, 120, 117, 108, 119, 124, 48,123,101,120];
    if (s.length == a.length) {
        for (i = 0; i < s.length; i++) {
            if (a[i] - s.charCodeAt(i) != 3)
                return ic = false;
        }
        return ic = true;
    }
    return ic = false;
}
```
发现我们需要让传进去的token每一位的值为数组a中每一位的值减3，那么只需每一位减三再转为字符即可得到token：**security-xbu**。输入token之后即可得到flag：**RenIbyd8Fgg5hawvQm7TDQ**。