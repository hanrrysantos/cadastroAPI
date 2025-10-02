# 💻 Sistema de Cadastro de Usuários (Full Stack)

Este projeto é uma aplicação **Full Stack** completa e simples, desenvolvida com o objetivo de demonstrar a criação de um sistema básico de cadastro de usuários e consolidar conhecimentos sobre o fluxo de dados entre o cliente e o servidor.

## ⚙️ Tecnologias e Estrutura

O projeto utiliza uma arquitetura cliente-servidor e a comunicação é feita através de uma **API REST**.

### Backend (API REST)

O Backend é o servidor de aplicação responsável por processar requisições, aplicar a lógica de negócios e persistir os dados.

* **Linguagem & Framework:** Java (JDK 21) com Spring Boot.
* **Persistência:** Spring Data JPA.
* **Banco de Dados:** PostgreSQL, configurado através do `application.properties`.
* **Gerenciador:** Maven.

**Componentes Chave do Backend:**

| Componente | Arquivo de Exemplo | Responsabilidade |
| :--- | :--- | :--- |
| **Entity (Modelo)** | `User.java` | Mapeia o objeto de usuário para a tabela `usuario` no banco de dados. |
| **Repository** | `UserRepository.java` | Interface que estende `JpaRepository`, fornecendo métodos CRUD prontos para a entidade `User`. |
| **Service (Lógica)** | `UserService.java` | Contém a lógica de negócios, como `listAll`, `criarUser`, `editarUser` e `delete`. |
| **Controller (API)** | `UserController.java` | Define os endpoints REST (rotas) sob o caminho `/usuarios` e lida com as requisições HTTP. |

### Frontend (Interface)

O Frontend é a interface de usuário que coleta os dados e envia para a API.

* **Tecnologias:** HTML, CSS e JavaScript puro.
* **Lógica:** O arquivo `script.js` captura os dados do formulário e utiliza a função nativa `fetch` para realizar uma requisição **POST** para a API.

## 🔄 Fluxo de Cadastro

O processo para criar um novo usuário se resume a:

1.  **Captura de Dados:** O usuário preenche os campos Nome, Email, Senha e Telefone no formulário (`index.html`).
2.  **Requisição HTTP:** Ao submeter, a função `cadastrar()` no `script.js` envia um objeto JSON com os dados para o endpoint `http://localhost:8080/usuarios/cadastrar`.
3.  **Processamento da API:** O `UserController` recebe o JSON, e o `UserService` utiliza o `UserRepository` para executar o método `save()`, persistindo o novo registro na tabela `usuario`.
4.  **Confirmação:** A API retorna uma resposta `201 Created`.

## 🔑 Configurações de Acesso (CORS)

Uma configuração de CORS (`CorsConfig.java`) foi essencial para permitir que o Frontend (hospedado em uma porta diferente, ex: `http://127.0.0.1:5500`) pudesse se comunicar com o Backend (padrão em `http://localhost:8080`).

---

## 🛠️ Pré-requisitos

Para executar a aplicação, você precisará ter instalado:

1.  **Java Development Kit (JDK) 21** ou superior.
2.  **PostgreSQL** (Servidor de Banco de Dados).
3.  Um ambiente de desenvolvimento (IDE) ou terminal com Maven.

## 🚀 Como Executar o Projeto

### 1. Configuração do Banco de Dados

O Spring Boot se conecta a um banco de dados PostgreSQL.

* **Nome do Banco de Dados:** Crie um banco de dados com o nome `banco_de_usuarios`.
* **Credenciais Padrão:**
    * **Usuário:** `postgres`
    * **Senha:** `1234`

> **Nota:** A tabela `usuario` será criada automaticamente na inicialização do Backend pelo Spring Data JPA (`ddl-auto=update`).

### 2. Executando o Backend (API)

1.  Navegue até o diretório `backend/`.
2.  Execute a aplicação Spring Boot através da sua IDE ou por linha de comando Maven:
    ```bash
    ./mvnw spring-boot:run
    ```
    O Backend será iniciado na porta padrão **8080**.

**Endpoints da API:**

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `GET` | `/usuarios` | Lista todos os usuários cadastrados. |
| `POST` | `/usuarios/cadastrar` | Cria um novo usuário (usado pelo Frontend). |
| `PUT` | `/usuarios/{id}` | Edita um usuário existente. |
| `DELETE` | `/usuarios/{id}` | Deleta um usuário pelo ID. |

### 3. Executando o Frontend

1.  Navegue até o diretório `frontend/`.
2.  Abra o arquivo `index.html` em seu navegador, preferencialmente usando uma extensão como **Live Server**.
3.  A interface de cadastro estará acessível (por exemplo, em `http://127.0.0.1:5500/index.html`) e pronta para interagir com a API.
