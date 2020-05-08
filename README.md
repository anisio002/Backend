# Spring Boot Application Template

Aplicação base para ser utilizada na avaliação. 

## Construído com

* [Maven] (https://maven.apache.org/) - Gerenciamento de dependências
* [Flyway] (https://flywaydb.org/) - Controle de versão do banco de dados
* [JDK] (http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Plataforma Java ™, Kit de Desenvolvimento Standard Edition 
* [Spring Boot] (https://spring.io/projects/spring-boot) - Estrutura para facilitar a inicialização e o desenvolvimento de novos aplicativos Spring
* [H2] (https://www.h2database.com/html/main.html) - Sistema de gerenciamento de banco de dados relacional de código aberto
* [git] (https://git-scm.com/) - Sistema de controle de versão distribuído gratuito e de código aberto 
* [Lombok] (https://projectlombok.org/) - Nunca escreva outro método getter ou igual novamente, com uma anotação em que sua classe possui um construtor completo, automatize suas variáveis ​​de log e muito mais.
* [Swagger] (https://swagger.io/) - estrutura de software de código aberto apoiada por um grande ecossistema de ferramentas que ajuda os desenvolvedores a projetar, criar, documentar e consumir serviços da Web RESTful.

## External Tools Used

* [Postman](https://www.getpostman.com/) - API Development Environment (Testing Docmentation)


## Iniciando a aplicação

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.arc.sbtest.SBtemplateApplication` class from your IDE.

- Importando o projeto no [Spring Tools](https://spring.io/tools)  
   - File -> Import -> Existing Maven Project -> Navegue até a pasta do projeto
   - Selecione o projeto
- Click com o botão direito do mouse na classe App.java e selecione Run As -> Spring Boot App

```shell
mvn spring-boot:run
```

## Acessando a bases de dados

Acesse a url do [H2 Console](http://localhost:8080/h2-console) http://localhost:8080/h2-console e click em conectar


### Serviço de Teste

|  URL |  Method
|----------|--------------|
|`http://localhost:8080/api/status`                           | GET 

## Documentação

* [Swagger](http://localhost:8088/swagger-ui.html) - Documentação e Teste

## Arquivos e Diretórios


```
.
├── Estrutura do projeto
├── src
│   └── main
│       └── java
│           ├── br.com.aplicacao
│           ├── br.com.aplicacao.config
│           ├── br.com.aplicacao.individuo
│           ├── br.com.aplicacao.endereco
├── src
│   └── main
│       └── resources
│           ├── application.properties
│           ├── banner.txt
├── src
│   └── test
│       └── java
├── JRE System Library
├── Maven Dependencies
├── bin
├── src
├── target
│   └──application-0.0.1-SNAPSHOT
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## packages

- `config` - Configurações da aplicação;
- `individuo`;
- `endereco`;

- `resources/` - Contém arquivos estáticos e configurações;
- `resources/application.properties`;

- `test/` - Deve conter todos os Testes de Unidade e Integração;

- `pom.xml` - Contém todas as dependências da aplicação;
  
## Requisitos a serem entregues

- [ ] Manter cadastro de Veículos;
- [ ] Manter cadastro de Proprietário;
