SELECT FLAVOR
FROM (
    SELECT FLAVOR, SUM(TOTAL_ORDER) AS TOTAL_ORDERS
    FROM (
        SELECT FLAVOR, TOTAL_ORDER FROM JULY
        UNION ALL
        SELECT FLAVOR, TOTAL_ORDER FROM FIRST_HALF
    ) AS combined_table
    GROUP BY FLAVOR
    ORDER BY TOTAL_ORDERS DESC
) AS top_flavors
LIMIT 3;