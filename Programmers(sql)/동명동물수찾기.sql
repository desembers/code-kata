SELECT NAME ,COUNT(*) COUNT 
FROM ANIMAL_INS 
WHERE NAME is not null
GROUP BY NAME
HAVING COUNT(*) >= 2
ORDER BY NAME;