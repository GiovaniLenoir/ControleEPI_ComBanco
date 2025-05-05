# ControleEPI_ComBanco

# Controle de EPIs com Banco de Dados
Este projeto visa a gestão de EPIs (Equipamentos de Proteção Individual) em uma empresa, permitindo o controle de empréstimos, devoluções, usuários e cadastro de EPIs. Utiliza banco de dados MySQL para armazenar informações sobre usuários, EPIs, empréstimos e devoluções.

# Funcionalidades
Cadastro de EPIs (Equipamentos de Proteção Individual)

Cadastro de usuários (colaboradores)

Empréstimos de EPIs para usuários

Devolução de EPIs

Consulta, atualização e exclusão de EPIs, usuários e empréstimos

# Tecnologias
Linguagem: Java

Banco de Dados: MySQL

JDBC para conexão com o banco de dados

# Estrutura do Projeto
-Classes principais:

Usuario: Representa os usuários da aplicação.

EPI: Representa os EPIs cadastrados no sistema.

Emprestimo: Representa o empréstimo de um EPI para um usuário.

Devolucao: Representa a devolução de um EPI emprestado.

Conexao: Classe responsável pela conexão com o banco de dados MySQL.

UsuarioDao, EPIDao, EmprestimoDao, DevolucaoDao: Classes de acesso ao banco de dados para manipulação de registros.

-Banco de Dados:

Tabelas:

usuario: Armazena informações sobre os usuários.

epi: Armazena informações sobre os EPIs.

emprestimo: Armazena informações sobre os empréstimos de EPIs.

devolucao: Armazena informações sobre as devoluções de EPIs.

# Instalação
-Pré-requisitos
Java 8 ou superior

MySQL

IDE de desenvolvimento como IntelliJ IDEA, Eclipse ou NetBeans

# Passos para executar
-Configuração do banco de dados:

Crie um banco de dados MySQL com o nome controle_epi.

Crie as tabelas necessárias. Aqui estão as instruções SQL para criar as tabelas:

-sql

CREATE TABLE usuario (

    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    
    nome VARCHAR(100) NOT NULL,
    
    email VARCHAR(100) NOT NULL,
    
    senha VARCHAR(100) NOT NULL,
    
    perfil VARCHAR(50) NOT NULL
    
);

CREATE TABLE epi (

    id INT AUTO_INCREMENT PRIMARY KEY,
    
    nome VARCHAR(100) NOT NULL,
    
    validade DATE NOT NULL
    
);


CREATE TABLE emprestimo (

    id_emprestimo INT AUTO_INCREMENT PRIMARY KEY,
    
    id_colaborador INT,
    
    id_epi INT,
    
    data_emprestimo DATE,
    
    FOREIGN KEY (id_colaborador) REFERENCES usuario(id_usuario),
    
    FOREIGN KEY (id_epi) REFERENCES epi(id)
    
);

CREATE TABLE devolucao (

    id_devolucao INT AUTO_INCREMENT PRIMARY KEY,
    
    id_emprestimo INT,
    
    data_devolucao DATE,
    
    FOREIGN KEY (id_emprestimo) REFERENCES emprestimo(id_emprestimo)
    
);
# Configuração do projeto:

Baixe ou clone o repositório do projeto.

Importe o projeto para sua IDE de preferência.

Configure as credenciais do banco de dados na classe Conexao.java (se necessário, altere a URL, usuário e senha do MySQL).

# Rodando o projeto:

Execute a classe Principal.java (ou Main.java), que é o ponto de entrada da aplicação.

O sistema irá pedir para você escolher a operação desejada no menu interativo:

Cadastro de usuários

Cadastro de EPIs

Empréstimo de EPIs

Devolução de EPIs

Consulta e alteração de registros

# Exemplo de Uso
-Cadastro de um novo usuário:

Digite o nome do usuário: João Silva

Digite o e-mail do usuário: joao@empresa.com

Digite a senha do usuário: 123456

Digite o perfil do usuário: Colaborador

-Cadastro de um novo EPI:

Digite o nome do EPI: Capacete

Digite a validade do EPI (formato yyyy-MM-dd): 2026-05-01

-Empréstimo de EPI:

Digite o ID do colaborador: 1

Digite o ID do EPI: 2

Digite a data do empréstimo (formato yyyy-MM-dd): 2025-05-01

-Devolução de EPI:

Digite o ID do empréstimo: 1

Digite a data de devolução (formato yyyy-MM-dd): 2025-05-15

# Contribuições
Se você deseja contribuir para este projeto, sinta-se à vontade para abrir issues ou enviar pull requests. Certifique-se de seguir as convenções de código do Java e de testar bem antes de enviar.
