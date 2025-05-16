CREATE TABLE tb_book (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255),
    author VARCHAR(255),
    publisher_id BIGINT,
    year INTEGER,
    edition VARCHAR(255),
    CONSTRAINT fk_publisher FOREIGN KEY (publisher_id) REFERENCES tb_publisher (id)
);
