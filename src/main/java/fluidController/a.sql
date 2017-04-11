SELECT *
FROM (SELECT *
      FROM (SELECT
              sum(total_qty)  AS storer_day_total,
              storer_id,
              CASE storer_id
              WHEN 238
                THEN '蘑菇优选'
              WHEN 4574508
                THEN '美大大'
              WHEN 5074502
                THEN '美丽优选' END  AS name,
              FROM_UNIXTIME(create_time / 1000, '%Y-%m-%d') AS days
            FROM t_wms_qc_header
            WHERE
              `create_time` < 1490889600000 AND 1490371200000 < `create_time` AND storer_id IN (238, 4574508, 5074502)
            GROUP BY days, storer_id) AS a) LEFT JOIN
  (SELECT *
   FROM (SELECT
           sum(total_qty) AS day_total,
           FROM_UNIXTIME(create_time / 1000, '%Y-%m-%d') AS days
         FROM t_wms_qc_header
         WHERE `create_time` < 1490889600000 AND 1490371200000 < `create_time`
         GROUP BY days) AS b) ON a.days = b.days



-- 按天聚合  多个字段