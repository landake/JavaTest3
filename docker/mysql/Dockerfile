FROM registry.saas.hand-china.com/tools/mysql:5.6

#将所需文件放到容器中
COPY setup.sh /mysql/setup.sh
COPY sakila-data.sql /mysql/sakila-data.sql
COPY sakila-schema.sql /mysql/sakila-schema.sql

#设置容器启动时执行的命令
CMD ["sh", "/mysql/setup.sh"]
