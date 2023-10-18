# Controle academia API

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![MySql](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)

Este projeto usa Java, Spring, banco de dados MySql e Spring Security com JWT!

Esta api fornece um controle de academia, com o módulo de clientes, planos, permissões, terá a funcionalidade de caso o cliente não tenha feito o pagamento após o vencimento fique sem autorização para uso da academia, será integrado com uma catraca eletrônica com a funcionalidade de liberar acesso.

## Table of Contents

- [Instalação](#instalação)
- [Configuração](#configuração)
- [Iniciar](#iniciar)
- [API Endpoints](#api-endpoints)
- [Autenticação](#autenticação)
- [Banco de dados](#bancodedados)
- [Contributing](#contributing)

## Instalação

1. Clone o repositório:

```bash
git clone https://github.com/joaopedropc7/academia.git
```

2. Instale as dependências com o Maven

3. Instale [MySQL](https://www.mysql.com/downloads/)

## Inicio

1. Inicie a aplicação com o Maven
2. A API ficará acessível em http://localhost:8080


## API Endpoints
Siga esses endpoints para acessar a API:

```markdown
GET /planos - Lista todos os planos.

GET /planos/{id} - Busca um plano por id

PUT /planos/{id} - Atualiza um plano pelo ID (ADMIN)

Delete /planos/{id} - Inativa um plano pelo ID (ADMIN)

POST /planos - Cadastra um plano (ADMIN)
```

## Authentication
The API uses Spring Security for authentication control. The following roles are available:

```
USER -> Standard user role for logged-in users.
ADMIN -> Admin role for managing partners (registering new partners).
```
To access protected endpoints as an ADMIN user, provide the appropriate authentication credentials in the request header.

## Database
Este projeto utiliza [MySQL](https://www.mysql.com/downloads/) database. Junto foi utilizado flyway migrations.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or submit a pull request to the repository.

When contributing to this project, please follow the existing code style, [commit conventions](https://www.conventionalcommits.org/en/v1.0.0/), and submit your changes in a separate branch.









