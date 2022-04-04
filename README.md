# **Employee API**

API de empregados para desafio técnico do processo seletivo da [*Ssys*](https://www.ssys.com.br/). O objetivo do desafio foi realizar uma API com: um CRUD de empregados e reports da variação de salário e idade dos empregados cadastrados. Além disso, a API deveria ter um forma de autenticação e guardar os dados em um banco de dados.

Para realizar a autenticação, foi adicionado uma entidade para o usuário no banco de dados e uma requisição para adicionar novos usuários.

Foi realizado o deploy da API em no Heroko.

### **Problema proposto**
![](https://i.imgur.com/0lp8PdQ.png)

## Ferramentas Utilizadas
- Java 11
- [IntelliJ](https://www.jetbrains.com/pt-br/idea/) (IDE)
- [Postman](https://www.postman.com/)
- [Heroko](https://www.heroku.com)
- [Spring initializr](https://start.spring.io/) (Spring boot)
- Gradlew

## Dependências do projeto
- Spring Web
- Spring Data JPA
- H2 Database
- Spring Validation
- Lombok
- Spring Boot DevTools
- [MapStruct](https://mapstruct.org/)
- Spring Security
- [Java JWT](https://mvnrepository.com/artifact/com.auth0/java-jwt)

## Referências
- [API REST usando Spring Boot 2, Hibernate, JPA, e H2 com Deploy no Heroku.](https://www.dio.me/articles/api-rest-usando-spring-boot-2-hibernate-jpa-e-h2-com-deploy-no-heroku)
- [Projeto-Person-API-Rest](https://github.com/GazetaGaveta/Projeto-Person-API-Rest)
- [Digital Innovation: Expert class - Desenvolvendo um sistema de gerenciamento de pessoas em API REST com Spring Boot](https://github.com/rpeleias-v1/personapi_dio_live_coding)
- [Tutorial: Como criar um token JWT com Java, Spring Boot, Spring Security e JPA](https://www.youtube.com/playlist?list=PLTN1gMq8EHuIpxyecEp04TvLr3TQbzMRL)
- [Tutorial: Como criptografar senhas com Java, Spring Boot, Spring Security e JPA](https://www.youtube.com/playlist?list=PLTN1gMq8EHuIvkz0ZdFSufK-eI0FrnkvI)

# **Instruções de usoo**

### Executar projeto
(A API no heroko pode ser usada pelo link: https://api-teste-ssys.herokuapp.com/)
- Baixar código fonte.
- Abrir e executar projeto na IDE.
- Raiz: http://localhost:8000


### Fazer login
Utilizando o postman, fazer uma requisição POST para http://localhost:8000/login enviando um usuário e uma senha válidos. Nesse caso inicial, o usuário e senha são "eee".
![](https://i.imgur.com/vTFZCY6.png)
Isso irá retornar um token de acesso. Para utilizar esse token no Postman, ele deve ser colocado no Headers, com Key "Authorization" e com um préfixo "Bearer ".
![](https://i.imgur.com/YhlzQoV.png)

### Acessar demais requisições da api
utilizar /api/v1/employees ou /api/v1/users




