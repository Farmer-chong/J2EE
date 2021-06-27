# 基于SpringBoot的TodoList代办事项清单-后端

## Tips
该项目仅为后端，不涉及前端，前端项目请移步前端仓库。  

## 项目介绍
本项目采用**前后端分离架构**。前端JavaScript框架采用Vue.js、后端WebApi框架采用SpringBoot。  
⚠ **本项目并未使用UI框架**。因此并未做移动端、大屏端等多端适配。目前仅支持常规pc端使用。



## 快速开始
### Requirements
- Java >= 1.8
- Vue 2.0+
- vue-cli 4.5.11+

### WebApi部署

1. **克隆仓库**:
```shell
$ git clone https://gitee.com/Farmer-chong/my-nooooob-code.git/springBootDemo
$ cd springBootDemo
```

2. **创建和初始化数据库**:  
command: 
```shell
mysql> SOURCE db.sql
```

3. **构建项目**  
Use command to build on Linux
```shell
./script/build.sh
```
Use command to build on Windows
```powershell
.\script\build.bat
```

4. **运行项目**  
Use command to build on Linux
```shell
./script/start.sh
```
Use command to build on Windows
```powershell
.\script\start.bat
```