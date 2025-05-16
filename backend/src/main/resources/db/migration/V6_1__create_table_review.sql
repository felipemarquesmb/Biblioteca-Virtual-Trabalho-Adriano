CREATE TABLE tb_review (
    id SERIAL PRIMARY KEY,
    comment TEXT,
    rating INTEGER,
    user_id BIGINT,
    book_id BIGINT,
    CONSTRAINT fk_review_user FOREIGN KEY (user_id) REFERENCES tb_user (id),
    CONSTRAINT fk_review_book FOREIGN KEY (book_id) REFERENCES tb_book (id)
);
