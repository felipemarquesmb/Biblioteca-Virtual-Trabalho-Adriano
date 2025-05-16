CREATE TABLE tb_favorite (
    id SERIAL PRIMARY KEY,
    user_id BIGINT,
    book_id BIGINT,
    CONSTRAINT fk_favorite_user FOREIGN KEY (user_id) REFERENCES tb_user (id),
    CONSTRAINT fk_favorite_book FOREIGN KEY (book_id) REFERENCES tb_book (id)
);
