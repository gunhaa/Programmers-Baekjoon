-- 코드를 입력하세요
SELECT COUNT(DISTINCT NAME)
FROM ANIMAL_INS
WHERE ANIMAL_INS.NAME IS NOT NULL;