@echo off
@REM 应用程序参数设置

@REM server_port  服务器端口 
set server_port=8087


@REM 数据源设置
set db_host=127.0.0.1
set db_port=3306
set db_name=spring
set db_username=root
set db_password=mojintao233
set db_params="useSSL=false&serverTimezone=UTC"



set jdbc_url=jdbc:mysql://%db_host%:%db_port%/%db_name%?%db_params%

java -jar ../target/springdemo-0.0.1-SNAPSHOT.jar ^
--server.port=%server_port% ^
--spring.datasource.druid.url=%jdbc_url% ^
--spring.datasource.druid.username=%db_username% ^
--spring.datasource.druid.password=%db_password% ^
