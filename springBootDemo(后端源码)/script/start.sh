#!/bin/sh
# 应用程序参数设置

# server_port  服务器端口 
server_port=8087


# 数据源设置
db_host="127.0.0.1"
db_port="3306"
db_name="spring"
db_username="root"
db_password=""
db_params="useSSL=false&serverTimezone=UTC"

jdbc_url="jdbc:mysql://${db_host}:${db_port}/${db_name}?${db_params}"

java -Dfile.encoding=utf-8 -jar ../target/springdemo-0.0.1-SNAPSHOT.jar \
--server.port=$server_port \
--spring.datasource.druid.url="$jdbc_url" \
--spring.datasource.druid.username="$db_username" \
--spring.datasource.druid.password="$db_password" \

