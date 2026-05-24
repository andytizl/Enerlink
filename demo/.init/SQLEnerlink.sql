CREATE DATABASE ENERLINK;

USE ENERLINK;

CREATE TABLE Usuarios (
    id VARCHAR(36) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    telefone VARCHAR(20),
    tipo_usuario VARCHAR(20) NOT NULL
);

CREATE TABLE Empresas (
    id VARCHAR(36) PRIMARY KEY,
    usuario_id VARCHAR(36) NOT NULL,
    cnpj VARCHAR(18) UNIQUE NOT NULL,
    nome_empresa VARCHAR(100) NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES Usuarios(id) ON DELETE CASCADE
);

CREATE TABLE Consultores (
    id VARCHAR(36) PRIMARY KEY,
    usuario_id VARCHAR(36) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    especialidade VARCHAR(100),
    avaliacao_media DECIMAL(5, 2) DEFAULT 0.00,
    FOREIGN KEY (usuario_id) REFERENCES Usuarios(id) ON DELETE CASCADE
);

CREATE TABLE Projetos (
    id VARCHAR(36) PRIMARY KEY,
    empresa_id VARCHAR(36) NOT NULL,
    titulo VARCHAR(150) NOT NULL,
    descricao TEXT,
    localizacao VARCHAR(100),
    status VARCHAR(30) DEFAULT 'Aberto',
    data_publicacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (empresa_id) REFERENCES Empresas(id) ON DELETE CASCADE
);

CREATE TABLE Propostas (
    id VARCHAR(36) PRIMARY KEY,
    projeto_id VARCHAR(36) NOT NULL,
    consultor_id VARCHAR(36) NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    prazo INT NOT NULL,
    descricao TEXT,
    status VARCHAR(30) DEFAULT 'Pendente',
    data_envio DATETIME DEFAULT CURRENT_TIMESTAMP,
    empresa_id VARCHAR(36) NOT NULL,
    FOREIGN KEY (projeto_id) REFERENCES Projetos(id) ON DELETE CASCADE,
    FOREIGN KEY (consultor_id) REFERENCES Consultores(id) ON DELETE CASCADE,
    FOREIGN KEY (empresa_id) REFERENCES Empresas(id) ON DELETE CASCADE
);