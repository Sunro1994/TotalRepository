-- SELECT T1.TITLE                               AS TITLE 
--      , T1.BOARD_ID                            AS BOARD_ID
--      , T2.REPLY_ID                            AS REPLY_ID
--      , T2.WRITER_ID                           AS WRITER_ID 
--      , T2.CONTENTS                            AS CONTENTS
--      , TO_CHAR(T2.CREATED_DATE, 'YYYY-MM-DD') AS CREATED_DATE
--   FROM USED_GOODS_BOARD       T1
--   JOIN USED_GOODS_REPLY       T2
--     ON T1.BOARD_ID  = T2.BOARD_ID
--    AND T2.CONTENTS != ' ' 
--  WHERE T1.CREATED_DATE >= TO_DATE('2022-10-01', 'YYYY-MM-DD')
--    AND T1.CREATED_DATE <= TO_DATE('2022-10-31', 'YYYY-MM-DD')
--  ORDER BY T2.CREATED_DATE ASC
--         , T1.TITLE        ASC ;
SELECT

        A.TITLE AS TITLE
       ,A.BOARD_ID AS BOARD_ID
       ,B.REPLY_ID AS REPLY_ID  
       ,B.WRITER_ID  AS WRITER_ID   
       ,B.CONTENTS  AS CONTENTS 
       ,TO_CHAR(B.CREATED_DATE,'YYYY-MM-DD') AS CREATED_DATE




FROM USED_GOODS_BOARD A, USED_GOODS_REPLY B

WHERE A.BOARD_ID = B.BOARD_ID
AND  TO_CHAR(A.CREATED_DATE,'YYYY-MM') = '2022-10'
ORDER BY B.CREATED_DATE ASC , A.TITLE ASC