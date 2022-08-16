# 基于SpringBoot的TodoList代办事项清单
[![State-of-the-art Shitcode](https://img.shields.io/static/v1?label=State-of-the-art&message=Shitcode&color=7B5804)](https://github.com/trekhleb/state-of-the-art-shitcode)

## Tips
该项目仅为后端，不涉及前端，前端项目请移步前端仓库。  

## 项目介绍
本项目采用**前后端分离架构**。前端JavaScript框架采用Vue.js、后端WebApi框架采用SpringBoot。  
⚠ **本项目并未使用UI框架**。因此并未做移动端、大屏端等多端适配。目前仅支持常规pc端使用。



## 快速开始
### Requirements
- Java >= 1.8
- vue 2.0+
- vue-cli 4.5.11+

### WebApi部署

1. **克隆仓库**:
```shell
$ git clone https://gitee.com/Farmer-chong/my-nooooob-code.git/springBootDemo
$ cd springBootDemo
```

2. **创建和初始化数据库**:  
使用命令行导入: 
```shell
mysql> SOURCE db.sql
```

~~使用图形化软件导入~~:   
根据自己使用的图形化软件导入

3. **构建项目**  
在Linux系统上构建项目
```shell
./script/build.sh
```

在Windows系统构建项目
```powershell
.\script\build.bat
```

4. **运行项目**  
在Linux系统上运行项目
```shell
./script/start.sh
```

在Windows系统上运行项目
```powershell
.\script\start.bat
```



### 前端部署

1. 克隆仓库: 
   ```shell
    $ cd /var/www/
    $ git clone https://gitee.com/Farmer-chong/vuejs-examples.git/todo-list-app
    $ cd todo-list-app
   ```
2. 修改api配置文件  
   修改项目根目录的`./src/api/apiConfig.js`文件里面的`server`属性的值为你部署的主机
3. 构建项目
   - 使用npm包管理器 -> `npm run build`
   - 使用yarn包管理器 -> `yarn run build`
   - 构建完成后，根目录下的`dist`为编译生成的文件夹
4. 配置静态页面服务器   
   这里以Nginx服务器配置为例:
   ```shell
   server{
       listen 80;
       server_name _;
       root /var/www/todo-list-app/dist
       index index.html;
       location / {
       }
   }
   ```
    🎇 除了Nginx外，你还可以使用我开发的简易版HttpServer进行部署  
    🚀 仓库地址: `https://gitee.com/Farmer-chong/simple-http-server`  
    具体使用方法请看仓库文档，这里不过多赘述.

### 前端部署方法二
😀 除了自行构建，你还可以使用已经编译好的前端静态页面.  
由于api内嵌，使用编译好的页面默认使用官方的WebApi接口，构建方法:
1. 下载解压编译好的包  
```shell
mkdir /var/www/todo-list-app
cd /var/www/todo-list-app

wget https://gitee.com/Farmer-chong/vuejs-examples/attach_files/750737/downloaddist.zip

unzip dist.zip ./
```

2. 配置静态页面服务器  
方法同上。

