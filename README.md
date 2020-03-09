# README

## 说明

- 本仓库用于存储队伍相关的比赛信息及队成员日常刷题的wp。
- 每名队员建立一个自己的分支，写好新wp后及时push。
- 每道题单设文件夹，里面尽量包含原题目文件。对于无法打包环境的题目，在wp开头写清题目靶场地址。
- 建议wp采用markdown格式，注意md文档的图片直接引用本地文件，不建议使用图床。
- team目录：存放队伍会议内容、成员进出等日常事务。
- CTF目录：存放比赛相关文件，如主办方给出的报名表、比赛内容说明等。比赛题目不在此目录上传。

## 一些参考

- 用`git clone https://github.com/teamchive/chive/`将仓库克隆到本地
- `git switch dev`切换到dev分支下
- `git checkout -b xxx`创建并切换到一个新分支
- 在team目录下添加一个新的文件夹，文件夹名是你的常用id，把你的wp和题目文件放进去，你的个人文件夹内部结构自己安排
- `git commit -m "xxxxx"`向分支提交commit，`-m`加一些必要的文字说明。commit前后可以使用`git status`查看状态
- `git push origin xxxx`向远程仓库推送你的分支内容
- `git merge xxxx`此命令在dev分支下进行，将xxxx分支合并到dev分支
