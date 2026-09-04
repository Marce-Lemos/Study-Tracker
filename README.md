# 📚 Study Tracker

> Um sistema para acompanhar, organizar e visualizar sua evolução nos estudos.

O **Study Tracker** é uma aplicação desenvolvida para ajudar estudantes a registrar suas sessões de estudo, acompanhar o tempo dedicado a cada conteúdo, visualizar sua consistência por meio de um calendário inspirado no GitHub e revisar conteúdos utilizando o conceito de **repetição espaçada**.

Além de ser uma aplicação funcional, o projeto está sendo desenvolvido como uma forma prática de aprender e aplicar conceitos de **Java, Spring Boot, PostgreSQL, APIs REST, JPA/Hibernate e arquitetura em camadas**.

---

# 🎯 Objetivo

A proposta do Study Tracker é transformar o acompanhamento dos estudos em algo simples, visual e organizado.

O usuário poderá:

- 📖 Registrar sessões de estudo
- ⏱️ Acompanhar o tempo estudado
- 📅 Visualizar seu histórico em um calendário
- 📝 Registrar anotações sobre os conteúdos
- 🧠 Identificar assuntos que apresentaram dificuldade
- 🔁 Revisar conteúdos utilizando repetição espaçada
- 📊 Acompanhar sua evolução
- 🔥 Construir uma sequência de estudos

---

# 🏗️ Arquitetura

A aplicação será construída utilizando uma arquitetura em camadas:

```text
                    STUDY TRACKER
                         │
           ┌─────────────┴─────────────┐
           │                           │
       Front-end                    Back-end
           │                           │
     HTML/CSS/JS                Java + Spring Boot
                                       │
                              ┌────────┴────────┐
                              │                 │
                       Spring Data JPA     Spring Security
                              │
                              │
                         PostgreSQL
````

O projeto começará utilizando **HTML, CSS e JavaScript** no frontend.

Não será utilizado React inicialmente, pois o objetivo é manter o primeiro MVP simples e concentrar o aprendizado no backend com Java.

---

# 🧩 Funcionalidades

## 📖 Registro de estudos

O usuário poderá registrar uma sessão de estudo informando:

```text
Data:       03/09/2026
Duração:    45 minutos
Matéria:    Java
Assunto:    Classes e objetos

O que estudei?
[________________________]

O que achei difícil?
[________________________]
```

Após o registro, as informações serão armazenadas no PostgreSQL.

---

## 📝 Conteúdos e anotações

Cada conteúdo poderá possuir informações relacionadas ao estudo.

Exemplo:

```text
03/09/2026
Java → POO

Hoje aprendi sobre classes,
objetos e construtores.

Dificuldade:

Construtores ainda estão
um pouco confusos.

Revisar:

Construtores
```

Os conteúdos ficarão associados ao usuário e poderão ser utilizados posteriormente pelo sistema de revisão.

---

## 📅 Calendário de estudos

O sistema terá um calendário inspirado no gráfico de contribuições do GitHub.

Exemplo:

```text
2026

Jan  Fev  Mar  Abr  Mai  Jun  Jul  Ago  Set

⬜ 🟩 🟩 🟨 ⬜ 🟩 🟩 🟩 🟩
🟩 🟩 ⬜ 🟩 🟩 🟨 🟩 ⬜ 🟩
🟩 🟩 🟩 🟩 ⬜ 🟩 🟩 🟩 ⬜
```

A intensidade será baseada no tempo estudado durante o dia:

```text
⬜ = 0 minutos
🟨 = 1–30 minutos
🟩 = 31–60 minutos
🟩 = 61–120 minutos
🟩 = 120+ minutos
```

O objetivo é permitir que o usuário visualize rapidamente sua consistência ao longo do ano.

---

## 🔁 Repetição espaçada

O sistema poderá criar revisões automaticamente para conteúdos estudados.

Exemplo:

```text
Java — Classes

📅 Aprendido: 03/09

🔁 Revisões:

04/09 → amanhã
06/09 → +2 dias
11/09 → +5 dias
21/09 → +10 dias
```

Durante uma revisão, o usuário poderá informar o nível de dificuldade:

```text
😵 Esqueci
😐 Tive dificuldade
🙂 Lembrei
😎 Muito fácil
```

Com base nessa resposta, o sistema poderá calcular o próximo intervalo de revisão.

---

# 🗄️ Banco de dados

O banco de dados será desenvolvido utilizando **PostgreSQL**.

A estrutura inicial será composta pelas seguintes tabelas:

## `users`

Responsável pelos usuários da aplicação.

```text
users
 ├── id
 ├── name
 ├── email
 ├── password
 └── created_at
```

## `study_sessions`

Responsável por armazenar as sessões de estudo.

```text
study_sessions
 ├── id
 ├── user_id
 ├── studied_at
 ├── duration_minutes
 └── notes
```

## `topics`

Responsável pelos conteúdos estudados.

```text
topics
 ├── id
 ├── user_id
 ├── subject
 ├── name
 └── description
```

## `reviews`

Responsável pelo sistema de repetição espaçada.

```text
reviews
 ├── id
 ├── topic_id
 ├── review_date
 ├── difficulty
 ├── interval_days
 └── created_at
```

Futuramente poderão ser adicionadas outras entidades.

---

# ☕ Tecnologias

## Backend

* **Java**
* **Spring Boot**
* **Spring Data JPA**
* **Hibernate**
* **Maven**
* **Spring Security**
* **PostgreSQL**

## Frontend

* **HTML5**
* **CSS3**
* **JavaScript**

## Ferramentas

* **Git**
* **GitHub**
* **Postman**
* **IntelliJ IDEA / VS Code**
* **PostgreSQL**

---

# 📁 Estrutura do projeto

A estrutura inicial do backend seguirá uma arquitetura em camadas:

```text
src/
└── main/
    ├── java/
    │   └── com/
    │       └── studytracker/
    │
    │           ├── controller/
    │           │   ├── StudyController.java
    │           │   ├── TopicController.java
    │           │   └── ReviewController.java
    │           │
    │           ├── service/
    │           │   ├── StudyService.java
    │           │   ├── TopicService.java
    │           │   └── ReviewService.java
    │           │
    │           ├── repository/
    │           │   ├── StudyRepository.java
    │           │   ├── TopicRepository.java
    │           │   └── ReviewRepository.java
    │           │
    │           ├── entity/
    │           │   ├── User.java
    │           │   ├── StudySession.java
    │           │   ├── Topic.java
    │           │   └── Review.java
    │           │
    │           └── StudyTrackerApplication.java
    │
    └── resources/
        └── application.properties
```

O fluxo principal da aplicação será:

```text
Controller
     ↓
 Service
     ↓
Repository
     ↓
PostgreSQL
```

---

# 🔌 API REST

A comunicação entre frontend e backend será realizada através de uma API REST.

## Estudos

```http
POST   /studies
GET    /studies
GET    /studies/{id}
DELETE /studies/{id}
```

## Conteúdos

```http
POST   /topics
GET    /topics
GET    /topics/{id}
DELETE /topics/{id}
```

## Revisões

```http
GET  /reviews
POST /reviews/{id}/complete
```

Os endpoints poderão ser ampliados conforme o desenvolvimento do projeto.

---

# 🛣️ Roadmap

O projeto será desenvolvido gradualmente, dividindo o desenvolvimento em etapas.

## 🟢 Etapa 1 — Configuração do projeto

* [ ] Definir ideia do projeto
* [ ] Definir tecnologias
* [ ] Definir arquitetura inicial
* [ ] Criar projeto Spring Boot
* [ ] Configurar Maven
* [ ] Configurar `application.properties`

---

## 🟢 Etapa 2 — Banco de dados

* [ ] Instalar/configurar PostgreSQL
* [ ] Criar banco de dados
* [ ] Configurar conexão Java + PostgreSQL
* [ ] Adicionar dependências JPA/Hibernate
* [ ] Criar primeira entidade
* [ ] Testar persistência dos dados

---

## 🟢 Etapa 3 — Estudos

* [ ] Criar entidade `StudySession`
* [ ] Criar relacionamento com usuário
* [ ] Criar `StudyRepository`
* [ ] Criar `StudyService`
* [ ] Criar `StudyController`
* [ ] Registrar estudos
* [ ] Listar estudos
* [ ] Buscar estudo por ID
* [ ] Excluir estudo

---

## 🟢 Etapa 4 — Conteúdos

* [ ] Criar entidade `Topic`
* [ ] Criar relacionamento com usuário
* [ ] Registrar conteúdos
* [ ] Adicionar anotações
* [ ] Registrar dificuldades
* [ ] Associar conteúdos às sessões de estudo

---

## 🟢 Etapa 5 — Calendário

* [ ] Calcular tempo estudado por dia
* [ ] Criar histórico anual
* [ ] Criar níveis de intensidade
* [ ] Criar calendário visual
* [ ] Exibir calendário de estudos
* [ ] Calcular sequência de estudos

---

## 🟢 Etapa 6 — Repetição espaçada

* [ ] Criar entidade `Review`
* [ ] Criar sistema de agendamento
* [ ] Registrar dificuldade
* [ ] Calcular próximo intervalo
* [ ] Listar revisões pendentes
* [ ] Marcar revisão como concluída

---

## 🟢 Etapa 7 — Usuários

* [ ] Criar cadastro
* [ ] Criar login
* [ ] Criptografar senhas
* [ ] Implementar autenticação
* [ ] Proteger endpoints
* [ ] Associar estudos ao usuário autenticado

---

## 🟢 Etapa 8 — Dashboard

* [ ] Criar dashboard
* [ ] Exibir tempo total estudado
* [ ] Exibir estudos da semana
* [ ] Exibir estudos do mês
* [ ] Exibir sequência atual
* [ ] Exibir conteúdos mais estudados
* [ ] Exibir próximas revisões
* [ ] Adicionar estatísticas

---

# 🔵 Futuro

Após a implementação do MVP, poderão ser adicionadas novas funcionalidades:

* 🏆 Conquistas
* 🎯 Metas de estudo
* 🔥 Sequência de estudos
* 📊 Estatísticas avançadas
* 📅 Planejamento semanal
* ⏰ Lembretes
* 🔔 Notificações de revisão
* 💻 Área específica para programação
* 🧩 Exercícios de programação
* 📂 Projetos de programação
* ⏱️ Tempo programando
* 📈 Evolução na programação
* 🌙 Dark mode

Essas funcionalidades não fazem parte do primeiro MVP e serão consideradas conforme a evolução do projeto.

---

# 🧠 Objetivo de aprendizado

Além de ser uma aplicação funcional, o **Study Tracker** será utilizado como um projeto prático para aprender desenvolvimento em Java.

Durante o desenvolvimento serão estudados conceitos como:

```text
Java
  ↓
Programação Orientada a Objetos
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

O objetivo não é apenas fazer o sistema funcionar, mas entender **por que cada tecnologia e estrutura está sendo utilizada e como elas se relacionam**.

Cada funcionalidade será desenvolvida gradualmente como um desafio de aprendizado.

---

# 🎯 Primeiro objetivo

O primeiro objetivo do projeto é simples:

> **Registrar que estudei hoje e salvar esse registro no PostgreSQL.**

A partir desse primeiro fluxo, novas funcionalidades serão implementadas uma por uma.

A ideia é evitar construir todo o sistema de uma vez e utilizar cada etapa para aprender novos conceitos de desenvolvimento.

---

# 🚀 Como executar o projeto

## Pré-requisitos

Antes de executar o projeto, será necessário ter instalado:

* Java
* Maven
* PostgreSQL
* Git

---

## 1. Clonar o repositório

```bash
git clone https://github.com/Marce-Lemos/Study-Tracker.git
```

Entrar na pasta:

```bash
cd Study-Tracker
```

---

## 2. Configurar o PostgreSQL

Criar o banco:

```sql
CREATE DATABASE study_tracker;
```

Depois, configurar as informações de conexão no arquivo:

```text
src/main/resources/application.properties
```

Exemplo:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/study_tracker
spring.datasource.username=postgres
spring.datasource.password=SUA_SENHA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

> ⚠️ Não coloque senhas reais no GitHub. Em versões futuras, essas configurações deverão utilizar variáveis de ambiente.

---

## 3. Executar o projeto

### Windows

```bash
mvnw.cmd spring-boot:run
```

### Linux/macOS

```bash
./mvnw spring-boot:run
```

---

# 🧪 Testes

A API poderá ser testada utilizando ferramentas como:

* Postman
* Insomnia
* Navegador
* Frontend da aplicação

Futuramente serão adicionados testes automatizados para garantir a qualidade e estabilidade do sistema.

---

# 📌 Status

🚧 **Em desenvolvimento**

O projeto está atualmente em fase de desenvolvimento e será construído inicialmente como um **MVP**, evoluindo gradualmente conforme novas funcionalidades forem implementadas.

---

# 👨‍💻 Autor

**Marce-Lemos**

Projeto desenvolvido para estudo, prática e evolução em desenvolvimento de software com Java.

---

# 📄 Licença

Este projeto está sendo desenvolvido inicialmente para fins de estudo e aprendizado.

Uma licença específica poderá ser adicionada posteriormente conforme a evolução do projeto.

