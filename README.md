# spring-boot-2-datasources
Projeto para ilustrar os problemas com dois datasources e spring-boot

Como levantar os dois bancos de dados com docker:

# Criando um docker mysql com user e password
sudo docker run -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root --name mysql-local -d mysql
# Subindo o mysql criando na linha anterior (quando estiver parado - por exemplo depois de reiniciar)
docker start mysql-local
# Executar um mysql por comandos no mysql que está up
docker exec -it mysql-local mysql -uroot -proot
# Criar database
create database spring_boot_2_datasources;
use spring_boot_2_datasources;
# Criar tabelas e registros
create table teste ( id int(11), primary key (id));
insert into teste values (1);
insert into teste values (2);
insert into teste values (3);
# Remover caso precisar
docker rm mysql-local



# Criando um docker postgres com user e password
docker run --name local-postgres -p 5432:5432 -e POSTGRES_PASSWORD=postgres -d postgres
# Subindo o postgres criando na linha anterior (quando estiver parado - por exemplo depois de reiniciar)
docker start local-postgres
# Executar um postgres por comandos no postgres que está up
docker run -it --rm --link local-postgres:postgres postgres psql -h postgres -U postgres
# criar novo banco
create database spring_boot_2_datasources
# connetar ao banco
\connect spring_boot_2_datasources
# Criar tabelas e registros
create table teste ( id int, primary key (id));
insert into teste values (4);
insert into teste values (5);
insert into teste values (6);
# sair
\q
