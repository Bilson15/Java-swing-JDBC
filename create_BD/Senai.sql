CREATE TABLE CLIENTES(
    CLI_CPF NUMBER(10,2),
    CLI_NOME VARCHAR(200),
    CLI_DATA_NASCIMENTO VARCHAR(200),
    CLI_CONTATO VARCHAR(200),
    CONSTRAINT CLI_FK PRIMARY KEY (CLI_CPF)
);

CREATE TABLE PRODUTO(
    PRO_ID NUMBER,
    PRO_NOME VARCHAR(100),
    PRO_PRECO NUMERIC(8,2),
    CONSTRAINT PRO_PK PRIMARY KEY (PRO_ID)
);
CREATE TABLE PEDIDO(
    PED_NUM NUMBER,
    PED_DATA VARCHAR(50),
    PED_CLI_CPF NUMBER,
    CONSTRAINT PED_PK PRIMARY KEY (PED_NUM),
    CONSTRAINT PED_CLI_FK FOREIGN KEY (PED_CLI_CPF) REFERENCES CLIENTES (CLI_CPF)
);

CREATE TABLE ITEM_PEDIDO(
    ITEM_PED_QUANTIDADE NUMBER,
    ITEM_PED_PORC_DESCO NUMBER,
    ITEM_PED_PROD_COD NUMBER,
    ITEM_PED_PED_NUM NUMBER,
    CONSTRAINT ITEM_PED_PROD_FK FOREIGN KEY (ITEM_PED_PROD_COD) REFERENCES PRODUTO (PRO_ID),
    CONSTRAINT ITEM_PED_PED_FK FOREIGN KEY (ITEM_PED_PED_NUM) REFERENCES PEDIDO (PED_NUM)
);
