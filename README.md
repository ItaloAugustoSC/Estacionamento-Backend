# Estacionamento-Backend


## Script para criação do banco de dados

CREATE TABLE acesso (
    hr_entrada       DATE NOT NULL,
    hr_saida         DATE,
    status_pagamento CHAR(1),
    placa_carro      VARCHAR2(7) NOT NULL,
    modalidade_plano VARCHAR2(15) NOT NULL,
    id_funcionario   NUMBER(10) NOT NULL
);

ALTER TABLE acesso ADD CONSTRAINT acesso_pk PRIMARY KEY ( placa_carro );

CREATE TABLE carro (
    placa            VARCHAR2(7) NOT NULL,
    chave_no_local   CHAR(1),
    cpf_cliente      NUMBER(11) NOT NULL,
    plano_modalidade VARCHAR2(15) NOT NULL
);

ALTER TABLE carro ADD CONSTRAINT carro_pk PRIMARY KEY ( placa );

CREATE TABLE cliente (
    nome    VARCHAR2(50) NOT NULL,
    cpf     NUMBER(11) NOT NULL,
    celular NUMBER(11)
);

ALTER TABLE cliente ADD CONSTRAINT cliente_pk PRIMARY KEY ( cpf );

CREATE TABLE funcionario (
    id    NUMBER(10) NOT NULL,
    cargo VARCHAR2(20)
);

ALTER TABLE funcionario ADD CONSTRAINT funcionario_pk PRIMARY KEY ( id );

CREATE TABLE plano (
    valor_hora NUMBER(3, 2) NOT NULL,
    modalidade VARCHAR2(15) NOT NULL,
    tempo      VARCHAR2(20) NOT NULL
);

ALTER TABLE plano ADD CONSTRAINT plano_pk PRIMARY KEY ( modalidade );

ALTER TABLE acesso
    ADD CONSTRAINT acesso_funcionario_fk FOREIGN KEY ( id_funcionario )
        REFERENCES funcionario ( id );

ALTER TABLE carro
    ADD CONSTRAINT carro_plano_fk FOREIGN KEY ( plano_modalidade )
        REFERENCES plano ( modalidade );

ALTER TABLE carro
    ADD CONSTRAINT id_cliente FOREIGN KEY ( cpf_cliente )
        REFERENCES cliente ( cpf );

ALTER TABLE acesso
    ADD CONSTRAINT placa FOREIGN KEY ( placa_carro )
        REFERENCES carro ( placa );

ALTER TABLE acesso
    ADD CONSTRAINT planov1 FOREIGN KEY ( modalidade_plano )
        REFERENCES plano ( modalidade );
