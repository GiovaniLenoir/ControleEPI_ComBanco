# ControleEPI_ComBanco

# 🦺 Controle de EPI - Java + MySQL

Sistema simples em **Java** com acesso a banco de dados **MySQL**, para controle de **EPIs (Equipamentos de Proteção Individual)**, **usuários**, **empréstimos** e **devoluções**.

---

## 📋 Funcionalidades

- Cadastro, listagem, atualização e exclusão de:
  - ✅ Usuários
  - 🧤 EPIs
  - 📄 Empréstimos
  - 🔁 Devoluções

- Conexão com banco de dados via JDBC  
- Menu de console (linha de comando) para interações

---

## 🧱 Tecnologias utilizadas

- Java (JDK 8+)
- JDBC (Driver do MySQL)
- MySQL (Banco de dados)
- IDE recomendada: IntelliJ, NetBeans ou Eclipse

---

## 🛠️ Requisitos

- JDK instalado
- MySQL Server ativo
- Driver JDBC do MySQL (`mysql-connector-java`) adicionado ao classpath
- Banco de dados com a seguinte estrutura:

---

### 💽 Script SQL para criar o banco de dados

- Arquivo SQL para adicionar o banco de dados controle_epi

- CREATE TABLE usuario (
    - id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    - nome VARCHAR(100) NOT NULL,
    - email VARCHAR(100) UNIQUE NOT NULL,
    - senha VARCHAR(255) NOT NULL,
    - perfil ENUM('administrador', 'colaborador', 'gerente') NOT NULL
- );

- CREATE TABLE epi (
    - id_epi INT AUTO_INCREMENT PRIMARY KEY,
    - nome VARCHAR(100) NOT NULL,
    - quantidade INT NOT NULL
- );

- CREATE TABLE emprestimo (
    - id_emprestimo INT AUTO_INCREMENT PRIMARY KEY,
    - id_usuario INT NOT NULL,
    - id_epi INT NOT NULL,
    - data_retirada DATETIME NOT NULL,
    - data_prevista_devolucao DATETIME NOT NULL,
    - confirmacao_retirada TINYINT(1) NOT NULL,
    - FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
    - FOREIGN KEY (id_epi) REFERENCES epi(id_epi)
- );

- CREATE TABLE devolucao (
    - id_devolucao INT AUTO_INCREMENT PRIMARY KEY,
    - id_emprestimo INT NOT NULL,
    - data_devolucao DATETIME NOT NULL,
    - FOREIGN KEY (id_emprestimo) REFERENCES emprestimo(id_emprestimo)
- );

---

## 📁 Estrutura do Projeto

- ControleEPI_ComBanco/
- ├── Main.java
- ├── Conexao.java
- ├── controle_epi.sql
- ├── EPI.java
- ├── EPIDao.java
- ├── Usuario.java
- ├── UsuarioDao.java
- ├── Emprestimo.java
- ├── EmprestimoDao.java
- ├── Devolucao.java
- ├── DevolucaoDao.java

---

### ▶️ Como executar

- Execute a classe Principal.java (ou Main.java), que é o ponto de entrada da aplicação.
- Certifique-se de que o banco de dados está criado e rodando.
- O sistema irá pedir para você escolher a operação desejada no menu interativo:
- Cadastro de usuários
- Cadastro de EPIs
- Empréstimo de EPIs
- Devolução de EPIs
- Consulta e alteração de registros

---

### ⚠️ Observações

- Os IDs são auto incrementados, então ao inserir registros, não é necessário informar o ID manualmente.
- O projeto usa Scanner para entrada de dados.
- Este é um projeto de terminal, ideal para fins acadêmicos ou aprendizado.

---

### Contribuições
Se você deseja contribuir para este projeto, sinta-se à vontade para abrir issues ou enviar pull requests. Certifique-se de seguir as convenções de código do Java e de testar bem antes de enviar.
