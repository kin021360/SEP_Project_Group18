# CS3343 Software Engineering Practice Project - Group18
## Java testing program
https://drive.google.com/drive/folders/0B2znpjlXrr9jV3VGT0RqYUZTYlE

## Git Practice Guide
* To do a development, should create a **feature branch** from **develop**. E.g. feature/abc
* The develop and master branch are protected. You could not commit/push into them directly.
* When you want to merge you feature branch into develop, you should create a pull request on GitHub and assign a reviewer to approve merging.
* Your should pull(merge) develop into your feature branch that make your feature branch up-to-date.
* Do not pull(merge) master into your feature branch because it is older than develop branch. Imagine that master branch is a production version (It should only contain the statble code).
* You could google **git flow** development practice.

## Important

### Choose **Ancestor Order** in SourceTree to show the correct order of history

<kbd><img src="/img/21.png"></kbd>


## Tools

### SourceTree - the gui git management program
https://www.sourcetreeapp.com   
You may need to create an Atlassian account while installing SourceTree

### Setup (After installation)
1. 

<kbd><img src="/img/1.png"></kbd>

2. 

<kbd><img src="/img/2.png"></kbd>

3. 

<kbd><img src="/img/3.png"></kbd>

4. 

<kbd><img src="/img/4.png"></kbd>


### Clone the repository
1. 
<kbd><img src="/img/5.png"></kbd>

2. 

<kbd><img src="/img/6.png"></kbd>

3. 

<kbd><img src="/img/7.png"></kbd>


### Create your feature branch
1. 

<kbd><img src="/img/8.png"></kbd>

2. Enter your feature branch name and select from a specified commit

<kbd><img src="/img/9.png"></kbd>

3. Choose develop (Mean create your feature branch which is copied from develop)

<kbd><img src="/img/10.png"></kbd>


### Import the project into eclipse
1. Choose the root folder "SEP_Project_Group18" as the Workspace

<kbd><img src="/img/13.png"></kbd>

2. Click "File">"Import..."

<kbd><img src="/img/14.png"></kbd>

3. Choose "General">"Existing Projects into Workspace

<kbd><img src="/img/15.png"></kbd>

4. Choose the folder "cs3343.group18.usermanagementsystem"

<kbd><img src="/img/16.png"></kbd>

5. Done

<kbd><img src="/img/17.png"></kbd>


### Please keep your feature branch up-to-date with develop

1. Commit all changes on your feature branch and **Push**
2. Switch to **develop**, then click **Pull**
3. Switch back to your feature branch
4. Click **Merge**, choose the history which is on **origin/develop origin/HEAD develop**
5. If you see the file conflict, you can try to fix it
6. If you cannot solve conflict, you can give up this merging by following command
```
(Click Terminal and enter):
    git merge --abort
```

### Pull request (Merge your finished feature branch into develop)

1. After finishing your feature branch, your want to merge into develop. Goto github you will see this and click "Compare & pull request"

<kbd><img src="/img/18.png"></kbd>

2. Add your command for pull request if necessary and choose the *reviewers* to help you *approve your changes*

<kbd><img src="/img/19.png"></kbd>

3. In the pull request, you can see all the files changes and "Review changes" for reviewers

<kbd><img src="/img/20.png"></kbd>


### WinMerge (Code different compare and view)
http://winmerge.org<br/>

1. 

<kbd><img src="/img/11.png"></kbd>

2. Setup WinMerge in SourceTree

<kbd><img src="/img/12.png"></kbd>


### Visual Studio Code (More powerfull than notepad++)
https://code.visualstudio.com