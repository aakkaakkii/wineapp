insert into usrs(id, username, password, active, blocked)
values (nextval('usrs_id_seq'), 'admin', 'admin', true, false);

insert into user_permission(user_id, permission_id)
values (1, 1), (1, 2);