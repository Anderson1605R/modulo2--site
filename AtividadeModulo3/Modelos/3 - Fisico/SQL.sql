-- Gera��o de Modelo f�sico
-- Sql ANSI 2003 - brModelo.


CREATE TABLE User (
    Id_user INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50),
    cpf_unico VARCHAR(20) UNIQUE,
    email VARCHAR(50), 
);

CREATE TABLE Pacote (
    ID_pacote INT AUTO_INCREMENT PRIMARY KEY,
    destino VARCHAR(50),
    preco DECIMAL(10,2),
    promocao_boolean BOOLEAN
);

CREATE TABLE Compra (
    Id_compra INT AUTO_INCREMENT PRIMARY KEY,
    Id_user INT,
    ID_pacote INT,
    FOREIGN KEY (Id_user) REFERENCES User (Id_user),
    FOREIGN KEY (ID_pacote) REFERENCES Pacote (ID_pacote)

);