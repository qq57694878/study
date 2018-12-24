DROP FUNCTION IF EXISTS queryChildrenAreaInfo;
CREATE FUNCTION queryChildrenAreaInfo(areaId INT)
RETURNS VARCHAR(4000)
BEGIN
DECLARE sTemp VARCHAR(4000);
DECLARE sTempChd VARCHAR(4000);

SET sTemp='$';
SET sTempChd = CAST(areaId AS CHAR);

WHILE sTempChd IS NOT NULL DO
SET sTemp= CONCAT(sTemp,',',sTempChd);
SELECT GROUP_CONCAT(id) INTO sTempChd FROM t_areainfo WHERE FIND_IN_SET(parentId,sTempChd)>0;
END WHILE;
RETURN sTemp;
END;



SELECT CATALOG_CODE,CATALOG_NAME,CATALOG_LEVEL,CATALOG_PID
FROM (
       SELECT
         @r AS _id,
         (SELECT @r := CATALOG_PID FROM gs_sku_catalog WHERE id = _id) AS parent_id,
         @l := @l + 1 AS lvl
       FROM
         (SELECT @r := 11, @l := 0) vars,
         gs_sku_catalog h
       WHERE @r <> 0) T1
  JOIN gs_sku_catalog T2
    ON T1._id = T2.id
ORDER BY id;