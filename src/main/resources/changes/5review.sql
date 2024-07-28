-- liquibase formatted sql
-- changeset rashmita:1
-- preconditions onFail:CONTINUE onError:HALT
CREATE TABLE if NOT EXISTS review (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     user_id BIGINT NOT NULL,
     movie_id BIGINT NOT NULL,
     content VARCHAR(255),
     rating DOUBLE,
     timestamp TIMESTAMP,
     status VARCHAR(255),
    CONSTRAINT fk_user_review FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_movie_review FOREIGN KEY (movie_id) REFERENCES movie(id)
    );

insert into review(user_id,movie_id,content,rating,status)values(1,2,"good movie",5,"users");