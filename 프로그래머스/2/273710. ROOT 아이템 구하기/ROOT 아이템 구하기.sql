SELECT A.ITEM_ID, A.ITEM_NAME
FROM ITEM_INFO A
    INNER JOIN ITEM_TREE B ON A.ITEM_ID = B.ITEM_ID
WHERE B.PARENT_ITEM_ID IS NULL