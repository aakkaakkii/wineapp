CREATE TABLE usrs
(
    id         bigint PRIMARY KEY,
    username   varchar(255),
    password   varchar(255),
    email      varchar(60),
    active     boolean not null ,
    blocked    boolean not null ,
    created_at timestamp
);

CREATE TABLE permissions
(
    id   bigint PRIMARY KEY,
    name varchar
);

CREATE TABLE groups
(
    id   bigint PRIMARY KEY,
    name varchar
);

CREATE TABLE group_permission
(
    group_id      bigint,
    permission_id bigint,

    CONSTRAINT fk_group_permission_group_id FOREIGN KEY ("group_id") REFERENCES groups ("id"),
    CONSTRAINT fk_group_permission_permission_id FOREIGN KEY ("permission_id") REFERENCES permissions ("id")
);

CREATE TABLE user_permission
(
    user_id       bigint,
    permission_id bigint,

    CONSTRAINT fk_user_permission_user_id FOREIGN KEY ("user_id") REFERENCES usrs ("id"),
    CONSTRAINT fk_user_permission_permission_id FOREIGN KEY ("permission_id") REFERENCES permissions ("id")
);

CREATE TABLE user_group
(
    user_id  bigint,
    group_id bigint,

    CONSTRAINT fk_user_group_user_id FOREIGN KEY ("user_id") REFERENCES usrs ("id"),
    CONSTRAINT fk_user_group_group_id FOREIGN KEY ("group_id") REFERENCES groups ("id")
);
