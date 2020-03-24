# 动态靶机出题指南

> 本指南大量借用[glzjin赵师傅](https://www.zhaoj.in/read-6259.html)的指南  

## 一、PWN 题
0、到 https://hub.docker.com 申请一个账户，并在终端中登录。
```
docker login
```
1、创建一个新目录。
```
mkdir pwntest
cd pwntest
```
2、进入该目录，将可执行文件拷贝到该目录下，命名为 pwn。创建一个 Dockerfile 文件，内容如下：
```
FROM glzjin/pwn_base_18
COPY pwn /pwn/pwn
```
这里使用赵师傅为pwn题准备的镜像：glzjin/pwn_base_18 代表 Ubuntu 18.04, glzjin/pwn_base_16 代表 Ubuntu 16.04, glzjin/pwn_base_19 代表 Ubuntu 19.04, glzjin/pwn_base_20 代表 Ubuntu 20.04。

3、构建。
```
docker build -t <你在 dockerhub的用户名/你的镜像名> ./
```
例如：
```
docker build -t glzjin/ogeek_2019_from_the_shadow_pwn ./
```
4、推送。
```
docker push glzjin/ogeek_2019_from_the_shadow_pwn
```
5、发镜像名。

## 二、Web 题
打好镜像后直接发镜像名。

动态FLAG命令参考如下。
```
echo $FLAG > /home/$USER/flag && export FLAG=not_flag && FLAG=not_flag 
```
## 三、Crypto 题
1、准备像pwn那样的镜像。

参考：https://github.com/CTFTraining/qwb_2019_crypto_copperstudy

2、直接给附件的题目请命名为如下格式发到钉盘。
```
题目名|flag(不带 flag{} 等格式).扩展名
```

## 四、Misc 题
1、准备像pwn那样的镜像。

参考：https://github.com/CTFTraining/qwb_2019_crypto_copperstudy

2、直接给附件的题目请命名为如下格式发到钉盘。
```
题目名|flag(不带 flag{} 等格式).扩展名
```
## 五、Reverse 题
1、准备像pwn那样的镜像。

参考：https://github.com/CTFTraining/qwb_2019_crypto_copperstudy

2、直接给附件的题目请命名为如下格式发到钉盘。
```
题目名|flag(不带 flag{} 等格式).扩展名
```