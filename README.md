# forum
# Alura Forum

Este é um projeto de exemplo para a criação de um fórum de discussão utilizando Spring Boot. O objetivo é permitir que usuários cadastrados possam criar tópicos, visualizar tópicos existentes, atualizar e deletar seus próprios tópicos. Além disso, o sistema inclui autenticação e autorização para garantir a segurança.

## Tecnologias Utilizadas

- **Java 11**
- **Spring Boot 2.7.2**
- **Spring Data JPA**
- **Spring Security**
- **H2 Database**
- **JWT (Json Web Token)**
- **Maven**

## Estrutura do Projeto

A estrutura do projeto está organizada da seguinte forma:

- **`com.example.forum`**: Pacote raiz do projeto.
  - **`configuration`**: Configurações de segurança.
    - `SecurityConfig.java`
  - **`controller`**: Controladores REST.
    - `AuthenticationController.java`
    - `TopicController.java`
  - **`dto`**: Objetos de Transferência de Dados (DTO).
    - `TopicDTO.java`
    - `UserDTO.java`
    - `LoginRequest.java`
  - **`model`**: Entidades do banco de dados.
    - `User.java`
    - `Topic.java`
  - **`repository`**: Repositórios para acesso ao banco de dados.
    - `UserRepository.java`
    - `TopicRepository.java`
  - **`service`**: Serviços da aplicação.
    - `UserService.java`
    - `TopicService.java`
    - `UserServiceImpl.java`
    - `TopicServiceImpl.java`
  - **`util`**: Utilitários ou classes auxiliares (se necessário).
  - **`ForumApplication.java`**: Classe principal que inicia a aplicação Spring Boot.

## Configuração do Banco de Dados

O projeto utiliza o banco de dados em memória H2. A configuração está no arquivo `application.properties`:

```properties
# Configuração do banco de dados H2
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.h2.console.enabled=true

# Configuração JPA
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=create-drop
