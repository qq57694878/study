CREATE OR REPLACE FUNCTION F_GETNID RETURN CHAR
IS
GUID CHAR(32);
BEGIN
     GUID := SYS_GUID();
     RETURN 'DB121207' || GUID;
END;