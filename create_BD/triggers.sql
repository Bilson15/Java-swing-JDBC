--------------------------------------------------------
--  Arquivo criado - Terça-feira-Agosto-31-2021   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Trigger CALCULA_COMISSAO
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "BILSON"."CALCULA_COMISSAO" 
    AFTER INSERT ON ITEM_PEDIDO
  FOR EACH ROW
  DECLARE
    COMISSAO NUMBER;
    PRECO_ITEM NUMBER;
    PRECO NUMBER;
    VENDEDOR NUMBER := NULL;
  BEGIN
        SELECT PED_VEN_MAT INTO VENDEDOR FROM PEDIDO WHERE PED_NUM = :NEW.ITEM_PED_PED_NUM;

        IF(VENDEDOR IS NOT NULL) THEN
            SELECT PRO_PRECO INTO PRECO FROM PRODUTO WHERE PRO_ID = :NEW.ITEM_PED_PROD_COD;
            PRECO_ITEM := (PRECO - (:NEW.ITEM_PED_PORC_DESCO * PRECO / 100)) * :NEW.ITEM_PED_QUANTIDADE;
            COMISSAO := (0.05 * PRECO_ITEM); 

            UPDATE PEDIDO SET PED_COMISSAO = COALESCE(PED_COMISSAO,0) + COMISSAO where PED_NUM = :NEW.ITEM_PED_PED_NUM;
        ELSE 
            UPDATE PEDIDO SET PED_COMISSAO = 0 where PED_NUM = :OLD.ITEM_PED_PED_NUM;
        END IF;

    end;
/
ALTER TRIGGER "BILSON"."CALCULA_COMISSAO" ENABLE;
--------------------------------------------------------
--  DDL for Trigger CALCULA_COMISSAO_DELETE
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "BILSON"."CALCULA_COMISSAO_DELETE" 
    AFTER DELETE ON ITEM_PEDIDO
  FOR EACH ROW
  DECLARE
  BEGIN
    UPDATE PEDIDO SET PED_COMISSAO = 0 where PED_NUM = :OLD.ITEM_PED_PED_NUM;     
    end; 
/
ALTER TRIGGER "BILSON"."CALCULA_COMISSAO_DELETE" ENABLE;
--------------------------------------------------------
--  DDL for Trigger GERA_DATA_PEDIDO_ID
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "BILSON"."GERA_DATA_PEDIDO_ID" 
  BEFORE INSERT ON PEDIDO
  FOR EACH ROW
  BEGIN
        :NEW.PED_DATA := SYSDATE;
    end;
/
ALTER TRIGGER "BILSON"."GERA_DATA_PEDIDO_ID" ENABLE;
--------------------------------------------------------
--  DDL for Trigger GERA_ITEM_ESTOQUE
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "BILSON"."GERA_ITEM_ESTOQUE" 
    AFTER INSERT ON PRODUTO
    FOR EACH ROW
    BEGIN
        INSERT INTO ITEM_ESTOQUE(ITEM_EST_QUANTIDADE, ITEM_EST_EST_ID, ITEM_EST_PRODUTO) VALUES (0, 1, :NEW.PRO_ID);
    END;
/
ALTER TRIGGER "BILSON"."GERA_ITEM_ESTOQUE" ENABLE;
--------------------------------------------------------
--  DDL for Trigger GERA_ITEM_ESTOQUE_ID
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "BILSON"."GERA_ITEM_ESTOQUE_ID" 
  BEFORE INSERT ON ITEM_ESTOQUE
  FOR EACH ROW
  BEGIN
  select SEQ_ITEM_PEDIDO_ID.nextval into :new.ITEM_EST_COD from dual;
end;
/
ALTER TRIGGER "BILSON"."GERA_ITEM_ESTOQUE_ID" ENABLE;
--------------------------------------------------------
--  DDL for Trigger GERA_MAT_VENDEDOR
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "BILSON"."GERA_MAT_VENDEDOR" 
    BEFORE INSERT ON VENDEDOR
    FOR EACH ROW
    BEGIN
        select SEQ_VENDEDOR_MAT.nextval into :new.VEN_MAT from dual;
    END;
/
ALTER TRIGGER "BILSON"."GERA_MAT_VENDEDOR" ENABLE;
--------------------------------------------------------
--  DDL for Trigger GERA_PEDIDO_ID
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "BILSON"."GERA_PEDIDO_ID" 
  BEFORE INSERT ON PEDIDO
  FOR EACH ROW
  BEGIN
  select SEQ_PEDIDO_ID.nextval into :new.PED_NUM from dual;
end;
/
ALTER TRIGGER "BILSON"."GERA_PEDIDO_ID" ENABLE;
--------------------------------------------------------
--  DDL for Trigger GERA_PRODUTO_ID
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "BILSON"."GERA_PRODUTO_ID" 
  BEFORE INSERT ON PRODUTO
  FOR EACH ROW
  BEGIN
  select SEQ_PRODUTO_ID.nextval into :new.PRO_ID from dual;
end;
/
ALTER TRIGGER "BILSON"."GERA_PRODUTO_ID" ENABLE;
--------------------------------------------------------
--  DDL for Trigger VERIFICA_ESTOQUE
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "BILSON"."VERIFICA_ESTOQUE" 
  BEFORE INSERT OR UPDATE ON ITEM_PEDIDO
  FOR EACH ROW
  DECLARE
    MSG_ERRO VARCHAR2(200);
    QUANTIDADE NUMBER;
  BEGIN
        SELECT ITEM_EST_QUANTIDADE INTO QUANTIDADE FROM ITEM_ESTOQUE WHERE item_est_produto = :NEW.item_ped_prod_cod;

        IF QUANTIDADE < :NEW.ITEM_PED_QUANTIDADE THEN
        MSG_ERRO := 'ACABOU O ESTOQUE';
        RAISE_APPLICATION_ERROR(-20999,MSG_ERRO);
        ELSE 
        UPDATE ITEM_ESTOQUE SET item_estoque.item_est_quantidade = item_estoque.item_est_quantidade - :new.ITEM_PED_QUANTIDADE where item_est_produto = :new.ITEM_PED_PROD_COD;
        END IF;
    end;
/
ALTER TRIGGER "BILSON"."VERIFICA_ESTOQUE" ENABLE;
--------------------------------------------------------
--  DDL for Trigger VERIFICA_ESTOQUE_DELETE
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "BILSON"."VERIFICA_ESTOQUE_DELETE" 
  AFTER DELETE ON ITEM_PEDIDO
  FOR EACH ROW
  DECLARE
    QUANTIDADE NUMBER;
  BEGIN
        SELECT ITEM_EST_QUANTIDADE INTO QUANTIDADE FROM ITEM_ESTOQUE WHERE item_est_produto = :OLD.item_ped_prod_cod;
        UPDATE ITEM_ESTOQUE SET item_estoque.item_est_quantidade = item_estoque.item_est_quantidade + :OLD.ITEM_PED_QUANTIDADE where item_est_produto = :OLD.ITEM_PED_PROD_COD;

    end;
/
ALTER TRIGGER "BILSON"."VERIFICA_ESTOQUE_DELETE" ENABLE;
--------------------------------------------------------
--  DDL for Trigger VERIFICA_SALARIO
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "BILSON"."VERIFICA_SALARIO" 
    BEFORE INSERT OR UPDATE
    OF SALARIO, COMISSAO ON FUNCIONARIO
    FOR EACH ROW
    DECLARE
        MSG_ERRO VARCHAR2(200);
    BEGIN
        IF:NEW.COMISSAO + :NEW.SALARIO > 10000 THEN
        MSG_ERRO := :OLD.NOME || ' ESTÁ RECEBENDO ACIMA DO TETO SALARIAL';
        RAISE_APPLICATION_ERROR(-20999,MSG_ERRO);
        END IF;
    END;
/
ALTER TRIGGER "BILSON"."VERIFICA_SALARIO" ENABLE;
