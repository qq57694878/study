CREATE OR REPLACE PROCEDURE TEST(
  V_NAMES OUT VARCHAR2
)
AS
  ID VARCHAR2(100);
  CURSOR C1 IS
    SELECT* FROM CITY;
  V_DATA C1%ROWTYPE;

  BEGIN
    OPEN  C1;
    FETCH C1 INTO V_DATA;
    WHILE C1%FOUND LOOP
      V_NAMES := V_NAMES||V_DATA.NAME;
      FETCH C1 INTO V_DATA;
    END LOOP;
    CLOSE C1;

  END;


CREATE OR REPLACE PROCEDURE UP_TEST(C_V1 OUT SYS_REFCURSOR)IS
  BEGIN
    OPEN C_V1 FOR SELECT * FROM CITY;
  END;

CREATE OR REPLACE PROCEDURE  up_getData
IS
  TYPE C_TYPE IS TABLE OF CITY%ROWTYPE;
  V_DATA C_TYPE;
  C_V2 SYS_REFCURSOR;

  BEGIN
    up_test(v);
    fetch C_V2 bulk collect into V_DATA;
    for i in 1..V_DATA.count loop
      dbms_output.put_line('字段1：'||V_DATA(i).ID || ' 字段2：' || V_DATA(i).NAME);
    end loop;
  END;