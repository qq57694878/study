创建版本库
初始化一个Git仓库，使用git init命令。

添加文件到Git仓库，分两步：

第一步，使用命令git add <file>，注意，可反复多次使用，添加多个文件；

第二步，使用命令git commit -m，完成。

版本回退
使用命令git reset --hard commit_id。

穿梭前，用git log可以查看提交历史，以便确定要回退到哪个版本。

要重返未来，用git reflog查看命令历史，以便确定要回到未来的哪个版本。


远程
git push -u origin master
.1从本地建远程
git init
git add README.md
git commit -m "first commit"
git remote add origin https://github.com/qq57694878/study.git
git push -u origin master
.2从本地已有推远程
git remote add origin https://github.com/qq57694878/study.git
git push -u origin master
.3从远程到本地
git clone

