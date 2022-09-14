INSERT INTO user (USER_ID, USER_NAME, USER_PASSWORD, USER_NICKNAME, USER_ACTIVATED) values ( 1, 'admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'bomsbro', 1);
INSERT INTO user (USER_ID, USER_NAME, USER_PASSWORD, USER_NICKNAME, USER_ACTIVATED) values ( 2, 'user', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', '재헌', 1);

INSERT INTO authority (AUTH_ID, AUTH_NAME) VALUES (1, 'ROLE_USER');
INSERT INTO authority (AUTH_ID, AUTH_NAME) VALUES (2, 'ROLE_ADMIN');

INSERT INTO user_authority (user_id, AUTH_ID) values (1, 1);
INSERT INTO user_authority (user_id, AUTH_ID) values (1, 2);

INSERT INTO post_category (pca_id, pca_name, pca_order) values (1, '첫번째 게시판', 1);
INSERT INTO post_category (pca_id, pca_name, pca_order) values (2, '두번째 게시판', 2);
INSERT INTO post_category (pca_id, pca_name, pca_order) values (3, '세번째 게시판', 3);

INSERT INTO post (post_id, pca_id, user_id, post_title, post_content, post_preview_text, post_view_count, post_reply_count, created_date, modified_date)
values (1, 1, 1, '테스트 게시물 1-1', '<h1>하이하이 1-1</h1>', '하이하이 1-1', 1, 1, '2021-08-17 12:12:11', '2021-08-19 13:15:19');
INSERT INTO post (post_id, pca_id, user_id, post_title, post_content, post_preview_text, post_view_count, post_reply_count, created_date, modified_date)
values (2, 1, 2, '테스트 게시물 1-2', '<h1>하이하이 1-2</h1>', '하이하이 1-2', 1, 1, '2021-08-18 12:12:11', '2021-08-19 13:15:19');
INSERT INTO post (post_id, pca_id, user_id, post_title, post_content, post_preview_text, post_view_count, post_reply_count, created_date, modified_date)
values (3, 2, 1, '테스트 게시물 2-1', '<h1>하이하이 2-1</h1>', '하이하이 2-1', 1, 1, '2021-08-19 12:12:11', '2021-08-20 13:15:19');
INSERT INTO post (post_id, pca_id, user_id, post_title, post_content, post_preview_text, post_view_count, post_reply_count, created_date, modified_date)
values (4, 2, 2, '테스트 게시물 2-2', '<h1>하이하이 2-2</h1>', '하이하이 2-2', 1, 1, '2021-08-20 12:12:11', '2021-08-21 13:15:19');
INSERT INTO post (post_id, pca_id, user_id, post_title, post_content, post_preview_text, post_view_count, post_reply_count, created_date, modified_date)
values (5, 2, 1, '테스트 게시물 2-3', '<h1>하이하이 2-3</h1>', '하이하이 2-3', 1, 1, '2021-08-21 12:12:11', '2021-08-22 13:15:19');
INSERT INTO post (post_id, pca_id, user_id, post_title, post_content, post_preview_text, post_view_count, post_reply_count, created_date, modified_date)
values (6, 3, 2, '테스트 게시물 3-1', '<h1>하이하이 3-1</h1>', '하이하이 3-1', 1, 1, '2021-08-22 12:12:11', '2021-08-23 13:15:19');
INSERT INTO post (post_id, pca_id, user_id, post_title, post_content, post_preview_text, post_view_count, post_reply_count, created_date, modified_date)
values (7, 3, 1, '테스트 게시물 3-2', '<h1>하이하이 3-1</h1>', '하이하이 3-2', 1, 1, '2021-08-23 12:12:11', '2021-08-24 13:15:19');
INSERT INTO post (post_id, pca_id, user_id, post_title, post_content, post_preview_text, post_view_count, post_reply_count, created_date, modified_date)
values (8, 3, 2, '테스트 게시물 3-2', '<h1>하이하이 3-1</h1>', '하이하이 3-3', 1, 1, '2021-08-24 12:12:11', '2021-08-25 13:15:19');
