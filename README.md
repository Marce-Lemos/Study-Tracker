# 📚 Study Tracker

Sistema de gerenciamento e acompanhamento de estudos desenvolvido em **Java** com **PostgreSQL**.

O projeto tem como objetivo permitir que o usuário registre sua rotina de estudos, acompanhe sua evolução através de um calendário inspirado no sistema de contribuições do GitHub, organize conteúdos e utilize um sistema de **repetição espaçada** para revisar aquilo que foi estudado.

---

## 🎯 Objetivo

O **Study Tracker** foi pensado para solucionar um problema simples:

> **Como acompanhar o que estou estudando, manter uma rotina e saber quando preciso revisar um conteúdo?**

A aplicação reúne essas funcionalidades em um único sistema.

O usuário poderá:

* 📚 Registrar o que estudou;
* ⏱️ Registrar quanto tempo estudou;
* 📝 Fazer anotações;
* 📅 Visualizar seu histórico de estudos;
* 📊 Acompanhar sua consistência;
* 🧠 Revisar conteúdos utilizando repetição espaçada;
* 🔁 Registrar o resultado de cada revisão.

---

# 🚀 Funcionalidades

## 📖 Registro de estudos

O usuário poderá registrar uma sessão de estudo contendo informações como:

```text
Data:       04/09/2026
Duração:    60 minutos

Matéria:    Java
Assunto:    Orientação a Objetos

Conteúdo estudado:
Classes, objetos, métodos e construtores.

Dificuldades:
Ainda tenho dificuldade com construtores.
```

Essas informações serão armazenadas no banco de dados PostgreSQL.

---

## 📅 Histórico de estudos

O sistema apresentará um calendário de estudos inspirado no gráfico de contribuições do GitHub.

Exemplo:

```text
           2026

JAN  FEV  MAR  ABR  MAI  JUN  JUL  AGO  SET

⬜ 🟩 🟩 ⬜ 🟨 🟩 🟩 🟩 ⬜
🟩 🟩 🟩 🟨 🟩 ⬜ 🟩 🟩 🟩
⬜ 🟩 🟨 🟩 🟩 🟩 🟩 ⬜ 🟩
```

A intensidade do dia será calculada com base no tempo estudado.

```text
⬜  0 minutos

🟨  1–30 minutos

🟩  31–60 minutos

🟩  61–120 minutos

🟩  120+ minutos
```

Ao selecionar um dia, será possível visualizar os estudos realizados naquela data.

---

# 📝 Anotações

Cada sessão de estudo poderá possuir suas próprias anotações.

Exemplo:

```text
04/09/2026

Java
└── Orientação a Objetos

Tempo estudado:
1 hora

O que aprendi:
- Classes
- Objetos
- Métodos
- Construtores

Dificuldades:
Construtores ainda não estão muito claros.

Observações:
Preciso revisar esse assunto.
```

As anotações ficarão armazenadas junto aos registros correspondentes.

---

# 🧠 Repetição espaçada

O sistema terá um mecanismo de **repetição espaçada** para ajudar na retenção dos conteúdos estudados.

Após estudar determinado assunto, o sistema poderá criar automaticamente uma sequência de revisões.

Exemplo:

```text
📚 Java — Classes e Objetos

Estudado:
04/09/2026

Revisões:

05/09 → 1ª revisão
07/09 → 2ª revisão
12/09 → 3ª revisão
22/09 → 4ª revisão
```

Durante uma revisão, o usuário informará o quanto conseguiu lembrar:

```text
😵 Esqueci
😐 Tive dificuldade
🙂 Lembrei
😎 Muito fácil
```

A resposta será utilizada para determinar o próximo intervalo de revisão.

---

# 🗃️ Banco de dados

O banco de dados utilizado pelo projeto será o **PostgreSQL**.

A estrutura inicial será composta pelas seguintes tabelas:

```text
users
 │
 ├── study_sessions
 │
 └── topics
        │
        └── reviews
```

## `users`

Armazena os usuários do sistema.

```text
id
name
email
password
created_at
```

## `study_sessions`

Armazena as sessões de estudo.

```text
id
user_id
studied_at
duration_minutes
notes
```

## `topics`

Armazena os conteúdos estudados.

```text
id
user_id
subject
name
description
```

## `reviews`

Armazena as revisões dos conteúdos.

```text
id
topic_id
review_date
difficulty
interval_days
created_at
```

---

# ☕ Tecnologias

## Linguagem

**Java**

A linguagem principal utilizada no desenvolvimento da aplicação.

## Backend

**Spring Boot**

Utilizado para desenvolver a aplicação e disponibilizar a API.

## Persistência

**Spring Data JPA / Hibernate**

Responsáveis pela comunicação entre as entidades Java e o banco de dados.

## Banco de dados

**PostgreSQL**

Utilizado para armazenar os usuários, estudos, conteúdos e revisões.

## Gerenciamento de dependências

**Maven**

Utilizado para gerenciamento das dependências e configuração do projeto Java.

---

# 🏗️ Arquitetura

O projeto seguirá inicialmente uma arquitetura em camadas:

```text
                 APPLICATION
                      │
                      ▼
               ┌─────────────┐
               │ Controller  │
               └──────┬──────┘
                      │
                      ▼
               ┌─────────────┐
               │   Service   │
               └──────┬──────┘
                      │
                      ▼
               ┌─────────────┐
               │ Repository  │
               └──────┬──────┘
                      │
                      ▼
               ┌─────────────┐
               │ PostgreSQL  │
               └─────────────┘
```

### Controller

Responsável por receber as requisições HTTP.

### Service

Responsável pelas regras de negócio da aplicação.

### Repository

Responsável pela comunicação com o banco de dados.

### Entity

Representa os dados utilizados pela aplicação.

---

# 📁 Estrutura do projeto

```text
study-tracker/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── studytracker/
│   │   │           │
│   │   │           ├── controller/
│   │   │           │   ├── StudyController.java
│   │   │           │   ├── TopicController.java
│   │   │           │   └── ReviewController.java
│   │   │           │
│   │   │           ├── service/
│   │   │           │   ├── StudyService.java
│   │   │           │   ├── TopicService.java
│   │   │           │   └── ReviewService.java
│   │   │           │
│   │   │           ├── repository/
│   │   │           │   ├── StudyRepository.java
│   │   │           │   ├── TopicRepository.java
│   │   │           │   └── ReviewRepository.java
│   │   │           │
│   │   │           ├── entity/
│   │   │           │   ├── User.java
│   │   │           │   ├── StudySession.java
│   │   │           │   ├── Topic.java
│   │   │           │   └── Review.java
│   │   │           │
│   │   │           └── StudyTrackerApplication.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│
├── pom.xml
└── README.md
```

---

# 🔌 API

A aplicação será construída utilizando uma API REST.

## Estudos

```http
POST /studies
```

Cria uma nova sessão de estudo.

```http
GET /studies
```

Lista os estudos registrados.

```http
GET /studies/{id}
```

Busca um estudo específico.

```http
DELETE /studies/{id}
```

Remove um estudo.

---

## Conteúdos

```http
POST /topics
GET /topics
GET /topics/{id}
DELETE /topics/{id}
```

---

## Revisões

```http
GET /reviews
```

Lista as revisões pendentes.

```http
POST /reviews/{id}/complete
```

Registra o resultado de uma revisão e calcula a próxima revisão.

---

# 🛠️ Configuração

## Pré-requisitos

Antes de executar o projeto, é necessário ter instalado:

* Java;
* Maven;
* PostgreSQL;
* Git.

---

## Banco de dados

Crie um banco PostgreSQL:

```sql
CREATE DATABASE study_tracker;
```

Depois configure a conexão no arquivo:

```text
src/main/resources/application.properties
```

Exemplo:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/study_tracker
spring.datasource.username=postgres
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

# ▶️ Executando o projeto

Clone o repositório:

```bash
git clone https://github.com/Marce-Lemos/study-tracker.git
```

Entre na pasta:

```bash
cd study-tracker
```

Execute a aplicação com Maven:

```bash
./mvnw spring-boot:run
```

No Windows:

```bash
mvnw.cmd spring-boot:run
```

---

# 🗺️ Roadmap

O projeto será desenvolvido gradualmente.

## 🟢 Etapa 1 — Configuração

* [ ] Criar projeto Spring Boot
* [ ] Configurar Maven
* [ ] Configurar PostgreSQL
* [ ] Conectar Java ao PostgreSQL
* [ ] Configurar JPA

## 🟢 Etapa 2 — Estudos

* [ ] Criar entidade `StudySession`
* [ ] Criar Repository
* [ ] Criar Service
* [ ] Criar Controller
* [ ] Registrar estudo
* [ ] Listar estudos
* [ ] Excluir estudo

## 🟢 Etapa 3 — Conteúdos

* [ ] Criar entidade `Topic`
* [ ] Criar relacionamento com usuário
* [ ] Registrar conteúdos
* [ ] Adicionar anotações

## 🟢 Etapa 4 — Calendário

* [ ] Calcular tempo estudado por dia
* [ ] Criar histórico anual
* [ ] Criar níveis de intensidade
* [ ] Exibir calendário de estudos

## 🟢 Etapa 5 — Repetição espaçada

* [ ] Criar entidade `Review`
* [ ] Criar sistema de agendamento
* [ ] Registrar dificuldade
* [ ] Calcular próximo intervalo
* [ ] Listar revisões pendentes

## 🟢 Etapa 6 — Usuários

* [ ] Criar cadastro
* [ ] Criar login
* [ ] Criptografar senhas
* [ ] Implementar autenticação
* [ ] Proteger endpoints

## 🔵 Futuro

Após a implementação do MVP, poderão ser adicionadas novas funcionalidades, como:

* Dashboard;
* Metas de estudo;
* Estatísticas;
* Sequência de estudos;
* Área específica para programação;
* Projetos de programação;
* Notificações de revisão.

---

# 📚 Objetivo de aprendizado

Além de ser uma aplicação funcional, o **Study Tracker** será utilizado como projeto prático para aprender desenvolvimento em Java.

Durante o desenvolvimento serão estudados conceitos como:

```text
Java
  ↓
POO
  ↓
Maven
  ↓
Spring Boot
  ↓
REST API
  ↓
HTTP
  ↓
JPA / Hibernate
  ↓
PostgreSQL
  ↓
Arquitetura em camadas
  ↓
Spring Security
```

A ideia é desenvolver cada funcionalidade gradualmente, entendendo **por que ela existe e como funciona**, em vez de apenas implementar o código.

---

# 📌 Status

🚧 **Em desenvolvimento**

O projeto está atualmente em fase de desenvolvimento e será construído inicialmente como um MVP.

Novas funcionalidades serão adicionadas conforme o projeto evoluir.

---

# 👨‍💻 Autor

Desenvolvido por Marcelo Lemos Lopes.

---

## 📄 Licença

Este projeto está sob a licença MIT.

Esse README agora está **100% alinhado com a proposta Java + PostgreSQL**, com Spring Boot/JPA como suporte ao desenvolvimento. Também deixei o frontend fora da definição principal do projeto, porque o núcleo do que você descreveu é o **backend + banco + lógica de estudos/repetição**.
