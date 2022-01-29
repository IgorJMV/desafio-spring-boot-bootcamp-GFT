# People Address - GFT Start #3 Java
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/IgorJMV/desafio-spring-boot-bootcamp-GFT/blob/main/LICENSE) 

# Sobre o projeto

O sistema de cadastro de pessoas e endereços foi desenvolvido com o auxílio do framework Spring Boot. O intuito desse projeto é aplicar os conceitos vistos no curso "Explorando Padrões de Projetos na Prática com Java" do bootcamp da GFT na plataforma DIO, tais como: singleton, strategy, facade.

O sistema possui os principais endpoints para realizar um CRUD no banco de dados. Esses métodos podem ser testados com a interface do Swagger-UI.

O sistema busca, com base no cep informado, todas as informações daquele endereço. Isso é possível pois foi utilizado no projeto o Feign Client (alternativa criada pela Netflix para implementação de clientes HTTPs em Java).

Todas as dependências do projeto são gerenciadas pelo Apache Maven. Para testes, foi usado o banco de dados H2.

## Modelo conceitual
![Modelo Conceitual](https://github.com/IgorJMV/desafio-spring-boot-bootcamp-GFT/blob/main/assets/domain.png)

## Endpoints disponíveis

### People

[![NPM](https://img.shields.io/badge/-GET-blue)]()/peoples

[![NPM](https://img.shields.io/badge/-GET-blue)]()/peoples/{id}

[![NPM](https://img.shields.io/badge/-POST-green)]()/peoples

[![NPM](https://img.shields.io/badge/-PUT-orange)]()/peoples/{id}

[![NPM](https://img.shields.io/badge/-DELETE-red)]()/peoples/{id}

### Address

[![NPM](https://img.shields.io/badge/-GET-blue)]()/adresses

[![NPM](https://img.shields.io/badge/-GET-blue)]()/adresses/{id}

[![NPM](https://img.shields.io/badge/-POST-green)]()/adresses

[![NPM](https://img.shields.io/badge/-PUT-orange)]()/adresses/{id}

[![NPM](https://img.shields.io/badge/-DELETE-red)]()/adresses/{id}

# Tecnologias utilizadas
- [![NPM](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.oracle.com/java/technologies/downloads/#jdk17) versão: 17.0.2 2022-01-18 LTS
- [![NPM](https://img.shields.io/badge/-Lombok-red?style=for-the-badge&logo=lombok)](https://projectlombok.org/) versão: 1.18.22
- [![NPM](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)](https://spring.io/projects/spring-boot)versão: 2.6.3
- [![NPM](https://img.shields.io/badge/-H2-blue?style=for-the-badge&logo=h2)](https://www.h2database.com/html/main.html) Banco de dados em memória
- [![NPM](https://img.shields.io/badge/-Swagger-brightgreen?style=for-the-badge&logo=swagger)](https://swagger.io/tools/swagger-ui/) Springdoc OpenAPI UI 1.6.5
- [![NPM](https://img.shields.io/badge/apache_maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)](https://maven.apache.org/) (Gerenciador de dependências)

# Autor

Igor José Marinho Vieira [![NPM](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/igor-marinho)
