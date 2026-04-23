# Product Catalog API (Microsserviços com Java)

Este projeto é um laboratório prático para o desenvolvimento de um **Microsserviço de Catálogo de Produtos**. O foco principal é aplicar padrões de arquitetura modernos, garantindo que o sistema seja escalável, testável e fácil de manter.

## Objetivo do Projeto
O intuito é aprender e praticar a construção de microsserviços do zero, utilizando **Java** e **Spring Boot**, aplicando conceitos de **Clean Architecture** e **DDD (Domain-Driven Design)**, além de comunicação assíncrona com **RabbitMQ**.

---

## Tecnologias e Ferramentas
*   **Linguagem:** Java 17
*   **Framework:** Spring Boot 3.x
*   **Persistência:** Spring Data JPA / PostgreSQL
*   **Mensageria:** RabbitMQ (Comunicação entre microsserviços)
*   **Cache:** Redis (Performance em consultas de catálogo)
*   **Migrações:** Flyway (Versionamento de banco de dados)
*   **Containers:** Docker & Docker Compose
*   **Arquitetura:** Clean Architecture / DDD

---

## Estrutura de Pastas e Arquitetura
O projeto está organizado para separar as regras de negócio das tecnologias externas:

- `domain/`: O coração do projeto. Contém as entidades de negócio (`Produto`, `Categoria`), objetos de valor (`Preco`, `SKU`) e as interfaces de repositório. Não depende de frameworks.
- `application/`: Camada que orquestra os casos de uso (Ex: Criar Produto, Atualizar Preço).
- `infrastructure/`: Detalhes técnicos e implementações (Conexão com Banco, RabbitMQ, Redis, Segurança).
- `interfaces/`: Pontos de entrada do sistema (Controllers REST para comunicação com o Front-end/Mobile).

---

## 🚀 Como rodar o projeto (Em desenvolvimento)

### Pré-requisitos
- Docker instalado
- JDK 17 ou superior
- Maven

### Passos para subir a infraestrutura
Este projeto utiliza Docker Compose para subir o banco de dados e o broker de mensagens:

bash
docker-compose up -d


Serviços iniciados:
- **PostgreSQL:** Porta 5432
- **RabbitMQ:** Porta 5672 (Interface de Gerenciamento: 15672)
- **Redis:** Porta 6379

---

## 📈 Roadmap de Aprendizado
- [x] Configuração inicial e estrutura de pastas.
- [x] Modelagem do Domínio e Value Objects.
- [ ] Implementação da Persistência (JPA/Adapter).
- [ ] Implementação dos Casos de Uso (Use Cases).
- [ ] Integração com RabbitMQ (Publicação de Eventos).
- [ ] Exposição de API REST e Documentação.
