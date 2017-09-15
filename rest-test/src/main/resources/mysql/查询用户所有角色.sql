select GROUP_CONCAT(c.role_name),a.username,a.user_id from sys_user a
LEFT JOIN sys_user_role b on a.user_id = b.user_id
LEFT JOIN sys_role c on c.role_id= b.role_id
group by a.user_id;