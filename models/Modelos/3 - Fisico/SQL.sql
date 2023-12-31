-- Gera��o de Modelo f�sico
-- Sql ANSI 2003 - brModelo.


CREATE TABLE User (
    Id_user INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    cpf_unico VARCHAR(20) UNIQUE NOT NULL,
    email VARCHAR(50) NOT NULL,
    senha VARCHAR(50) NOT NULL
 );

CREATE TABLE Pacote (
    ID_pacote INT AUTO_INCREMENT PRIMARY KEY,
    destino VARCHAR(50) NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    promocao_boolean BOOLEAN NOT NULL
);

CREATE TABLE Compra (
    Id_compra INT AUTO_INCREMENT PRIMARY KEY,
    Id_user INT,
    ID_pacote INT,
    FOREIGN KEY (Id_user) REFERENCES User (Id_user),
    FOREIGN KEY (ID_pacote) REFERENCES Pacote (ID_pacote)

);