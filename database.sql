CREATE DATABASE jpa_treinamento OWNER postgres;

CREATE SEQUENCE sq_pessoa;

CREATE SEQUENCE sq_cliente;

CREATE SEQUENCE sq_item;

CREATE SEQUENCE sq_order;


CREATE TABLE pessoa 
(
	 id                 		bigint  PRIMARY KEY,
    	codigo       		varchar(14) NOT NULL UNIQUE,
    	tipo             		char(1) NOT NULL,
    	nome          		varchar(200) NOT NULL,
    	data_nascimento         timestamp without time zone,
    	nome_fantasia		varchar(200)
);


CREATE TABLE cliente
(
    	id 			bigint  PRIMARY KEY,
    	login			varchar(50) NOT NULL,
    	email			varchar(100) UNIQUE NOT NULL,
    	pessoa_id		bigint NOT NULL  REFERENCES pessoa (id),
    	password		varchar(10)
);

CREATE TABLE item (
	 id 			bigint  PRIMARY KEY,
	 codigo		char(36) NOT NULL UNIQUE,
	 nome 			varchar(200) NOT NULL,
	 valor			numeric(9,2) NOT NULL
);


CREATE TABLE order_
(
	id 			bigint  PRIMARY KEY,
	cliente_id		bigint NOT NULL REFERENCES cliente (id),
	valor			numeric(9,2) NOT NULL,
	data_compra  		timestamp without time zone NOT NULL,
	status_pagamento	char(2) NOT NULL
);

CREATE TABLE order_item 
(
	order_id 	bigint NOT NULL REFERENCES order_ (id),
	item_id 	bigint NOT NULL REFERENCES item (id),
	valor		numeric(9,2) NOT NULL,
	quantidade	integer NOT NULL,
	CONSTRAINT code_title PRIMARY KEY(order_id, item_id)
);

INSERT INTO item
VALUES (nextval('sq_item'), '03323817-4f40-4258-a7a9-86894c2a44b9', 'Notebook HP Inspiron', 2500.32),
                   (nextval('sq_item'), '3bd4798a-89c7-419d-96a1-57bc397193de', 'Smartphone Motorola G5',  849.90),
                   (nextval('sq_item'), '162a1b6d-8db3-4d46-9150-17176c1fd9e8', 'Smart TV LED 49" UHD Samsung', 2200.00),
                   (nextval('sq_item'), '13e339d0-bd24-48a5-896b-fac916da7bf6', 'Ar Condicionado Philco Split', 1049.00);


INSERT INTO pessoa
VALUES (nextval('sq_pessoa'), '04654734000145', 'J', 'S2IT SOLUTIONS CONSULTORIA LTDA', null, 'S2IT'),
	    (nextval('sq_pessoa'),'11111111111', 'F', 'VICTOR MACHADO PASQUALINO', '17-01-1988', null);
