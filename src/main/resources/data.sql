INSERT INTO user (USER_ID, USER_NAME, USER_PASSWORD, USER_NICKNAME, USER_ACTIVATED) values ( 1, 'admin', 'qwer1234!', 'bomsbro', 1);

INSERT INTO authority (AUTH_ID, AUTH_NAME) VALUES (1, 'ROLE_USER');
INSERT INTO authority (AUTH_ID, AUTH_NAME) VALUES (2, 'ROLE_ADMIN');

INSERT INTO user_authority (user_id, AUTH_ID) values (1, 1);
INSERT INTO user_authority (user_id, AUTH_ID) values (1, 2);