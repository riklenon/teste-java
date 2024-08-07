# Projeto RikTeste

Este é um projeto Spring Boot para gerenciar pedidos e clientes. O projeto utiliza um banco de dados MySQL para armazenar as informações e oferece uma API REST para interagir com os dados.

## Pré-requisitos

- Java 17 ou superior
- Maven 3.6.0 ou superior
- MySQL 8.0 ou superior

## Configuração do Banco de Dados

Crie um banco de dados no MySQL chamado `meu_banco_de_dados`. Utilize as credenciais de acesso apropriadas para configurar o acesso no arquivo `application.properties`.

### Comandos SQL para criar o banco de dados

```sql
CREATE DATABASE meu_banco_de_dados;
CREATE USER 'meu_usuario'@'localhost' IDENTIFIED BY 'minha_senha';
GRANT ALL PRIVILEGES ON meu_banco_de_dados.* TO 'meu_usuario'@'localhost';
FLUSH PRIVILEGES;
```

### Configuração do `application.properties`

No diretório `src/main/resources`, configure o arquivo `application.properties` com as informações do banco de dados:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/meu_banco_de_dados
spring.datasource.username=meu_usuario
spring.datasource.password=minha_senha
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

## Compilação e Execução

### Passo 1: Compilar o Projeto

No diretório raiz do projeto, execute o seguinte comando para compilar o projeto:

```sh
mvn clean install
```

### Passo 2: Executar o Projeto

Após a compilação bem-sucedida, execute o projeto usando o plugin Spring Boot do Maven:

```sh
mvn spring-boot:run
```

## Dados de Teste
Ao iniciar o projeto, três clientes de teste serão criados automaticamente no banco de dados.

```
id          nome
1	    Cliente 1
2	    Cliente 2
3	    Cliente 3
```

## Endpoints da API

- `GET /api/pedidos` - Lista todos os pedidos ou lista pedidos por filtro desejado
- `POST /api/pedidos` - Cria um novo pedido
- `GET /api/pedidos/{id}` - Busca um pedido por ID
- `POST /api/clientes/` - Cria um novo cliente


## Swagger UI

A documentação da API está disponível através do Swagger UI. Após iniciar o projeto, acesse a URL abaixo para visualizar a doc:

```
http://localhost:8080/swagger-ui.html
```

## Contato
e-mail: [riklenon@gmail.com](mailto:riklenon@gmail.com)
