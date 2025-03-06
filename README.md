# loja-brinquedos-kgb-api
B# Kidsgrace Brasil - Loja de Brinquedos

Kidsgrace Brasil é uma API desenvolvida com **Spring Boot** para gerenciar uma loja de brinquedos. O sistema permite o cadastro, busca, atualização e remoção de brinquedos, marcas e categorias.

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3**
- **Spring Data JPA** (Hibernate)
- **Spring Web** (REST APIs)
- **MySQL** (Banco de dados em produção)
- **Swagger OpenAPI** (Documentação da API)

## 📌 Funcionalidades

- CRUD de Brinquedos
- Filtragem por marca, categoria e nome
- Documentação interativa com Swagger

## 📦 Instalação e Configuração

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/kidsgrace-brasil.git
   ```
2. Acesse o diretório do projeto:
   ```bash
   cd kidsgrace-brasil
   ```
3. Configure o **application.properties** (para MySQL):
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/kidsgrace
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
   ```
4. Execute o projeto:
   ```bash
   mvn spring-boot:run
   ```

## 🛠️ Endpoints Principais

| Método  | Endpoint                        | Descrição                               |
|---------|--------------------------------|--------------------------------|
| GET     | `/toys/findAll`                | Lista todos os brinquedos     |
| GET     | `/toys/findByName/{name}`      | Busca brinquedo por nome      |
| GET     | `/toys/findAllByBrand/{brand}` | Filtra brinquedos por marca   |
| GET     | `/toys/findAllByCategory/{category}` | Filtra brinquedos por categoria |
| POST    | `/toys/insert`                 | Adiciona um novo brinquedo    |
| PUT     | `/toys/update`                 | Atualiza um brinquedo         |
| DELETE  | `/toys/deleteById/{id}`        | Remove um brinquedo por ID    |

A documentação completa está disponível em:
- [Swagger UI](http://localhost:8080/swagger-ui.html)

## 🏠 Estrutura do Projeto
```
 kidsgrace-brasil/
 ├── src/main/java/edu/meialua/kidsgrace/
 │   ├── model                      # Classes de Negócio
 │   ├── adapters/in/repositories/  # Repositórios JPA
 │   ├── adapters/out/controller/   # Controllers (REST APIs)
 ├── src/main/resources/
 │   ├── application.properties     # Configuração do Spring Boot
```

## 💌 Devs
- **Alisson Mayer Medeji**
- **Bruno Araujo de Souza**
- **Gabriel Tavares Barsani**
- **Henrique Barreto**
- **Henrique Porto**
- **Leonardo Costa Lima**
- **Lucas Oliveira Silva**



