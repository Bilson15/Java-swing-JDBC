--------------------------------------------------------
--  Arquivo criado - Terça-feira-Agosto-31-2021   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Function NOME_CLIENTE_PEDIDOS
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE FUNCTION "BILSON"."NOME_CLIENTE_PEDIDOS" RETURN SYS_REFCURSOR
    IS
    SAIDA SYS_REFCURSOR;
 BEGIN
    OPEN SAIDA FOR
        SELECT CLI_NOME, COUNT(PED_NUM)
        FROM CLIENTES INNER JOIN PEDIDO ON CLI_CPF = PED_CLI_CPF
        GROUP BY CLI_NOME;                         
    RETURN SAIDA;          
END NOME_CLIENTE_PEDIDOS;

/
--------------------------------------------------------
--  DDL for Function PEDIDO_VALOR_MAIOR_MEDIA
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE FUNCTION "BILSON"."PEDIDO_VALOR_MAIOR_MEDIA" RETURN SYS_REFCURSOR
    IS
    SAIDA SYS_REFCURSOR;
 BEGIN
    OPEN SAIDA FOR
        SELECT CLI_NOME, PED_NUM, SUM(PRO_PRECO * ITEM_PED_QUANTIDADE) AS TOTAL_PEDIDO
        FROM PEDIDO INNER JOIN ITEM_PEDIDO ON PED_NUM = ITEM_PED_PED_NUM
        INNER JOIN PRODUTO ON PRO_ID = ITEM_PED_PROD_COD
        INNER JOIN CLIENTES ON CLI_CPF = PED_CLI_CPF
        WHERE PRO_PRECO * ITEM_PED_QUANTIDADE > (SELECT AVG(PRO_PRECO * ITEM_PED_QUANTIDADE)
            FROM PEDIDO INNER JOIN ITEM_PEDIDO ON PED_NUM = ITEM_PED_PED_NUM
            INNER JOIN PRODUTO ON PRO_ID = ITEM_PED_PROD_COD
        )
        GROUP BY CLI_NOME, PED_NUM;          
    RETURN SAIDA;          
END PEDIDO_VALOR_MAIOR_MEDIA;

/
--------------------------------------------------------
--  DDL for Function PRODUTO_ESTOQUE_MENOR_10
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE FUNCTION "BILSON"."PRODUTO_ESTOQUE_MENOR_10" RETURN SYS_REFCURSOR
    IS
    SAIDA SYS_REFCURSOR;
 BEGIN
    OPEN SAIDA FOR
        SELECT PRO_ID, PRO_NOME, ITEM_EST_QUANTIDADE
        FROM PRODUTO INNER JOIN ITEM_ESTOQUE ON PRO_ID = ITEM_EST_PRODUTO
        WHERE ITEM_EST_QUANTIDADE <= 10;
    RETURN SAIDA;          
END PRODUTO_ESTOQUE_MENOR_10;

/
--------------------------------------------------------
--  DDL for Function PRODUTO_MAIS_VENDIDO
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE FUNCTION "BILSON"."PRODUTO_MAIS_VENDIDO" RETURN SYS_REFCURSOR
    IS
    SAIDA SYS_REFCURSOR;
    BEGIN
        OPEN SAIDA FOR
            SELECT PRO_NOME, PRO_PRECO, TOTAL
            FROM (
                    SELECT * 
                    FROM PRODUTO INNER JOIN 
                        (
                            SELECT ITEM_PED_PROD_COD, SUM(ITEM_PED_QUANTIDADE) AS TOTAL
                            FROM ITEM_PEDIDO
                            GROUP BY ITEM_PED_PROD_COD
                        ) ON PRO_ID = ITEM_PED_PROD_COD
                    )
                         WHERE TOTAL IN 
                            (
                                SELECT MAX(TOTAL) 
                                FROM PRODUTO INNER JOIN 
                                    (
                                        SELECT ITEM_PED_PROD_COD, SUM(ITEM_PED_QUANTIDADE) AS TOTAL
                                        FROM ITEM_PEDIDO
                                        GROUP BY ITEM_PED_PROD_COD
                                    ) ON PRO_ID = ITEM_PED_PROD_COD
                            );
            RETURN SAIDA;
END PRODUTO_MAIS_VENDIDO; 

/
--------------------------------------------------------
--  DDL for Function PRODUTO_MENOS_VENDIDO
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE FUNCTION "BILSON"."PRODUTO_MENOS_VENDIDO" RETURN SYS_REFCURSOR
    IS
    SAIDA SYS_REFCURSOR;
 BEGIN
    OPEN SAIDA FOR
        SELECT PRO_NOME, PRO_PRECO, TOTAL
        FROM (
                SELECT * 
                FROM PRODUTO INNER JOIN 
                    (
                        SELECT ITEM_PED_PROD_COD, SUM(ITEM_PED_QUANTIDADE) AS TOTAL
                        FROM ITEM_PEDIDO
                        GROUP BY ITEM_PED_PROD_COD
                    ) ON PRO_ID = ITEM_PED_PROD_COD
                )
                     WHERE TOTAL IN 
                        (
                            SELECT MIN(TOTAL) 
                            FROM PRODUTO INNER JOIN 
                                (
                                    SELECT ITEM_PED_PROD_COD, SUM(ITEM_PED_QUANTIDADE) AS TOTAL
                                    FROM ITEM_PEDIDO
                                    GROUP BY ITEM_PED_PROD_COD
                                ) ON PRO_ID = ITEM_PED_PROD_COD
                        );                        
    RETURN SAIDA;          
END PRODUTO_MENOS_VENDIDO;

/
--------------------------------------------------------
--  DDL for Function TOTAL_PEDIDO
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE FUNCTION "BILSON"."TOTAL_PEDIDO" RETURN SYS_REFCURSOR
    IS
    SAIDA SYS_REFCURSOR;
 BEGIN
    OPEN SAIDA FOR
        SELECT CLI_NOME,PED_NUM, SUM(PRO_PRECO * ITEM_PED_QUANTIDADE) AS TOTAL_PEDIDO
        FROM PEDIDO INNER JOIN ITEM_PEDIDO ON PED_NUM = ITEM_PED_PED_NUM
            INNER JOIN PRODUTO ON PRO_ID = ITEM_PED_PROD_COD
            INNER JOIN CLIENTES ON CLI_CPF = PED_CLI_CPF
        GROUP BY CLI_NOME, PED_NUM
        ORDER BY TOTAL_PEDIDO;             
    RETURN SAIDA;          
END TOTAL_PEDIDO;

/
--------------------------------------------------------
--  DDL for Function VALOR_TOTAL_VENDIDO_PRODUTO
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE FUNCTION "BILSON"."VALOR_TOTAL_VENDIDO_PRODUTO" RETURN SYS_REFCURSOR
    IS
    SAIDA SYS_REFCURSOR;
 BEGIN
    OPEN SAIDA FOR
        SELECT PRO_ID, PRO_NOME, SUM(PRO_PRECO * ITEM_PED_QUANTIDADE) AS SOMA
        FROM PRODUTO INNER JOIN ITEM_PEDIDO ON PRO_ID = ITEM_PED_PROD_COD
        GROUP BY PRO_NOME, PRO_ID;
    RETURN SAIDA;          
END VALOR_TOTAL_VENDIDO_PRODUTO;

/
