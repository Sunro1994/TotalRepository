-- 코드를 입력하세요
SELECT 
A.PRODUCT_ID,
A.PRODUCT_NAME, 
SUM(A.PRICE*B.AMOUNT)                  AS TOTAL_SALES
FROM 
(SELECT * FROM FOOD_PRODUCT WHERE PRICE IS NOT NULL) A 
JOIN 
(SELECT * FROM FOOD_ORDER WHERE PRODUCE_DATE IS NOT NULL AND TO_CHAR(PRODUCE_DATE,'YYYY-MM') = '2022-05')  B
ON A.PRODUCT_ID = B.PRODUCT_ID
GROUP BY A.PRODUCT_ID, A.PRODUCT_NAME
ORDER BY TOTAL_SALES DESC, A.PRODUCT_ID ASC