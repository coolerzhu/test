
```
自己远程仓库地址：
http://120.78.172.118/

在本地添加远程仓库域名映射，在C:\Windows\System32\drivers\etc\hosts添加映射
120.78.172.118 gitlab.chedaibao.com

1、安装Git
   安装完成后，还需要最后一步设置，在命令行输入：
   $ git config --global user.name 'Your Name'
   $ git config --global user.email 'email@example.com'

2、创建版本库
   2.1、初始化一个Git仓库，使用git init命令
   2.2、使用命令git add <file>，注意，可反复多次使用，添加多个文件；添加所有文件：git add .
   2.3、使用命令git commit -m ''，完成。
 

3、时光机穿梭
   要随时掌握工作区的状态，使用git status命令。
   如果git status告诉你有文件被修改过，用git diff可以查看修改内容。gitk查看修改记录

   3.1、版本回退
	HEAD指向的版本就是当前版本，因此，Git允许我们在版本的历史之间穿梭，使用命令git reset --hard commit_id
	穿梭前，用git log可以查看提交历史，以便确定要回退到哪个版本。
	要重返未来，用git reflog查看命令历史，以便确定要回到未来的哪个版本。
	首先已经push到远程仓库的提交，有可能已经被其他人pull到他们的本地仓库，而且他们有可能已经在你的提交的基础上进行开发，这样你rollback你的提交，就会影响到其他人。
    如果你确定你的提交没有被其他人pull，或者你可以通知到其他人。那么你可以在push命令里加入 --force，这样远程分支的HEAD就会被强制修改成和你本地的一样。 git push --force origin HEAD:master
   
   3.2、工作区和六暂存区
	工作区有一个隐藏目录.git，这个不算工作区，而是Git的版本库。
	前面讲了我们把文件往Git版本库里添加的时候，是分两步执行的：
	是用git add把文件添加进去，实际上就是把文件修改添加到暂存区；
	是用git commit提交更改，实际上就是把暂存区的所有内容提交到当前分支。

   3.3、管理修改
	Git跟踪并管理的是修改，而非文件，
	当你用git add命令后，在工作区的第一次修改被放入暂存区，准备提交，但是，在工作区的第二次修改并没有放入暂存区，所以，git commit只负责把暂存区的修改提交了，也就是第一次的修改被提交了，第二次的修改不会被提交
	你可以继续git add再git commit，也可以别着急提交第一次修改，先git add第二次修改，再git commit，就相当于把两次修改合并后一块提交了：第一次修改 -> git add -> 第二次修改 -> git add -> git commit
	每次修改，如果不add到暂存区，那就不会加入到commit中。
   
   3.4、撤销修改
	3.4.1、当你改乱了工作区某个文件的内容，想直接丢弃工作区的修改时，用命令git checkout -- file。
	3.4.2、当你不但改乱了工作区某个文件的内容，还添加到了暂存区时，想丢弃修改，分两步，第一步用命令git reset HEAD file，就回到了场景1，第二步按场景1操作。
	3.4.3、已经提交了不合适的修改到版本库时，想要撤销本次提交，参考版本回退一节，不过前提是没有推送到远程库。
   
   3.5、删除文件
	在Git中，删除也是一个修改操作
	一般情况下，你通常直接在文件管理器中把没用的文件删了，或者用rm命令删了，这个时候，Git知道你删除了文件，因此，工作区和版本库就不一致了，git status命令会立刻告诉你哪些文件被删除了
	现在你有两个选择，一是确实要从版本库中删除该文件，那就用命令git rm删掉，并且git commit；另一种情况是删错了，因为版本库里还有呢，所以可以很轻松地把误删的文件恢复到最新版本： $ git checkout -- test.txt
	命令git rm用于删除一个文件。如果一个文件已经被提交到版本库，那么你永远不用担心误删，但是要小心，你只能恢复文件到最新版本，你会丢失最近一次提交后你修改的内容。

4、远程仓库
   第1步：创建SSH Key ：$ ssh-keygen -t rsa -C "youremail@example.com"
   第2步：登陆GitHub，打开“Account settings”，“SSH Keys”页面，然后，点“Add SSH Key”，填上任意Title，在Key文本框里粘贴id_rsa.pub文件的内容：

   4.1、添加远程仓库
	要关联一个远程库，使用命令git remote add origin git@server-name:path/repo-name.git；
	关联后，使用命令git push -u origin master第一次推送master分支的所有内容；
	此后，每次本地提交后，只要有必要，就可以使用命令git push origin master推送最新修改；
   
   4.2、从远程仓库克隆
	要克隆一个仓库，首先必须知道仓库的地址，然后使用git clone命令克隆。Git支持多种协议，包括https，但通过ssh支持的原生git协议速度最快。
   
   4.3、

5、分支管理
   
   5.1、创建与合并分支
	5.1.1、查看分支：git branch
	5.1.2、创建分支：git branch <name>
	5.1.3、切换分支：git checkout <name>
	5.1.4、创建+切换分支：git checkout -b <name>
	5.1.5、合并某分支到当前分支：git merge <name>
	5.1.5、删除分支：git branch -d <name>
	5.1.6、删除远程仓库分支：git push origin :branch-name

   5.2、解决冲突
	当Git无法自动合并分支时，就必须首先解决冲突。
	git status也可以告诉我们冲突的文件；解决冲突后，再提交，合并完成；
	用git log --graph命令可以看到分支合并图。

   5.3、分支管理策略
	在实际开发中，我们应该按照几个基本原则进行分支管理：
	首先，master分支应该是非常稳定的，也就是仅用来发布新版本，平时不能在上面干活；
	干活都在dev分支上，也就是说，dev分支是不稳定的，到某个时候，比如1.0版本发布时，再把dev分支合并到master上，在master分支发布1.0版本；
	你和你的小伙伴们每个人都在dev分支上干活，每个人都有自己的分支，时不时地往dev分支上合并就可以了。
	合并分支时，加上--no-ff参数就可以用普通模式合并，合并后的历史有分支，能看出来曾经做过合并，而fast forward合并就看不出来曾经做过合并。
  
   5.4、Bug管理
	修复bug时，我们会通过创建新的bug分支进行修复，然后合并，最后删除；
	当手头工作没有完成时，先把工作现场git stash一下，然后去修复bug，修复后，再git stash pop，回到工作现场。

   5.5、Feature分支
	开发一个新feature，最好新建一个分支；
	如果要丢弃一个没有被合并过的分支，可以通过git branch -D <name>强行删除。

   5.6、多人协作
	5.6.1、查看远程库信息，使用git remote -v；
	5.6.2、本地新建的分支如果不推送到远程，对其他人就是不可见的；
	5.6.3、从本地推送分支，使用git push origin branch-name，如果推送失败，先用git pull抓取远程的新提交；
	5.6.4、在本地创建和远程分支对应的分支，使用git checkout -b branch-name origin/branch-name，本地和远程分支的名称最好一致；
	5.6.5、建立本地分支和远程分支的关联，使用git branch --set-upstream branch-name origin/branch-name；
	5.6.6、从远程抓取分支，使用git pull，如果有冲突，要先处理冲突。

6、标签管理
	标签也是版本库的一个快照。
   
   6.1、创建标签
	6.1.1、命令git tag <name>用于新建一个标签，默认为HEAD，也可以指定一个commit id；
	6.1.2、git tag -a <tagname> -m "blablabla..."可以指定标签信息；
	6.1.3、git tag -s <tagname> -m "blablabla..."可以用PGP签名标签；
	6.1.4、命令git tag可以查看所有标签。

   6.2、操作标签
	6.2.1、命令git push origin <tagname>可以推送一个本地标签；
	6.2.2、命令git push origin --tags可以推送全部未推送过的本地标签；
	6.2.3、命令git tag -d <tagname>可以删除一个本地标签；
	6.2.4、命令git push origin :refs/tags/<tagname>可以删除一个远程标签。

7、搭建Git服务器
	第一步，安装git：$ sudo apt-get install git
	第二步，创建一个git用户，用来运行git服务：$ sudo adduser git
	第三步，创建证书登录：收集所有需要登录的用户的公钥，就是他们自己的id_rsa.pub文件，把所有公钥导入到/home/git/.ssh/authorized_keys文件里，一行一个。
	第四步，初始化Git仓库：
		先选定一个目录作为Git仓库，假定是/srv/sample.git，在/srv目录下输入命令：$ sudo git init --bare sample.git
		Git就会创建一个裸仓库，裸仓库没有工作区，因为服务器上的Git仓库纯粹是为了共享，所以不让用户直接登录到服务器上去改工作区，并且服务器上的Git仓库通常都以.git结尾。
		然后，把owner改为git：$ sudo chown -R git:git sample.git
	第五步，禁用shell登录：
		出于安全考虑，第二步创建的git用户不允许登录shell，这可以通过编辑/etc/passwd文件完成。找到类似下面的一行：
		git:x:1001:1001:,,,:/home/git:/bin/bash
		改为：
		git:x:1001:1001:,,,:/home/git:/usr/bin/git-shell
		这样，git用户可以正常通过ssh使用git，但无法登录shell，因为我们为git用户指定的git-shell每次一登录就自动退出。
	第六步，克隆远程仓库：
		现在，可以通过git clone命令克隆远程仓库了，在各自的电脑上运行：
		$ git clone git@server:/srv/sample.git





//拉取远程分支
git fetch
//合并
git rebase
如若有冲突，修改冲突 ，然后 git rebase --continue 
如若有冲突，想要放弃合并  git rebase --abort
//提交远程分支
git push --no-thin origin HEAD:master


//多次提交时
１、在已经提交的远程分支下拉出临时分支temp
２、在temp上看log,如果要合并当前到第５个提交，则git reset --soft 第六个commitId
３、直接git commit
４、记住刚刚的commitId
５、切换到要合并的分支（要合并到哪个分支）
６、git cherry-pick 记住刚刚的commitId
７、如果有冲突，解决冲突，然后git cherry-pick --continue


提交前，一定要 git fetch ；git rebase



```
.gitignore  忽略文件

https://www.jianshu.com/p/1c74f84e56b4
```



















```
